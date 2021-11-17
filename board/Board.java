package board;

import java.util.ArrayList;
import java.util.Scanner;

public class Board {

	ArrayList<collect> collects = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	int no = 1;
	
	public void run_board() {
		
	
		
	while(true) {
		
		System.out.print("명령어를 입력해 주세요 : ");
		String cmd = sc.nextLine();
		
		if(cmd.equals("help")) {
			help();
		}
		else if(cmd.equals("add")) {
			add();
		}
		else if(cmd.equals("list")) {
			
			list();
		}
		else if(cmd.equals("update")) {
			
			update();
		}
		else if(cmd.equals("delete")) {
			
			delete();
		}
		
		
			
			
			
			
		
		
	
		
		
	} // --> while문
	
	
	
	} // --> run_board문
	
	private void help() {
		System.out.println("add  : 게시물 등록");
		System.out.println("list : 게시물 목록 조회	");
	}
	private void add() {

		
		System.out.print("제목을 입력해 주세요 :");
		String title = sc.nextLine();
	
		
		System.out.print("내용을 입력해 주세요 :");
		String body = sc.nextLine();
		
		
		//collect라는 class에 만들어 놓은 생성자를 사용하기 위해??
		collect make_collect = new collect(no, title, body);
		collects.add(make_collect);
		
		System.out.println("게시물이 저장 되었습니다.");
		no++;
	}
	private void update() {
		System.out.print("수정할 게시물 번호 :");
		int target_num = Integer.parseInt(sc.nextLine());
		

		int target_real_num = check_list(target_num);
		
		if(target_real_num == -1) {
			System.out.println("없는 게시물 번호 입니다.");
		}
		else {
			System.out.print("새제목 :");
			String new_title = sc.nextLine();
	
			
			System.out.print("새내용 :");
			String new_body = sc.nextLine();
			
			
			collect make_collect = new collect(target_num, new_title, new_body);
			collects.set(target_real_num, make_collect);
			
			System.out.println("수정이 왼료 되었습니다.");
			list();
			
		}
	}
	private void delete() {
		System.out.print("삭제할 게시물 번호 : ");
		int target_num = Integer.parseInt(sc.nextLine());
		
		int target_real_num = check_list(target_num);
		
		if(target_real_num == -1) {
			System.out.println("없는 게시물 번호 입니다.");
		}
		else {
			collects.remove(target_real_num);
			
			
			System.out.println("삭제가 완료 되었습니다.");
			list();
		}
	}
	
	
	
	
	public void list() {
		for(int i = 0; i < collects.size(); i++) {
			collect make_collect = collects.get(i);
			System.out.println("번호 :" + make_collect.numbers);
			System.out.println("제목 : " + make_collect.All_title);
			System.out.println("내용 : " + make_collect.All_body);
			System.out.println("===========================");
		}
	}
	
	public int check_list(int target_num) {
		
		for(int i = 0; i < collects.size(); i++) {
		
			collect exist_num = collects.get(i);
			if(target_num == exist_num.numbers) {
				return i;
			}
	}
		return -1;
}		
	
	
} // --> Board class
