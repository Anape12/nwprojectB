package jp.nw.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import jp.nw.parts.DBBase;
import jp.nw.parts.DaoPart;

public class UpdateLogic {
//	static final String URL = "jdbc:mysql://localhost:3306/family?serverTimezone=JST";
//	static final String USER = "root";
//	static final String PASSWORD = "4062tomi";
	PreparedStatement ps = null;
	Connection con = null;
	Map<Object,Object> param = new HashMap<>();

	public void execute(User user) {

		try {

			// ユーザー情報チェック処理
			if(!userInfoCheck(user)) {
				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame, "値を更新してください");
			} else {
				con = DriverManager.getConnection(DBBase.Base.URL, DBBase.Base.USER , DBBase.Base.PASSWORD);
				 StringBuilder sb = new StringBuilder();
			        sb.append(DaoPart.SQL.UPDATE);
			        sb.append(DaoPart.SQL.SPACE);
			        sb.append("users");
			        sb.append(DaoPart.SQL.SPACE);
			        sb.append(DaoPart.SQL.SET);
			        sb.append(DaoPart.SQL.SPACE);
			        sb.append("password");
			        sb.append(DaoPart.SQL.EQUARL);
			        sb.append("?");
			        sb.append(DaoPart.SQL.SPACE);
			        sb.append(DaoPart.SQL.WHEHE);
			        sb.append(DaoPart.SQL.SPACE);
			        sb.append("name");
			        sb.append(DaoPart.SQL.EQUARL);
			        sb.append(DaoPart.SQL.SPACE);
			        sb.append("?");

			        ps = con.prepareStatement(sb.toString());

			        ps.setString(1, user.getnewPass());
					ps.setString(2, user.getName());

					con.setAutoCommit(false);
					try {
						int result = ps.executeUpdate();
						System.out.println("結果" + result);
						con.commit();
					} catch (Exception e) {
						 // ロールバック
		                con.rollback();
					}
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			 // 各オブジェクトを解放する
            if(ps != null) {
                try {
                	ps.close();
                }catch (Exception e) {
                    System.out.println(e.getMessage());
              }
            }
            if(con != null) {
                try {
                    con.close();
                }catch (Exception e) {
                    System.out.println(e.getMessage());
              }
		}
	}
	}

	/**
	 * ユーザー情報更新チェック処理
	 * @param user
	 * @return boolean
	 */
	private boolean userInfoCheck(User user) {
		String name = "";
		String pass = "";
		try {
			con = DriverManager.getConnection(DBBase.Base.URL, DBBase.Base.USER , DBBase.Base.PASSWORD);
			String sql = "SELECT name, password FROM users WHERE name = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getName());

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				name = rs.getString("name");
				pass = rs.getString("password");
			}
			if(name.equals(user.getName())) {
				return false;
			}
			if(pass.equals(user.getPass())) {
				return false;
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return true;
	}
}
