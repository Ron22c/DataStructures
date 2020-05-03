package singlyLinkedList;

public class SinglyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    public SinglyLinkedList() {
        this.head=null;
        this.tail=null;
        this.length=0;
    }

    public SinglyLinkedList push(int value) {
        Node node = new Node(value);
        if(this.head==null) {
            this.head=node;
        } else {
            this.tail.next=node;
        }
        this.tail=node;
        this.length++;
        return this;
    }

    public Node pop() {
        if(this.head==null) return null;
        Node current = this.head;
        Node newTail = current;
        while(current.next!=null) {
            newTail=current;
            current=current.next;
        }
        this.tail=newTail;
        this.tail.next=null;
        this.length--;
        if(length==0){
            this.head=null;
            this.tail=null;
        }
        return current;
    }

    public Node shift() {
        if(this.head==null) return null;
        Node current = this.head;
        this.head=current.next;
        current.next=null;
        this.length--;
        if(length==0) {
            this.head=null;
            this.tail=null;
        }
        return current;
    }

    public SinglyLinkedList unShift(int value) {
        Node node = new Node(value);
        if(this.head==null) {
            this.tail=node;
        } else {
            node.next=this.head;
        }
        this.head=node;
        this.length++;
        return this;
    }

    public Node get(int index) {
        if(this.head==null) return null;
        if(index<0||index>=this.length) return null;
        Node current = this.head;
        int count = 0;
        while(count<index) {
            current = current.next;
            count++;
        }
        return current;
    }

    public Boolean set(int index, int value) {
        if(this.get(index)==null) return false;
        this.get(index).value=value;
        return true;
    }

    public Boolean insert(int index, int value) {
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
        node.next=prev.next;
        prev.next=node;
        length++;
        return true;
    }

    public Node remove(int index) {
        if(index<0||index>=this.length) return null;
        if(index==0) return this.shift();
        if(index==this.length-1) return this.pop();
        Node prev=this.get(index-1);
        Node current=prev.next;
        prev.next=current.next;
        current.next=null;
        length--;
        return current;
    }

    public SinglyLinkedList reverse() {
        Node current = this.head;
        this.head=this.tail;
        this.tail=current;
        Node next;
        Node prev=null;
        for(int i=0;i<this.length-1;i++) {
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return this;
    }

    public void printList(SinglyLinkedList list) {
        Node node = list.head;
        while(node!=null){
            System.out.print(node.value+"->");
            node=node.next;
        }
        System.out.println("");
    }
}
