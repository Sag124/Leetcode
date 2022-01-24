class MyCircularQueue {
    
    int[] data;
    int front;
    int size;

    public MyCircularQueue(int k) {
        data = new int[k];
        front = 0;
        size = 0;
    }
    
    public boolean enQueue(int value) {
        boolean flag = false;
        if (size == data.length) {
            return false;
        } else {
        int rear = (front + size) % data.length;
        data[rear] = value;
        size++;
        flag = true;
        }
        return flag;
    }
    
    public boolean deQueue() {
        boolean flag = false;
        if (size == 0) {
            return false;
        } else {
            int val = data[front];
            front = (front+1)%data.length;
            size--;
            flag = true;
        }
        return flag;
    }
    
    public int Front() {
        if (size == 0) {
            return -1;
        }
        return data[front];
    }
    
    public int Rear() {
        if (size == 0) {
            return -1;
        }
        int rear = (front + size - 1) % data.length;
        return data[rear];
        // return data[(front + size) % data.length];
    }
    
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isFull() {
        if (size == data.length) {
            return true;
        } else {
            return false;
        }
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */