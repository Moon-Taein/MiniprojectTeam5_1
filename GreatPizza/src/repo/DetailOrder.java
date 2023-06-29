package repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DetailOrder {
	private int no;
	private String menu;
	private int mainOrder;
	
	private OrderRepo order;
	private List<Ingredient> ingredients;
	private List<Ingredient> addIngredients;
	
	public DetailOrder(int no, String menu, int mainOrder) {
		super();
		this.no = no;
		this.menu = menu;
		this.mainOrder = mainOrder;
		setIngredients();
	}
	public void setIngredients() {
		order = new OrderRepo();
		ingredients = new ArrayList<>();
		addIngredients = new ArrayList<>();
		
		ingredients.add(order.getIngredient(menu));
		ingredients.addAll(order.getIngredients(menu));
		addIngredients.addAll(order.getIngredients(no));
		ingredients.removeIf(Objects::isNull);
	}
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	public List<Ingredient> getAddIngredients() {
		return addIngredients;
	}
	public void setAddIngredients(List<Ingredient> addIngredients) {
		this.addIngredients = addIngredients;
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
	public int getMainOrder() {
		return mainOrder;
	}
	public void setMainOrder(int mainOrder) {
		this.mainOrder = mainOrder;
	}
	@Override
	public String toString() {
		return "DetailOrder [no=" + no + ", menu=" + menu + ", mainOrder=" + mainOrder + "]";
	}
	
}
