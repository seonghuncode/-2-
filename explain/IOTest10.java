package explain;

import board.BoardCollect;
import boardutil.FileManager;

public class IOTest10 {
	
	public static void main(String[] args) {
		FileManager fm = new FileManager();

		BoardCollect a1 = new BoardCollect(1, "안녕하세요", "내용1입니다.", "2021120320000", 1, 20);
		BoardCollect a2 = new BoardCollect(2, "안녕하세요2", "내용2입니다.", "2021120420000", 2, 30);
		BoardCollect a3 = new BoardCollect(3, "안녕하세요3", "내용3입니다.", "2021120520000", 3, 40);
	
		fm.saveCollectToFile(a1);
		fm.saveCollectToFile(a1);
		fm.saveCollectToFile(a2);
		fm.saveCollectToFile(a3);

		fm.loadCollectFromFile(3);
		fm.loadCollectFromFile(4);
		
	}
	
}
