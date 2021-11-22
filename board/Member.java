package board;

public class Member {
	int localId;
	String id;
	String pw;
	String nickname;
	
	//Alt + S + A 
	public Member(int localId, String id, String pw, String nickname) {
		super();
		this.localId = localId;
		this.id = id;
		this.pw = pw;
		this.nickname = nickname;
	}
	//객체는 하나의 사물, 하나의 개념을 설명할때는 class로 만들어 분류한다.
	//여러개의 같이 다니는 정보들을 편리하게 한곳에 모아 만들어 주었다??
	
}
