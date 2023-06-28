package repo;

public class Ingredient {
	String id;
	String name;
	int priceRetail;
	int priceSupply;
	int lowerLimitCount;
	int currentCount;
	String type;

	public Ingredient(String id) {
		this.id = id;
	}

	public Ingredient(String id, String name, int priceRetail, int priceSupply, int lowerLimitCount,
			int currentCount) {
		super();
		this.id = id;
		this.name = name;
		this.priceRetail = priceRetail;
		this.priceSupply = priceSupply;
		this.lowerLimitCount = lowerLimitCount;
		this.currentCount = currentCount;
		
		this.type = setingType(id);
	}
	
	public String setingType(String id) {
		String types[] = id.split("_");
		String type = types[0];
		return type;
	}

	public Ingredient(String name, int lowerCount, int currentCount) {
		super();
		this.name = name;
		this.priceRetail = 0;
		this.priceSupply = 0;
		this.lowerLimitCount = lowerCount;
		this.currentCount = currentCount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
		return "Ingredient [id=" + id + ", name=" + name + ", priceRetail=" + priceRetail
				+ ", priceSupply=" + priceSupply + ", lowerLimitCount=" + lowerLimitCount + ", currentCount="
				+ currentCount + "]";
	}

}
