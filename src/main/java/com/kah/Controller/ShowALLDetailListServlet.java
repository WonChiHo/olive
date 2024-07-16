package com.kah.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kah.DAO.DetailListDAO;
import com.kah.VO.ItemVO;
import com.kah.util.PageNavigator;

@WebServlet("/detail/ShowALLDetailList")
public class ShowALLDetailListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/** 인코딩 */
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("[SLOG] ShowALLDetailList IN");

		/** 페이징 관련 변수 처리 */
		// 전달된 파라미터를 이용하여 값 추출(처음에는 전달되는 값이 없슴)
		String pageNum = request.getParameter("pageNum"); // 페이지 번호
		String searchType = request.getParameter("searchType"); // 검색 종류
		String searchText = request.getParameter("keyword");
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

		/** 카테고리별 조회 */
		String List = request.getParameter("List");

//		if (List == null) {
//			HttpSession session = request.getSession();
//
//			String[] categories = { "ALL", "Skin", "Makeup", "Perfume", "Cleansing" };
//
//			for (String category : categories) {
//				if (category.equals(List))
//					session.setAttribute("List", category);
//
//			}
//		}
		
		System.out.println("List : " + List);

		if (List != null) {

			List<ItemVO> itemList = null;
			DetailListDAO detailListDAO = new DetailListDAO();

			// 게시물 총 수 (목록 아래에 페이지 번호를 계산하기 위한 메서드 호출)
			int totalCount = detailListDAO.selectCount(itemModel, List);

			switch (List) {
			case "Skin":
				itemList = detailListDAO.selectItemListByCategory("Skin", itemModel);
				break;
			case "Cleansing":
				itemList = detailListDAO.selectItemListByCategory("Cleansing", itemModel);
				break;
			case "Perfume":
				itemList = detailListDAO.selectItemListByCategory("Perfume", itemModel);
				break;
			case "Makeup":
				itemList = detailListDAO.selectItemListByCategory("Makeup", itemModel);
				break;
			case "ALL":
				itemList = detailListDAO.selectItemListByCategory("ALL", itemModel);
				break;
			}

			System.out.println("ShowDetailALLListServlet => doPost() =>  ItemList : " + itemList);

			// View 사용될 객체 설정
			request.setAttribute("totalCount", totalCount);

			// 목록 하단 페이지 번호출력을 위한 객체 생성
			PageNavigator pNavigator = new PageNavigator();

			String p_navi = pNavigator.getPageNavigator(totalCount, itemModel.getListCount(),
					itemModel.getPagePerBlock(), Integer.parseInt(pageNum), searchType, searchText, request);

			request.setAttribute("pageNavigator", p_navi); // 페이지 번호들
			request.setAttribute("itemList", itemList); // 조회 결과 리스트
			request.setAttribute("itemModel", itemModel); // 모델
			request.setAttribute("keyword", searchText); // 모델
			request.setAttribute("searchType", searchType); // 모델

			RequestDispatcher rd = request.getRequestDispatcher("detail.jsp");
			rd.forward(request, response);
		}

	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
