package wrapper;

public class WrapperTest2 {
	public static void main(String[] args) {
		Test t = new Test();
		t.f(20);
//		아래와 같이 넣으면 int 타입에 들어가면 오토 언박싱을 해야되고 Integer타입으로 
//		들어가면 그대로 출력이 가능해서 바로 출력
//		Object로 들어가면 업캐스팅이 발생하여 패스 가장 효율적인 함수가 출력됨
		t.f((Integer)10);
//		단, Integer타입의 함수가 없을때는 Object타입으로 들어가 업캐스팅이 됨
//		오토 언박싱보다 효율적임.
	}
}

class Test {
	void f(int data) {
		System.out.println("int 자료형으로 호출한 f(): " +data);
	}
	void f(Integer data) {
		System.out.println("integer 자료형으로 호출한 f(): " +data);
	}
	void f(Object data) {
		System.out.println("Object 자료형으로 호출한 f(): " +data);
	}
}