package Try_test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class test_day {
	
	public static void main(String[] args) {

		LocalDate now = LocalDate.now();
		//날짜를 원하는 형식으로 보기에 하기 위한 포맷 괴장(API이해하기)      (안에 부분을 . , -로 변경 하여 표시 가능)
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
		String formatedNow = now.format(formatter);
		System.out.println(formatedNow);

	}
	
}
