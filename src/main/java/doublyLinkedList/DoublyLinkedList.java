package doublyLinkedList;

public class DoublyLinkedList {

    public int length;
    public Node head;
    public Node tail;

    public DoublyLinkedList() {
        this.length=0;
        this.head=null;
        this.tail=null;
    }

    public DoublyLinkedList push(int value) {
        Node node = new Node(value);
        if(this.head==null) {
            this.head=node;
        } else {
            this.tail.next=node;
            node.prev=this.tail;
        }
        this.tail=node;
        this.length++;
        return this;
    }

    public Node pop() {
        if(this.head==null) return null;
        Node current = this.tail;
        Node prev = current.prev;
        prev.next=null;
        current.prev=null;
        this.length--;
        if(this.length==0) {
            this.head=null;
            this.tail=null;
        }
        return current;
    }

    public Node shift() {
        if(this.head==null) return null;
        Node current = this.head;
        this.head=current.next;
        this.head.prev=null;
        current.next=null;
        this.length--;
        if(this.length==0) {
            this.head=null;
            this.tail=null;
        }
        return current;
    }

    public DoublyLinkedList unShift(int value) {
        Node node = new Node(value);
        if(this.head == null) {
            this.tail=node;
        } else {
            node.next=this.head;
            this.head.prev=node;
        }
        this.head=node;
        length++;
        return this;
    }

    public Node get(int index) {
        if(index<0||index>=this.length) return null;
        int middle = this.length/2;
        Node start;
        int count;
        if(index!=middle) {
            start = this.head;
            count=0;
            while(count<index){
                start=start.next;
                count++;
            }
        } else {
            start = this.tail;
            count=this.length-1;
            while (count>index){
                start=start.prev;
                count--;
            }
        }
        return start;
    }

    public Boolean set(int index, int value) {
        if(this.get(index)==null) return false;
        this.get(index).value=value;
        return true;
    }

    public boolean insert(int index, int value) {
        if(index<0||index>this.length) return false;
        if(index==0){
            this.unShift(value);
            return true;
        }
        if(index==this.length) {
            this.push(value);
            return true;
        }
        Node node = new Node(value);
        Node prev = this.get(index-1);
        Node cur = prev.next;
        node.next=cur;
        node.prev=prev;
        cur.prev=node;
        prev.next=node;
        this.length++;
        return true;
    }

    public Node remove(int index) {
        if(index<0||index>=length) return null;
        if(index==0) return this.shift();
        if(index==length-1) return this.pop();
        Node prev = this.get(index-1);
        Node cur = prev.next;
        prev.next=cur.next;
        cur.next.prev=prev;
        cur.prev=null;
        cur.next=null;
        length--;
        return cur;
    }

    public void printList() {
        Node current=this.head;
        while(current!=null) {
            System.out.print(current.value+"-> ");
            current=current.next;
        }
        System.out.println();
    }
}
