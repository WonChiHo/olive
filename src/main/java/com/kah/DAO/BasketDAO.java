package com.kah.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kah.Controller.ConnectSQLController;
import com.kah.VO.BasketVO;
import com.kah.VO.ItemVO;

public class BasketDAO extends ConnectSQLController {
	Connection connector = null;

	public BasketDAO() {

	} // 기본 생성자 END

	/** 장바구니 단일제품 조회 */
	public List<BasketVO> showBasketOne(int category_idx, int user_idx, int staticPrice) {
		this.connector = connectMYSQL();
		System.out.println("user_idx : " + user_idx);

		System.out.println("category_idx : " + category_idx);

		BasketVO basket = new BasketVO();
		ArrayList<BasketVO> basketList = new ArrayList<BasketVO>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String query = "select * from basket where item_idx = ? and user_idx= ?"; 
			pstmt = this.connector.prepareStatement(query);
			pstmt.setInt(1, category_idx);
			pstmt.setInt(2, user_idx);

			rs = pstmt.executeQuery();

			basketList = new ArrayList<BasketVO>();

			while (rs.next()) {
				basket = new BasketVO();

				basket.setIdx(rs.getInt("idx"));
				basket.setUser_idx(rs.getInt("user_idx"));
				basket.setCategory(rs.getString("category"));
				basket.setItem_idx(rs.getInt("item_idx")); //
				basket.setCount(rs.getInt("count"));
				basket.setPrice(rs.getInt("price"));
				basket.setSale(rs.getInt("sale"));

				int applySalePrice = rs.getInt("price")-(int)(rs.getInt("price") * ((float)rs.getInt("sale")/100));
				basket.setApplySalePrice(applySalePrice);

				basketList.add(basket);
			}
			System.out.println(" BasketDAO => showBasketOne()=> basketList : " + basketList);
		} catch (Exception e) {
			System.err.println("selectCart ERR : " + e.getMessage());
		} finally {
			close(rs, pstmt, null);
		}
		return basketList;
	}// showBaskeOne() END

	/** 장바구니 전제품 조회 */
	public List<BasketVO> showBasket(int user_idx) {
		this.connector = connectMYSQL();

		BasketVO basket = new BasketVO();
		ArrayList<BasketVO> basketList = new ArrayList<BasketVO>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String query = "select B.*, I.stock_count from basket B, item I where user_idx = ? and B.item_idx = I.idx";
			pstmt = this.connector.prepareStatement(query);
			pstmt.setInt(1, user_idx);

			rs = pstmt.executeQuery();

			basketList = new ArrayList<BasketVO>();

			while (rs.next()) {
				basket = new BasketVO();
				basket.setIdx(rs.getInt("idx"));
				basket.setUser_idx(rs.getInt("user_idx"));
				basket.setCategory(rs.getString("category"));
				basket.setItem_idx(rs.getInt("item_idx")); //
				basket.setCount(rs.getInt("count"));
				basket.setPrice(rs.getInt("price"));
				basket.setSale(rs.getInt("sale"));

				int applySalePrice = rs.getInt("price")-(int)(rs.getInt("price") * ((float)rs.getInt("sale")/100));
				basket.setApplySalePrice(applySalePrice);
				
				basket.setStock_count(rs.getInt("stock_count"));
				basketList.add(basket);
			}
			System.out.println(" BasketDAO => showBasket()=> basketList : " + basketList);
		} catch (Exception e) {
			System.err.println("showBasket ERR : " + e.getMessage());
		} finally {
			close(rs, pstmt, connector);
		}
		return basketList;
	}// showBasket() END

	/** 장바구니 제품 추가 */
	public List<BasketVO> addToBasket(int user_idx, BasketVO basket, int staticPrice) {
		System.out.println("user_idx : " + user_idx);
		System.out.println("basket : " + basket);

		this.connector = connectMYSQL();
		
		ArrayList<BasketVO> basketList = new ArrayList<BasketVO>();
		ResultSet rs= null;
		PreparedStatement pstmt = null;

		try {
			String queryProductUpdate = "insert into basket (user_idx, category, item_idx, count, price, sale ) values (?, ?, ?, ?, ?, ?)";   //

			pstmt = this.connector.prepareStatement(queryProductUpdate);
			pstmt.setInt(1, user_idx);
			pstmt.setString(2, basket.getCategory());
			pstmt.setInt(3, basket.getItem_idx()); //
			pstmt.setInt(4, basket.getCount());
			pstmt.setInt(5, staticPrice * basket.getCount());
			pstmt.setInt(6, basket.getSale());

			int n = pstmt.executeUpdate();
			if (n < 1) {
				System.err.println("장바구니 추가 실패");
			}
			
			if(n>1) { // 수정 여기서부터
				String selectQuery = "SELECT * FROM basket WHERE user_idx = ?";
				pstmt = connector.prepareStatement(selectQuery);
				pstmt.setInt(1, user_idx);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					BasketVO basketVo = new BasketVO();

					basketVo.setIdx(rs.getInt("idx"));
					basketVo.setUser_idx(rs.getInt("user_idx"));
					basketVo.setCategory(rs.getString("category"));
					basketVo.setItem_idx(rs.getInt("item_idx")); // 
					basketVo.setCount(rs.getInt("count"));
					basketVo.setPrice(rs.getInt("price"));
					basketVo.setSale(rs.getInt("sale"));

					int applySalePrice = rs.getInt("price")-(int)(rs.getInt("price") * ((float)rs.getInt("sale")/100));
					basket.setApplySalePrice(applySalePrice);

					basketList.add(basketVo);
			}

			}
			} catch (Exception e) {
			System.err.println("addToBasket ERR : " + e.getMessage());
		} finally {
			close(rs, pstmt, connector);
		}
		return basketList;
	}// addToBasket() END

	/** 장바구니 제품 삭제 */
	public List<BasketVO> deletebasketItem(int user_idx, int category_idx) {
		this.connector = connectMYSQL();

		System.out.println("user_idx : " + user_idx);
		System.out.println("category_idx : " + category_idx);

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BasketVO> basketList = new ArrayList<BasketVO>();

		String query = "DELETE FROM basket WHERE user_idx =?  and item_idx =? "; // 

		try {
			pstmt = this.connector.prepareStatement(query);
			System.out.println("deletebasketItem =>  user_idx : " + user_idx);
			pstmt.setInt(1, user_idx);
			pstmt.setInt(2, category_idx);

			int rowAffected = pstmt.executeUpdate();

			if (rowAffected > 0) {

				String selectQuery = "SELECT * FROM basket WHERE user_idx = ?";
				pstmt = connector.prepareStatement(selectQuery);
				pstmt.setInt(1, user_idx);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					BasketVO basket = new BasketVO();

					basket.setIdx(rs.getInt("idx"));
					basket.setUser_idx(rs.getInt("user_idx"));
					basket.setCategory(rs.getString("category"));
					basket.setItem_idx(rs.getInt("item_idx")); // 
					basket.setCount(rs.getInt("count"));
					basket.setPrice(rs.getInt("price"));
					basket.setSale(rs.getInt("sale"));

					int applySalePrice = rs.getInt("price")-(int)(rs.getInt("price") * ((float)rs.getInt("sale")/100));
					basket.setApplySalePrice(applySalePrice);

					basketList.add(basket);

				}
				System.out.println("basket DAO => basketList : " + basketList);
			} else {
				System.out.println("제품 삭제에 실패했습니다.");
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			close(rs, pstmt, connector);
		}
		return basketList;
	}

	/** 장바구니 목록 수정 */
	public List<BasketVO> modifyBasketItem(int user_idx, BasketVO basketItem, int staticPrice) {
		this.connector = connectMYSQL();
		System.out.println("basketItem : " + basketItem);
		System.out.println("staticPrice : " + staticPrice);
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BasketVO> basketList = new ArrayList<BasketVO>();

		String query = "update basket set count = ?, price = ? WHERE user_idx =?  and item_idx =? "; //

//		String query = "update basket set count = ?  price = price + ? WHERE user_idx =?  and item_idx =? "; //

		try {
			pstmt = connector.prepareStatement(query);
			pstmt.setInt(1, basketItem.getCount());
			pstmt.setInt(2, staticPrice * basketItem.getCount()); 
			pstmt.setInt(3, user_idx);
			pstmt.setInt(4, basketItem.getItem_idx()); 

			int rowAffected = pstmt.executeUpdate();
			System.out.println("rowAffected : " + rowAffected);
			pstmt.close();
			
			if (rowAffected > 0) {

				String selectQuery = "select B.*, I.stock_count from basket B, item I where user_idx = ? and B.item_idx = I.idx"; //
				pstmt = this.connector.prepareStatement(selectQuery);
				pstmt.setInt(1, user_idx);
				rs = pstmt.executeQuery();
				System.out.println("user_idx : " + user_idx);
				
				
				while (rs.next()) {
					BasketVO updatedItem = new BasketVO();

					updatedItem.setIdx(rs.getInt("idx"));
					updatedItem.setUser_idx(rs.getInt("user_idx"));
					updatedItem.setCategory(rs.getString("category"));
					updatedItem.setItem_idx(rs.getInt("item_idx")); // 
					updatedItem.setCount(rs.getInt("count"));
					
					updatedItem.setPrice(rs.getInt("price"));
					updatedItem.setSale(rs.getInt("sale"));

					int applySalePrice = rs.getInt("price")-(int)(rs.getInt("price") * ((float)rs.getInt("sale")/100));
					updatedItem.setApplySalePrice(applySalePrice);
					
					updatedItem.setStock_count(rs.getInt("stock_count"));
					basketList.add(updatedItem);

				}
				System.out.println("basket DAO => basketList : " + basketList);
			} else {
				System.out.println("수정에 실패했습니다.");
			}
		} catch (SQLException e) {
			System.err.println("BasketDAO => modifyBasketItem() => SQL ERR : " + e.getMessage());
		} finally {
			close(rs, pstmt, connector);
		}
		return basketList;
	}
	
	
	/** 제품 추가 시, 장바구니 수량 수정 쿼리  */ 
	public List<BasketVO> countModifyBasketItem(int user_idx, BasketVO basketItem, int staticPrice) {
		this.connector = connectMYSQL();
		System.out.println("basketItem : " + basketItem);
		System.out.println("staticPrice : " + staticPrice);

		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BasketVO> basketList = new ArrayList<BasketVO>();
		
		String query = "update basket set count = count + ?, price = price +  ? WHERE user_idx =?  and item_idx =? "; 
//		String query = "update basket set count = count + ?, price = price + ? WHERE user_idx =?  and item_idx =? "; 
		
		try {
//			int result = basketItem.getPrice() * basketItem.getCount();
			
			pstmt = connector.prepareStatement(query);
			pstmt.setInt(1, basketItem.getCount());
			pstmt.setInt(2, staticPrice * basketItem.getCount());
			pstmt.setInt(3, user_idx);
			pstmt.setInt(4, basketItem.getItem_idx()); // 

			int rowAffected = pstmt.executeUpdate();
			System.out.println("rowAffected : " + rowAffected);

			if (rowAffected > 0) {

				String selectQuery = "SELECT * FROM basket WHERE user_idx = ?"; //
				pstmt = this.connector.prepareStatement(selectQuery);
				pstmt.setInt(1, user_idx);
				rs = pstmt.executeQuery();
				System.out.println("user_idx : " + user_idx);
				
				
				while (rs.next()) {
					BasketVO updatedItem = new BasketVO();

					updatedItem.setIdx(rs.getInt("idx"));
					updatedItem.setUser_idx(rs.getInt("user_idx"));
					updatedItem.setCategory(rs.getString("category"));
					updatedItem.setItem_idx(rs.getInt("item_idx")); //
					updatedItem.setCount(rs.getInt("count"));
					updatedItem.setPrice(rs.getInt("price"));
					updatedItem.setSale(rs.getInt("sale"));
					
					int applySalePrice = rs.getInt("price")-(int)(rs.getInt("price") * ((float)rs.getInt("sale")/100));
					updatedItem.setApplySalePrice(applySalePrice);
					
//					updatedItem.setApplySalePrice(
//							((staticPrice - (staticPrice * rs.getInt("sale") / 100))* rs.getInt("count")) / 10 * 10);

					basketList.add(updatedItem);

				}
				System.out.println("basket DAO => basketList : " + basketList);
			} else {
				System.out.println("수정에 실패했습니다.");
			}
		} catch (SQLException e) {
			System.err.println("BasketDAO => modifyBasketItem() => SQL ERR : " + e.getMessage());
		} finally {
			close(rs, pstmt, connector);
		}
		return basketList;
	}

}