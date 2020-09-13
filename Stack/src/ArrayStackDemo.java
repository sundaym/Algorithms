import java.util.Scanner;

/**
 * 用数组模拟stack
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("show: show stack");
            System.out.println("exit: exit");
            System.out.println("push: push value");
            System.out.println("pop: pop value");
            key = scanner.next();
            switch (key) {
                case "show":
                    stack.show();
                    break;
                case "push":
                    System.out.println("input a value:");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.println("pop value is:" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("program stop");
    }
}

/**
 * 定义一个Stack，用数组实现
 */
class ArrayStack {
    private int maxSize; // stack的大小
    private int[] stack; // 数组模拟stack,数据放在数组中
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    /**
     * stack满
     * @return
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * stack空
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * push
     * @param value
     */
    public void push(int value) {
        // 先判断stack是否满
        if (isFull()) {
            System.out.println("stack is full");
            return;
        }
        top++;
        stack[top] = value;
    }

    /**
     * pop, 将栈顶数据返回
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            System.out.println("stack is empty");
            throw new RuntimeException("stack is empty");
        }
        int value = stack[top];
        top--;
        return value;
    }

    /**
     * 遍历stack
     */
    public void show() {
        if (isEmpty()) {
            System.out.println("stack is empty");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }
}
