package jp.nw.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.nw.model.User;


/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		// ID/passwordの取得
		String name = request.getParameter("userId");
		String pass = request.getParameter("password");
		// ID/password取得クラス
		User user = new User(name,pass);
//		LoginLogic loginLogic = new LoginLogic();
//		boolean isLogin = loginLogic.execute(user);
		
//		if(isLogin) {
//			HttpSession session = request.getSession();
//			session.setAttribute("loginUser",user);
//		}
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("WEB-INF/jsp/loginResult.jsp");
		dispatcher.forward(request,response);
	}

}
