import java.beans.DesignMode;

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
//        singleLinkedList.add(node1);
//        singleLinkedList.add(node2);
//        singleLinkedList.add(node3);
//        singleLinkedList.add(node4);
//        singleLinkedList.show();

        // 按照编号的顺序加入
        singleLinkedList.addByOrder(node1);
        singleLinkedList.addByOrder(node4);
        singleLinkedList.addByOrder(node3);
        singleLinkedList.addByOrder(node2);
        singleLinkedList.show();

        Node newNode = new Node(1, "update data1_0", "update data1_1");
        singleLinkedList.update(newNode);
        System.out.println("-------------------------");
        singleLinkedList.show();
        System.out.println("-------------------------");
        singleLinkedList.removeElement(1);
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

    /**
     * 第二种添加方式
     * @param node
     */
    public void addByOrder(Node node) {
        // 头节点不动，通过辅助变量来找到添加的位置
        // 因为是单链表，因此我们找的temp是位于添加位置的前一个节点，否则插入不了
        Node temp = head;
        boolean flag = false; // 添加的编号是否存在，默认为false
        while (true) {
            if (temp.next == null) { // 说明temp已经在链表的最后
                break;
            }
            if (temp.next.no > node.no) {
                break;
            } else if (temp.next.no == node.no) {
                flag = true; // 说明编号存在
                break;
            }
            temp = temp.next; // 后移
        }

        // 判断flag的值
        if (flag) { // 不能添加，说明编号存在
            System.out.println("准备插入的节点的编号存在，不能加入");
        } else {
            // 插入链表中，temp后面
            node.next = temp.next;
            temp.next = node;
        }
    }

    /**
     * 修改节点的信息，根据no编号修改
     * @param newNode
     */
    public void update(Node newNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 找到需要修改的节点
        Node temp = head.next;
        boolean flag = false; // 表示是否找到该节点
        while (true) {
            if (temp == null) {
                break; // 已经遍历完链表
            }
            if (temp.no == newNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 根据flag判断是否已经找到需要修改的节点
        if (flag) {
            temp.data0 = newNode.data0;
        } else {
            System.out.println("没找到需要修改的节点，不能修改，编号：" + newNode.no);
        }
    }

    /**
     * 1.head不动，使用辅助变量temp找到要删除节点的前一个节点
     * 2。比较的时候，是temp.next.no和需要需要删除的节点的no比较
     * @param no
     */
    public void removeElement(int no) {
        Node temp = head;
        boolean flag = false; // 标识是否找到删除节点
        while (true) {
            if (temp.next == null) { // 已经到链表的最后
                break;
            }
            if (temp.next.no == no) {
                // 找到了删除节点的前一个节点
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("没有找到要删除的节点");
        }
    }
}

/**
 * 定义节点， 每个Node对象就是一个节点
 */
class Node {
    public int no;
    public String data0; // 节点中的数据
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
