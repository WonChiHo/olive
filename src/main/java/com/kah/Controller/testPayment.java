package com.kah.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.coh.vo.User;
import com.wch.dao.PaymentDAO;
import com.wch.dto.Payment;


@WebServlet("/testPayment")
public class testPayment extends HttpServlet {
	PaymentDAO paymentDAO = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
	//	String value1 = request.getParameter("totalAmountInput");
	//	System.out.println("totalAmountInput:" + value1);
		
//		String[] product_title = request.getParameterValues("ProductTitle");
//		for(String title : product_title) {
//			System.out.println("상품 제목들 : " + title);
//		}
		String[] item_idx = request.getParameterValues("category_idxInput"); // 상품 아이디 
//		for(String itemId : item_idx) {
//			System.out.println("상품 아이디 : " + itemId);
//		}
		String[] item_count = request.getParameterValues("countInput"); // 상품 수량 
//		for(String itemCount : item_count) {
//			System.out.println("상품 수량 : " + itemCount);
//		}	
		String[] applySalePriceInput  = request.getParameterValues("applySalePriceInput"); // 상품 가격
//		for(String itemPrice : applySalePriceInput) {
//			System.out.println("상품 가격 : " + itemPrice);
//		}
		
		String[] itemIdx = item_idx[0].split(","); // 쉼표를 기준으로 문자열을 분리하여 배열
		String[] price = applySalePriceInput[0].split(",");
		String[] count = item_count[0].split(",");
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		int user_idx = user.getIdx();
		
		paymentDAO = new PaymentDAO();
		Payment payment = null;
		for(int i=0; i<itemIdx.length;i++) {
			payment =new Payment();
			
			payment.setUser_idx(user_idx);
			payment.setItem_idx(Integer.parseInt(itemIdx[i].trim()));
			payment.setPrice(Integer.parseInt(price[i].trim()));
			payment.setCount(Integer.parseInt(count[i].trim()));
			
			paymentDAO.insertPayment(payment);
		}
		response.sendRedirect("user/ShowBasket");
		
	}

}

