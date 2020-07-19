import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class FixedCapacityStackOfStrings implements Iterable<String> {
    private String[] a; // holds the items 保存元素
    private int N; // number of items in stack

    public FixedCapacityStackOfStrings(int capacity) {
        a = new String[capacity];
        N = 0;
    }

    public boolean isEmpty() { return N == 0; }
    public boolean isFull() { return N == a.length; }
    public void push(String item) { a[N++] = item; }
    public String pop() { return a[--N]; }
    public String peek() { return a[N-1]; }
    public Iterator<String> iterator()  { return new ReverseArrayIterator(); }

    public class ReverseArrayIterator implements Iterator<String> {
        private int i = N-1;
        public boolean hasNext() {
            return i >= 0;
        }

        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[i--];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        int max = 6;
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(max);
        List<String> ls = new ArrayList<>();
        ls.add("a");
        ls.add("b");
        ls.add("c");
        ls.add("d");
        ls.add("e");
        ls.add("-");
        ls.add("-");
        ls.add("-");
        ls.add("-");
        ls.add("-");
        ls.add("-");
        for (int i = 0; i < ls.size(); i++) {
            String item = ls.get(i);
            if (!item.equals("-")) {
                stack.push(item);
            } else if (stack.isEmpty()) {
                System.out.println("BAD INPUT");
            } else {
                System.out.println(stack.pop() + " ");
            }
        }
    }
}