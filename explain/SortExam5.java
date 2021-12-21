package explain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortExam5 {

	public static void main(String[] args) {
		NumData n1 = new NumData(1, 4);
		NumData n2 = new NumData(4, 5);
		NumData n3 = new NumData(3, 2);
		NumData n4 = new NumData(5, 1);
		NumData n5 = new NumData(2, 3);

		ArrayList<NumData> datas = new ArrayList<>();
		datas.add(n1);
		datas.add(n2);
		datas.add(n3);
		datas.add(n4);
		datas.add(n5);
		Collections.sort(datas, new MySort());

		for(int i = 0; i < datas.size(); i++) {
			System.out.println(datas.get(i).num1);
		}

	}

}

class MySort implements Comparator<NumData> {

	@Override
	public int compare(NumData o1, NumData o2) {

		if(o1.num2 > o2.num2) {
			return 1;// 자리 바꾸고 싶을 땐 0 이상
		}


		return -1; // -1 이하 리턴
	}



}


class NumData {
	int num1;
	int num2;

	NumData(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}	
	
}
