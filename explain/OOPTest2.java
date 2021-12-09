package explain;

public class OOPTest2 {
	
	public static void main(String[] args) {
		
		경차 경차1 = new 경차();
		세단 세단1 = new 세단();
		
		자동차 자동차1 = 경차1;


		// 형이 다름. 형변환하면 위험함. 잘못된 실행 명령
//		if(자동차1 instanceof 경차) {
//			경차 경차3 = (경차)자동차1;
//			경차3.달리다();
//		} else if(자동차1 instanceof 세단) {
//			세단 세단3 = (세단)자동차1;
//			세단3.달리다();
//		}
//		

		세단1.달리다();
		세단1.안정된주행();

		자동차1.달리다();
		
		
				
	}

}

class 자동차 {
	void 달리다() {
		System.out.println("자동차가 달립니다.");
	}
}

class 경차 extends 자동차 {
	void 연비절감() {
		System.out.println("연비가 절감됩니다.");
	}
}

class 세단 extends 자동차 {
	void 안정된주행() {
		System.out.println("차가 정숙합니다.");
	}
	
}
