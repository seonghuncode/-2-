package board;

public class collect {

	int numbers;
	String All_title;
	String All_body; //묶고 싶은 정보를 적어준다
	//=> 틀과 같은 개념 필요할때 마다 상자를 만들어 담는다. 
	
	//데이터가 늘어났다.(원하는 정보가 늘어 났으므로 우선 데이터를 늘려 준다.)
	String regDate; // ==> 등록날자
	String writer; // == 작성자
	int hit; // == 조회수
	
	//생성자는 class로 부터 객체를 생성할때 필드값을 초기화 하는 작업을 해준다.
	//생성자 == 객체의 생성과 동시에 자동으로 호출되는 메서드
	//생성자의 이름은 class의 이름과 같아야 한다.
	//리턴 값이 없기 때문에 void는 생략
	//필드와 동일한 매개변수 사용가능, 이때 this는 필드와 매개변수를 명확히 구분하는 역할(this는 class안에서만 사용 가능)

	//Alt + s + a ==> 단축키
	public collect(int numbers, String All_title, String All_body, String regDate, String writer, int hit) {
		super();
		this.numbers = numbers;
		this.All_title = All_title;
		this.All_body = All_body;
		this.regDate = regDate;
		this.writer = writer;
		this.hit = hit;
	}
	
	
}

