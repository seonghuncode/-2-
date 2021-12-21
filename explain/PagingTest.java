package explain;

import java.util.Scanner;

public class PagingTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int currentPageNo = 1; //현재페이지
		
		//페이징의 원리, 간단한 페이지를 만들어 보고 연습하고 -> 적용하기
		//System.out.println("[1] 2 3 4 5");
		
//		System.out.println("1. 다음 2. 이전");
//		int pcmd = Integer.parseInt(sc.nextLine());
//		//1번 누르면 이렇게 변화 되어야 한다
//		System.out.println("1 [2] 3 4 5");
//		//일일이 만들 수 가 없으므로 동적으로 만든다.
		
		while(true) {
			
			for(int i = 1; i <= 5; i++) {
				if(i == currentPageNo) {
					System.out.print("["+i + "] "); //현재페이지를 보여주는 방식
				}
				else {
					System.out.print(i + " ");
				}
			}
			System.out.println();
			
			System.out.println("1. 다음 2. 이전");
			int pcmd = Integer.parseInt(sc.nextLine());
			if(pcmd == 1) {
				currentPageNo++;
			}
			else if(pcmd == 2) {
				currentPageNo--;
			}
			
		}
			
		}

}
