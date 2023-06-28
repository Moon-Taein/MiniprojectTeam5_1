package repo;

public class Menu {
	private int no; 
	private String menuId;
	private String menuName;
	private String type;
	private int price;
	private Integer size;

	public Menu(String menuId,String menuName, int price) {
		super();
		this.no = 0;
		this.menuId = menuId;
		this.menuName = menuName;
		this.price = price;
		this.size = 0;
		
		this.type = setingType(menuId);
	}
	public Menu(int no, String menuId, String menuName, int price, Integer size) {
		super();
		this.no = no;
		this.menuId = menuId;
		this.menuName = menuName;
		this.price = price;
		this.size = size;
		
		this.type = setingType(menuId);
	}
	
	public String setingType(String menuId) {
		String types[] = menuId.split("_");
		String type = types[0];
		return type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
