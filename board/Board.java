package board;

import java.util.ArrayList;
import java.util.Scanner;

import boardutil.My_util;

public class Board {
	//이름을 변경하는 이유 -> 이름짓는것과(class,변수)이름을 잘 짓도록 신경쓰기
	//나중에 또다른것이 나오면 현재의 것을 바탕으로 만들수 있기 때문에 
	
	//BoadColect > BaseCollect > 데이터
	//무엇을 시키면 자신의 데이터에서 먼자 찾아보고 없으면 상속관계의 데이터에서 찾아본다
	
	//리펙토링을 하면서 Collect -> BoardCollect로 변경(일일히 안하고 한번에 하는 방법 == 커서를 맨위에두고 ctrl + f)
	//=> find부분에 collct, replace부분에 BoardCollect로 하면 한번에 변경 가능하다.
	//replace all해도 되지만 안전하게 find후 replace/find로 확인하면서 변경해주면 좋다.
	
	
	//변수명은 소문자로 시작한다(개발자간 약속??)
	ArrayList<BoardCollect> boardCollects = new ArrayList<>();
	ArrayList<Member> members = new ArrayList<>();
	ArrayList<ReplyCollect> replies = new ArrayList<>(); //REplyCollect를 저장하는 저장소
	ArrayList<Like> likes = new ArrayList<>(); //Like를 저장할 배열을 만들어 준다
	
	Scanner sc = new Scanner(System.in);
	String dateFormat = "yyyy.MM.dd"; // 항상 직접 적어주어야 하기에 변수에 넣어 사용한다.
	int boardCollect_no = 4;  //no가 두개 생겼기 때문에 헷갈리지 않게 이름을 바꾸어 준다
	int memberNo = 3;
	int replyCollectNo = 1; // BoardCollect넘버에서 memberNo처럼 만들어 준다.
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
			//add();
			if(isLoginCheck() == true) {
				add();
			}
		}
		else if(cmd.equals("list")) {
			
			list(boardCollects);
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
		else if(cmd.equals("logout")) {
			//logout(); -> 메서드를 사용하지 않고 초기 코드값을 사용했을 경우
			if(isLoginCheck() == true) {
				logout();
			}
		}
			
			
			
			
		
		
	
		
		
	} // --> while문
	
	
	
	} // --> run_board문
	
	private boolean isLoginCheck() {
		if(loginedMember == null) {
			System.out.println("로그인이 필요한 기능 입니다.");
			return false;
		}
		return true;
	}
	
	
	
	private void logout() {
		//if(loginedMember == null) {
		//	System.out.println("로그인이 필요한 기능입니다.");
		//	return;  //리턴을 만나는 즉시 메서드 종료, 호출한 쪽으로 다시 되돌아 간다.
		//}   --> 이 기능이 중복으로 사용 되기 때문에 따로 메서드로 만들어 준다.
		loginedMember = null;
		System.out.println("로그아웃 되었습니다.");
	}
	
	
	
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
				
				//우수회원 일반회원 구별
