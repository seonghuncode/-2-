package explain;

import board.BoardCollect;

public class SplitTest {

	public static void main(String[] args) {
		
		String target = "id:3,title:안녕하세요3,body:내용3입니다.,memberId:3,regDate:2021120520000,hit:40";
		// 한줄짜리 target 문자열을 -> BoardArticle 객체로 바꾸고 싶다.

		// split -> 문자열 짜르기// 구글링 해보기
		String[] properties = target.split(",");
		BoardCollect article = new BoardCollect();

		for(int i = 0; i < properties.length; i++) {
			String[] property = properties[i].split(":");

			if(property[0].equals("id")) {
				article.id = Integer.parseInt(property[1]);
			} else if(property[0].equals("title")) {
				article.All_title = property[1];
			} else if(property[0].equals("body")) {
				article.body = property[1];
			} else if(property[0].equals("memberId")) {
				article.memberId = Integer.parseInt(property[1]);
			} else if(property[0].equals("regDate")) {
				article.regDate = property[1];
			} else if(property[0].equals("hit")) {
				article.hit = Integer.parseInt(property[1]);
			}
		}

		System.out.println("번호 : " + article.id);
		System.out.println("제목 : " + article.All_title);
		System.out.println("내용 : " + article.body);
		System.out.println("작성자 : " + article.memberId);
		System.out.println("작성일 : " + article.regDate);
		System.out.println("조회수 : " + article.hit);

		

	}

}
