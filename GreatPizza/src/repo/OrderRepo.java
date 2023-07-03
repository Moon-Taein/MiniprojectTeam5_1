package repo;

import java.sql.*;
import java.util.*;
import java.util.AbstractMap.SimpleEntry;

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
				String id = rs.getString("ingredient_id");
				String name = rs.getString("ingredient_name");
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
	
	public List<Ingredient> findIngredients(String find){
		String sql = "SELECT * FROM ingredient WHERE ingredient_id Like ?";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Ingredient> list = new ArrayList<>();
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			String line = "%"+find+"%";
			stmt.setString(1, line);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("ingredient_id");
				String name = rs.getString("ingredient_name");
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
		String sql = "SELECT * FROM ingredient WHERE ingredient_id \r\n" + 
				"IN (SELECT ingredient_id FROM recipe WHERE menu_id = ?);";
		
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
				String id = rs.getString("ingredient_id");
				String name = rs.getString("ingredient_name");
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
		String sql = "SELECT * FROM ingredient WHERE ingredient_id = ?";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, menu);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("ingredient_id");
				String name = rs.getString("ingredient_name");
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
		String sql = "SELECT * FROM ingredient WHERE ingredient_id \r\n" + 
				"IN (SELECT ingredient_id FROM addingredient WHERE detailorder_no = ?)";
		
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
				String id = rs.getString("ingredient_id");
				String name = rs.getString("ingredient_name");
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
		String sql = "UPDATE ingredient SET current_count = current_count - ? WHERE ingredient_id = ?";
		
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
		String sql = "UPDATE ingredient SET current_count = current_count + ? WHERE ingredient_id = ?";
		
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
	
	public int deleteIngredient(String id) {
		String sql = "DELETE FROM ingredient WHERE ingredient_id = ?";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return 0;
	}
	
	public int plusDay(String date) {
		if (plusAccount(0, date) == 0) {
			String sql = "INSERT account (date, purchase, sales) VALUES (?, 0, 0); ";
			Connection conn = null;
			PreparedStatement stmt = null;
			try {
				conn = DBUtil.getConnection();
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, date);
				return stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.close(stmt);
				DBUtil.close(conn);
			}
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
	
	public int minusAccount(int purchase, String date) {
		String sql = "UPDATE account SET purchase = purchase + ? WHERE date = ?";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, purchase);
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
	
	public int updateAsset(String date) {
		String[] dates = date.split("-");
		System.out.println(dates[1].toString());
		String sql = "UPDATE asset SET money = (SELECT sum(total_price) from mainorder WHERE 주문날짜 like ?) WHERE month = ?;";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			String month = dates[0] + "-" + dates[1] + "%"; 
			stmt.setString(1, month);
			stmt.setInt(2, Integer.valueOf(dates[1]));
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
				"(ingredient_id, ingredient_name, price_retail, price_supply, lower_limit_count, current_count)\r\n" + 
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
	
	public String todaySales(String date) {
		String sql = "SELECT * FROM account WHERE date = ?";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, date);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return rs.getString("sales");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return "0";
	}
	public String todayPurchase(String date) {
		String sql = "SELECT * FROM account WHERE date = ?";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, date);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return rs.getString("purchase");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return "0";
	}
	
	public String soldtoday(String date) {
		String sql = "SELECT COUNT(*) FROM mainorder WHERE 주문날짜 = ? AND state = '확인';";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, date);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return rs.getString("COUNT(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return "0";
	}
	
	public Map<Integer, List<String>> bestMonth(String year) {
		String sql = "SELECT month, money FROM asset WHERE year = ? ORDER BY money DESC LIMIT 5";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Map<Integer, List<String>> map = new LinkedHashMap<>();
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, year);
			rs = stmt.executeQuery();
			int i = 1;
			while (rs.next()) {
				List<String> list = new ArrayList<>();
				list.add(rs.getString("month"));
				list.add(rs.getString("money"));
				map.put(i, list);
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return map;
	}
	
	public Map<Integer, List<String>> months() {
		String sql = "SELECT month, money FROM asset LIMIT 12";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Map<Integer, List<String>> map = new LinkedHashMap<>();
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			int i = 1;
			while (rs.next()) {
				List<String> list = new ArrayList<>();
				list.add(rs.getString("month"));
				list.add(rs.getString("money"));
				map.put(i, list);
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return map;
	}
	
	public Map<Integer, List<String>> bestMenu() {
		String sql = "SELECT menu, SUM(menu_count) AS menu_count\r\n"
				+ "FROM detailorder WHERE no IN (SELECT no FROM mainorder WHERE state = '확인')\r\n"
				+ "GROUP BY menu ORDER BY menu_count DESC";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Map<Integer, List<String>> map = new LinkedHashMap<>();
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			int i = 1;
			while (rs.next()) {
				List<String> list = new ArrayList<>();
				list.add(rs.getString("menu"));
				list.add(rs.getString("menu_count"));
				map.put(i, list);
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return map;
	}
	
	
}