//				if(member instanceof GeneralMember) {
//					System.out.println("안녕하세요 일반회원" + member.nickname + "님 반갑습니다" );
//					
//				}
//				 else if(member instanceof SpecialMember) {
//						SpecialMember specialMember = (SpecialMember)member;
//						System.out.println("안녕하세요 우수회원" + specialMember.nickname + "님 사랑합니다. 회원님의 잔여 포인트는 " + specialMember.point);
//					}
				
				//위의 방법도 가능하나 오버라이딩을 횔용한 방법
				
				member.greeting();
				//greeting은 member에 있으며 상속관계에 있는 generalmember, specialmember모두 사용 가능하다
				
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
		
		System.out.print("1. 일반회원, 2. 우수회원 :");
		int memberFlag = Integer.parseInt(sc.nextLine());
		
		System.out.println("==== 회원 가입을 진행합니다 ====");
		System.out.print("아이디를 입력해주세요 :");
		String id = sc.nextLine();
		
		System.out.print("비밀번호를 입력해주세요 :");
		String pw = sc.nextLine();
		
		System.out.println("닉네임을 입력해주세요 :");
		String nickname = sc.nextLine();
		
		
		Member member = null;

		if(memberFlag == 2) {
			member = new SpecialMember(memberNo, id, pw, nickname, 0);
		} else {
			member = new GeneralMember(memberNo, id, pw, nickname);
		}
		
		//add를 해주기 위해 member만 모아두는 ArrayList를 만들어 준다.
		members.add(member);
		
		System.out.println("==== 회원가입이 완료되었습니다. ====");
		memberNo++;
	}
	
	
	private void read() {
	//list에서 내용을 보여주지 않기 때문에 상세 read를 하면 상세보기를 할 수 있는 기능이다.
	     System.out.print("상세 보기 할 게시물 번호를 입력해 주세요 :");
	     int target_num = Integer.parseInt(sc.nextLine());
	     
	     //int target_real_num = check_list(target_num);
	     BoardCollect boardCollect1 = getBoardCollectByNo(target_num);
	     
	     if(boardCollect1 == null) {
	    	 System.out.println("없는 게시물 번호 입니다.");
	     }
	     else {
	    	
	    	 boardCollect1.hit ++; //조회수를 1씩 증가 시켜준다.(상세 보기 할 때마다 증가??)
	    	 
	    	          //같은 데이터가 다른곳에도 필요로 하기 때문에 따로 만들어 사용한다(중복 최소화)
	    	 		  printBoardCollect(boardCollect1);//BoardCollect1이 필요하니까 넘겨준다
	    	 
	          		  readProcess(boardCollect1);
	          		  
	          		  
	          		  
	          		  
	          		  
	     }
	     
	     		
	}
	
	private void printBoardCollect(BoardCollect BoardCollect1) {
		  System.out.println("====" + BoardCollect1.id + "번 게시물 ====");
          System.out.println("번호 :" + BoardCollect1.id);
          System.out.println("제목 :" + BoardCollect1.All_title);
          System.out.println("-------------------");
		  System.out.println("내용 :" + BoardCollect1.body);
		  System.out.println("-------------------");
 		  System.out.println("작성자 :" + BoardCollect1.nickname); 
		  System.out.println("등록날짜:" + BoardCollect1.regDate);
		  System.out.println("조회수 :" + BoardCollect1.hit);
		  
		  Like like = getLikeByCollectIdAndMemberId(BoardCollect1.id, loginedMember.localId);
		  if(like == null) {
			  System.out.println("좋아요 : ♡" + getLikeCountByCollectId(BoardCollect1.id));
		  }
		  else {
			  System.out.println("좋아요 : ♥" + getLikeCountByCollectId(BoardCollect1.id)); 
		  }
		  
		  System.out.println("===================");
		  System.out.println("======= 댓글 =======");
		  //댓글을 보여주기 위해 어디 있는지 찾아야 한다
		  for(int i = 0; i < replies.size(); i++) {
			  
			  ReplyCollect currentReplyCollect = replies.get(i);
			  //BoardCollect와 같은 역할을 하게 만든다??(방금 전 코드의)
			  
			 BaseCollect info = currentReplyCollect;
			 
			 if(currentReplyCollect.parentId == BoardCollect1.id) {
				 //바로 넣을 수 없기 때문에 (REplyCollect)를 적어 형변환을 시켜준다.
				currentReplyCollect = (ReplyCollect)setNickname(currentReplyCollect); 
			 //replyCollect는 boarcollect에 들어 올수 없다 > 형이 안맞기 때문에
			  
				  //setREplyCollectNickname을 거쳐서 오면 닉네임이 셋팅이 되어 나온다
				  System.out.println("내용 :" + currentReplyCollect.body);
				  System.out.println("작성자 :" + currentReplyCollect.nickname); //memberId인데 memberId로 적으면 안되기 때문에
				  System.out.println("작성일 :" + currentReplyCollect.regDate); //REplyCollect class에 nickname을 하나 더 만들어 준다.
				  System.out.println("==================");
			  }
			  
		  }
		  
	}
	
	
	
	
	public int getLikeCountByCollectId(int collectId) {
	//누적 좋아요 하트의 숫자를 계산해주는 메서드	
		int count = 0;
		for(int i = 0; i < likes.size(); i++) {
			Like like = likes.get(i);
			if(like.collectId == collectId) {
				count++;
			}
		}
		return count;
	}
	
	
	
	
	private void readProcess(BoardCollect boardCollect1) {
		//상세 보기 메뉴 추가
		while(true) { //반복문에 기능들을 넣는 이유는 원할때 까지 기능을 사용하도록 하기 위해서 이다.
		
		System.out.println("상세보기 기능을 선택해주세요(1. 댓글 등록, 2. 좋아요, 3. 수정, 4. 삭제, 5. 목록으로) : ");
		  int readCmd = Integer.parseInt(sc.nextLine());
		  
		  if(readCmd == 1) {
			  System.out.println("[댓글 기능]");
			  ReplyCollect(boardCollect1);
		  }
		  else if(readCmd == 2) {
			  System.out.println("[좋아요 기능]");
			  
			  //1. 어떤 게시물? 게시물 번호?
			  //2. 누가 체크 했나? 회원 번호
			  //3. 언제 작성 했는가? 등록 날짜
			  
			  //좋아요가 하나 만들어진 상태이다.
			  //new Like(boardCollect1.id, loginedMember.localId, My_util.getCurrentDate(dateFormat));
			  //이후에 이 게시물을 이 회원이 어느때 체크했다는 것을 기억하게 해야한다
			  //변수에 기억을 해야하는데 좋아요가 한두개가 아니므로 arrayList에 저장한다
			  //--> 우선 받아준후 저장한다
			  
			  //양자 택일 구조를 만들어준다 / 좋아요 체크 / 좋아요 해제
			  //likes라는  저장소에 저장이 되어 있느냐 안되어 있느냐에 따라 체크 여부가 결정 된다
			  
			  //저장소에서 좋아요를 찾아오는 메서드/ 게시물 번호와 회원 번호를 조합하여 좋아요 구별(한게시물에 한개의 좋아요 가능 각 회원별로)
			 Like like = getLikeByCollectIdAndMemberId(boardCollect1.id, loginedMember.localId);
			 //이때 메서들 이름을 먼저 만들고 빤갈줄 클릭하여 자동 메서드 생성 
			 
			  if(like == null) {
				  like = new Like(boardCollect1.id, loginedMember.localId, My_util.getCurrentDate(dateFormat));
				  likes.add(like);
				  System.out.println("해당 게시물을 좋아합니다.");
			  }
			  else{
				  likes.remove(like); //찾았으면 이미 좋아요를 했다는 뜻이기 때문에 지워준다.
			  System.out.println("해당 게시물의 좋아요를 해제합니다.");
			  }
			  //마지막에 출력을 해줘야 볼 수 있다
			  printBoardCollect(boardCollect1);
			  
		  }
		  else if(readCmd == 3) {
			  System.out.println("[수정 기능]");
		  }
		  else if(readCmd == 4) {
			  System.out.println("[삭제기능]");
		  }
		  else if(readCmd == 5) {
			  System.out.println("[목록 으로]");
			  break;
		  }
		}
		  
	}
	
	
	
	private Like getLikeByCollectIdAndMemberId(int collectId, int memberId) {
		
		for(int i = 0; i < likes.size(); i++) {
			Like like = likes.get(i); 
			if(like.collectId == collectId && like.memberId == memberId) {
				return like; //찾았으면 내보내야 한다
			}
		}
		//위의 for문을 다 돌았는데도 없으면 비어있는 null값으로 리턴
		return null;
	}
	
	
	
	private void ReplyCollect(BoardCollect BoardCollect1) {
		//상세보기할 게시물
		 System.out.print("댓글 내용을 입력해 주세요 :");

		 String rbody = sc.nextLine();
		 int memberId = loginedMember.localId; // == memberId구하는 방법
		 String regDate = My_util.getCurrentDate(dateFormat);
		 
		 //read하면 상세보기 하겠다는 이야기 이므로 이때 찾은 상세보기 게시물이 번호기 때문에 BoardCollect1.numbers를 작성해 준다.
		 ReplyCollect ReplyCollect = new ReplyCollect(replyCollectNo,BoardCollect1.id, rbody, memberId, regDate);//REplyCollect틀에 REplyCollect라는 인스턴스를 만들어서
		 replies.add(ReplyCollect);			// -> ()안에 원하는 저장 값을 넣어 저장 후  만들어 놓은 배열에 REplyCollect를 통체로 저장
		 
		System.out.println("댓글이 등록 되었습니다."); 
		
		//상세보기 다시 보여 주기.(read에 있다)
		printBoardCollect(BoardCollect1); //BoardCollect1이 없기 때문에 
		// -> REplyCollect를 호출하고 있는 것 == readProcess(여기도 게시물 번호가 없다) -> readProcess를 호출한 것(read) 여기서
		//BoardCollect1 정보가 필요 하기 때문에 read메서드에 readProcess에 BoardCollect1을 넣어준다 -> readProcess에서 BoardCollect BoardCollect1으로
		//바로 받아준다 -> REplyCollect(BoardCollect1) -> 현 REplyCollect메서드 에서도 BoardCollect BoardCollect1으로 받아준다.
		  
	}
	
	
	
	private void test_data() {
		//Main class에 3개의 데이터가 추가 되었으므로 작성일, 작성자, 조회수 순으로 데이터를 추가햇 넣어 준다.
		//My_util에서 getCurrnetDate(yyyy.MM.dd)의 형태로 오늘 날짜를 출력해 줘라
		String currentDate = My_util.getCurrentDate(dateFormat); //같은 긴 코드가 중복되기 때문에 변수로 만들어 관리해준다.
//		BoardCollects.add(new BoardCollect(1, "안녕하세요", "내용1입니다", currentDate, "홍길동", 0));
//		BoardCollects.add(new BoardCollect(2, "안녕하세요", "내용2입니다", currentDate, "이순신", 0));
//		BoardCollects.add(new BoardCollect(3, "안녕하세요", "내용3입니다", currentDate, "홍길동", 0));
		//writer에서 memberId로 바뀌었으므로 몇번엔지 순번으로 적어준다.
		boardCollects.add(new BoardCollect(1, "안녕하세요", "내용1입니다", currentDate, 2, 0));
		boardCollects.add(new BoardCollect(2, "안녕하세요", "내용2입니다", currentDate, 1, 0));
		boardCollects.add(new BoardCollect(3, "안녕하세요", "내용3입니다", currentDate, 2, 0));
		
		members.add(new GeneralMember(1, "hong123", "h1234", "홍길동"));
		members.add(new SpecialMember(2, "lee123", "1234", "이순신", 0));
		
		loginedMember = members.get(0);//테스트 데이터인데 일일이 로그인을 하기 번거롭기 때문에 로그인을 시켜 놓는다.
	}
	
	private void search() {
		System.out.print("검색 키워드를 입력해 주세요 : ");
		String keyword = sc.nextLine();
		
		//검색된 것들만 모아서 출력해 주기 위해서는 그곳들만 모아줄 배열이 필요 하다.
		ArrayList<BoardCollect> searched_all_keyword = new ArrayList<>();
		
		//무언가 찾아 출력하기 위해서는 반복문을 돌려 우선 찾게 시킨다.
		for(int i = 0; i < boardCollects.size(); i++) {   //contains API 사용법 이해하기!!
			if(boardCollects.get(i).All_title.contains(keyword)) {
//<방법1>				
//				System.out.println("번호 :" + BoardCollects.get(i).numbers);
//				System.out.println("제목 : " + BoardCollects.get(i).All_title);
//				System.out.println("==========================="); //이렇게도 사용 가능하지만 list외 겹치므로 더 좋은 코드를 만들어 준다
				searched_all_keyword.add(boardCollects.get(i));
				
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
		String currentDate = My_util.getCurrentDate(dateFormat);
		
		
		//BoardCollect라는 class에 만들어 놓은 생성자를 사용하기 위해??
		BoardCollect make_BoardCollect = new BoardCollect(boardCollect_no, title, body, currentDate, loginedMember.localId, 0);
		boardCollects.add(make_BoardCollect);    //이름이 같은 중복자가 있을경우 구별을 할 수 없으므로 loginedMemberid와 
		//collet_no를 사용하여 구별을 해준다 이때 BoardCollect_no는 고유의 번호로 1씩 증가하면서 저장 되기에 중복이 될 수 없다
		
		System.out.println("게시물이 저장 되었습니다.");
		boardCollect_no++;
	}
	private void update() {
		System.out.print("수정할 게시물 번호 :");
		int target_num = Integer.parseInt(sc.nextLine());
		

		BoardCollect BoardCollect1 = getBoardCollectByNo(target_num);
		
		if(BoardCollect1 == null) {
			System.out.println("없는 게시물 번호 입니다.");
		}
		else {
			System.out.print("새제목 :");
			String new_title = sc.nextLine();
	
			
			System.out.print("새내용 :");
			String new_body = sc.nextLine();
			
			BoardCollect1.All_title = new_title;
			BoardCollect1.body = new_body;
			
			System.out.println("수정이 왼료 되었습니다.");
			list(boardCollects);
			
		}
	}
	private void delete() {
		System.out.print("삭제할 게시물 번호 : ");
		int target_num = Integer.parseInt(sc.nextLine());
		
		BoardCollect BoardCollect1 = getBoardCollectByNo(target_num);
		
		if(BoardCollect1 == null) {
			System.out.println("없는 게시물 번호 입니다.");
		}
		else {
			boardCollects.remove(BoardCollect1);
			
			
			System.out.println("삭제가 완료 되었습니다.");
			list(boardCollects); //list를 사용하기 위해서는 내가 보고 싶은 것을 매개변수로 넣어 주어야 한다.
		}
	}
	
	
	
	
	public void list(ArrayList<BoardCollect> list) {  //list를 더 유동성 있게 사용하기 위해서 매개변수를 통해 사용할 수 있도록 한다
		for(int i = 0; i < list.size(); i++) {
			// == BoardCollect make_BoardCollect = BoardCollects.get(i);
			BoardCollect make_BoardCollect = list.get(i);  
			
			make_BoardCollect = (BoardCollect)setNickname(make_BoardCollect);//모든 게시물의 닉네임을 작성자에게 맞게 세팅
			
			System.out.println("번호 :" + make_BoardCollect.id);
			System.out.println("제목 : " + make_BoardCollect.All_title);
			//데이터가 추가가 되었으므로 출력할때 역시 추가하여 출력해주어야 한다.
			System.out.println("작성자 : " + make_BoardCollect.nickname);
			System.out.println("등록날짜 : " + make_BoardCollect.regDate);
			System.out.println("조회수 : " + make_BoardCollect.hit);
			System.out.println("===========================");
		}
	}
	
	
	//게시물 데이터를 찾을때 index가 아닌 게시물 데이터 그 자체를 찾는 것으로 변경	
	//회원이름을 게시물에 적용시켜 조립된 상태로 얻기 위함
	public BoardCollect getBoardCollectByNo(int target_num) {
		
		BoardCollect targetBoardCollect = null;
		//찾고자 하는 게시물 찾기
		for(int i = 0; i < boardCollects.size(); i++) {
		
			BoardCollect exist_num = boardCollects.get(i);
			if(target_num == exist_num.id) {
				targetBoardCollect = exist_num;
				break;
			}
	}
		//닉네임을 세팅하고
		targetBoardCollect = (BoardCollect)setNickname(targetBoardCollect);
		//반환
		return targetBoardCollect;
	}	
	
	//게시물을 받아 해당 게시물의 작성자 번호에 맞는 작성자 닉네임을 세팅해 주는 메서드
	private BaseCollect setNickname(BaseCollect baseCollect) {
	 //둘다 가지고 있는 BaseCollect로 받아준다(boardcollect, replycollect모두 받아줄수 있다)
		
		//null이 아니면 게시물에 닉네임을 세팅해주고 반환 아니면 null그대로 반환
		if(baseCollect != null) {
			Member member = getMemberByMemberNo(baseCollect.memberId);
			baseCollect.nickname = member.nickname;
		}
		return baseCollect;
	}
	
	
	//게시물 찾기와 마찬가지로 역시 회원 저보 그 자체를 찾은 것으로 변경
	private Member getMemberByMemberNo(int memberId) {
		
		Member targetMember = null;
		
		for(int i = 0; i < members.size(); i++) {
			Member currentMember = members.get(i);
			if(memberId == currentMember.localId) {
				targetMember = currentMember;
				break;
			}
		}
		return targetMember;
	}
	
	
} // --> Board class
