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
	private List<Account> listAc = null;
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

		String sql = "select inventory_id from ingredient where inventory_id like '" + type + "%'";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("inventory_id");
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

	public List<Account> monthYear매입매출(String dateDay) {
		listAc = new ArrayList();
		String sql = "select * from account where date like '" + dateDay + "-%' ORDER BY date ASC;";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				String date = rs.getString("date");
				Integer purchase = Integer.valueOf(rs.getString("purchase"));
				Integer sales = Integer.valueOf(rs.getString("sales"));
				listAc.add(new Account(date, purchase, sales));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}

		return listAc;
	}

	public String cost(String month) {
		String totalCost = "";
		String sql = "select money from asset where month = " + month;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				totalCost = rs.getString("money");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return totalCost;
	}

	public int InsertSide(String type, String name, String size, String price) {
		String sql = "INSERT INTO menu (Menu_id,Menu_name,size,price) VALUES (?,?,?,?)";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			String menuId = type + "_" + name;

			stmt.setString(1, menuId);
			stmt.setString(2, name);
			stmt.setString(3, size);
			stmt.setString(4, price);
//				stmt.setString(4, priceSupply);

			System.out.println("메뉴에 사이드가 추가 됐다!");
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return 0;
	}

	public int InsertDrink(String type, String name, String size, String price) {
		String sql = "INSERT INTO menu (Menu_id,Menu_name,price) VALUES (?,?,?)";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			String menuId = type + "_" + name;
			String menuName = name + size;

			stmt.setString(1, menuId);
			stmt.setString(2, menuName);
			stmt.setString(3, price);
			System.out.println("메뉴에 음료가 추가 됐다!");
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return 0;
	}

	// 피자는 메뉴 용 하나, 레시피용 하나가 필요합니다. 주의 하세요
	public int InsertPizzaMenu(String type, String name, String size, String price) {
		String sql = "INSERT INTO menu (Menu_id,Menu_name,size,price) VALUES (?,?,?,?)";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			String menuName = name + size;
			String menuId = type + "_" + menuName;

			stmt.setString(1, menuId);
			stmt.setString(2, menuName);
			stmt.setString(3, size);
			stmt.setString(4, price);
			System.out.println("메뉴에 피자가 추가 됐다!");
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return 0;
	}

	// 피자는 메뉴 용 하나, 레시피용 하나가 필요합니다. 주의 하세요
	public int InsertPizzaRecipe() {
		String sql = "INSERT INTO menu (Menu_id,inventory_ID,count) VALUES (?,?,?)";

		return 0;
	}

	public static void main(String[] args) {
		PosRepo pr = new PosRepo();
	}

}
