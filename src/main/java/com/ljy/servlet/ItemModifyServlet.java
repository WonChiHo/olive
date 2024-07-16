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


@WebServlet("/ItemModifyServlet")
public class ItemModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	private ItemDAO itemDAO = null;
    public ItemModifyServlet() {
        super();
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemVO itemvo = new ItemVO();
		int n = Integer.parseInt(request.getParameter("idx"));
		itemvo.setIdx(n);
		
		itemDAO = new ItemDAO();
		ItemVO itemOne = itemDAO.selectOne(itemvo);
		
		request.setAttribute("itemvo", itemOne);
		
		RequestDispatcher rd=request.getRequestDispatcher("/admin_itemModify.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int n = Integer.parseInt(request.getParameter("idx"));
		
		ItemVO itemvo = new ItemVO();
		itemvo.setIdx(n);
		//카테고리, 상품명, 상품 사진, 상품 가격, 상품 상세 설명
		itemvo.setCategory(request.getParameter("category"));
		itemvo.setTitle(request.getParameter("title"));
		itemvo.setImage(request.getParameter("image"));
		itemvo.setPrice(Integer.parseInt(request.getParameter("price")));
		itemvo.setDetail(request.getParameter("detail"));
		
		ItemDAO idao = new ItemDAO();
		idao.update(itemvo);
		
		response.sendRedirect("ItemListServlet");
	}

}
