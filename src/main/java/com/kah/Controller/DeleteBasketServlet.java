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

import com.coh.vo.User;
import com.kah.DAO.BasketDAO;
import com.kah.VO.BasketVO;

@WebServlet("/user/DeleteBasket")
public class DeleteBasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[SLOG] ShowBasketServlet IN");

		/** 인코딩 설정 */
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");


		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		int user_idx = user.getIdx();

			if (user_idx != 0) {
				System.out.println("user_idx 세션 값: " + user_idx);
				int category_idx =  Integer.parseInt(request.getParameter("category_idx"));
				System.out.println("category_idx 값: " + category_idx);

				BasketDAO basketDao = new BasketDAO();
				
				List<BasketVO> basketList = basketDao.deletebasketItem(user_idx, category_idx);
				
				
				request.setAttribute("basketList", basketList);
				RequestDispatcher rd = request.getRequestDispatcher("/users/basket.jsp");
				rd.forward(request, response);

			} else {
				System.out.println("[SLOG] 세션에 저장된 user_idx 값이 없습니다.");
				System.out.println(" 사용자 로그인 창으로 돌아갑니다 ");
				

			}
//		} else {
//			System.out.println("[SLOG] 세션이 존재하지 않습니다.");

//		}
	}

}
