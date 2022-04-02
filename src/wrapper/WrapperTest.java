package wrapper;

public class WrapperTest {
	public static void main(String[] args) {
//		박싱, 기본 타입의 클래스를 객체화 하는 것
		Integer obj = new Integer(10);
//		object 객체를 다운캐스팅하여 담음
		Integer obj2 = (Integer)10;
		
//		언박싱
		int data = obj.intValue();
//		data는 객체가 아니다.(편의상)
//		obj Integer타입으로 선언했으니, 오토박싱이 일어남
		obj  = 20;
//		data는 int기본 타입으로 선언되어서 오토 언박싱이 일어남
		data = obj;
		
	}
}
