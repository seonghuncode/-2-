package board;

public class GeneralMember extends Member {
	//일반회원, Member의 한 종류이므로 상속을 받는다.
	
	public GeneralMember(int localId, String id, String pw, String nickname) {
		
		this.localId = localId;
		this.id = id;
		this.pw = pw;
		this.nickname = nickname;
	}
}
