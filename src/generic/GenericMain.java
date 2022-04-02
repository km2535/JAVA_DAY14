package generic;

public class GenericMain {
	public static void main(String[] args) {
	//  제네릭 클래스, int 타입이 아닌 클래스형의 기본타입이 들어간다.
		GClassTest<Integer> obj = new GClassTest<Integer>();
		obj.data = 20;
		System.out.println(obj.getData()+1);
		
//		제네릭 메소드 사용
		GMethodTest obj2 = new GMethodTest();
//		제네릭 메소드는 매개변수로 키워드를 유추 할 수 있기 때문에 <키워드>를 적어주지 않아도 됨
		obj2.f(3);
		obj2.f("안녕");
		
//		제네릭 인터페이스
		GInterTest<Integer, Double> obj3 = new GInterTest<Integer, Double>() {
			
			@Override
			public Double div(Double num1, Double num2) {
				return num1 / num2;
			}
			
			@Override
			public Integer add(Integer num1, Integer num2) {
				// TODO Auto-generated method stub
				return num1 + num2;
			}
		};
		System.out.println(obj3.add(3, 3));
		System.out.println(obj3.div(3.0, 3.0));
	}	
}
