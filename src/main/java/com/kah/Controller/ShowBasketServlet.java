package com.kah.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.coh.vo.User;
import com.kah.DAO.BasketDAO;
import com.kah.DAO.ItemDAO;
import com.kah.VO.BasketVO;
import com.kah.VO.ItemVO;

@WebServlet("/user/ShowBasket")
public class ShowBasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("[SLOG] ShowBasketServlet IN");

		/** 인코딩 설정 */
		request.setCharacterEncoding("UTF-8"); // 합칠 때 지우기
		response.setContentType("text/html; charset=utf-8"); // 합칠 때 지우기

		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		int user_idx = user.getIdx();

		if (user_idx != 0) {
			
		
			BasketDAO basketDao = new BasketDAO();
			List<BasketVO> basketList = basketDao.showBasket(user_idx);
			
			System.out.println("ShowBasketServlet => doPost() =>  basketList  : " + basketList);

		
			request.setAttribute("basketList", basketList);
			RequestDispatcher rd = request.getRequestDispatcher("/users/basket.jsp");
			rd.forward(request, response);

		} 
//		} else {
//			System.out.println("[SLOG] 세션이 존재하지 않습니다.");

//		}

	}
}