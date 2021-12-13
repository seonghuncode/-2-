package explain;

public class OOPTTest6 {

	public static void main(String[] args) {


		// 거품정렬
		int[] arr = {2,4,1,3,7,6,8,5}; //무작위로 되어있는 배열

		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		
		//이해하기!!
		//오름차순으로 2개씩 묶어 비교하며 배렬의 자리를 바꿔주며 오름차순이 될때까지 반복한다
		//0 부터 시작하기 때문에 7번째 까지 가야하므로 length -1 (인텍스는 7까지 존재한다)
		for(int j = 0; j < arr.length - 1; j++) {			
			//위의 반복문이 한번 돌때마다 하나씩 정력이 된다 ==> 따라서 총7개의 숫자이기 때문에 7번을 실행해야한다(나머지 하나는 자동으로 정렬)
			//안쪽 for문은 가장 큰 숫자를 제일 끝으로 보내는 로직이다
			//이때 for문이 돌면 돌수록 제일 큰 숫자가 맨 끝네 고정이 되기 때문에 숫자 하나씩 줄기 때문에 arr.length - 1 -j를 해주면 좋다
			//																필수는 아니기 때문에 해줘도 그만 안해줘도 그만
			for(int i = 0; i < arr.length - 1 ; i++) {
				if(arr[i] < arr[i + 1]) {
				//바로 붙어 있는 2배열을 비교해야 한다
					
					//교체알고리즘
					int tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;

					
					//이정렬은 느려서 많이 사용하지 않는다 더 빠른 정렬이 있는데 복잡하다는 단점이있다.
					//이해만 하기 실제에서 사용하는 정렬은 훨씬 복잡하다(자바에서 제공을한다)
				}
			}
		}


		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}



	}
	
	
}
