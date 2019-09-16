package all3.runnable.callable.supplier;

import java.util.concurrent.Callable;

public class MyCallable implements Callable {

	@Override
	public Void call() throws Exception {
		System.out.println("My Callable");
		return null;
	}

}
