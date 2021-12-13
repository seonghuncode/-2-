package explain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import explain.SortExam.사람;

public class SortExam3 {

	public static void main(String[] args) {
//		ArrayList<Integer> nums = new ArrayList<>();
//
//		nums.add(2);
//		nums.add(4);
//		nums.add(1);
//		nums.add(3);
//		nums.add(7);
//		nums.add(6);
//		nums.add(8);
//		nums.add(5);
//		
//		//Collections.sort(nums);
//		
//		for(int i = 0; i < nums.size(); i++) {
//			System.out.print(nums.get(i) + " ");
//		}
//		System.out.println();
//		
//		//Collections.sort(nums);
//		
//		ComparatorImpl com = new ComparatorImpl();
//		//Sortor.sort(nums, com);
//		
//		for(int i = 0; i < nums.size(); i++) {
//			System.out.print(nums.get(i) + " ");
//		}
//		System.out.println();


		사람 사람1 = new 사람(20, 50, "홍길동");
		사람 사람2 = new 사람(17, 40, "유관순");
		사람 사람3 = new 사람(21, 60, "을지문덕");
		사람 사람4 = new 사람(30, 80, "이순신");
		사람 사람5 = new 사람(28, 60, "강감찬");

		ArrayList<사람> 사람들 = new ArrayList<>();

		사람들.add(사람1);
		사람들.add(사람2);
		사람들.add(사람3);
		사람들.add(사람4);
		사람들.add(사람5);

		//Sortor.sort(사람들);

		for(int i = 0; i < 사람들.size(); i++) {
			사람 현재사람 = 사람들.get(i);
			현재사람.자기소개();
		}

//		ComparatorImpl com2 = new ComparatorImpl();
//		Sortor.sort(사람들, com2);

		RealComparator rc = new RealComparator();
		Collections.sort(사람들, rc);

		System.out.println("====================================");
		for(int i = 0; i < 사람들.size(); i++) {
			사람 현재사람 = 사람들.get(i);
			현재사람.자기소개();
		}

	}

}


class RealComparator implements Comparator<사람> {

	@Override
	public int compare(사람 o1, 사람 o2) {

		if(o1.몸무게 > o2.몸무게) {
			return 1; // 양수 리턴시 자리 바꿈
		}

		return -1;
	}

}






class ComparatorImpl implements MyComparator {
	public boolean compare(사람 a1, 사람 a2) {
		if(a1.이름.compareTo(a2.이름) < 0) {
			return true;
		}
		return false;
	}
}























//아래 부분은 없는 부분이라고 생각하면 된다
// ======================================================================

interface MyComparator {
	boolean compare(사람 a1, 사람 a2);
}

//Collections
class Sortor {

	static void sort(ArrayList<사람> nums, MyComparator com) {
		for(int j = 0; j < nums.size() - 1; j++) {			
			for(int i = 0; i < nums.size() - 1 ; i++) {
				if(com.compare(nums.get(i), nums.get(i + 1))) {

					사람 tmp = nums.get(i);
					nums.set(i, nums.get(i + 1));
					nums.set(i + 1, tmp);

				}
			}
		}
	}

	}

}
