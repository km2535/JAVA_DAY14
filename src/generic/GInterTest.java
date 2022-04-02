package generic;

public interface GInterTest<N1, N2> {
//	인터페이스에는 추상메소드를 키워드를 사용하여 적어주면 된다.
	N1 add(N1 num1, N1 num2);
//	개발자가 어떻게 사용하냐에 따라서 타입이 동일할 수도 있어서 아래는 오버로딩을 못한다.
//	동일한 매개변수 동일 메소드명, 동일 타입이면 오버로딩을 못한다.
	//N2 add(N2 num1, N2 num2);
	N2 div(N2 num1, N2 num2);
}
