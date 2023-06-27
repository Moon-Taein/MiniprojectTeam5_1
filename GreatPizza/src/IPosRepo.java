
public interface IPosRepo {
	// 주문 내역 가져오기 ( 시간, 상태 )
	void getMainOrder();
	
	// 세부 주문 내역 가져오기
	void getDetailOrder();
		
	// 레시피 가져오기
	void getMenuItem();
		
	// 레시피 재료 가져오기
	void getInventoryID();

}
