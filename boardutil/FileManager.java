package boardutil;

import java.io.FileWriter;
import java.io.IOException;

import board.BoardCollect;

public class FileManager {
	//파일을 만들어 주고 읽어주는 역할을 한다.
	//쓰는것 따로 읽는 것 따로 관리 해준다.
	
	public void saveCollectToFile(BoardCollect collect) {
		
		try {
			FileWriter writer = new FileWriter("c:/javatest/collect_"+ collect.id + ".txt"); //게시물 하나당 파일하나로 저장하는게 관리에 용이하다
			//게시물 저장
			//번호
			writer.write("id:" + collect.id + ",");
			//제목
			writer.write("title:" + collect.All_title + ",");
			//내용
			writer.write("body:" + collect.body + ",");
			//작성자
			writer.write("memberid:" + collect.memberId + ",");
			//작성일
			writer.write("regDate:" + collect.regDate + ",");
			//조회수
			writer.write("hit:" + collect.hit);
			
			writer.close(); 
		}
		catch(IOException e) {
			System.out.println("파일 쓰지 중 문제가 발생하였습니다.");
			//-> 이 코드가 실행되면 예외적 상황이 발생하여 여기로 빠졌다. == 문제가 발생했다.
			e.printStackTrace(); // -> 문제가 발생했을때 어디서 생긴 문제인지 잘 모를 경우 사용하면 뭐때문에 문제가 생겼는지 알려준다.
		}
		
		//잘 동작하는지 확인하기 위해 test파일을 만들어 불러와 실행하는 것이 좋다.
		
	}
	
}
