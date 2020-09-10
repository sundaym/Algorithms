import java.util.Scanner;

/**
 * 环形数组实现队列，数组可以复用
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        System.out.println("测试环形数组实现队列");
        CircleArrayQueue arrayQueue = new CircleArrayQueue(4);
        char key = ' '; // 接受用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show), 显示队列");
            System.out.println("e(exit), 退出程序");
            System.out.println("a(add), 添加数据到队列");
            System.out.println("g(get), 从队列取出数据");
            System.out.println("p(peak), 查看队列头部数据");
            key = scanner.next().charAt(0); // 接受第一个字符
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数字");
                    int value = scanner.nextInt();
                    arrayQueue.addElement(value);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getElement();
                        System.out.println("取出的数据是" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'p':
                    try {
                        int res = arrayQueue.peak();
                        System.out.println("队列头的数据是" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("程序退出");
    }
}

class CircleArrayQueue {
    private int maxSize;
    private int front; // 初始值为0，front指向队列的第一个元素，arr[front]就是队列的第一个元素
    private int rear; // 初始值为0，rear指向队列的最后一个元素的后一个位置
    private int[] arr;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    // 添加数据到队列
    public void addElement(int n) {
        // 判断队列是否满
        if (isFull()) {
            System.out.println("队列已满，不能加入数据");
            return;
        }
        // 直接将数据加入
        arr[rear] = n;
        // 将rear后移
        rear = (rear + 1) % maxSize;
    }

    public int getElement() {
        // 判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        // front指向队列的第一个元素
        // 1.先讲front对应的值保留到一个临时变量
        // 2.将front后移
        // 3.返回保存的临时变量
        int tmp = front;
        front++;
        return arr[tmp];
    }

    // 显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
        }
        // 从front开始遍历
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    // 当前队列的有效元素个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public int peak() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }
}