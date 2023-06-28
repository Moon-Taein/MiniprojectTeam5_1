package repo;

public class Menu {
	private int no; 
	private String menuId;
	private String menuName;
	private int price;
	private Integer size;

	public Menu(int no, String menuId, String menuName, int price, Integer size) {
		super();
		this.no = no;
		this.menuId = menuId;
		this.menuName = menuName;
		this.price = price;
		this.size = size;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Menu [no=" + no + ", menuId=" + menuId + ", menuName=" + menuName + ", price=" + price + ", size="
				+ size + "]";
	}

}
