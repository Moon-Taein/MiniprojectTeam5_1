
public interface IPosRepo {
	// 주문 내역 가져오기 ( 시간, 상태 )
	void getMainOrder();
	

		
	// 레시피 가져오기
	void getMenuItem();
		
	// 레시피 재료 가져오기
	void getInventoryID();
	
	// 분류만 똑 때어주는 메소드();
	String DDok(String type,String name);
	// type 은 Menu or Inventory // name 은 찾고자 하는 품목의 이름
	
	// 세부 주문 내역 가져오기
	void getDetailOrder(String name);

}
