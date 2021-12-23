package explain;

import board.BoardCollect;
import boardutil.FileManager;

public class IOTest10 {
	
	public static void main(String[] args) {
		FileManager fm = new FileManager();

		BoardCollect a1 = new BoardCollect(1, "안녕하세요", "내용1입니다.", "2021120320000", 1, 20);

		fm.saveCollectToFile(a1);

	}
	
}
