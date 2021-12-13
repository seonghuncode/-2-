package explain;

import java.util.ArrayList;
import java.util.Collections;

public class SortExam2 {

	public static void main(String[] args) {
		
		ArrayList<Integer> nums = new ArrayList<>(); //-> ArrayList로 하는 방법
		
		nums.add(2);
		nums.add(4);
		nums.add(1);
		nums.add(3);
		nums.add(7);
		nums.add(6);
		nums.add(8);
		nums.add(5);
		
		//Collections.sort(nums);
		//collections를 사용하지 않고 개발자가 만든 코드를 사용하고 싶을 경우
		
		for(int i = 0; i < nums.size(); i++) {
			System.out.print(nums.get(i) + " ");
		}
		System.out.println();

		//Collections.sort(nums);
		Sortor.sort(nums);

		for(int i = 0; i < nums.size(); i++) {
			System.out.print(nums.get(i) + " ");
		}
		System.out.println();
		
		
		
		
		//사람 타입일 경우 사용 방법
		
		사람 사람1 = new 사람(20, "홍길동");
		사람 사람2 = new 사람(17, "유관순");
		사람 사람3 = new 사람(21, "을지문덕");
		사람 사람4 = new 사람(30, "이순신");
		사람 사람5 = new 사람(28, "강감찬");

		ArrayList<사람> 사람들 = new ArrayList<>();

		사람들.add(사람1);
		사람들.add(사람2);
		사람들.add(사람3);
		사람들.add(사람4);
		사람들.add(사람5);
		
		Sortor.sort(사람들);
		
		
	}

}
//
////collections를 모방해서 만든다
//class Sortor{
//	
//	static void sort(ArrayList<Integer> nums) { //바로바로 사용하기 위해 static
//	
//		for(int j = 0; j < nums.size() - 1; j++) {																
//			for(int i = 0; i < nums.size() - 1 ; i++) {
//				if(nums.get(i) > nums.get(i + 1)) { //오름차순
//				//바로 붙어 있는 2배열을 비교해야 한다
//					
//					//교체알고리즘
//					int tmp = nums.get(i);
//					nums.set(i, nums.get(i + 1));
//					nums.set(i + 1, tmp);
//
//					
//					//이정렬은 느려서 많이 사용하지 않는다 더 빠른 정렬이 있는데 복잡하다는 단점이있다.
//					//이해만 하기 실제에서 사용하는 정렬은 훨씬 복잡하다(자바에서 제공을한다)
//				}
//			}
//		}
//
//		
//	}
//	
//}



//아래의 코드에 넣고 싶은 개발자가 만든 코드라고 생각하면 된다
class ComparatorImple implements MyComparator{
	
	public boolean compare(int a1, int a2) {
		if(a1 > a2) {
			return true;
		}
		return false;
	}
	
}


//========================================================
//아래의 경우는 자바가 만들어 놓았다고 생각 하면 된다

//사람일 경우에 해당 하는 풀이
//정렬에 넣고 싶은 class를 만든다
interface MyComparator{
	
	boolean compare(int a1, int a2);// compare은 MyComparator을 사용하기 위한 약속이 되기 때문에 class MyComparator -> interface MyComparator
	//따로 만들어서 코드를 넣어 사용하고 싶으면 이형식을 따라 만들어라
}



//사람일 경우 풀이

class Sortor{

static void sort(ArrayList<Integer> nums, MyComparator com) { //바로바로 사용하기 위해 static
	//Mycomparator이라는 것을 보고 비교해서 결과를 출력해 주겠다??
	
	
	for(int j = 0; j < nums.size() - 1; j++) {																
		for(int i = 0; i < nums.size() - 1 ; i++) {
			if(com.compare(nums.get(i), nums.get(i + 1))) { //나이순으로 하고 싶을 경우 이부분에 나이가 들어가야한다 고로 자바는 이부분을 비워 놓느다
			//사용자에게 요구 한다
			//또한 MyComparator에는 반드시 comapare이라는 것이 있어야 사용가능하다
			//개발자가 관여할 수 있는 부분	
				//교체알고리즘
				int tmp = nums.get(i);
				nums.set(i, nums.get(i + 1));
				nums.set(i + 1, tmp);

				
				//이정렬은 느려서 많이 사용하지 않는다 더 빠른 정렬이 있는데 복잡하다는 단점이있다.
				//이해만 하기 실제에서 사용하는 정렬은 훨씬 복잡하다(자바에서 제공을한다)
			}
		}
	}

	
}

}



//강사님 코드
//다시 한번 복습하기----------------------------------------------------------------------------------------------------


package test.day6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortExam4 {

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







