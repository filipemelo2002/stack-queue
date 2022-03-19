package com.company;

class MyCircularQueue {
    private final int data[];
    private final int queueSize;
    private int head = -1;
    private int tail = -1;
    private int rear = -1;

    public MyCircularQueue(int k) {
        this.queueSize = k;
        this.data = new int[queueSize];
        for (int i =0; i < queueSize; i++) {
            this.data[i] = -1;
        }
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        if (head < 0) {
            head++;
        }

        tail++;

        if (tail == queueSize) {
            tail = 0;
        }

        data[tail] = value;
        rear = value;

        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        if (head < 0) {
            head++;
        }

        data[head] = -1;
        head++;

        if (head == queueSize) {
            head = 0;
        }

        if (isEmpty()) {
            head = -1;
            tail = -1;
        }

        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;

        return data[head];
    }

    public int Rear() {
        if (isEmpty()) return -1;

        return rear;
    }

    public boolean isEmpty() {
        boolean empty = true;
        for (int i =0; i < queueSize; i++) {
            if (data[i] >= 0) {
                empty = false;
                break;
            }
        }
        return empty;
    }

    public boolean isFull() {
        boolean full = true;

        for (int i =0; i < queueSize; i++) {
            if (data[i] < 0) {
                full = false;
                break;
            }
        }

        return full;
    }
}
