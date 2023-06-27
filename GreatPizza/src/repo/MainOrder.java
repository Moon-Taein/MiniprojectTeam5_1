package repo;

public class MainOrder {
	private int no;
	private int totalprice;
	private String date;
	private String time;
	private String state;
	
	public MainOrder(int no, int totalprice, String date, String time, String state) {
		super();
		this.no = no;
		this.totalprice = totalprice;
		this.date = date;
		this.time = time;
		this.state = state;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "MainOrder [no=" + no + ", totalprice=" + totalprice + ", date=" + date + ", time=" + time + ", state="
				+ state + "]";
	}
}
