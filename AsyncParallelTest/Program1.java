import java.util.stream.IntStream;

class Program {

	private static void doComputation(int limit) {
		System.out.print("Computing...");
		var c = new Computation();
		var t1 = System.nanoTime();
		var r = c.compute(1, limit);
		var t2 = System.nanoTime();
		System.out.println("Done!");
		System.out.printf("Result = %d, computed in %.3f seconds.%n", r, (t2 - t1) / 1e9);
	}

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(args[0]);
		doComputation(n);
	}

	static class Computation {

		public long compute(int first, int last) {
			return IntStream.range(first, last + 1)
					.mapToLong(Worker::doWork)
					.sum();
		}
	}
}

