package repo;

public class Recipe {
	private int no;
	private String menuId;
	private String ingredientId;
	private int count;
	public Recipe(int no, String menuId, String ingredientId, int count) {
		super();
		this.no = no;
		this.menuId = menuId;
		this.ingredientId = ingredientId;
		this.count = count;
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
	public String getIngredientId() {
		return ingredientId;
	}
	public void setIngredientId(String ingredientId) {
		this.ingredientId = ingredientId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Recipe [no=" + no + ", menuId=" + menuId + ", ingredientId=" + ingredientId + ", count=" + count + "]";
	}
}
