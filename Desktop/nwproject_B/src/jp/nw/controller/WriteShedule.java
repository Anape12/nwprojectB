package jp.nw.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.nw.model.MyCalendar;
import jp.nw.model.MyCalendarLogic;
import jp.nw.model.User;
import jp.nw.model.UserViewLogic;


/**
 * Servlet implementation class UserView
 */
@WebServlet("/WriteShedule")
public class WriteShedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteShedule() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String s_year=request.getParameter("YEAR");
			String s_month=request.getParameter("MONTH");
			String s_day=request.getParameter("DAY");

			//viewにフォワード
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/Schedule/UserSchedule.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	}

}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=Shift_JIS");
		
		// スケジュールの取得
		String s_year=request.getParameter("progyear");
		String s_month=request.getParameter("progmonth");
		String s_day=request.getParameter("progday");

		// 選択されたユーザーIDを取得
		String userId = request.getParameter("radiobutton");
		// ユーザー情報編集
		UserViewLogic userview = new UserViewLogic();
		List<User> userList = userview.editUserInfo(userId);
		request.setAttribute("userList",userList);
		
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			response.sendRedirect("/nwproject_B/");
			request.setCharacterEncoding("UTF-8");
			request.setAttribute("errorMsg","エラー");
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/editUserInfo.jsp");
			dispatcher.forward(request, response);
		}		
	}

}
