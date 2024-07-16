package com.ljy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ljy.OrderDAO;
import com.ljy.OrderVO;

@WebServlet("/OrderListServlet")
public class OrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private OrderDAO orderDAO = null;
    public OrderListServlet() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		this.orderDAO = new OrderDAO();
		List<OrderVO> orderList = this.orderDAO.selectList();
		request.setAttribute("orderList", orderList);
		
		RequestDispatcher requestDispatcher = 
				request.getRequestDispatcher("/admin_order.jsp");
		requestDispatcher.forward(request, response);
	}

}
