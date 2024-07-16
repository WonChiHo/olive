package com.ljy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ljy.ItemDAO;
import com.ljy.ItemVO;

@WebServlet("/ItemDeleteServlet")
public class ItemDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ItemDAO itemDAO = null;
    public ItemDeleteServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n = Integer.parseInt(request.getParameter("idx"));
		
		ItemVO itemvo = new ItemVO();
		itemvo.setIdx(n);
		
		itemDAO = new ItemDAO();
		itemDAO.delete(itemvo);
		
		response.sendRedirect("ItemListServlet");
	
	
	
	
	}


}
