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

import org.apache.jasper.tagplugins.jstl.core.If;

import com.coh.vo.User;
import com.kah.DAO.BasketDAO;
import com.kah.DAO.ItemDAO;
import com.kah.VO.BasketVO;
import com.kah.VO.ItemVO;

@WebServlet("/user/ModifyBasket")
public class ModifyBasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/** 인코딩 설정 */
		request.setCharacterEncoding("UTF-8"); // 합칠 때 지우기
		response.setContentType("text/html; charset=utf-8"); // 합칠 때 지우기

		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		int user_idx = user.getIdx();

		if (user_idx != 0) {
			System.out.println("user_idx 세션 값: " + user_idx);

			/** 01. 사용자 입력값 가져오기(count, sale, category_idx) */
			int category_idx = Integer.parseInt(request.getParameter("category_idx"));
			System.out.println("category_idx 값: " + category_idx);
			
			int SalePercent = Integer.parseInt(request.getParameter("SalePercent"));
			System.out.println("Sale 값: " + SalePercent);
			
			int count = Integer.parseInt(request.getParameter("count"));
			System.out.println("count 값: " + count);
			
			BasketVO basketItem = new BasketVO();
			basketItem.setUser_idx(user_idx);
			basketItem.setItem_idx(category_idx);
			basketItem.setCount(count);
		
			
			
			//제품별 고정 가격 가져오기
			ItemVO item = new ItemVO();
			ItemDAO itemDao = new ItemDAO();
			item = itemDao.selectDetailItem(category_idx);
			int staticPrice = item.getPrice();
			System.out.println("staticPrice 값 : " + staticPrice);
		
			System.out.println("ModifyBasketServlet => doPost() =>  basketItem  : " + basketItem);

			BasketDAO basketDao = new BasketDAO();
			List<BasketVO> basketList = basketDao.modifyBasketItem(user_idx, basketItem, staticPrice);
			
			
			System.out.println("ModifyBasketServlet => doPost() =>  item  : " + item);
			
			request.setAttribute("basketList", basketList);
			request.setAttribute("item", item);
			
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
