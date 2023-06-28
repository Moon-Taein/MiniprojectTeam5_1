package repo;

public class DetailOrder {
	private String menu;
	private int mainOrder;
	
	public DetailOrder(String menu, int mainOrder) {
		super();
		this.menu = menu;
		this.mainOrder = mainOrder;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public int getMainOrder() {
		return mainOrder;
	}
	public void setMainOrder(int mainOrder) {
		this.mainOrder = mainOrder;
	}
	@Override
	public String toString() {
		return "DetailOrder [menu=" + menu + ", mainOrder=" + mainOrder + "]";
	}
}
