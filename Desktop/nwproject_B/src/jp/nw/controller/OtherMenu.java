package jp.nw.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.nw.model.LoginLogic;
import jp.nw.model.User;
import jp.nw.parts.DaoPart;


/**
 * Servlet implementation class Login
 */
@WebServlet("/OtherMenu")
public class OtherMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String URL = "jdbc:mysql://localhost:3306/family?serverTimezone=JST";
	static final String USER = "root";
	static final String PASSWORD = "4062tomi";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OtherMenu() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/WEB-INF/jsp/preMenu.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("userInfo");
		String getName = "";
		String pass = "";
		List<User> userList = new ArrayList<>();
		User user = null;
		try {
			Connection con = DriverManager.getConnection(URL, USER , PASSWORD);
			String sql = "SELECT name, password from users where name = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				getName = rs.getString("name");
				pass = rs.getString("password");
			}
			user = new User(getName,pass);
//			userList.add(user);

//			request.setAttribute("userList",userList);
			
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/preMenu.jsp");
			dispatcher.forward(request, response);

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	
}
