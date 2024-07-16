package com.ljy.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ljy.ItemDAO;
import com.ljy.ItemVO;


@WebServlet("/ItemAddServlet")
public class ItemAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private ItemDAO itemDAO = null;
    
    public ItemAddServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin_itemAdd.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//카테고리, 상품명, 상품 사진, 상품 가격, 상품 상세 설명
		String category = request.getParameter("category");
		String title = request.getParameter("title");
		String image = request.getParameter("image");
		Integer price = Integer.parseInt(request.getParameter("price"));
		String detail = request.getParameter("detail");
		
		ItemVO itemvo = new ItemVO();
		itemvo.setCategory(category);
		itemvo.setTitle(title);
		itemvo.setImage(image);
		itemvo.setPrice(price);
		itemvo.setDetail(detail);
		
		this.itemDAO = new ItemDAO();
		this.itemDAO.insert(itemvo);
		
		response.sendRedirect("ItemListServlet");
	}

}
