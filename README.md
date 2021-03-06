# JAVA_DAY14

# JAVA-14

## Wrapper Class

기본형 타입의 값들을 객체로 사용 가능하게 도와주는 클래스
기본형 타입의 클래스 타입

```java
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

```

```
	Wrapper클래스명 객체명 = new Wrapper생성자(값);	//	박싱
	Wrapper클래스명 객체명 = (Wrapper클래스명)값;

	기본자료형 변수명 = Wrapper객체.~~Value();	//언박싱
	언박싱 ->> obj.intValue();
```

(언)박싱 < 업(다운)캐스팅
캐스팅이 먼저 일어남

```java
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
```

Wrapper Class를 사용하는 이유

- 기본형 타입의 값을 객체로 다루어야 할 때
- 기본형 타입이 아닌 객체로 값을 저장해야 할 때
- 매개변수로 객체를 넘길 때(특히 Object)
- 객체간의 비교가 필요할 때

## Generic

자료형을 선언할 때 정하지 않고, 객체를 생성할 때 정하는 기법
<키워드>
E : Element
N : Number
T : Type
K : Key
V : Value

### 제네릭 클래스

클래스 내부에서 사용될 자료형을 지정한다.

```java
class 클래스명<키워드>{
	내부에서 키워드 타입으로 사용 가능
}
```

제네릭 클래스 정의

```java
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
```

메인메소드에서 사용

```java
package generic;

public class GenericMain {
	public static void main(String[] args) {
	//  제네릭 클래스, int 타입이 아닌 클래스형의 기본타입이 들어간다.
		GClassTest<Integer> obj = new GClassTest<Integer>();
		obj.data = 20;
		System.out.println(obj.getData()+1);
	}
}

```

### 제네릭 메소드

메소드 내부에서 사용될 자료형을 지정한다.

```java
	<키워드>리턴타입 메소드명(){
   	내부에서 키워드 타입으로 사용 가능
   }
```

제네릭 메소드 정의

```java
package generic;

public class GMethodTest {
//	T, type으로 제네릭을 만들고 T형의 f함수를 T형의 매개변수를 받아서 사용
	<T>T f(T data){
		System.out.println(data);
		return data;
	}
}
```

메인 메소드에서 사용

```java
package generic;

public class GenericMain {
	public static void main(String[] args) {
//		제네릭 메소드 사용
		GMethodTest obj2 = new GMethodTest();
//		제네릭 메소드는 매개변수로 키워드를 유추 할 수 있기 때문에 <키워드>를 적어주지 않아도 됨
		obj2.f(3);
		obj2.f("안녕");
	}
}

```

### 제네릭 인터페이스

인터페이스 내부에서 사용될 자료형을 지정한다.

```java
	interface 인터페이스명<키워드>{
   	내부에서 키워드를 타입으로 사용 가능
   }
```

제네릭 인터페이스 정의

```java
package generic;

public interface GInterTest<N1, N2> {
//	인터페이스에는 추상메소드를 키워드를 사용하여 적어주면 된다.
	N1 add(N1 num1, N1 num2);
//	개발자가 어떻게 사용하냐에 따라서 타입이 동일할 수도 있어서 아래는 오버로딩을 못한다.
//	동일한 매개변수 동일 메소드명, 동일 타입이면 오버로딩을 못한다.
	//N2 add(N2 num1, N2 num2);
	N2 div(N2 num1, N2 num2);
}
```

메인메소드에서 사용

```java
package generic;

public class GenericMain {
	public static void main(String[] args) {

//		제네릭 인터페이스
//		인터페이스를 정의 했던 것 처럼 타입을 2개 받으면서 추상 메소드를 재정의
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

```

중요한 사실은 우리는 제네릭을 직접적으로 설계하지 않는다.
다만, 선배 개발자들이 만들어 놓은 수많은 라이브러리에서 제네릭을 사용하여 재정의를 통해 프로그램을 개발하게 될 것이다.
지금 예제는 살짝 복잡하지만 직접 설계를 하려면 굉장한 많은 노력이 필요하다.
