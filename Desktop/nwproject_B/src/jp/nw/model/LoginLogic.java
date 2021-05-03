package jp.nw.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginLogic {
	static final String URL = "jdbc:mysql://localhost:3306/family?serverTimezone=JST";
	static final String USER = "root";
	static final String PASSWORD = "4062tomi";
	Map<Object,Object> param = new HashMap<>();
	//SELECT情報抽出
//	List selectInfo = new ArrayList();
//	//WHERE情報抽出
//	List whereInfo = new ArrayList();
//
//	public Map<Object,Object> execute(User user, Map<Object,Object> info, String table) {
//		
//		try {
//		Connection con = DriverManager.getConnection(URL, USER , PASSWORD);
//		
//		selectInfo = (List)info.get(DaoPart.KOMOKU_INFO.SELECT_INFO);
//		whereInfo = (List)info.get(DaoPart.KOMOKU_INFO.WHERE_INFO);
//		
//		 StringBuilder sb = new StringBuilder();
//	        sb.append(DaoPart.SQL.SELECT);
//	        sb.append(DaoPart.SQL.SPACE);
//	  
//	        for(int i=0; i<selectInfo.size();i++) {
//	        	sb.append(selectInfo.get(i));
//	        }
//	        
//	        sb.append(DaoPart.SQL.SPACE);
//	        sb.append(DaoPart.SQL.FROM);
//	        sb.append(DaoPart.SQL.SPACE);
//	        if(table != null || table != "") {
//	        	sb.append(table);
//	        }
//	        sb.append(DaoPart.SQL.SPACE);
//	        sb.append(DaoPart.SQL.WHEHE); 
//	        sb.append(DaoPart.SQL.SPACE);
//
//	        for(int i=0; i<whereInfo.size();i++) {
//	        	sb.append(whereInfo.get(i));
//	        }
//	        
//	        sb.append(DaoPart.SQL.SPACE);
//	        sb.append(DaoPart.SQL.EQUARL);
//	        sb.append(DaoPart.SQL.SPACE);
//	        sb.append("?");     
//	        
//	        PreparedStatement ps = con.prepareStatement(sb.toString());
//		
//			ps.setString(1, user.getName());
//			ResultSet result = ps.executeQuery();
//			
//			//　パスワード・権限レベルを格納
//			while(result.next()) {
//				param.put("password", result.getString("password"));
//				param.put("level", result.getInt("permission_level"));
//            }
//			
//			if(user.getPass().equals(param.get("password"))) {
//				param.put("result",true);
//				return param;
//			} else {
//				param.put("result",false);
//				return param;
//			}
//
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//		return param;
//	}

}
