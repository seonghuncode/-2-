package explain;

import java.util.Scanner;

public class PagingTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int currentPageNo = 1; //현재페이지
		
		//규칙을 찾아 만들어야 하므로 반복적으로 연습하기
		//현재페이지 : 1 ~ 5, 블럭 1
		//현재페이지 : 6 ~ 10, 블럭 2
		//현재페이지 : 11 ~ 15, 블럭 3
		//=
		//현재페이지 : 0 ~ 5, 블럭 1
		//현재페이지 : 5 + 1 ~ 10, 블럭 2
		//현재페이지 : 10 + 1 ~ 15, 블럭 3
		//현재페이지 : (5 * n) + 1
		
		//반올림, 형변환 하는 것은 자바 api사용 -> 구글링
		//currentPageNo / 5;
		//int currnetBlockNo = (int)Math.ceil((double)currentPageNo / 5); //int / int 는 정수라 나머지가 앖으므로 하나를 double형변횐해준다
		//현재페이지 번호 / 한 브럭당 페이지 개수
		
		//1 / 5 -> 1 0.xxx
		//2 / 5 -> 1
		//3 / 5 -> 1
		//4 / 5 -> 1
		//5 / 5 -> 1
		
		//6 / 5 -> 2
		//7 / 5 -> 2
		//8 / 5 -> 2
		//9 / 5 -> 2
		//10 / 5 -> 2  //반올림 하면 블럭 번호가 된다.
		
		int currentBlock = 1; 
		
		
		
		//페이지 블럭 번호 1, 1~ 5
		//페이지 블럭 번호 2, 6~ 10
		//페이지 블럭 번호 3, 11~ 15
		
		//페이지 블럭 번호 1, (5 * 0) + 1~ 5
	    //페이지 블럭 번호 2, (5 * 1) + 1~ 10
	    //페이지 블럭 번호 3, (5 * 2) + 1~ 15
		
		//(5 * 페이지블럭 번호 -1) + 1 ==> 현재 페이지 블럭의 시작 번호
		//현재 페이지 블럭의 시작 번호 + 4 ==> 현재 페이지 블럭의 마지막 번호
		
		
		//페이징의 원리, 간단한 페이지를 만들어 보고 연습하고 -> 적용하기
		//System.out.println("[1] 2 3 4 5");
		
//		System.out.println("1. 다음 2. 이전");
//		int pcmd = Integer.parseInt(sc.nextLine());
//		//1번 누르면 이렇게 변화 되어야 한다
//		System.out.println("1 [2] 3 4 5");
//		//일일이 만들 수 가 없으므로 동적으로 만든다.
		
		while(true) {
			
			int currnetBlockNo = (int)Math.ceil((double)currentPageNo / 5);
			
//			int startPageNoInBlock = 1; //현재 페이지에 따라 변화 되어야한다.
//			int endPageNoInBlock = 5;
			int startPageNoInBlock = 5 * (currnetBlockNo - 1) + 1;
			int endPageNoInBlock = startPageNoInBlock + 4;
			
			System.out.println("현재 페이지 블럭 번호 :" + currnetBlockNo);
			
			for(int i = startPageNoInBlock; i <= endPageNoInBlock; i++) {
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
