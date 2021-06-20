package jp.nw.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;

import jp.nw.model.UpdateLogic;
import jp.nw.model.User;

/**
 * Servlet implementation class UserUpdate
 */
@WebServlet("/UserInsert")
public class UserInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("WEB-INF/jsp/RegUser/userInsert.jsp");
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userid");
		String userPass = request.getParameter("userpass");
		String year = request.getParameter("birthYear");
		String month = request.getParameter("birthMonth");
		String date = request.getParameter("birthDate");
		// 生年月日を結合
		StringBuilder sb = new StringBuilder();
		sb.append(year);
		sb.append("-");
		sb.append(month);
		sb.append("-");		
		sb.append(date);
		// 権限レベルをint型へ
		String userPermis = request.getParameter("userpermis");
		int figPermis = Integer.parseInt(userPermis);
		
		User user = new User(userId,userPass,sb.toString(),figPermis);

		HttpSession session = request.getSession();
		session.setAttribute("loginUser",user);
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("WEB-INF/jsp/RegUser/userInsertCheck.jsp");
		dispatcher.forward(request, response);

	}

}
