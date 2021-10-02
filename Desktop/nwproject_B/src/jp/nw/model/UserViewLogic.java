package jp.nw.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.nw.parts.DBBase;

public class UserViewLogic {
//	static final String URL = "jdbc:mysql://localhost:3306/family?serverTimezone=JST";
//	static final String USER = "root";
//	static final String PASSWORD = "4062tomi";
	
	/**
	 * ユーザ―情報一覧表示
	 * */
	public List<User> findAll(){
		List<User> userList = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(DBBase.Base.URL, DBBase.Base.USER , DBBase.Base.PASSWORD)){
			String sql = "SELECT id, name,password,permission_level FROM users where 削除フラグ = '0' ORDER BY id";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt("id");
				String name = rs.getString("name");
				String pass = rs.getString("password");
				int permission = rs.getInt("permission_level");
				User mutter = new User(num, name, pass, permission);
				userList.add(mutter);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return userList;
	}
	/**
	 * 編集ユーザ－情報取得
	 * */
	public List<User> editUserInfo(String userId){
		List<User> userList = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(DBBase.Base.URL, DBBase.Base.USER , DBBase.Base.PASSWORD)){
			String sql = "SELECT name,password,permission_level FROM users where name =? ORDER BY id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString("name");
				String pass = rs.getString("password");
				int permission = rs.getInt("permission_level");
				User mutter = new User(name,pass,permission);
				userList.add(mutter);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return userList;
	}
	/**
	 * ユーザー情報変更確定処理
	 * */
	public List<User> confirUserInfo(String nowId, String userId, String userPass, String userPermission) {
		List<User> userList = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(DBBase.Base.URL, DBBase.Base.USER , DBBase.Base.PASSWORD)){
			String sql = "UPDATE users Set name = ?, password = ?, permission_level = ? where name=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			int permission = Integer.parseInt(userPermission) ;
			ps.setString(1, userId);
			ps.setString(2, userPass);
			ps.setInt(3, permission);
			ps.setString(4, nowId);
			// 更新処理
			int num =ps.executeUpdate();
			if(num == 0) {
				userList = findAll();
				return userList;
			} else {
				userList = findAll();
				return userList;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}