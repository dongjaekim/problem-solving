package April;

import java.util.Arrays;

// circular queue
public class lc_210405 {
    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(2);
/*        System.out.println(myCircularQueue.enQueue(1)); // return True
        System.out.println(myCircularQueue.enQueue(2)); // return True
        System.out.println(myCircularQueue.enQueue(3)); // return True
        System.out.println(myCircularQueue.enQueue(4)); // return False
        System.out.println(myCircularQueue.Rear());     // return 3
        System.out.println(myCircularQueue.isFull());   // return True
        System.out.println(myCircularQueue.deQueue());  // return True
        System.out.println(myCircularQueue.enQueue(4)); // return True
        System.out.println(myCircularQueue.Rear());     // return 4*/
        System.out.println(myCircularQueue.enQueue(1));
        System.out.println(myCircularQueue.enQueue(2));
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.enQueue(3));
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.enQueue(3));
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.enQueue(3));
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.Front());
    }
//
    public static class MyCircularQueue {
        int front = 0;
        int rear = -1;
        int cnt = 0;
        int[] queue;

        public MyCircularQueue(int k) {
            queue = new int[k];
            Arrays.fill(queue, -1);
        }

        public boolean enQueue(int value) {
            if(cnt >= queue.length)
                return false;
            else {
                cnt++;
                rear++;
                while(queue[rear % queue.length] != -1)
                    rear++;
                queue[rear % queue.length] = value;
                return true;
            }
        }

        public boolean deQueue() {
            if(cnt == 0)
                return false;
            else {
                cnt--;
                queue[front % queue.length] = -1;
                if(front == rear) {
                    front = 0;
                    rear = -1;
                }
                else {
                    front++;
                    while(queue[front % queue.length] == -1)
                        front++;
                }
                return true;
            }
        }

        public int Front() {
            if(cnt == 0)
                return -1;
            return queue[front % queue.length];
        }

        public int Rear() {
            if(cnt == 0)
                return -1;
            return queue[rear % queue.length];
        }

        public boolean isEmpty() {
            return cnt == 0;
        }

        public boolean isFull() {
            return cnt == queue.length;
        }
    }
}
