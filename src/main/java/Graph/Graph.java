package Graph;

import heapandpriorityqueue.PriorityQueue;
import java.util.*;

public class Graph {
    public HashMap<String, ArrayList<Node>> adjecencyList;
    public Graph() {
        this.adjecencyList = new HashMap<String, ArrayList<Node>>();
    }

    public boolean addVertex(String vertex) {
        if(!this.adjecencyList.containsKey(vertex)) {
            this.adjecencyList.put(vertex, new ArrayList<Node>());
            return true;
        } else {
            return false;
        }
    }

    public boolean addEdge(String vertex1, String vertex2, int weight) {
        if(this.adjecencyList.containsKey(vertex1) && this.adjecencyList.containsKey(vertex2)) {
            ArrayList<Node> vertex1Associates = this.adjecencyList.get(vertex1);
            ArrayList<Node> vertex2Associates = this.adjecencyList.get(vertex2);
            vertex1Associates.add(new Node(vertex2, weight));
            vertex2Associates.add(new Node(vertex1, weight));
            this.adjecencyList.put(vertex1, vertex1Associates);
            this.adjecencyList.put(vertex2, vertex2Associates);
            return true;

        } else {
            return false;
        }
    }

    public boolean removeEdge(String vertex1, String vertex2) {
        if(this.adjecencyList.containsKey(vertex1) && this.adjecencyList.
                containsKey(vertex2)) {
            ArrayList<Node> vertex1Associates = this.adjecencyList.get(vertex1);
            ArrayList<Node> vertex2Associates = this.adjecencyList.get(vertex2);
            ArrayList<Node> mordifiedV1 = new ArrayList<Node>();
            ArrayList<Node> mordifiedV2 = new ArrayList<Node>();
            for(Node n:vertex1Associates) {
                if (!n.value.equals(vertex2)){
                    mordifiedV1.add(n);
                }
            }
            for(Node n2:vertex2Associates) {
                if (!n2.value.equals(vertex1)){
                    mordifiedV2.add(n2);
                }
            }
            this.adjecencyList.put(vertex1, mordifiedV1);
            this.adjecencyList.put(vertex2, mordifiedV2);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeVertex(String vertex) {
        if(this.adjecencyList.containsKey(vertex)) {
            ArrayList<Node> associates = this.adjecencyList.get(vertex);
            for(Node n:associates) {
                removeEdge(n.value, vertex);
            }
            this.adjecencyList.remove(vertex);
            return true;
        } else {
            return false;
        }
    }

    public List<String> ShortestPath(String start, String end) {
        PriorityQueue queue = new PriorityQueue();
        HashMap<String, Integer> distance = new HashMap<String, Integer>();
        HashMap<String,String> previous = new HashMap<String, String>();
        ArrayList<String> result = new ArrayList<String>();
        String current=null;

        for(String key: this.adjecencyList.keySet()) {
            if(key.equals(start)) {
                distance.put(key, 0);
                queue.enqueue(key, 0);
            } else {
                distance.put(key, Integer.MAX_VALUE);
                queue.enqueue(key, Integer.MAX_VALUE);
            }
            previous.put(key, null);
        }

        while(queue.list.size()>0) {
            current=queue.dequeue().value;
            if(current.equals(end)) {
                while(previous.get(current)!=null) {
                    result.add(current);
                    current=previous.get(current);
                }
                break;
            }
            if(current != null && distance.get(current)!=Integer.MAX_VALUE) {
                ArrayList<Node> associates = this.adjecencyList.get(current);
                for(Node n:associates) {
                    int updatedWeight = distance.get(current)+n.weight;
                    String nextElement = n.value;
                    if(updatedWeight<distance.get(nextElement)) {
                        distance.put(nextElement, updatedWeight);
                        previous.put(nextElement,current);
                        queue.enqueue(nextElement, updatedWeight);
                    }
                }
            }
        }
        result.add(current);
        Collections.reverse(result);
        return result;
    }

    public List<String> BFS(String start) {
        ArrayList<String> result = new ArrayList<String>();
        Queue<String> queue = new LinkedList<String>();
        HashMap<String, Boolean> marker = new HashMap<String, Boolean>();
        String element;
        queue.add(start);
        marker.put(start,true);

        while(queue.size()>0) {
            element = queue.poll();
            result.add(element);
            for(Node n: this.adjecencyList.get(element)) {
                if(!marker.containsKey(n.value)) {
                    marker.put(n.value, true);
                    queue.add(n.value);
                }
            }
        }
        return result;
    }

    public List<String> DFS(String start) {
        Stack<String> s= new Stack<String>();
        HashMap<String,Boolean> marker = new HashMap<String, Boolean>();
        ArrayList<String> result = new ArrayList<String>();
        String element;

        s.add(start);
        marker.put(start, true);
        while(s.size()>0) {
            element = s.pop();
            result.add(element);
            for(Node n: this.adjecencyList.get(element)) {
                if(!marker.containsKey(n.value)) {
                    marker.put(n.value, true);
                    s.push(n.value);
                }
            }

        }
        return result;
    }
}
