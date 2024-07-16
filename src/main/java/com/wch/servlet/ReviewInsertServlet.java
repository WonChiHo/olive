package com.wch.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.coh.vo.User;
import com.wch.dao.ItemDAO;
import com.wch.dao.ReviewDAO;
import com.wch.dto.Item;
import com.wch.dto.Review;

/**
 * Servlet implementation class RankingListServlet
 */
@WebServlet("/review/reviewInsert")
public class ReviewInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReviewDAO reviewDAO = null;
	ItemDAO itemDAO = null;
    public ReviewInsertServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		// 합칠때 지우기
		response.setContentType("text/html;charset=UTF-8"); // 합칠때 지우기
	
		reviewDAO = new ReviewDAO();
		itemDAO = new ItemDAO();
		Review review = new Review();
		Item item = new Item();
		String category = "";
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		int item_idx = Integer.parseInt(request.getParameter("item_idx"));
		review.setUser_id(user.getId());
		review.setItem_idx(item_idx);
		review.setContent(request.getParameter("qnaText"));
		review.setImage(request.getParameter("filePath"));
		review.setGrade(Integer.parseInt(request.getParameter("grade")));
		item = itemDAO.selectDetailItem(item_idx);
		category = item.getCategory();
		reviewDAO.insertReview(review, category);
		
		response.sendRedirect("../detail/detailList?idx="+item_idx); //임의로 적음
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
