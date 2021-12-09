package board;

public class GeneralMember extends Member {
	//일반회원, Member의 한 종류이므로 상속을 받는다.
	
	public GeneralMember(int localId, String id, String pw, String nickname) {
		
		this.localId = localId;
		this.id = id;
		this.pw = pw;
		this.nickname = nickname;
	}
	
	public void greeting() {
		System.out.println("안녕하세요 일반회원" + nickname + "님 반갑습니다");
	}
	//member에 있는 greeting의 인사법을 general외 special member을 구별하여 다르게 사용하기위해 사용 -> 오버라이딩
	
}
