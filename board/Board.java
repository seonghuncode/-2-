package board;

import java.util.ArrayList;
import java.util.Scanner;

public class Board {

	ArrayList<String> All_title = new ArrayList<>();
	ArrayList<String> All_body = new ArrayList<>();
	ArrayList<Integer> numbers = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	
	public void run_board() {
		
	
	int no = 1;
		
	while(true) {
		
		System.out.print("명령어를 입력해 주세요 : ");
		String cmd = sc.nextLine();
		
		if(cmd.equals("help")) {
			System.out.println("add  : 게시물 등록");
			System.out.println("list : 게시물 목록 조회	");
		}
		else if(cmd.equals("add")) {
			//제목을 입력해주세요 : (출력) 안녕하세요(입력)
			// 내용을 입력해주세요 : (출력) 반갑습니다(입력)
			// 게시물이 저장되었습니다. (출력)
			numbers.add(no);
			
			System.out.print("제목을 입력해 주세요 :");
			String title = sc.nextLine();
			All_title.add(title);
			
			System.out.print("내용을 입력해 주세요 :");
			String body = sc.nextLine();
			All_body.add(body);
			
			System.out.println("게시물이 저장 되었습니다.");
			no++;
		}
		else if(cmd.equals("list")) {
			// 번호 : 1(출력)
			// 제목 : 안녕하세요(출력)
			// 내용 : 반갑습니다(출력)
//			for(int i = 0; i < All_title.size(); i++) {
//				System.out.println("번호 :" + (i + 1));
//				System.out.println("제목 : " + All_title.get(i));
//				System.out.println("내용 : " + All_body.get(i));
//				System.out.println("===========================");
//			}
			list();
		}
		else if(cmd.equals("update")) {
			System.out.print("수정할 게시물 번호 :");
			int target_num = Integer.parseInt(sc.nextLine());
			
//			int target_real_num = -1;
//			for(int i = 0; i < numbers.size(); i++) {
//				int exist_num = numbers.get(i);
//				if(target_num == exist_num) {
//					target_real_num = i;
//					break;
//				}
//			}
			int target_real_num = check_list(target_num);
			
			if(target_real_num == -1) {
				System.out.println("없는 게시물 번호 입니다.");
			}
			else {
				System.out.print("새제목 :");
				String new_title = sc.nextLine();
				All_title.set(target_real_num, new_title);
				
				System.out.print("새내용 :");
				String new_body = sc.nextLine();
				All_body.set(target_real_num, new_body);
				
				System.out.println("수정이 왼료 되었습니다.");
				list();
				
			}
			
			
		}
		else if(cmd.equals("delete")) {
			System.out.print("삭제할 게시물 번호 : ");
			int target_num = Integer.parseInt(sc.nextLine());
			
			int target_real_num = check_list(target_num);
			
			if(target_real_num == -1) {
				System.out.println("없는 게시물 번호 입니다.");
			}
			else {
				All_title.remove(target_real_num);
				All_body.remove(target_real_num);
				numbers.remove(target_real_num);
				
				System.out.println("삭제가 완료 되었습니다.");
				list();
			}
			
		}
				
		
	
		
		
	} // --> while문
	
	} // --> run_board문
	
	public void list() {
		for(int i = 0; i < All_title.size(); i++) {
			System.out.println("번호 :" + (i + 1));
			System.out.println("제목 : " + All_title.get(i));
			System.out.println("내용 : " + All_body.get(i));
			System.out.println("===========================");
		}
	}
	
	public int check_list(int target_num) {
		
		for(int i = 0; i < numbers.size(); i++) {
			int exist_num = numbers.get(i);
			if(target_num == exist_num) {
				return i;
			}
	}
		return -1;
}		
	
	
} // --> Board class
