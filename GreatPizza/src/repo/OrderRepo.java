package repo;

import java.sql.*;
import java.util.*;

public class OrderRepo {

	public List<MainOrder> getList() {
		String sql = "SELECT * FROM mainorder";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<MainOrder> list = new ArrayList<>();
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt("no");
				int totalprice = rs.getInt("total_price");
				String date = rs.getString("주문날짜");
				String time = rs.getString("주문시간");
				String state = rs.getString("state");
				
				list.add(new MainOrder(no, totalprice, date, time, state));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return list;
	}

//	public List<MainOrder> getDetailOrder() {
//		
//	}
//	

}
