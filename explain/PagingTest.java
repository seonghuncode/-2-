package explain;

import java.util.ArrayList;
import java.util.Scanner;

public class PagingTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<String> datas = new ArrayList<String>();
		int currentPageNo = 1; //현재페이지
		//의미를 갖는 데이터는 변수에 담아서 사용한다.
		int pageCountPerBlock = 5; //블럭당 페이지 갯수
		int itemCountPerPage = 3;
		
		for(int i = 1; i < 30; i++) {
			String str = "data" + i;
			datas.add(str);
		}
		
		//현재페이지 1, 0,3
		//현재페이지 2, 3,6
		//현재페이지 3, 6,9
		
		//3 *(현재페이지 - 1);
		
		
		
		while(true) {
			//현재페이지 번호 / 한 블럭당 페이지 개수
			int currnetBlockNo = (int)Math.ceil((double)currentPageNo / pageCountPerBlock );
		
			int startPageNoInBlock = pageCountPerBlock  * (currnetBlockNo - 1) + 1;
			int endPageNoInBlock = startPageNoInBlock + pageCountPerBlock  - 1;
			
			int startIdx = itemCountPerPage *(currentPageNo - 1);
			int endIdx = startIdx + itemCountPerPage;
		
			//한페이지에 3개씩 출력
			for(int i = startIdx; i < endIdx; i++) {
				System.out.println(datas.get(i));
				System.out.println("==============");
			}
			
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
