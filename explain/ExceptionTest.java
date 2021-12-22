package explain;

import java.util.ArrayList;
import java.util.Scanner;

public class ExceptionTest {

	public static void main(String[] args) {
		

		// 예외 상황

		Scanner sc = new Scanner(System.in);
		int num = 0;

		ArrayList list = null;		

		try { // 예외처리			

			//list.get(0);

			String str = sc.nextLine();
			num = Integer.parseInt(str); // 예외 발생

		} catch(NumberFormatException e) {
			System.out.println("숫자만 입력 가능합니다.");
		} catch(NullPointerException e) {

			System.out.println("null인 대상에게 명령을 지시했습니다. 확인해주세요.");
		}

		System.out.println(num);

	}

}
