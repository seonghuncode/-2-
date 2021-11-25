package explain;

public class OOPTest {
	public static void main(String[] args) {

		// 고양이
		// 야옹~
		강아지 강아지1 = new 강아지();
		강아지1.짖다();
		강아지1.숨쉬다();

		// 강아지
		// 멍멍~
		고양이 고양이1 = new 고양이();
		고양이1.울다();
		고양이1.숨쉬다();

		닭 닭1 = new 닭();

		// 강아지야 이동해, 고양이야 이동해, 닭아 이동해.
		강아지1.이동하다();
		고양이1.이동하다();
		닭1.이동하다();


		// 동물들아 이동해

		int a = 0;
		double b = 1.0;
		//a = (int)b; // 자동형변환 X, 수동형변환
		//b = a; // int가 double로 형변환. 자동형변환

		//타입이 다르면 넣을 수 없지만 extends를 해주었기 때문에 숨쉬고 이동하는 것능 같기에 그것을 제외한 다른 기능은 사용하지 않으면 되기때문에
		//자바가 안전하다고 판단하고 형변환을 해서 사용 가능하다??
		동물 동물1 = 강아지1; // 강아지가 동물로 모습을 바꿀수 있는가?(형변환)
		동물 동물2 = 고양이1; // 고양이가 동물로 모습을 바꿀수 있는가?(형변환)
		동물 동물3 = 닭1; // 닭이 동물로 모습을 바꿀수 있는가?(형변환)

		동물 동물4 = 고양이1;

		고양이 고양이2 = (고양이)동물4; // 형변환
		//동물4 // 강아지, 고양이, 닭


		동물[] 동물들 = {동물1, 동물2, 동물3};
		// 일괄처리
		for(int i = 0 ; i < 3; i++) {
			동물들[i].숨쉬다();
		}	
	}

}

class 동물 {
	void 숨쉬다() {
		System.out.println("숨쉬다");
	}

	void 이동하다() {
		System.out.println("이동하다");
	}
}

class 강아지 extends 동물 {

	void 숨쉬다() {
		System.out.println("헥헥헥");
	}

	void 짖다() {
		System.out.println("멍멍~");
	}

}

class 고양이 extends 동물 {
	void 숨쉬다() {
		System.out.println("갸르릉");
	}
	void 울다() {
		System.out.println("야옹~");
	}
}

class 닭 extends 동물 {
	void 숨쉬다() {
		System.out.println("푸드득");
	}
	void 울다() {
		System.out.println("꼬기오~");
	}
}
