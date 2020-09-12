/**
 * 单向链表示例
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        // 先创建节点
        Node node1 = new Node(1, "node1_data0", "node1_data1");
        Node node2 = new Node(2, "node2_data0", "node2_data1");
        Node node3 = new Node(3, "node3_data0", "node3_data1");
        Node node4 = new Node(4, "node4_data0", "node4_data1");

        // 创建一个链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        // 未添加Node前的链表
        singleLinkedList.show();
        System.out.println("向链表中添加Node");
        // 加入
        singleLinkedList.add(node1);
        singleLinkedList.add(node2);
        singleLinkedList.add(node3);
        singleLinkedList.add(node4);
        singleLinkedList.show();
    }
}

/**
 * 定义SingleLinkedList, 管理Node
 */
class SingleLinkedList {
    // 先初始化一个头节点
    private Node head = new Node(0, "", "");

    /**
     * 添加节点到单向链表
     * 当不考虑编号顺序时，1.找到当前链表的最后的节点 2.将最后节点的next指向新的节点
     * @param node
     */
    public void add(Node node) {
        // head节点不能动，需要一个辅助变量
        Node temp = head;
        // 遍历链表找到最后的节点
        while (true) {
            // 找到链表的最后节点
            if (temp.next == null) {
                break;
            }
            // 如果没有找到就将temp后移
            temp = temp.next;
        }
        // 当退出while循环时，temp表示链表的最后节点
        // 将最后这个节点的next指向新的节点
        temp.next = node;
    }

    /**
     * 显示链表
     */
    public void show() {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 因为头节点不能动，因此需要一个辅助变量遍历
        Node temp = head.next;
        while (true) {
            // 判断是否到链表最后
            if (temp == null) {
                break;
            }
            // 输出节点信息
            System.out.println(temp);
            // 将temp后移
            temp = temp.next;
        }
    }
}

/**
 * 定义节点， 每个Node对象就是一个节点
 */
class Node {
    private int no;
    private String data0; // 节点中的数据
    private String data1; // 节点中的数据
    public Node next; // 指向下一个节点

    public Node(int hNo, String hData0, String hData1) {
        this.no = hNo;
        this.data0 = hData0;
        this.data1 = hData1;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", data0='" + data0 + '\'' +
                ", data1='" + data1 + "'" +
                '}';
    }
}
