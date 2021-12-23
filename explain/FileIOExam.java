package explain;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIOExam {

	public static void main(String[] args) {
		
		//파일 작성하는 방법
		
		/*
		FileWriter writer = new FileWriter("c:\javatest/test1.txt"); 
		파일 작성 관련하여 여러가지 기능을 제공해주는 역할, (파일 위치(경로)를 적어 준다.)
		위의 () -> c드라이브에 내가 만든 javatest라는 파일에 test1.txt라는 이름으로 저장한다
		 + 위의 코드를 사용하기 위해서는 반드시 예외처리거 필요하다.
		*/
		
		try {
			FileWriter writer = new FileWriter("c:/javatest/test1.txt");
			writer.write("안녕하세요.\n");
			writer.write("반갑습니다.\n");
			writer.write("잘가세요.\n"); // 순서대로 test1.txt에 적힌다.
		
			writer.close(); //== 다작성했다는 의미
		}
		catch(IOException e) {
			System.out.println("파일 쓰지 중 문제가 발생하였습니다.");
		}

		
		//파일을 읽어 오는 방법
		try {
			FileReader reader = new FileReader("c:/javatest/test1.txt");
			//int result = reader.read();// -> 숫자로 읽어와서 불편하다
			//System.out.println("읽어온 문자 :" + result);
			
			/*
			BufferedReader br = new BufferedReader(reader);//숫자가 아닌 문자로 읽어 오기 위해서 사용해준다.
			String line = br.readLine();
			System.out.println(line); // -> 한줄씩 읽어 온다.
			line = br.readLine();
			System.out.println(line); //두번째 줄을 읽어 온다.
			*/
			
			BufferedReader br = new BufferedReader(reader);//숫자가 아닌 문자로 읽어 오기 위해서 사용해준다.
			String line = br.readLine();
			
			while(line != null) {
				System.out.println(line);
				line = br.readLine();
			}
			
			br.close();
			reader.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일이 없습니다.");
		} catch(IOException e) {
			System.out.println("파일 읽어 오는 중 문제가 발생하였습니다.");
		}
		
		
	}
	
}
