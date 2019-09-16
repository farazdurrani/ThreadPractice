package all3.runnable.callable.supplier;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class Test {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ExecutorService es = Executors.newSingleThreadExecutor();
		es.submit(new MyRunnable());
		es.submit(new MyCallable());
		es.execute(new MyRunnable());
		CompletableFuture.runAsync(new MyRunnable());
		CompletableFuture.supplyAsync(() -> bogusMethod());
		Supplier<Void> s = () -> {
			System.out.println("Supplier Seperately created");
			return null;
		};
		CompletableFuture.supplyAsync(s);
		es.shutdown(); // very important
	}

	private static Void bogusMethod() {
		System.out.println("Ran from Supplier method");
		return null;
	}

}
