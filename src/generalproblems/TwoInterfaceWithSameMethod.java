package generalproblems;

/**
 * Created by mishrk3 on 5/10/2017.
 */
public class TwoInterfaceWithSameMethod implements One, Two {
	@Override
	public void m1() {
		System.out.println("class Test");
	}

	@Override
	public void m2() {
		System.out.println("implemented default m2");
	}

	public static void main(String[] args) {
		One one = new TwoInterfaceWithSameMethod();
		one.m1();
		one.m2();
	}
}

interface One {
	void m1();

	default void m2() {
		System.out.println("One");
	}
}

interface Two {
	void m1();

	default void m2() {
		System.out.println("Two");
	}
}
