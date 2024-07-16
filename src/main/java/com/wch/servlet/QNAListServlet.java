package com.wch.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.wch.dao.QNADAO;
import com.wch.dto.QNA;

/**
 * Servlet implementation class RankingListServlet
 */
@WebServlet("/qna/qnaList")
public class QNAListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	QNADAO qnaDAO = null;
	
    public QNAListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		// 합칠때 지우기
		response.setContentType("text/html; charset=utf-8");
		qnaDAO= new QNADAO();
		ArrayList<QNA> qnaList = new ArrayList<QNA>();
		
		PrintWriter out = response.getWriter();
		qnaList = qnaDAO.selectQNA(Integer.parseInt(request.getParameter("item_idx")));
		JSONObject qnaArrayList = new JSONObject();
		JSONArray qnaArray = new JSONArray();
		JSONObject qna = null;
		
		for(int i=0; i<qnaList.size();i++) {
			qna = new JSONObject();
			qna.put("idx", qnaList.get(i).getIdx());
			qna.put("user_id",qnaList.get(i).getUser_id());
			qna.put("item_idx",qnaList.get(i).getItem_idx());
			qna.put("questionContent",qnaList.get(i).getQuestionContent());
			qna.put("answer",qnaList.get(i).getAnswer());
			qna.put("moment",""+qnaList.get(i).getMoment());
			qnaArray.add(qna);
		}
		
		qnaArrayList.put("qnaList", qnaArray);

		String info = qnaArrayList.toJSONString();
		//System.out.println(info);
		out.print(info);

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
