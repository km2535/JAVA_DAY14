package generic;

public class GMethodTest {
//	T, type으로 제네릭을 만들고 T형의 f함수를 T형의 매개변수를 받아서 사용
	<T>T f(T data){
		System.out.println(data);
		return data;
	}
}
