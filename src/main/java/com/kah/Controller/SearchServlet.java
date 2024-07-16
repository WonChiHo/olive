package com.kah.Controller;

import java.io.IOException;

import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.If;

import com.kah.DAO.SearchDAO;
import com.kah.VO.ItemVO;
import com.kah.util.PageNavigator;

@WebServlet("/Search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/** 인코딩 */
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("[SLOG] SearchServlet IN");

		/** 페이징 관련 변수 처리 */
		// 전달된 파라미터를 이용하여 값 추출(처음에는 전달되는 값이 없슴)
		String pageNum = request.getParameter("pageNum"); // 페이지 번호
		String searchType = request.getParameter("searchType"); // 검색 종류
		String searchText = request.getParameter("keyword"); // 검색어

		System.out.println("SearchServlet => keyword : " + searchText);

		if (pageNum == null) {
			pageNum = "1"; // 전달된 페이지 번호가 없으면 1
		}
		if (searchText == null) {
			searchType = ""; // 전달된 검색 종류가 없으면 "" 를 이용하여 초기화
			
			if (request.getParameter("name") != null) {
				
				searchText = request.getParameter("name"); // 검색어
			   }else {
			   searchText = ""; // 전달된 검색어가 없으면 "" 를 이용하여 초기화
		}
		}

		/** 페이징 관련 셋팅 */
		// 모델 (BoardDAO의 메서드에게 전달할 데이터를 하나의 객체로 )
		ItemVO itemModel = new ItemVO();
		itemModel.setPageNum(pageNum);
		itemModel.setSearchType(searchType);
		itemModel.setSearchText(searchText);

		SearchDAO searchDao = new SearchDAO(searchText);
		// 게시물 총 수 (목록 아래에 페이지 번호를 계산하기 위한 메서드 호출)
		

		List<ItemVO> itemList = searchDao.search(itemModel);
		int totalCount = itemList.size();
		System.out.println("SearchServlet => doPost() =>  ItemList : " + itemList);
		
		// View 사용될 객체 설정
		request.setAttribute("totalCount", totalCount);
		
		// 목록 하단 페이지 번호출력을 위한 객체 생성
		PageNavigator pNavigator = new PageNavigator();
		
		String p_navi=pNavigator.getPageNavigator(
				totalCount,
				itemModel.getListCount(), 
				itemModel.getPagePerBlock(), 
				Integer.parseInt(pageNum), 
				searchType, searchText, request);
				
		request.setAttribute("pageNavigator", p_navi);   	// 페이지 번호들
		request.setAttribute("itemList", itemList);			// 조회 결과 리스트
		request.setAttribute("itemModel", itemModel);	// 모델
		request.setAttribute("keyword", searchText);
		
		RequestDispatcher rd = request.getRequestDispatcher("/detail/detail.jsp");

		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

	}
}
