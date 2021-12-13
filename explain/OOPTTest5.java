package explain;

public class OOPTTest5 {

	
	public static void main(String[] args) {
		/*
		Test b1 = new A(); //new하고 ABCD로반 변경하면 잘 출력된다
		int rst = b1.func();
		System.out.println(rst);
		*/
		
		A a1 = new A();
		a1.test();
	}
}


	class A {

		void test() {

			Test b1 = new B();

			int rst = b1.func();

			System.out.println(rst);
		}

	}

	interface Test {
		int func();
	}
	//interface는 일종의 계약서 같은것
	//예를 들어 A B C D가 있는데 각각 원하는 것을 사용하기 위해서 각 기능의 이름이 다르면 매번 이름 또힌 같이 변경해야 하는 번거러움이 있다.
	//interface에서 처음에 func라고 이름을 정하고 약속을 하면 각 A B C D의 기능의 이름도 fucn으로 해야한다
	//-> 결국적으로 A B C D중 어떤것을 사용할지만 결정하면 그 기능을 바로 사용 가능하다.
	

	//위의 약속을 따르겠다는 의미가 바로 implements가 되는 것이다
	//안지키면 에러가 난다
	class B implements Test {
		public int func() {
			return 1;
		}
	}

	class C implements Test {
		public int func() {
			return 3;
		}
	}

	class D implements Test {
		public int func() {
			return 7;
		}

	}

