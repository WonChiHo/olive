package com.wch.servlet;

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

@WebServlet("/user/paymentInsert")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    PaymentDAO paymentDAO = null;
    public PaymentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		// 합칠때 지우기
		response.setContentType("text/html;charset=UTF-8"); // 합칠때 지우기
		
		paymentDAO = new PaymentDAO();
		Payment payment= new Payment();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		payment.setUser_idx(user.getIdx()); //나중에 세션값으로 바꿈
		payment.setItem_idx(Integer.parseInt(request.getParameter("item_idx")));
		payment.setPrice(Integer.parseInt(request.getParameter("price")));
		payment.setCount(Integer.parseInt(request.getParameter("count")));
		paymentDAO.insertPayment(payment);
		
		response.sendRedirect("../detail/detailList?idx="+request.getParameter("item_idx"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
