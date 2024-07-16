package com.kah.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kah.Controller.ConnectSQLController;
import com.kah.VO.ItemVO;

public class DetailListDAO extends ConnectSQLController {
	
	Connection Connector;
	PreparedStatement pstmt = null;

	ArrayList<ItemVO> itemList = new ArrayList<ItemVO>();

	public DetailListDAO() {
		this.Connector = connectMYSQL();
	}// 생성자 END


/**상세리스트 조회*/
	public List<ItemVO> selectItemListByCategory(String category, ItemVO itemModel) {
		int pageNum = Integer.parseInt(itemModel.getPageNum()); // "1" => 1
		int listCount = itemModel.getListCount();	// 한 페이지 게시물 갯수
		String searchType = itemModel.getSearchType();	//  검색 종류
		String searchText = itemModel.getSearchText();		// 검색어

		System.out.println("category : " + category);
		System.out.println("pageNum  : " + pageNum );
		System.out.println("listCount  : " + listCount );
		
		List<ItemVO> itemList = null;
		ResultSet rs = null;

		if (category == "ALL") {
			System.out.println("ALL IN");
			try {

				String query = "SELECT * FROM item ORDER BY idx DESC LIMIT ?, ?";
				this.Connector = connectMYSQL();
				PreparedStatement pstmt = this.Connector.prepareStatement(query);
				
				pstmt.setInt(1, listCount * (pageNum-1));
				pstmt.setInt(2, listCount);
				rs = pstmt.executeQuery();
				itemList = new ArrayList<ItemVO>();
				
				while (rs.next()) {
					ItemVO item = new ItemVO();
					item.setIdx(rs.getInt("idx"));
					item.setCategory(rs.getString("category"));
					item.setTitle(rs.getString("title"));
					item.setImage(rs.getString("image"));
					item.setPrice(rs.getInt("price"));
					item.setDetail(rs.getString("detail"));
					item.setDiscount(rs.getInt("discount"));
					item.setStock_count(rs.getInt("stock_count"));
					item.setHit(rs.getInt("hit"));
					itemList.add(item);
				}

			} catch (SQLException e) {
				System.err.println("SQLException: " + e.getMessage());
			}finally {
				close(rs, pstmt, this.Connector);
			}

		} else {
			System.out.println(category + "IN");
			try {
				String query = "select * from item WHERE category = ? ORDER BY idx DESC LIMIT ?, ?";

				this.Connector = connectMYSQL();
				PreparedStatement pstmt = this.Connector.prepareStatement(query);
				pstmt.setString(1, category);
				pstmt.setInt(2, listCount * (pageNum-1));
				pstmt.setInt(3, listCount);
				rs = pstmt.executeQuery();

				itemList = new ArrayList<ItemVO>();
					while (rs.next()) {
						ItemVO item = new ItemVO();
						
						item.setIdx(rs.getInt("idx"));
						item.setCategory(rs.getString("category"));
						item.setTitle(rs.getString("title"));
						item.setImage(rs.getString("image"));
						item.setPrice(rs.getInt("price"));
						item.setDetail(rs.getString("detail"));
						item.setDiscount(rs.getInt("discount"));
						item.setStock_count(rs.getInt("stock_count"));
						item.setHit(rs.getInt("hit"));
						itemList.add(item);
					}
					System.out.println("itemList : " + itemList);
				} catch (SQLException e) {
				System.err.println("SQLException: " + e.getMessage());
			}finally {
				close(rs, pstmt, this.Connector);
			}

		}

		return itemList;
	}


/**페이징 테스트 게시물 총 갯수 조회*/
	
	public int selectCount(ItemVO boardModel, String category) {
		int totalCount = 0;	// 전체 조회 또는 검색어를 통한 조회 시 총 레코드 갯수 저장
		String whereSQL = "where category = ?";		// select 쿼리의 조건 부분만 저장
		Connector = connectMYSQL();
		ResultSet rs = null;
		
		try {
			
			
			// 게시물의 총 수를 얻는 쿼리 실행
			String query="SELECT COUNT(idx) AS TOTAL FROM item " + whereSQL;
			pstmt = Connector.prepareStatement(query);
			
			pstmt.setString(1, category);
			
			rs = pstmt.executeQuery();	// 쿼리 실행
			
			if (rs.next()) {
				totalCount = rs.getInt("TOTAL");	//  결과 필드명을 이용
			}
		} catch (Exception e) {		// SQLException   
			e.printStackTrace();		// System.out.println(e.getMessage());  
		} finally {
			// 사용한 객체 종료 (나중에 사용한 것 부터 종료)
			close(rs, pstmt, null);
		}
		return totalCount;	// 결과 값 반환...(BoardListServlet 의 doGet()에게)
	}	// selectCount() END 
	
	
}
