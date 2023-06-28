import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PosRepo implements IPosRepo {

	@Override
	public void getMainOrder() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getDetailOrder(String name) {
		
	}

	@Override
	public void getMenuItem() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getInventoryID() {
		// TODO Auto-generated method stub

	}

	
	
//	@Override
//	public String DDok(String typeZip, String name) {
//		String sql = "select "+typeZip+"_id from "+typeZip+" where "+typeZip+"_id like '%"+name+"%'";
//		String type;
//		
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		ResultSet rs = null;
//		try {
//			conn = DBUtil.getConnection();
//			stmt = conn.prepareStatement(sql);
//			rs = stmt.executeQuery();
//
//			while (rs.next()) {
//				String nameList = rs.getString(""+typeZip+"_id");
//				System.out.println(nameList);
//				
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBUtil.close(rs);
//			DBUtil.close(stmt);
//			DBUtil.close(conn);
//		}
//
//		return null;
//	}
	public static void main(String[] args) {
//		PosRepo pr = new PosRepo();
//		pr.DDok("inventory","불고기");
	}
}
