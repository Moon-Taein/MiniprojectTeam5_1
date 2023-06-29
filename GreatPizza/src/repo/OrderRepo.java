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
	
	public List<MainOrder> getMainOrders(String status){
		String sql = "SELECT * FROM mainorder WHERE state = ?";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<MainOrder> list = new ArrayList<>();
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, status);
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
	
	public List<DetailOrder> getDetailOrders(int id) {
		String sql = "SELECT * FROM detailorder WHERE mainorder = ?";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<DetailOrder> list = new ArrayList<>();
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt("no");
				String menu = rs.getString("menu");
				int mainOrder = rs.getInt("mainorder");
				int count = rs.getInt("menu_count");
				
				list.add(new DetailOrder(no, menu, mainOrder, count));
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
	
	public List<Ingredient> getIngredients(){
		String sql = "SELECT * FROM ingredient";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Ingredient> list = new ArrayList<>();
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("inventory_id");
				String name = rs.getString("inventory_name");
				int priceRetail = rs.getInt("price_retail");
				int priceSupply = rs.getInt("price_supply");
				int lowerCount = rs.getInt("lower_limit_count");
				int currentCount = rs.getInt("current_count");
				
				list.add(new Ingredient(id, name, priceRetail, priceSupply, lowerCount, currentCount));
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
		String sql = "SELECT * FROM ingredient WHERE inventory_id \r\n" + 
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
				String id = rs.getString("inventory_id");
				String name = rs.getString("inventory_name");
				int priceRetail = rs.getInt("price_retail");
				int priceSupply = rs.getInt("price_supply");
				int lowerCount = rs.getInt("lower_limit_count");
				int currentCount = rs.getInt("current_count");
				
				list.add(new Ingredient(id, name, priceRetail, priceSupply, lowerCount, currentCount));
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
	
	public Ingredient getIngredient(String menu) {
		String sql = "SELECT * FROM ingredient WHERE inventory_id = ?";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, menu);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("inventory_id");
				String name = rs.getString("inventory_name");
				int priceRetail = rs.getInt("price_retail");
				int priceSupply = rs.getInt("price_supply");
				int lowerCount = rs.getInt("lower_limit_count");
				int currentCount = rs.getInt("current_count");
				
				return new Ingredient(id, name, priceRetail, priceSupply, lowerCount, currentCount);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return null;
	}
	
	public List<Ingredient> getIngredients(int no) {
		String sql = "SELECT * FROM ingredient WHERE inventory_id \r\n" + 
				"IN (SELECT inventory_id FROM addingredient WHERE detailorder_no = ?)";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Ingredient> list = new ArrayList<>();
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, no);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("inventory_id");
				String name = rs.getString("inventory_name");
				int priceRetail = rs.getInt("price_retail");
				int priceSupply = rs.getInt("price_supply");
				int lowerCount = rs.getInt("lower_limit_count");
				int currentCount = rs.getInt("current_count");
				
				list.add(new Ingredient(id, name, priceRetail, priceSupply, lowerCount, currentCount));
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
	
	public int updateMainOrder(String state, int no) {
		String sql = "UPDATE mainorder SET state = ? WHERE no = ?";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, state);
			stmt.setInt(2, no);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return 0;
	}
	
	public int minusIngredient(int count, String id) {
		String sql = "UPDATE ingredient SET current_count = current_count - ? WHERE inventory_id = ?";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, count);
			stmt.setString(2, id);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return 0;
	}
	
	public int plusIngredient(int number, String id) {
		String sql = "UPDATE ingredient SET current_count = current_count + ? WHERE inventory_id = ?";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, number);
			stmt.setString(2, id);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return 0;
	}
	
	public int plusAccount(int sales, String date) {
		String sql = "UPDATE account SET sales = sales + ? WHERE date = ?";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, sales);
			stmt.setString(2, date);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return 0;
	}
	
	public int insertIngredient(String name, String priceRetail, String priceSupply, String lowerCount, String type) {
		String sql = "INSERT INTO ingredient \r\n" + 
				"(inventory_id, inventory_name, price_retail, price_supply, lower_limit_count, current_count)\r\n" + 
				"VALUES (?, ?, ?, ?, ?, 0)";
		String id = type + "_" + name;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, name);
			stmt.setString(3, priceRetail);
			stmt.setString(4, priceSupply);
			stmt.setString(5, lowerCount);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return 0;
	}
	
}
