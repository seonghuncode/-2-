package explain;

import java.util.ArrayList;
import java.util.Collections;

public class SortExam {

	public static void main(String[] args) {
		
		사람 사람1 = new 사람(20, "홍길동");
		
		사람 사람2 = new 사람(17, "유관순");
		
		사람 사람3 = new 사람(21, "을지문덕");
		
		사람 사람4 = new 사람(30, "이순신");
		
		사람 사람5 = new 사람(28, "강감찬");
		
		
		ArrayList<사람> 사람들 = new ArrayList<>();
		
		사람들.add(사람1);
		사람들.add(사람2);
		사람들.add(사람3);
		사람들.add(사람4);
		사람들.add(사람5);
		
		for(int i = 0; i < 사람들.size(); i++) {
			사람 현재사람 = 사람들.get(i);
			현재사람.자기소개();
		}// -> 단점 정렬이 안되어 있다.
		
		System.out.println("======================");
		
		//Collections.sort(사람들); -> 기준이 없기에 에러(나이순? 이름순?)
		 
		for(int i = 0; i < 사람들.size(); i++) {
			사람 현재사람 = 사람들.get(i);
			현재사람.자기소개();
		

	}

}

class 사람{
	int	나이;
	String 이름;
	
	//생성자 만들기(main class에 new 사람으로 만들어야 하는 번거러움을 해소하기 위해 만든다)
	사람(int 나이, String 이름){
		this.나이 = 나이;
		this.이름 = 이름;
	}
	
	void 자기소개() {
		System.out.println("아녕하세요 저는" + 이름 + "이고" + 나이 + "살 입니다");
	}
}
