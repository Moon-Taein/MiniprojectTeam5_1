package repo;

public class Account {
	private int no;
	private String date;
	private int purchase;
	private int sales;

	public Account(String date, int purchase, int sales) {
		super();
		this.date = date;
		this.purchase = purchase;
		this.sales = sales;
	}

	public Account(int no, String date, int purchase, int sales) {
		super();
		this.no = no;
		this.date = date;
		this.purchase = purchase;
		this.sales = sales;
	}

	public String settingDateYearMonth(String date) {
		String dayes[] = date.split("-");
		String day = dayes[2];
		return day;
	}
	
//	public String settingDateDay2(String date) {
//		String dayes[]
//	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getPurchase() {
		return purchase;
	}

	public void setPurchase(int purchase) {
		this.purchase = purchase;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	@Override
	public String toString() {
		return "Account [no=" + no + ", date=" + date + ", purchase=" + purchase + ", sales=" + sales + "]";
	}

}
