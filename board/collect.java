package board;

public class collect {

	int numbers;
	String All_title;
	String All_body; //묶고 싶은 정보를 적어준다
	//=> 틀과 같은 개념 필요할때 마다 상자를 만들어 담는다. 
	
	
	//생성자는 class로 부터 객체를 생성할때 필드값을 초기화 하는 작업을 해준다.
	//생성자 == 객체의 생성과 동시에 자동으로 호출되는 메서드
	//생성자의 이름은 class의 이름과 같아야 한다.
	//리턴 값이 없기 때문에 void는 생략
	//필드와 동일한 매개변수 사용가능, 이때 this는 필드와 매개변수를 명확히 구분하는 역할(this는 class안에서만 사용 가능)

	//Alt + s + a ==> 단축키
	public collect(int numbers, String All_title, String All_body) {
		
		super();
		this.numbers= numbers;
		this.All_title = All_title;
		this.All_body = All_body;
	}//==> 연습문제_게시판_article add = new 연습문제_게시판_article(no,title,body);의 생성자
	
}

