package textbook.Week06.collection.arraylist;

import java.util.ArrayList;

public class QueueTest {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.enQueue("A");
        queue.enQueue("B");
        queue.enQueue("C");

        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
    }
}

class MyQueue {
    private ArrayList<String> arrayQueue = new ArrayList<>();

    public void enQueue(String data) {
        arrayQueue.add(data);
    }

    public String deQueue() {
        int len = arrayQueue.size();

        if(len == 0) {
            System.out.println("큐가 비었습니다.");
            return null;
        }

        return arrayQueue.remove(0);
    }
}