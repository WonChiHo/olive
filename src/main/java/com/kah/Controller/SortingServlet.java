package com.kah.Controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kah.DAO.DetailListDAO;
import com.kah.DAO.SortingDetailDAO;
import com.kah.VO.ItemVO;
import com.kah.util.PageNavigator;
import com.mysql.cj.Session;

@WebServlet("/detail/Sorting")
public class SortingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DetailListDAO detailListDAO = new DetailListDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/** 인코딩 */
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("[SLOG] SortingServlet IN");

		String categoryName = request.getParameter("categoryName");
		String sortType = request.getParameter("sort");

		/** 페이징 관련 변수 처리 */
		// 전달된 파라미터를 이용하여 값 추출(처음에는 전달되는 값이 없슴)
		String pageNum = request.getParameter("pageNum"); // 페이지 번호
		String searchType = request.getParameter("searchType"); // 검색 종류
		String searchText = request.getParameter("keyword"); // 검색어
		if (pageNum == null) {
			pageNum = "1"; // 전달된 페이지 번호가 없으면 1
		}
		if (searchText == null) {
			searchType = ""; // 전달된 검색 종류가 없으면 "" 를 이용하여 초기화
			searchText = ""; // 전달된 검색어가 없으면 "" 를 이용하여 초기화
		}

		/** 페이징 관련 셋팅 */
		// 모델 (BoardDAO의 메서드에게 전달할 데이터를 하나의 객체로 )
		ItemVO itemModel = new ItemVO();
		itemModel.setPageNum(pageNum);
		itemModel.setSearchType(searchType);
		itemModel.setSearchText(searchText);

		/** 세션에 카테고리 배열 저장 */
		HttpSession session = request.getSession();

		String[] categories = { "ALL", "Skin", "Makeup", "Perfume", "Cleansing" };

		for (String category : categories) {
			if (category.equals(categoryName))
				session.setAttribute("categoryName", category);
		    }
			System.out.println("categoryName : " + categoryName);
			System.out.println("sortType : " + sortType);

			/** 정렬 */
			if (sortType != null) {
				List<ItemVO> sortedItemList = null;
				SortingDetailDAO sortingDetailDao = new SortingDetailDAO();

				int totalCount = detailListDAO.selectCount(itemModel, (String)(session.getAttribute("categoryName")));

				switch (sortType) {
				case "popularity":
					if (categoryName != null) {
						sortedItemList = sortingDetailDao.sortHit(categoryName, itemModel);
					} else {
						categoryName = (String) session.getAttribute("categoryName");
						sortedItemList = sortingDetailDao.sortHit(categoryName, itemModel);
					}

					break;
				case "highPrice":
					if (categoryName != null) {
						sortedItemList = sortingDetailDao.sortHighPrice(categoryName, itemModel);
					} else {
						categoryName = (String) session.getAttribute("categoryName");
						sortedItemList = sortingDetailDao.sortHighPrice(categoryName, itemModel);
					}
					break;
				case "lowPrice":
					if (categoryName != null) {
						sortedItemList = sortingDetailDao.sortLowPrice(categoryName, itemModel);
					} else {
						categoryName = (String) session.getAttribute("categoryName");
						sortedItemList = sortingDetailDao.sortLowPrice(categoryName, itemModel);
					}
					break;
				}

				// View 사용될 객체 설정
				request.setAttribute("totalCount", totalCount);

				// 목록 하단 페이지 번호출력을 위한 객체 생성
				PageNavigator pNavigator = new PageNavigator();

				String p_navi = pNavigator.getPageNavigator(totalCount, itemModel.getListCount(),
						itemModel.getPagePerBlock(), Integer.parseInt(pageNum), searchType, searchText, request);

				request.setAttribute("pageNavigator", p_navi); // 페이지 번호들
				request.setAttribute("itemList", sortedItemList); // 조회 결과 리스트
				request.setAttribute("itemModel", itemModel); // 모델

				RequestDispatcher rd = request.getRequestDispatcher("/detail/detail.jsp");
				rd.forward(request, response);
			}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("[SLOG] SortingServlet IN");
	}

}
