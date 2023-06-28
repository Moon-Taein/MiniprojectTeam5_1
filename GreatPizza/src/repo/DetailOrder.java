package repo;

public class DetailOrder {
	private int no;
	private String menu;
	private int menuCount;
	private int mainOrder;
	
	public DetailOrder(int no, String menu, int menuCount, int mainOrder) {
		super();
		this.no = no;
		this.menu = menu;
		this.menuCount = menuCount;
		this.mainOrder = mainOrder;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public int getMenuCount() {
		return menuCount;
	}
	public void setMenuCount(int menuCount) {
		this.menuCount = menuCount;
	}
	public int getMainOrder() {
		return mainOrder;
	}
	public void setMainOrder(int mainOrder) {
		this.mainOrder = mainOrder;
	}
	@Override
	public String toString() {
		return "DetailOrder [no=" + no + ", menu=" + menu + ", menuCount=" + menuCount + ", mainOrder=" + mainOrder
				+ "]";
	}
}
