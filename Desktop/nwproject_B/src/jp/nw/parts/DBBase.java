package jp.nw.parts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBBase {

	private Connection con = null;
	// SQLパラメータ一時退避領域
	private Map<String, Object> param = new HashMap<>();
	//SELECT情報一時退避領域
	private List<String> selectInfo = new ArrayList<String>();
	//WHERE句情報一時退避領域
	private List<String> whereInfo = new ArrayList<String>();
	// 発行SQL
	private StringBuilder sb = null;

	public static interface Base {
		public static final String URL = "jdbc:mysql://localhost:3306/family?serverTimezone=JST";
		public static final String USER = "root";
		public static final String PASSWORD = "4062tomi";
	};

	public DBBase() {
		try {
			// Connection生成
			this.con = DriverManager.getConnection(Base.URL, Base.USER, Base.PASSWORD);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public String selectSql(Map<String, Object> sqlWardInfo, Map<String, Object> sqlResultInfo, String table) {
		try {

			// 一時退避領域へ各パラメータを格納
			this.selectInfo = (List<String>) sqlWardInfo.get(DaoPart.KOMOKU_INFO.SELECT_INFO);
			this.whereInfo = (List<String>) sqlResultInfo.get(DaoPart.KOMOKU_INFO.WHERE_INFO);

			// SQL発行
			sb = new StringBuilder();
			sb.append(DaoPart.SQL.SELECT);
			sb.append(DaoPart.SQL.SPACE);

			for (int i = 0; i < this.selectInfo.size(); i++) {
				sb.append(this.selectInfo.get(i));
				sb.append(",");
			}
			// 末尾のカンマを削除
			sb.setLength(sb.length() - 1);

			sb.append(DaoPart.SQL.SPACE);
			sb.append(DaoPart.SQL.FROM);
			sb.append(DaoPart.SQL.SPACE);
			if (table != null || table != "") {
				sb.append(table);
			}
			sb.append(DaoPart.SQL.SPACE);
			sb.append(DaoPart.SQL.WHEHE);
			sb.append(DaoPart.SQL.SPACE);
			sb.append("?");

			// バインド変数定義
			PreparedStatement ps = con.prepareStatement(sb.toString());
			
		} catch (SQLException e) {
			// Error処理
			e.printStackTrace();
		}

		return null;
	}
}