package board;

public class Like {
	//좋아요를 표현하는 게시문 3개
	int collectId;
	int memeberId; //회원
	String regDate; //등록날짜 -> 데이터의 성격과 상관없이 거의 무조건 있어야 한다
	
	//생성자를 만들어 준다.
	public Like(int collectId, int memeberId, String regDate) {
		super();
		this.collectId = collectId;
		this.memeberId = memeberId;
		this.regDate = regDate;
	}
	
}
