/**
 * 计时器，用于测量程序运行时间
 */
public class Stopwatch {
    private final long start;

    public Stopwatch() {
        start = System.currentTimeMillis();
    }

    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }

    public static void main(String[] args) {
        int n = 10000;
        Stopwatch timer1 = new Stopwatch();
        double sum1 = 0.0;
        for (int i = 0; i < n; i++) {
            sum1 += Math.sqrt(i);
        }

        double time1 = timer1.elapsedTime();
        System.out.println(sum1 + "(" + time1 + ")");

        Integer i = 12;
        System.out.println(i.toString().length());

    }
}