package datastructure.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 循环队列
 * @author hongyanbo
 * @date 2020/4/10
 * @version 1.0.0
 * @since 1.0.0
 */
public class CircleQueue<T> {
    /**
     * 容器
     */
    private List<T> list = new ArrayList<>();
    /**
     * 头指针
     */
    private int head = -1;
    /**
     * 尾指针
     */
    private int tail = -1;
    private int length = 0;
    public CircleQueue(int k) {
        this.length = k;
    }

    public boolean enQueue(T value) {
        if(isFull()){
            return false;
        }
        if(isEmpty()){
            head++;
        }
        tail = (tail+1)%length;
        list.set(tail,value);
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        if(head == tail){
            head=-1;
            tail=-1;
        }
        head = (head+1)%length;
        return true;
    }

    public T Front() {
        if(isEmpty()){
            return null;
        }
        return list.get(head);
    }

    public T Rear() {
        if(isEmpty()){
            return null;
        }
        return list.get(tail);
    }

    public boolean isEmpty() {
        return head == -1;
    }

    public boolean isFull() {
        return head == tail && head >=0;
    }
}
