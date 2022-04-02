package generic;

// 키워드에는 아무거나 들어갈 수 있지만 키워드를 타입으로 사용기에 아래와 같이 사용 
public class GClassTest<T> {
//	어떤 타입이 들어올지 모르지만 데이터가 들어오면 변수를 할당
	T data;
//	같은 타입의 data를 사용함
	T getData() {
		return data;
	}
}
