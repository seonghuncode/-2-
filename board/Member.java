package board;

public class Member {
	int localId;
	String id;
	String pw;
	String nickname;
	
	public void greeting() {
		System.out.println("안녕하세요 일반회원" + nickname + "님 반갑습니다");
	}
}
