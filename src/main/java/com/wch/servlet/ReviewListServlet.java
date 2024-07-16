package com.wch.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.wch.dao.ReviewDAO;
import com.wch.dto.Review;

/**
 * Servlet implementation class RankingListServlet
 */
@WebServlet("/review/reviewList")
public class ReviewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReviewDAO reviewDAO = null;
    public ReviewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		// 합칠때 지우기
		response.setContentType("text/html;charset=UTF-8"); // 합칠때 지우기
		
		reviewDAO = new ReviewDAO();
		ArrayList<Review> reviewList = new ArrayList<Review>();
		
		PrintWriter out = response.getWriter();
		reviewList = reviewDAO.selectReview(Integer.parseInt(request.getParameter("item_idx")));
		JSONObject reviewArrayList = new JSONObject();
		JSONArray reviewArray = new JSONArray();
		JSONObject review = null;
		
		for(int i=0; i<reviewList.size();i++) {
			review = new JSONObject();
			review.put("idx", reviewList.get(i).getUser_id());
			review.put("user_id",reviewList.get(i).getUser_id());
			review.put("item_idx",reviewList.get(i).getItem_idx());
			review.put("content",reviewList.get(i).getContent());
			review.put("image",reviewList.get(i).getImage());
			review.put("moment",""+reviewList.get(i).getMoment());
			review.put("grade",""+reviewList.get(i).getGrade());	
			reviewArray.add(review);
		}
		
		reviewArrayList.put("reviewList", reviewArray);
		
		String info = reviewArrayList.toJSONString();
		out.print(info);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
