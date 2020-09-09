import java.util.Scanner;

/**
 * 数组模拟队列，数组只能使用一次，不考虑复用
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
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

// 使用数组模拟队列
class ArrayQueue {
    private int maxSize; // 数组最大容量
    private int front; // 指向队列头
    private int rear; // 指向队列尾部
    private int[] arr; // 数组用于存放队列数据

    // 创建队列的构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; // 指向队列头部，指向队列头的前一个位置
        rear = -1; // 指向队列尾部，指向队列尾的数据(包含最后一个数据)
    }

    // 判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    // 判断队列是否为空
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
         rear++;
         arr[rear] = n;
     }

     // 数据出队列
    public int getElement() {
        // 判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;
        return arr[front];
    }

    // 显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    // 显示队列头数据，不是取数据
    public int peak() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front + 1];
    }
}
