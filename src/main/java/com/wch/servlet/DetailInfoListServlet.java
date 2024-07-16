package com.wch.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wch.dao.ItemDAO;
import com.wch.dto.Item;

/**
 * Servlet implementation class RankingListServlet
 */
@WebServlet("/detail/detailList")
public class DetailInfoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ItemDAO itemDAO = null;
    public DetailInfoListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		// 합칠때 지우기
		response.setContentType("text/html;charset=UTF-8"); // 합칠때 지우기
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		itemDAO = new ItemDAO();
		Item item = new Item();
		item = itemDAO.selectDetailItem(idx);
		
		itemDAO.updateHit(item.getIdx(), item.getHit());
		
		int salePrice = 0;
		float dicount=0;
		
		if(item.getDiscount() !=0) {
			dicount = item.getPrice()*((float)(100-item.getDiscount())/100);
			salePrice = ((int)(dicount/10)*10);
		}else {
			salePrice=0;
		}
		
		RequestDispatcher rd = null;
		request.setAttribute("item", item);
		request.setAttribute("salePrice", salePrice);
		
		rd = request.getRequestDispatcher("/detail/detailInfo.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
