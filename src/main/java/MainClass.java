import Graph.Graph;

import java.util.List;

public class MainClass {
    public static void main(String arr[]) {
        Graph g = new Graph();
        g.addVertex("kolkata");
        g.addVertex("bangalore");
        g.addVertex("noida");
        g.addVertex("delhi");

        System.out.print(g.adjecencyList.keySet()+"\n");

        g.addEdge("kolkata", "delhi",28);
        g.addEdge("bangalore", "delhi",28);
        g.addEdge("kolkata", "noida",28);
        g.addEdge("delhi", "noida",28);

        System.out.print(g.adjecencyList.values()+"\n");

        g.removeVertex("kolkata");
        System.out.print(g.ShortestPath("kolkata", "delhi"));

        List<String> result = g.BFS("kolkata");
        List<String> result1 = g.DFS("kolkata");

        for(String s: result) {
            System.out.print(s+" ");
        }
        System.out.println();
        for(String s: result1) {
            System.out.print(s+" ");
        }
    }
}




//        SinglyLinkedList list = new SinglyLinkedList();
//        list.push(1234);
//        list.push(1235);
//        list.push(1236);
//        list.push(1237);
//        list.unShift(3);
//        list.unShift(2);
//        list.unShift(1);
//        list.printList(list);
//        System.out.println(list.insert(7,12));
//        list.printList(list);
//        System.out.println(list.remove(4).value);
//        list.printList(list.reverse());
//
//
//
//        DoublyLinkedList Dlist = new DoublyLinkedList();
//        Dlist.push(1);
//        Dlist.push(2);
//        Dlist.push(3);
//        Dlist.push(4);
//        Dlist.unShift(5);
//        Dlist.printList();
//        Dlist.insert(2,123456756);
//        System.out.println(Dlist.get(3).value);
//        System.out.println(Dlist.set(3,12345));
//        System.out.println(Dlist.pop().value);
//        System.out.println(Dlist.shift().value);
//        System.out.println(Dlist.remove(2).value);
//
//
//        Dlist.printList();
//
//        Search s = new Search();
//        int [] arr= {1,2,4,5,6,7};
//        System.out.println(s.binarySearch(arr,99));
//        System.out.println(s.stringSearch("hellohihellohihello", "hello"));

//        Sort so = new Sort();
//        int[] arrso = {4,5,2,6,1,3};
//        int[] arr1 = {3,5,7};
//        int[] arr2 = {1,2,10};
//        int[] res = so.quick_sort(arrso,0,arrso.length-1);
//        int[] resM = so.marge_function(arr1,arr2);
////        so.printArr(res);
//
//        int num = so.size(12345);
//        System.out.println(num);
//
//    PriorityQueue heap = new PriorityQueue();
//        heap.enqueue("two",122);
//        heap.enqueue("six",126);
//        heap.enqueue("five",125);
//        heap.enqueue("four",124);
//        heap.enqueue("one",121);
//        heap.enqueue("three",123);
//
//
//        for(Node i: heap.list) {
//        System.out.print(i.value + "    ");
//    }
//        System.out.println("");
//
//        System.out.println(heap.dequeue().value);
//        System.out.println(heap.dequeue().value);
//        System.out.println(heap.dequeue().value);
//        System.out.println(heap.dequeue().value);
//
//
//        for(Node i: heap.list) {
//        System.out.print(i.value);
//    }
//}