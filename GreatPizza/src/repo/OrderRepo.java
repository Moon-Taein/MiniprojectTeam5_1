package repo;

import java.sql.*;
import java.util.*;

public class OrderRepo {

	public List<MainOrder> getMainOrders() {
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
	
	public List<DetailOrder> getDetailOrders(int no) {
		String sql = "SELECT * FROM detailorder WHERE mainorder = ?";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<DetailOrder> list = new ArrayList<>();
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, no);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String menu = rs.getString("menu");
				int mainOrder = rs.getInt("mainorder");
				
				list.add(new DetailOrder(menu, mainOrder));
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
	
	public List<Ingredient> getIngredients(String menu){
		String sql = "SELECT inventory_name, lower_limit_count, current_count \r\n" + 
				"FROM ingredient WHERE inventory_id \r\n" + 
				"IN (SELECT inventory_id FROM recipe WHERE menu_id = ?);";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Ingredient> list = new ArrayList<>();
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, menu);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("inventory_name");
				int lowerCount = rs.getInt("lower_limit_count");
				int currentCount = rs.getInt("current_count");
				
				list.add(new Ingredient(name, lowerCount, currentCount));
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
	


}
