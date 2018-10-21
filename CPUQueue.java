import java.util.LinkedList;
import java.util.Queue;

class CPUQueue {

    private Queue<String> queue = new LinkedList<>();
    private int capacity = 1;
    private int deleteProcess = 0;

    public CPUQueue() { }
    public int getDeleteProcess() {
        return deleteProcess;
    }
    public synchronized void put(String element) throws InterruptedException {
        if (queue.size() == capacity) {
            System.out.println("CPU work");
            deleteProcess++;
            //wait();
            return;
        }
        queue.add(element);
        System.out.println("Process added, queue size = [" + queue.size() + "]\n");
        notify(); // notifyAll() for multiple CPU/CPUProcess threads
    }

    public synchronized String get() throws InterruptedException {
        while(queue.isEmpty()) {
            System.out.println("Queue is EMPTY, waiting..");
            wait();
        }
        String item = queue.element();
        //System.out.println("Process removed, queue size = [" + queue.size() + "]");
        //notify(); // notifyAll() for multiple CPU/CPUProcess threads
        return item;
    }
    public synchronized String delete() throws InterruptedException {
        while(queue.isEmpty()) {
            System.out.println("Queue is EMPTY, waiting..");
            wait();
        }
        String item = queue.remove();
        //System.out.println("Process removed, queue size = [" + queue.size() + "]");
        //notify(); // notifyAll() for multiple CPU/CPUProcess threads
        return item;
    }
}
