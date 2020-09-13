/**
 * 双向链表
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        // test
        System.out.println("------双向链表测试------");
        Node node1 = new Node(1, "data1");
        Node node2 = new Node(2, "data2");
        Node node3 = new Node(3, "data3");
        Node node4 = new Node(4, "data4");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addElement(node1);
        doubleLinkedList.addElement(node2);
        doubleLinkedList.addElement(node3);
        doubleLinkedList.addElement(node4);

        doubleLinkedList.show();

        // update
        Node newNode = new Node(4, "update data4");
        doubleLinkedList.update(newNode);
        System.out.println("---------after update---------");
        doubleLinkedList.show();
        // remove
        System.out.println("--------remove-------");
        doubleLinkedList.remove(3);
        doubleLinkedList.show();
    }
}

class Node {
    public int no;
    public String data;
    public Node next; // 指向后一节点，默认null
    public Node pre; // 指向前一节点，默认null

    public Node(int no, String data) {
        this.no = no;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", data='" + data + '\'' +
                '}';
    }
}

class DoubleLinkedList {
    private Node head = new Node(0, "");

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
     * 添加节点到链表最后
     * @param node
     */
    public void addElement(Node node) {
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
        // 形成一个双向链表
        temp.next = node;
        node.pre = temp;
    }

    /**
     * 修改节点内容
     * @param newNode
     */
    public void update(Node newNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

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
            temp.data = newNode.data;
        } else {
            System.out.println("没找到需要修改的节点，不能修改，编号：" + newNode.no);
        }
    }

    /**
     * 双向链表可以直接找到要删除的节点，找到后直接删除
     * @param no
     */
    public void remove(int no) {
        // 判断当前链表是否为空
        if (head.next == null) {
            System.out.println("链表为空，不能删除");
            return;
        }

        Node temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.pre.next = temp.next;
            // 如果是最后一个节点就不需要执行下面这句话，否则会出现NullPointException
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("要删除的节点不存在");
        }
    }
}