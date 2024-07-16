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

import org.apache.el.lang.ELSupport;

import com.coh.vo.User;
import com.kah.DAO.BasketDAO;
import com.kah.DAO.ItemDAO;
import com.kah.VO.BasketVO;
import com.kah.VO.ItemVO;

@WebServlet("/user/InsertBasket")
public class InsertBasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("[SLOG] InsertBasketServlet IN");

		/** 인코딩 설정 */
		request.setCharacterEncoding("UTF-8"); // 합칠 때 지우기
		response.setContentType("text/html; charset=utf-8"); // 합칠 때 지우기

		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		int user_idx = user.getIdx();

		if (user_idx != 0) {
			System.out.println("user_idx 세션 값: " + user_idx);

			
			// 입력값 
			
			int category_idx = Integer.parseInt(request.getParameter("category_idx"));
			System.out.println("category_idx : " + category_idx);
			
			String category = request.getParameter("title");
			System.out.println("category : " + category );
			
			int count = Integer.parseInt(request.getParameter("count"));
			System.out.println("count : " + count);
			
			int discount = Integer.parseInt(request.getParameter("discount"));
			System.out.println("discount : " + discount );
			
			BasketVO basketItem = new BasketVO();
			basketItem.setItem_idx(category_idx);
			basketItem.setCategory(category);
			basketItem.setCount(count);
			basketItem.setSale(discount);
			
		   ItemVO item = new ItemVO();
		   ItemDAO itemDao = new ItemDAO();
		   
		   item = itemDao.selectDetailItem(category_idx);
		   
		   int staticPrice = item.getPrice();

			// 단일 제품 조회
			BasketDAO basketDao = new BasketDAO();
			BasketVO basket = new BasketVO();
			List<BasketVO> checkItemInBasket= basketDao.showBasketOne(category_idx, user_idx, staticPrice);

			System.out.println("InsertBasketServlet => showBasketOne() => checkItemInBasket  : " + checkItemInBasket);
			
			if(checkItemInBasket.isEmpty()){
				// 제품 추가 메서드 호출
				System.out.println("장바구니에 제품이 없을 때");
				basketDao.addToBasket(user_idx, basketItem, staticPrice);
				RequestDispatcher rd = request.getRequestDispatcher("../detail/detailList?idx=" + category_idx);
				rd.forward(request, response);
				
			}else {
				// 제품 업데이트 메서드 호출
				System.out.println("장바구니에 제품이 있을 때");
				List<BasketVO> basketList = basketDao.countModifyBasketItem(user_idx, basketItem, staticPrice);

				System.out.println("InsertBasketServlet => countModifyBasketItem() =>  basketList  : " + basketList);
				System.out.println("basketItem.getIdx() : " + basketItem.getIdx());
				RequestDispatcher rd = request.getRequestDispatcher("../detail/detailList?idx=" + category_idx);
				request.setAttribute("basketList", basketList);
				rd.forward(request, response);
				
			}

		} 
//		} else {
//			System.out.println("[SLOG] 세션이 존재하지 않습니다.");

//		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}