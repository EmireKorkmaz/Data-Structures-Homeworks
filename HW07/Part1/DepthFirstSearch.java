import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DepthFirstSearch {
    private Graph graph;
    private int[] parent;
    private boolean returnVal;
    private boolean[] visited;
    private LinkedList visitedVertices;
    private Stack<Integer> stack = new Stack<>();
    private int[] discoveryOrder;
    private int[] finishOrder;
    private int discoverIndex = 0;
    private int finishIndex = 0;
    boolean flag=true, breakval;
    public DepthFirstSearch(Graph graph) {
        this.graph = graph;
        int n = graph.getNumV();
        parent = new int[n];
        visitedVertices = new LinkedList();
        visited = new boolean[n];
        discoveryOrder = new int[n];
        finishOrder = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                depthFirstSearch(i);
                visitedVertices.add(i);
            }
        }
    }

    public void depthFirstSearch(int current) {
        visited[current] = true;
        discoveryOrder[discoverIndex++] = current;
        Iterator<Edge> itr = graph.edgeIterator(current);
        while (itr.hasNext()) {
            int neighbor = itr.next().getDest();
            if(flag && visitedVertices.contains(neighbor)){
                returnVal = false; // it is not acyclic cyclic
                flag = false;
            }
            if (!visited[neighbor]) {
                parent[neighbor] = current;
                depthFirstSearch(neighbor);
            }
        }
        finishOrder[finishIndex++] = current;
    }
    // is acyclic
    public boolean check(){
       return returnVal;
    }
}

