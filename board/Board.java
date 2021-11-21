package board;

import java.util.ArrayList;
import java.util.Scanner;

import boardutil.My_util;

public class Board {

	ArrayList<collect> collects = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	int no = 4;
	
	public Board() {
		test_data();
	}  //Board가 main class에서 new 하는 순간 실행이 된다.
	
	public void run_board() {
		
	//test_data(); ==> test_data는 메인이 아닌 중요하지 않은 코드이므로 메인 코드 위에 사용하는 것은 적절하지 못 하다.
		
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
			
			list(collects);
		}
		else if(cmd.equals("update")) {
			
			update();
		}
		else if(cmd.equals("delete")) {
			
			delete();
		}
		else if(cmd.equals("search")){
			search();
		}
		
			
			
			
			
		
		
	
		
		
	} // --> while문
	
	
	
	} // --> run_board문
	
	private void test_data() {
		//Main class에 3개의 데이터가 추가 되었으므로 작성일, 작성자, 조회수 순으로 데이터를 추가햇 넣어 준다.
		//My_util에서 getCurrnetDate(yyyy.MM.dd)의 형태로 오늘 날짜를 출력해 줘라
		collects.add(new collect(1, "안녕하세요", "내용1입니다", My_util.getCurrentDate("yyyy.MM.dd"), "익명", 0));
		collects.add(new collect(2, "안녕하세요", "내용2입니다", My_util.getCurrentDate("yyyy.MM.dd"), "익명", 0));
		collects.add(new collect(3, "안녕하세요", "내용3입니다", My_util.getCurrentDate("yyyy.MM.dd"), "익명", 0));
	}
	
	private void search() {
		System.out.print("검색 키워드를 입력해 주세요 : ");
		String keyword = sc.nextLine();
		
		//검색된 것들만 모아서 출력해 주기 위해서는 그곳들만 모아줄 배열이 필요 하다.
		ArrayList<collect> searched_all_keyword = new ArrayList<>();
		
		//무언가 찾아 출력하기 위해서는 반복문을 돌려 우선 찾게 시킨다.
		for(int i = 0; i < collects.size(); i++) {   //contains API 사용법 이해하기!!
			if(collects.get(i).All_title.contains(keyword)) {
//<방법1>				
//				System.out.println("번호 :" + collects.get(i).numbers);
//				System.out.println("제목 : " + collects.get(i).All_title);
//				System.out.println("==========================="); //이렇게도 사용 가능하지만 list외 겹치므로 더 좋은 코드를 만들어 준다
				searched_all_keyword.add(collects.get(i));
				
			}	
		}
		list(searched_all_keyword);
		
		
	}
	
	private void help() {
		System.out.println("add  : 게시물 등록");
		System.out.println("list : 게시물 목록 조회	");
	}
	private void add() {

		
		System.out.print("제목을 입력해 주세요 :");
		String title = sc.nextLine();
	
		
		System.out.print("내용을 입력해 주세요 :");
		String body = sc.nextLine();
		
		//괄호안의 형태로 오늘날의 날짜가 계산이 되어진다.
		String currentDate = My_util.getCurrentDate("yyyy.MM.dd");
		
		
		//collect라는 class에 만들어 놓은 생성자를 사용하기 위해??
		collect make_collect = new collect(no, title, body, currentDate, "익명", 0);
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
			
			
			collect make_collect = new collect(target_num, new_title, new_body, "2021-11-21", "익명", 0);
			collects.set(target_real_num, make_collect);
			
			System.out.println("수정이 왼료 되었습니다.");
			list(collects);
			
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
			list(collects); //list를 사용하기 위해서는 내가 보고 싶은 것을 매개변수로 넣어 주어야 한다.
		}
	}
	
	
	
	
	public void list(ArrayList<collect> list) {  //list를 더 유동성 있게 사용하기 위해서 매개변수를 통해 사용할 수 있도록 한다
		for(int i = 0; i < list.size(); i++) {
			// == collect make_collect = collects.get(i);
			collect make_collect = list.get(i);  
			System.out.println("번호 :" + make_collect.numbers);
			System.out.println("제목 : " + make_collect.All_title);
			//데이터가 추가가 되었으므로 출력할때 역시 추가하여 출력해주어야 한다.
			System.out.println("작성자 : " + make_collect.writer);
			System.out.println("등록날짜 : " + make_collect.regDate);
			System.out.println("조회수 : " + make_collect.hit);
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
