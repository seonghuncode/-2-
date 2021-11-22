package board;

import java.util.ArrayList;
import java.util.Scanner;

import boardutil.My_util;

public class Board {

	ArrayList<collect> collects = new ArrayList<>();
	ArrayList<Member> members = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	int no = 4;
	Member loginedMember = null; //자바에서 검은색 글씨는 객체를 의미, 값을 넣어주지 않으면 null값이 자동으로 들어간다.
	
	public Board() {
		test_data();
	}  //Board가 main class에서 new 하는 순간 실행이 된다.
	
	public void run_board() {
		
	//test_data(); ==> test_data는 메인이 아닌 중요하지 않은 코드이므로 메인 코드 위에 사용하는 것은 적절하지 못 하다.
		
	while(true) {
		
		if(loginedMember == null) {
			System.out.print("명령어를 입력해 주세요 :");
		}
		else {
			System.out.println("명령어를 입력해주세요[" + loginedMember.id + "(" + loginedMember.nickname + ")] : ");
		}
		
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
		else if(cmd.equals("read")) {
			read();  
		}
		else if(cmd.equals("signup")) {
			signup();
		}
		else if(cmd.equals("login")) {
			login();
		}
			
			
			
			
		
		
	
		
		
	} // --> while문
	
	
	
	} // --> run_board문
	
	private void login() {
		System.out.print("아이디 :");
		String login_id = sc.nextLine();
		
		System.out.print("비밀번호 :");
		String login_pw = sc.nextLine();
		
		boolean exist_login_id = false;
		//존재 여부를 먼저 확인 해야 하기 때문에 반복문을 통해 존재하는 아이디,비밀번호 인지 찾아보개 시킨다.
		for(int i = 0; i < members.size(); i++) {
			Member member = members.get(i);
			if(member.id.equals(login_id) && member.pw.equals(login_pw)) {
				System.out.println(member.nickname + "님 환영 합니다.");
				loginedMember = member; // ->로그인이 필요한 기능이 나올때 마다 로그인을 해야 하기 때문에 로그아웃을 하기전 까지 유지 되어야 한다.
				exist_login_id = true;  //로그인이 유지 되기 위해서는 지역변수 보다 상위에 정보가 위치해 있어야 기억할 수 있다.
				break; 				//메서드 위에 적어도 되지만 자바에서 변수들은 맨위에 모아서 관리하는게 편리하다.
			}
		}
		//존재 하지 않는 아이디의 경우 반복문 밖에 코들를 만드는데 else를 사용할 경우 매번 코드가 실행 되기 땜누에 boolean값을 활용한다.
		if(exist_login_id == false) {
			System.out.println("비밀번호를 틀렸거나 잘못된 회원정보입니다.");
		}
	}
	
	
	private void signup() {
		System.out.println("==== 회원 가입을 진행합니다 ====");
		System.out.print("아이디를 입력해주세요 :");
		String id = sc.nextLine();
		
		System.out.print("비밀번호를 입력해주세요 :");
		String pw = sc.nextLine();
		
		System.out.println("닉네임을 입력해주세요 :");
		String nickname = sc.nextLine();
		
		//회원가입하는 멤버에 대한 새로운 class를 만들어 준다.
		Member member = new Member(id, pw, nickname);
		//add를 해주기 위해 member만 모아두는 ArrayList를 만들어 준다.
		members.add(member);
		
		System.out.println("==== 회원가입이 완료되었습니다. ====");
	}
	
	
	private void read() {
	//list에서 내용을 보여주지 않기 때문에 상세 read를 하면 상세보기를 할 수 있는 기능이다.
	     System.out.print("상세 보기 할 게시물 번호를 입력해 주세요 :");
	     int target_num = Integer.parseInt(sc.nextLine());
	     
	     int target_real_num = check_list(target_num);
	     
	     if(target_real_num == -1) {
	    	 System.out.println("없는 게시물 번호 입니다.");
	     }
	     else {
	    	 collect collect_read = collects.get(target_real_num);  // -> 상세 보기할 진찌 번호
	    	 collect_read.hit ++; //조회수를 1씩 증가 시켜준다.(상세 보기 할 때마다 증가??)
	    	 
	    	          System.out.println("====" + collect_read.numbers + "번 게시물 ====");
	    	          System.out.println("번호 :" + collect_read.numbers);
	    	          System.out.println("제목 :" + collect_read.All_title);
	    	          System.out.println("-------------------");
	    	  		  System.out.println("내용 :" + collect_read.All_body);
	          		  System.out.println("-------------------");
		       		  System.out.println("작성자 :" + collect_read.writer);
	          		  System.out.println("등록날짜:" + collect_read.regDate);
	          		System.out.println("조회수 :" + collect_read.hit);
	          		  System.out.println("===================");
	    	 
	     }
	     
	     		
	}
	
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
