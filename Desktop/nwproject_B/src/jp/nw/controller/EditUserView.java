package jp.nw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.nw.model.User;
import jp.nw.model.UserViewLogic;


/**
 * Servlet implementation class UserView
 */
@WebServlet("/EditUserView")
public class EditUserView extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public UserView() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// ユーザー情報一覧取得処理
//		UserViewLogic userview = new UserViewLogic();
//		List<User> userList = userview.findAll();
//		request.setAttribute("userList",userList);
//		
//		HttpSession session = request.getSession();
//		User loginUser = (User)session.getAttribute("loginUser");
//		
//		if(loginUser == null) {
//			response.sendRedirect("/nwproject_B/");
//		}else {
//			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/userList.jsp");
//			dispatcher.forward(request, response);
//		}		
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=Shift_JIS");
		// 編集されたユーザ情報（ID,パスワード,権限レベル）を取得
		String nowUserId = request.getParameter("nowID");
		String userId = request.getParameter("editID");
		String userPass = request.getParameter("editPass");
		String userPermission = request.getParameter("editPermission");
		// ユーザー情報編集
		UserViewLogic userview = new UserViewLogic();
		List<User> userList = userview.confirUserInfo(nowUserId,userId,userPass,userPermission);
		request.setAttribute("userList",userList);

		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			response.sendRedirect("/nwproject_B/");
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/userList.jsp");
			dispatcher.forward(request, response);
		}		
	}

}
