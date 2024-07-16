package com.ljy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ljy.BoardDAO;
import com.ljy.BoardVO;
import com.ljy.ItemDAO;
import com.ljy.ItemVO;
import com.ljy.MemberDAO;
import com.ljy.MemberVO;
import com.ljy.OrderDAO;
import com.ljy.OrderVO;


@WebServlet("/IndexListServlet")
public class IndexListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberDAO memberDAO = null;
	private OrderDAO orderDAO = null;
	private BoardDAO boardDAO = null;
	private ItemDAO itemDAO = null;
	
    public IndexListServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
    	this.memberDAO = new MemberDAO();
    	this.orderDAO = new OrderDAO();
    	this.boardDAO = new BoardDAO();
    	this.itemDAO = new ItemDAO();
    	
    	ItemVO itemvo = new ItemVO();
    	
		List<MemberVO> memberList = this.memberDAO.selectList();
		List<OrderVO> orderList = this.orderDAO.selectList();
		List<BoardVO> boardList = this.boardDAO.selectList();
		List<ItemVO> itemList = this.itemDAO.selectAll();
		
		request.setAttribute("memberList", memberList);
		request.setAttribute("orderList", orderList);
		request.setAttribute("boardList", boardList);
		request.setAttribute("itemList", itemList);
		
		RequestDispatcher requestDispatcher = 
				request.getRequestDispatcher("/admin_index.jsp");
		requestDispatcher.forward(request, response);
		
	}

}

