package chapter3.ex4ex5;

public interface IntSequence {
    default boolean hasNext() {
        return true;
    }

    int next();

    static IntSequence of(int... digits) {
        int n = 0;
        for (int i : digits) {
            n *= 10;
            n += i;
        }
        final int res = n;
        return new IntSequence() {
            int number = res;

            @Override
            public boolean hasNext() {
                return number != 0;
            }

            @Override
            public int next() {
                int result = number % 10;
                number = number / 10;
                return result;
            }
        };
    }

    static IntSequence constant(int i) {
        return () -> 1;
    }
}
