package board;

public class SpecialMember extends Member {
	//우수회원, Member의 한 종류이기 때문에 상속을 받는다.
	//Member에 있는것을 모두 물려 받느다.
	
	int point;
	
	public SpecialMember(int localId, String id, String pw, String nickname, int point) {
		
		this.localId = localId;
		this.id = id;
		this.pw = pw;
		this.nickname = nickname;
		this.point = point;
	}
}
