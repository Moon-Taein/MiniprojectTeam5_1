package repo;

public class Ingredient {
	int no;
	String id;
	String name;
	int priceRetail;
	int priceSupply;
	int lowerLimitCount;
	int currentCount;
	
	public Ingredient(int no, String id, String name, int priceRetail, int priceSupply, int lowerLimitCount,
			int currentCount) {
		super();
		this.no = no;
		this.id = id;
		this.name = name;
		this.priceRetail = priceRetail;
		this.priceSupply = priceSupply;
		this.lowerLimitCount = lowerLimitCount;
		this.currentCount = currentCount;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPriceRetail() {
		return priceRetail;
	}
	public void setPriceRetail(int priceRetail) {
		this.priceRetail = priceRetail;
	}
	public int getPriceSupply() {
		return priceSupply;
	}
	public void setPriceSupply(int priceSupply) {
		this.priceSupply = priceSupply;
	}
	public int getLowerLimitCount() {
		return lowerLimitCount;
	}
	public void setLowerLimitCount(int lowerLimitCount) {
		this.lowerLimitCount = lowerLimitCount;
	}
	public int getCurrentCount() {
		return currentCount;
	}
	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}
	@Override
	public String toString() {
		return "Ingredient [no=" + no + ", id=" + id + ", name=" + name + ", priceRetail=" + priceRetail
				+ ", priceSupply=" + priceSupply + ", lowerLimitCount=" + lowerLimitCount + ", currentCount="
				+ currentCount + "]";
	}
}
