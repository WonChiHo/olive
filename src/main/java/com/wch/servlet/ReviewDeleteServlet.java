package com.wch.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wch.dao.ReviewDAO;

@WebServlet("/review/reviewDelete")
public class ReviewDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ReviewDAO reviewDAO = null;
    
    public ReviewDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		// 합칠때 지우기
		response.setContentType("text/html;charset=UTF-8"); // 합칠때 지우기
		
		reviewDAO = new ReviewDAO();
		reviewDAO.deleteReview(Integer.parseInt(request.getParameter("idx")));
		
		//response.sendRedirect("../detail/detailList?idx="+request.getParameter("item_idx"));
		response.sendRedirect("../detail/detailList?idx=12");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
