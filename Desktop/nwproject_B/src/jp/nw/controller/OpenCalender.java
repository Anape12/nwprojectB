package jp.nw.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
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
@WebServlet("/OpenCalender")
public class OpenCalender extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public UserView() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// ユーザーID取得
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("loginUser");
			String userId = user.getName();

			String s_year=request.getParameter("year");
			String s_month=request.getParameter("month");
			// インスタンス生成に伴い、取得するユーザーＩＤを設定
			MyCalendarLogic logic=new MyCalendarLogic(userId);
 			MyCalendar mc=null;
 			if(s_year != null && s_month != null) {
 				int year =Integer.parseInt(s_year);
 				int month=Integer.parseInt(s_month);
 				if(month==0) {
 					month=12;
 					year--;
 				}
 				if(month==13) {
 					month=1;
 					year++;
 				}
 				//年と月のクエリパラメーターが来ている場合にはその年月でカレンダーを生成する
 					mc=logic.createMyCalendar(year,month);
 			}else {
 				//クエリパラメータが来ていないときは実行日時のカレンダーを生成する。
 				mc=logic.createMyCalendar();
 			}
 			//リクエストスコープに格納
 			request.setAttribute("mc", mc);
 			//viewにフォワード
 			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/calender/calender.jsp");
 			rd.forward(request, response);											
		} catch (Exception e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	}

}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=Shift_JIS");
		// スケジュール月取得
		String month = request.getQueryString();
		request.setAttribute("month", month);
				
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/calender/schedule.jsp");
		dispatcher.forward(request, response);
	}

}
