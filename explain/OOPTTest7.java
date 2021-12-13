package explain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class OOPTTest7 {

	public static void main(String[] args) {
		
		//필요할때 마다 정렬을 만들어 사용하면 복잡하기 때문에 자바에서 제공한다
		
		int[] arr = {2,4,1,3,7,6,8,5};
		
		
		
		//정렬하기 전
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		//위의 arr은 배열이고 arr이라는 배열을 만들면 Arrays라는 class가 있다 -> 자바에서 만들어 놓았다
		Arrays.sort(arr); //()안에 정렬하고 싶은 배열을 넣으면 된다
		
		//구글링 해보기
		//Arrays.sort(arr,Collections.reverseOrder()); //내림차순
		
		//정렬후
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		ArrayList<Integer> nums = new ArrayList<>(); //-> ArrayList로 하는 방법
		
		nums.add(2);
		nums.add(4);
		nums.add(1);
		nums.add(3);
		nums.add(7);
		nums.add(6);
		nums.add(8);
		nums.add(5);
		
		Collections.sort(nums); //ArrayList -> collections
		Collections.sort(nums, Collections.reverseOrder()); // == 내림차순
		
		for(int i = 0; i < nums.size(); i++) {
			System.out.print(nums.get(i) + " ");
		}
		
		
		//문자의 경우 정렬은 사전순으로 된다
		ArrayList<String>  Strings = new ArrayList<>();
		
		Strings.add("bbb");
		Strings.add("aaa");
		Strings.add("ccc");
		Strings.add("ddd");
		
		Collections.sort(Strings); // -> 정렬이 이 한줄로 실행된다

		for(int i = 0; i < Strings.size(); i++) {
			System.out.print(Strings.get(i) + " ");
		}
		
		
		

	}

}
