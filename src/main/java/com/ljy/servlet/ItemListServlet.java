package com.ljy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ljy.ItemDAO;
import com.ljy.ItemVO;
import com.ljy.util.PageNavigator;

@WebServlet("/ItemListServlet")
public class ItemListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	private ItemDAO itemDAO = null;
    public ItemListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String pageNum = request.getParameter("pageNum");
		if( pageNum == null) {
			pageNum = "1";
		}
		
		ItemVO itemvo = new ItemVO();
		itemvo.setPageNum(pageNum);
		
		this.itemDAO = new ItemDAO();
	
		int totalCount = this.itemDAO.selectCount(itemvo);
		
		List<ItemVO> itemList = this.itemDAO.selectList(itemvo);
	
		
		request.setAttribute("itemList", itemList);
		
		PageNavigator pNavigator = new PageNavigator();
		String p_navi = pNavigator.getPageNavigator(
				totalCount, 
				itemvo.getListCount(),
				itemvo.getPagePerBlock(),
				Integer.parseInt(pageNum)
				
				);
		
		request.setAttribute("pageNavigator", p_navi);   	// 페이지 번호들
		request.setAttribute("itemList", itemList);			// 조회 결과 리스트
		request.setAttribute("itemvo", itemvo);	// 모델
		
		RequestDispatcher requestDispatcher = 
				request.getRequestDispatcher("/admin_itemList.jsp");
		requestDispatcher.forward(request, response);
		
	}


}