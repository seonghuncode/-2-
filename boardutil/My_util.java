package boardutil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class My_util {
	//어플리케이션 내에서 유용하게 쓰일 전반적인 내용들을 모아둔다
	//ex. 날짜 구하는 코드의 경우 필요한 경우에 바로 넣어서 사용도 가능 하지만 많이 쓰이는 기능 이므로 따로 코드를 관리 해준다.
	
	//오늘 날짜 구하는 메서드 
//	public String getCurrentDate() {
//		LocalDate now = LocalDate.now();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
//		String formatedNow = now.format(formatter);
//
//		return formatedNow;
//	}
	//위의 코드를 매개변수를 받아 사용할 경우
	public static String getCurrentDate(String dateFormat) {
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
		String formatedNow = now.format(formatter);

		return formatedNow;
	}
	//보통은 static을 사용하지 않지만 유틸의 경우 보통 기능을 사용하고 상태값을 넣어 사용하지 X 
	//이경우 기능을 사용하기 위해서
	// My_util util = new My_util();
	//util.getCurrentDate(body); 를 해야 사용이 가능하지만
	//static 사용시 class에 붙어 있기 때문에
	// ==> My_util.getCurrentDate(body);만으로 사용가능
	
}
