package heapandpriorityqueue;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue {
    public List<Node> list;
    public PriorityQueue() {
        this.list = new ArrayList<Node>();
    }

    public void enqueue(String value, int priority) {
        Node node = new Node(value,priority);
        this.list.add(node);
        this.bubbleUp();
    }

    public void bubbleUp() {
        int idx = this.list.size()-1;
        Node current = this.list.get(idx);
        while(idx>0) {
            int parentIdx = (idx-1)/2;
            Node parent = this.list.get(parentIdx);
            if(parent.priority<=current.priority) break;
            this.list.set(idx, parent);
            this.list.set(parentIdx, current);
            idx=parentIdx;
        }
    }

    public Node dequeue() {
        if(this.list.size()<=0) return null;
        Node min = this.list.get(0);
        Node end = this.list.remove(this.list.size()-1);
        if(this.list.size()>0) {
            this.list.set(0, end);
            this.sinkdown();
        }
        return min;
    }

    public void sinkdown() {
        int idx = 0;
        int length = this.list.size();
        Node current = this.list.get(idx);

        while(true) {
            int leftChildIdx = 2*idx+1;
            int rightChildIdx = 2*idx+2;
            Node leftChild=null, rightChild=null;
            int swap = -1;

            if(leftChildIdx<length) {
                leftChild = this.list.get(leftChildIdx);
                if(leftChild.priority<current.priority) {
                    swap = leftChildIdx;
                }
            }
            if(rightChildIdx<length) {
                rightChild = this.list.get(rightChildIdx);
                if(
                        (swap == -1 && rightChild.priority<current.priority)||
                        (swap != -1 && rightChild.priority<leftChild.priority)
                ) {
                    swap=rightChildIdx;
                }
            }
            if(swap==-1) break;
            this.list.set(idx, this.list.get(swap));
            this.list.set(swap, current);
            idx=swap;
        }
    }
}
// belmanford
