package repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PosRepo {
	private List<Menu> list = null;
	private List<Ingredient> listIg = null;
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	public List<Menu> menuIdPrice() {
		list = new ArrayList<>();

		String sql = "select menu_id,menu_name,Price from menu";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("menu_id");
				String name = rs.getString("menu_name");
				int price = rs.getInt("price");

				list.add(new Menu(id, name, price));
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

	public List<Ingredient> ingredientID(String type) {
		listIg = new ArrayList<>();

		String sql = "select ingredient_id from ingredient where ingredient_id like '" + type + "%'";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("ingredient_id");
				listIg.add(new Ingredient(id));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return listIg;
	}

	public Set<Integer> year() {
		Set<Integer> listY = new HashSet();
		String sql = "select year from asset";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Integer year = rs.getInt("year");
				listY.add(year);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return listY;
	}

	public List<Integer> month(Integer year) {
		List<Integer> list = new ArrayList();
		String sql = "select month from asset where year = " + year;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Integer month = rs.getInt("month");
				list.add(month);
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

	public List<Integer> monthYear() {

		return null;
	}

	public static void main(String[] args) {
		PosRepo pr = new PosRepo();
	}
}
