package board;

public class BoardCollect extends BaseCollect {

	//public을 해주는 이유 -> FileManager에서 사용하기 위해서
	public String All_title;
	
	
	
	public int hit; // == 조회수
	
	public BoardCollect() {}
	
	//생성자는 class로 부터 객체를 생성할때 필드값을 초기화 하는 작업을 해준다.
	//생성자 == 객체의 생성과 동시에 자동으로 호출되는 메서드
	//생성자의 이름은 class의 이름과 같아야 한다.
	//리턴 값이 없기 때문에 void는 생략
	//필드와 동일한 매개변수 사용가능, 이때 this는 필드와 매개변수를 명확히 구분하는 역할(this는 class안에서만 사용 가능)

	//Alt + s + a ==> 단축키
	public BoardCollect(int id, String All_title, String body, String regDate, int memberId, int hit) {
		super();
		this.id = id;
		this.All_title = All_title;
		this.body = body;
		this.regDate = regDate;
		this.memberId = memberId;
		this.hit = hit;
	}
	
	
}

