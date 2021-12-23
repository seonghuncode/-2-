package explain;

import java.io.File;

public class FileListTest {

	public static void main(String[] args) {
		
		File file = new File("c:/test/article/article_1.txt");

		System.out.println(file.getName());
		System.out.println(file.getParentFile());
		System.out.println(file.isDirectory());

		File file2 = new File("c:/test/article");
		System.out.println(file2.getName());
		System.out.println(file2.getParentFile());
		System.out.println(file2.isDirectory());

		String[] filenames = file2.list();

		for(int i = 0; i < filenames.length; i++) {
			System.out.println(filenames[i]);
		}
		

	}

}
