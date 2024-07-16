package com.kah.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kah.Controller.ConnectSQLController;
import com.kah.VO.ItemVO;

public class SearchDAO extends ConnectSQLController {

	Connection connector;
	PreparedStatement pstmt = null;
	ArrayList<ItemVO> itemList = new ArrayList<ItemVO>();
	String keyword;

	public SearchDAO(String keyword) {
		this.connector = connectMYSQL();
		this.keyword = keyword;
	}

	/** 검색 */
	public List<ItemVO> search(ItemVO itemModel) {
		System.out.println("[SLOG] SearchDAO => search() IN");

		int pageNum = Integer.parseInt(itemModel.getPageNum()); // "1" => 1
		int listCount = itemModel.getListCount(); // 한 페이지 게시물 갯수
		String searchType = itemModel.getSearchType(); // 검색 종류
		String searchText = keyword; // 검색어

		System.out.println("keyword : " + keyword);
		System.out.println("searchType : " + searchType);
		System.out.println("pageNum  : " + pageNum);
		System.out.println("listCount  : " + listCount);

		List<ItemVO> itemList = null;
		ResultSet rs = null;

		try {
			String query = "select * from item where title like ? ORDER BY idx DESC LIMIT ?, ?";
			this.connector = connectMYSQL();
			pstmt = this.connector.prepareStatement(query);

			System.out.println("searchText : " + searchText);

			pstmt.setString(1, "%" + searchText + "%");
			pstmt.setInt(2, listCount * (pageNum - 1));
			pstmt.setInt(3, listCount);

			rs = pstmt.executeQuery();
			itemList = new ArrayList<ItemVO>();
			ItemVO item = null;

			while (rs.next()) {

				item = new ItemVO();
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
			System.out.println("SearchDAO => search() = > itemList  : " + itemList);

		} catch (SQLException e) {
			System.err.println("SearchDAO => search() => SQL ERR : " + e.getMessage());
		} finally {
			close(rs, pstmt, connector);
		}

		return itemList;
	}

	
	
	/** 검색 인기순 정렬 */
	public List<ItemVO> searchItemSortByHit(ItemVO itemModel, String searchText) {

		System.out.println("[SLOG] SearchDAO => searchItemSortByHit() 메서드 실행");
        
		/**페이지 네비게이터 변수 선언*/		
		int pageNum = Integer.parseInt(itemModel.getPageNum()); // "1" => 1
		int listCount = itemModel.getListCount(); // 한 페이지 게시물 갯수
		

		System.out.println("pageNum  : " + pageNum);
		System.out.println("listCount  : " + listCount);
		System.out.println("searchText  : " + searchText);
        
		/**인기순 정렬*/		
		List<ItemVO> itemList = null;
		ResultSet rs = null;
		try {

			String query = "select * from item where title like ? order by hit desc, idx DESC LIMIT ?, ? ";

			this.connector = connectMYSQL();
			PreparedStatement pstmt = this.connector.prepareStatement(query);
			
			pstmt.setString(1, "%" + searchText + "%");
			pstmt.setInt(2, listCount * (pageNum - 1));
			pstmt.setInt(3, listCount);
			
			rs = pstmt.executeQuery();
			itemList = new ArrayList<ItemVO>();

			while (rs.next()) {
				ItemVO item = new ItemVO();
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
			System.err.println("SearchDAO => searchItemSortByHit()  SQLException : " + e.getMessage());
		} finally {
			close(rs, pstmt, this.connector);
			System.out.println("SearchDAO => searchItemSortByHit() END "); 
		}return itemList;

	} // searchItemSortByHit() END

	
	
	/** 검색 낮은 가격 순 정렬 */
	public List<ItemVO> searchItemSortByLowPrice(ItemVO itemModel, String keyword) {

		System.out.println("[SLOG] SearchDAO => searchItemSortByLowPrice() 메서드 실행");
        
		/**페이지 네비게이터 변수 선언*/		
		int pageNum = Integer.parseInt(itemModel.getPageNum()); // "1" => 1
		int listCount = itemModel.getListCount(); // 한 페이지 게시물 갯수
		String searchType = itemModel.getSearchType(); // 검색 종류
		String searchText = keyword;

		System.out.println("pageNum  : " + pageNum);
		System.out.println("listCount  : " + listCount);
		System.out.println("searchText  : " + searchText);
        
		/**낮은 가격 순 정렬*/		
		List<ItemVO> itemList = null;
		ResultSet rs = null;
		try {

			String query = "select * from item where title like ? order by price asc, idx DESC LIMIT ?, ? ";

			this.connector = connectMYSQL();
			PreparedStatement pstmt = this.connector.prepareStatement(query);
			
			pstmt.setString(1, "%" + searchText + "%");
			pstmt.setInt(2, listCount * (pageNum - 1));
			pstmt.setInt(3, listCount);
			
			rs = pstmt.executeQuery();
			itemList = new ArrayList<ItemVO>();

			while (rs.next()) {
				ItemVO item = new ItemVO();
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
			System.err.println("SearchDAO => searchItemSortByLowPrice()  SQLException : " + e.getMessage());
		} finally {
			close(rs, pstmt, this.connector);
			System.out.println("SearchDAO => searchItemSortByLowPrice() END "); 
		}return itemList;

	} // searchItemSortByLowPrice() END
	
	
	/** 검색 높은 가격 순 정렬 */

	public List<ItemVO> searchItemSortByHighPrice(ItemVO itemModel, String keyword) {

		System.out.println("[SLOG] SearchDAO => searchItemSortByHighPrice() 메서드 실행");
        
		/**페이지 네비게이터 변수 선언*/		
		int pageNum = Integer.parseInt(itemModel.getPageNum()); // "1" => 1
		int listCount = itemModel.getListCount(); // 한 페이지 게시물 갯수
		String searchType = itemModel.getSearchType(); // 검색 종류
		String searchText = keyword;

		System.out.println("pageNum  : " + pageNum);
		System.out.println("listCount  : " + listCount);
		System.out.println("searchText  : " + searchText);
        
		/**낮은 가격 순 정렬*/		
		List<ItemVO> itemList = null;
		ResultSet rs = null;
		try {

			String query = "select * from item where title like ? order by price desc, idx DESC LIMIT ?, ? ";

			this.connector = connectMYSQL();
			PreparedStatement pstmt = this.connector.prepareStatement(query);
			
			pstmt.setString(1, "%" + searchText + "%");
			pstmt.setInt(2, listCount * (pageNum - 1));
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
			System.err.println("SearchDAO => searchItemSortByHighPrice()  SQLException : " + e.getMessage());
		} finally {
			close(rs, pstmt, this.connector);
			System.out.println("SearchDAO => searchItemSortByHighPrice() END "); 
		}return itemList;

	} // searchItemSortByHighPrice() END
	
	
	
}
