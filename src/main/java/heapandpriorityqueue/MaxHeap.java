package heapandpriorityqueue;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {
    public List<Integer> list;
    public MaxHeap() {
        this.list= new ArrayList<Integer>();
    }

    public void insert(int value) {
        this.list.add(value);
        this.bubbleUp();
    }

    public void bubbleUp() {
        int idx = this.list.size()-1;
        int current = this.list.get(idx);
        while(idx>0) {
            int parentIdx = (idx-1)/2;
            int parent = this.list.get(parentIdx);
            if(parent>=current) break;
            this.list.set(idx,parent);
            this.list.set(parentIdx, current);
            idx=parentIdx;
        }
    }

    public Integer get() {
        if(this.list.size()<=0) return -1;
        int max = this.list.get(0);
        int end = this.list.remove(this.list.size()-1);
        if(this.list.size()>0) {
            this.list.set(0, end);
            this.sinkDown();
        }
        return max;
    }

    public void sinkDown() {
        int idx = 0;
        int length = this.list.size();
        int current = this.list.get(0);
        while(true) {
            int leftChildIdx = (2*idx)+1;
            int rightChildIdx = (2*idx)+2;
            int leftchild=-1;
            int rightChild=-1;
            int swap = -1;

            if(leftChildIdx<length) {
                leftchild = this.list.get(leftChildIdx);
                if(leftchild>current) {
                    swap = leftChildIdx;
                }
            }

            if(rightChildIdx<length) {
                rightChild = this.list.get(rightChildIdx);
                if(
                        (swap == -1 && rightChild>current)||
                        (swap != -1 && rightChild>leftchild)
                ) {
                    swap = rightChildIdx;
                }
            }

            if(swap == -1) break;
            this.list.set(idx, this.list.get(swap));
            this.list.set(swap, current);
            idx=swap;
        }
    }
}
