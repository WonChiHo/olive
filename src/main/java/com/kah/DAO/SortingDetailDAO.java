package com.kah.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import com.kah.Controller.ConnectSQLController;
import com.kah.VO.ItemVO;

public class SortingDetailDAO extends ConnectSQLController {
	Connection Connector;
	PreparedStatement pstmt;

	ArrayList<ItemVO> itemList = new ArrayList<ItemVO>();

	public SortingDetailDAO() {
		this.Connector = connectMYSQL();
	}

	/**
	 * 낮은 가격순 정렬
	 * 
	 * @return
	 */
	public List<ItemVO> sortLowPrice(String categoryName, ItemVO itemModel) {

		int pageNum = Integer.parseInt(itemModel.getPageNum()); // "1" => 1
		int listCount = itemModel.getListCount(); // 한 페이지 게시물 갯수
		String searchType = itemModel.getSearchType(); // 검색 종류
		String searchText = itemModel.getSearchText(); // 검색어
		System.out.println("pageNum  : " + pageNum);
		System.out.println("listCount  : " + listCount);

		List<ItemVO> itemList = null;
		ResultSet rs = null;
		System.out.println("sortLowPrice => categoryName : " + categoryName);

		if ("ALL".equals(categoryName)) {

			try {
				System.out.println("ALL IN");
				System.out.println("[SLOG] SortingDetailDAO => sortLowPrice() 메서드 실행");

				String query = "select * from item order by price asc, idx DESC LIMIT ?, ?";

				this.Connector = connectMYSQL();
				PreparedStatement pstmt = this.Connector.prepareStatement(query);

				pstmt.setInt(1, listCount * (pageNum - 1));
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
				System.out.println("itemList : " + itemList);
			} catch (SQLException e) {
				System.err.println("sortLowPrice => sortLowPrice()  SQLException : " + e.getMessage());
			} finally {
				close(rs, pstmt, this.Connector);
			}
			System.out.println("DetailListDAO => sortLowPrice() END ");
		} else {
			try {

				String query = "select*from item where category = ? order by price asc , idx DESC LIMIT ?, ?";

				System.out.println("[SLOG] SortingDetailDAO => sortLowPrice() 메서드 실행");
				pstmt = this.Connector.prepareStatement(query);
				pstmt.setString(1, categoryName);
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
				System.err.println("DetailListDAO => sortLowPrice()  SQLException : " + e.getMessage());
			} finally {
				close(rs, pstmt, this.Connector);
			}
		}
		return itemList;

	}// sortLowPrice() END

	/** 높은 가격순 정렬 */
	public List<ItemVO> sortHighPrice(String categoryName, ItemVO itemModel) {

		int pageNum = Integer.parseInt(itemModel.getPageNum()); // "1" => 1
		int listCount = itemModel.getListCount(); // 한 페이지 게시물 갯수
		String searchType = itemModel.getSearchType(); // 검색 종류
		String searchText = itemModel.getSearchText(); // 검색어

		System.out.println("categoryName : " + categoryName);
		System.out.println("pageNum  : " + pageNum);
		System.out.println("listCount  : " + listCount);

		List<ItemVO> itemList = null;
		ResultSet rs = null;

		if ("ALL".equals(categoryName)) {

			try {
				System.out.println("ALL IN");
				String query = "select*from item order by price desc, idx DESC LIMIT ?, ?";

				System.out.println("[SLOG] SortingDetailDAO => sortHighPrice() 메서드 실행");

				this.Connector = connectMYSQL();
				PreparedStatement pstmt = this.Connector.prepareStatement(query);
				pstmt.setInt(1, listCount * (pageNum - 1));
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
				System.out.println("itemList : " + itemList);
			} catch (SQLException e) {
				System.err.println("DetailListDAO => sortHighPrice()  SQLException : " + e.getMessage());
			} finally {
				close(rs, pstmt, this.Connector);
			}
			System.out.println("DetailListDAO => sortHighPrice() END ");
		} else {
			try {

				String query = "select * from item where category = ? order by price desc, idx DESC LIMIT ?, ? ";

				System.out.println("[SLOG] SortingDetailDAO => sortHighPrice() 메서드 실행");
				pstmt = this.Connector.prepareStatement(query);
				pstmt.setString(1, categoryName);
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
				System.err.println("DetailListDAO => sortHighPrice()  SQLException : " + e.getMessage());
			} finally {
				close(rs, pstmt, this.Connector);
			}
			System.out.println("DetailListDAO => sortHighPrice() END ");
		}
		return itemList;

	}// sortHighPrice() END

	/** 인기순 정렬 */
	public List<ItemVO> sortHit(String categoryName, ItemVO itemModel) {

		int pageNum = Integer.parseInt(itemModel.getPageNum()); // "1" => 1
		int listCount = itemModel.getListCount(); // 한 페이지 게시물 갯수
		String searchType = itemModel.getSearchType(); // 검색 종류
		String searchText = itemModel.getSearchText(); // 검색어

		System.out.println("categoryName : " + categoryName);
		System.out.println("pageNum  : " + pageNum);
		System.out.println("listCount  : " + listCount);

		List<ItemVO> itemList = null;
		ResultSet rs = null;

		if ("ALL".equals(categoryName)) {

			try {
				System.out.println("ALL IN");
				String query = "select*from item order by hit desc, idx DESC LIMIT ?, ? ";

				System.out.println("[SLOG] SortingDetailDAO => sortHit() 메서드 실행");

				this.Connector = connectMYSQL();
				PreparedStatement pstmt = this.Connector.prepareStatement(query);

				pstmt.setInt(1, listCount * (pageNum - 1));
				pstmt.setInt(2, listCount);
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
				System.err.println("DetailListDAO => sortHit()  SQLException : " + e.getMessage());
			} finally {
				close(rs, pstmt, this.Connector);
			}
			System.out.println("DetailListDAO => sortHit() END ");
		} else {
			try {

				String query = "select*from item where category = ? order by hit desc, idx DESC LIMIT ?, ? ";

				System.out.println("[SLOG] SortingDetailDAO => sortHit() 메서드 실행");
				pstmt = this.Connector.prepareStatement(query);
				pstmt.setString(1, categoryName);
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
				System.err.println("DetailListDAO => sortHit()  SQLException : " + e.getMessage());
			} finally {
				close(rs, pstmt, this.Connector);
			}
			System.out.println("DetailListDAO => sortHit() END ");
		}
		return itemList;

	}// sortHit() END



}