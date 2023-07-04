package repo;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.ImageIcon;

import frame.InputImage;

public class PosRepo {
	private List<Menu> list = null;
	private List<Ingredient> listIg = null;
	private List<Account> listAc = null;
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private InputImage ip;
	private int day;
	private byte[] bytesSs;
	private byte[] bytesBs;

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

	public int getPurchase(String date) {
		String sql = "select purchase from account where date = '" + date + "'";
		int purchase = 0;

		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				purchase = rs.getInt("purchase");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return purchase;
	}

	public int getSales(String date) {
		String sql = "select sales from account where date = '" + date + "'";
		int sales = 0;

		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				sales = rs.getInt("sales");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return sales;
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

	public int InsertSide(String type, String name, String price, byte[] bytes) {
		ip = new InputImage();

		String sql = "INSERT INTO menu (Menu_id,Menu_name,price,image) VALUES (?,?,?,?)";

		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			String menuId = type + "_" + name;

			stmt.setString(1, menuId);
			stmt.setString(2, name);
			stmt.setString(3, price);
			stmt.setBytes(4, bytes);

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

	public int InsertDrink(String type, String name, String size, String price, byte[] bytes) {
		ip = new InputImage();
		String sql = "INSERT INTO menu (Menu_id,Menu_name,price,image) VALUES (?,?,?,?)";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			String menuId = type + "_" + name;
			String menuName = name + size;

			stmt.setString(1, menuId);
			stmt.setString(2, menuName);
			stmt.setString(3, price);
			stmt.setBytes(4, bytes);
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

	public int InsertPizzaMenu(String type, String name, String size, String price, byte[] bytes) {
		ip = new InputImage();
		ImageIcon iconS = new ImageIcon(getClass().getResource("/pizzaImageS.png"));
		ImageIcon iconB = new ImageIcon(getClass().getResource("/pizzaImageB.png"));

		byte[] Bigbyte = ip.getBytes();
		if (bytes == null) {
			try {
				bytesSs = convertImageIconToBytes(iconS);
				bytesBs = convertImageIconToBytes(iconB);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			bytesSs = bytes;
			bytesBs = Bigbyte;
		}

		String sql = "INSERT INTO menu (Menu_id,Menu_name,size,price,image,image_big) VALUES (?,?,?,?,?,?)";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			String menuName = name + size;
			String menuId = type + "_" + menuName;

			stmt.setString(1, menuId);
			stmt.setString(2, menuName);
			stmt.setString(3, size);
			stmt.setString(4, price);
			stmt.setBytes(5, bytesSs);
			stmt.setBytes(6, bytesBs);
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
	
	public int InsertPizzaMenuB(String type, String name, String size, String price, byte[] bytes, byte[] bytesB) {
		ip = new InputImage();

		String sql = "INSERT INTO menu (Menu_id,Menu_name,size,price,image,image_big) VALUES (?,?,?,?,?,?)";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			String menuName = name + size;
			String menuId = type + "_" + menuName;

			stmt.setString(1, menuId);
			stmt.setString(2, menuName);
			stmt.setString(3, size);
			stmt.setString(4, price);
			stmt.setBytes(5, bytes);
			stmt.setBytes(6, bytesB);
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
	public int InsertPizzaRecipe(String type, String name, String size, String price, List<String> list) {

		List<String> ingredientList = new ArrayList<>();
		List<Integer> ingredientCount = new ArrayList<>();

		String sql = "INSERT INTO recipe (Menu_id,ingredient_id,count) VALUES (?,?,?)";

		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			String menuName = name + size;
			String menuId = type + "_" + menuName;
			String douSize = "도우_" + size;
			list.add(douSize);

			// ArrayList 준비
			System.out.println("원본 : " + list); // [A, B, C, A, B, A]

			// ArrayList 원소 빈도수를 Map에 저장
			Map<String, Integer> map = new HashMap<String, Integer>();
			for (String str : list) {
				Integer count = map.get(str);
				if (count == null) {
					map.put(str, 1);
				} else {
					map.put(str, count + 1);
				}
			}
			// // Map 출력
			for (String key : map.keySet()) {
				ingredientList.add(key);
				ingredientCount.add(map.get(key));
				stmt.setString(1, menuId);
				stmt.setString(2, key);
				stmt.setInt(3, Integer.valueOf(map.get(key)));
				stmt.executeUpdate();
			}

			return 1;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return 0;
	}

	// 데이터베이스에서 오리지널 레시피 들고오기
	public HashMap<String, Integer> originHash(String menuId) {
		HashMap<String, Integer> recipe = new HashMap<>();
		String ingredient_id = "";
		int recipeCount;
		String sql = "select * from recipe where menu_id = ?";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, menuId);
			rs = stmt.executeQuery();

			while (rs.next()) {
				ingredient_id = rs.getString("ingredient_id");
				recipeCount = rs.getInt("count");
				/*
				 * String targetString1 = "도우_"; boolean contains1 =
				 * ingredient_id.contains(targetString1);
				 * 
				 * if(!(contains1)) { }
				 */
				recipe.put(ingredient_id, recipeCount);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return recipe;
	}

	// 수정된 레시피
	public HashMap<String, Integer> setHash(List<String> setRecipe) {
		HashMap<String, Integer> set = new HashMap<>();
		for (String item : setRecipe) {
			System.out.println(item);
			set.put(item, set.getOrDefault(item, 0) + 1);
		}
		return set;
	}

	public HashMap<String, Integer> addRecipe(HashMap<String, Integer> originHash, HashMap<String, Integer> setHash) {
		for (Map.Entry<String, Integer> entry : setHash.entrySet()) {
			String key = entry.getKey();
			int setValue = entry.getValue();
			int originValue = originHash.getOrDefault(key, 0);

			int difference = setValue - originValue;
			if (difference != 0) {

				setHash.put(key, difference);
			} else {
				setHash.remove(key);
			}
		}
		return setHash;
	}

	public HashMap<String, Integer> removeRecipe(HashMap<String, Integer> originHash,
			HashMap<String, Integer> setHash) {
		for (Map.Entry<String, Integer> entry : setHash.entrySet()) {
			String key = entry.getKey();
			int originValue = entry.getValue();
			int setValue = originHash.getOrDefault(key, 0);

			int difference = originValue - setValue;
			if (difference != 0) {

				originHash.put(key, difference);
			} else {
				originHash.remove(key);
			}
		}
		return originHash;
	}

	public List<String> getToppingList(HashMap<String, Integer> hashMap, String menuId) {
		List<String> toppoingList = new ArrayList<>();
		HashMap<String, Integer> map = originHash(menuId);

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			int value = entry.getValue();

			for (int i = 0; i < value; i++) {
				toppoingList.add(key);
			}
		}
		return toppoingList;
	}

	public int updateSide(String type, String name, String price, byte[] bytes) {
		ip = new InputImage();

		String sql = "INSERT INTO menu (Menu_id,Menu_name,price,image) VALUES (?,?,?,?)";

		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			String menuId = type + "_" + name;

			stmt.setString(1, menuId);
			stmt.setString(2, name);
			stmt.setString(3, price);
			stmt.setBytes(4, bytes);

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

	public int updateDrink(String type, String name, String size, String price, byte[] bytes) {
		ip = new InputImage();
		String sql = "INSERT INTO menu (Menu_id,Menu_name,price,image) VALUES (?,?,?,?)";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			String menuId = type + "_" + name;
			String menuName = name + size;

			stmt.setString(1, menuId);
			stmt.setString(2, menuName);
			stmt.setString(3, price);
			stmt.setBytes(4, bytes);
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

	public int deletePizzaRecipe(String type, String name, String size, List<String> removerecipe) {

		String sql = "DELETE FROM recipe  WHERE menu_id = ? AND ingredient_id = ?";

		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			String menuName = name + size;
			String menuId = type + "_" + menuName;

			for (String str : removerecipe) {
				stmt.setString(1, menuId);
				stmt.setString(2, str);
				stmt.executeUpdate();
			}

			return 1;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return 0;
	}

	public int deletePizzaMenu(String originType, String originName, String originSize, String originPrice,
			List<String> originList, String setPrice, List<String> setList) {

		String sql = "DELETE FROM menu WHERE menu_id = ?";

		String menuName = originName + originSize;
		String menuId = originType + "_" + menuName;

		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, menuId);
			stmt.executeUpdate();

			return 1;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return 0;
	}

	public int dropPizzaRecipe(String origin) {

		String sql = "DELETE FROM recipe WHERE menu_id = ?";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, origin);
			stmt.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return 0;
	}

	public int dropPizzaMenu(String origin) {

		String sql = "DELETE FROM menu WHERE menu_id = ?";

		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, origin);
			stmt.executeUpdate();

			return 1;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return 0;
	}

	public int drupMenu(String origin) {

		String sql = "DELETE FROM menu WHERE menu_id = ?";

		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, origin);
			stmt.executeUpdate();

			return 1;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return 0;
	}

	public List<Menu> findmenus(String find) {
		String sql = "SELECT * FROM menu WHERE menu_id Like ?";

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Menu> list = new ArrayList<>();
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			String line = "%" + find + "%";
			stmt.setString(1, line);
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

	public int lastOrder() {
		String sql = "SELECT * FROM mainorder ORDER BY no DESC LIMIT 1";

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Menu> list = new ArrayList<>();
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next()) {
				int no = rs.getInt("no");
				return no;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return 0;
	}

	public byte[] getImage(String menuId) {
		byte[] image = null;
		String sql = "select image from menu where  menu_id like '%" + menuId + "'";

		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next()) {
				byte[] no = rs.getBytes("image");
				System.out.println(no);
				return no;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println(image);
		return image;
	}
	
	public byte[] getImageB(String menuId) {
		byte[] image = null;
		String sql = "select image_big from menu where  menu_id like '%" + menuId + "'";

		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next()) {
				byte[] no = rs.getBytes("image_big");
				System.out.println(no);
				return no;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println(image);
		return image;
	}

	public static void ballSound() {
		try {
			URL soundFile = PosRepo.class.getClassLoader().getResource("call-to-attention-123107.wav");
			// 사운드 파일 경로 설정

			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (IOException | UnsupportedAudioFileException | LineUnavailableException ex) {
			ex.printStackTrace();
		}
	}

	private static byte[] convertImageIconToBytes(ImageIcon icon) throws IOException {
		Image image = icon.getImage();

		BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null),
				BufferedImage.TYPE_INT_RGB);

		bufferedImage.getGraphics().drawImage(image, 0, 0, null);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(bufferedImage, "png", baos);

		return baos.toByteArray();
	}
}
