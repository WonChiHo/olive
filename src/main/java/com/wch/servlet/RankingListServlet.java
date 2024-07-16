package com.wch.servlet;

import java.io.IOException;
import java.util.ArrayList;

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
@WebServlet("/ranking/rankingList")
public class RankingListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ItemDAO itemDAO = null;
	
    public RankingListServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		// 합칠때 지우기
		response.setContentType("text/html;charset=UTF-8"); // 합칠때 지우기
		
		itemDAO = new ItemDAO();
		ArrayList<Item> itemList = new ArrayList<Item>();
		itemList = itemDAO.selectSortHit();
		
		ArrayList<Integer> salePrice = new ArrayList<Integer>();
		
		for(int i=0; i<itemList.size();i++) {
			float dicount=0;
			
			if(itemList.get(i).getDiscount() !=0) {
				dicount = itemList.get(i).getPrice()*((float)(100-itemList.get(i).getDiscount())/100);
				salePrice.add((int)(dicount/10)*10);
			}else {
				salePrice.add(0);
			}
		}
		
		RequestDispatcher rd = null;
		request.setAttribute("itemList", itemList);
		request.setAttribute("salePrice", salePrice);
		rd = request.getRequestDispatcher("/ranking/ranking.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
