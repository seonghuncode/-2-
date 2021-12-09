package explain;

public class OOPTest2 {
	
	public static void main(String[] args) {
		
		// 일반 형변환 규칙
		int a = 10;
		double d = 10.0;

		d = a; // 자동 형변환 - 안전할 때 자바가 해줌
		a = (int) d; // 수동 형변환 - 안전하지 않을 때 개발자가 직접 수행

		// 객체 형변환 규칙
		경차 경차1 = new 경차();
		
		//new를 통해서 만들어 진것을 instance라고 한다.
		세단 세단1 = new 세단();

		자동차 자동차1 = 세단1;
		
		//자동차1 instanceof ==> 자동차1의 인스턴스를 확인해달라는 의미 이다
		
		System.out.println(자동차1 instanceof 경차);
			// == 자동차1에 들어 있는것이 경차 입니까?
			//경차가 들어있으면 true, 세단이 들어 있으면 false
		System.out.println(자동차1 instanceof 세단);

		// 형이 다름. 형변환하면 위험함. 잘못된 실행 명령
		if (자동차1 instanceof 경차) {
			경차 경차3 = (경차) 자동차1;
			경차3.연비절감();
		} else if (자동차1 instanceof 세단) {
			세단 세단3 = (세단) 자동차1;
			세단3.안정된주행();
		}

		// 경차3.연비절감();
				
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
