import java.util.*;

public class part3 {
    public static void main(String[] args){
        ListGraph m = new ListGraph(25, false);
        Edge e = new Edge(0,1);
        Edge e1 = new Edge(1,2);
        Edge e2 = new Edge(2,7) ;
        Edge e3 = new Edge(3,7);
        Edge e4 = new Edge(4,7);
        Edge e5 = new Edge(5,0);
        Edge e6 = new Edge(9,8);
        Edge e7 = new Edge(6,10);
        Edge e8 = new Edge(11,12);
        Edge e9 = new Edge(5,14);
        Edge e10 = new Edge(12,14);
        Edge e11 = new Edge(1,3);
        Edge e12 = new Edge(5,18);
        Edge e13 = new Edge(15,9);
        Edge e14 = new Edge(13,19);
        Edge e15 = new Edge(3,14);
        Edge e16 = new Edge(16,11);
        Edge e17 = new Edge(15,18);
        Edge e18 = new Edge(0,17);
        Edge e19 = new Edge(19,14);

        m.insert(e);
        m.insert(e1);
        m.insert(e2);
        m.insert(e3);
        m.insert(e4);
        m.insert(e5);
        m.insert(e6);
        m.insert(e7);
        m.insert(e8);
        m.insert(e9);
        m.insert(e10);
        m.insert(e11);
        m.insert(e12);
        m.insert(e13);
        m.insert(e14);
        m.insert(e15);
        m.insert(e16);
        m.insert(e17);
        m.insert(e18);
        m.insert(e19);

        plot_graph(m);
        System.out.println("Is this graph undirected : " +is_undirected(m));
        System.out.println("Is this graph acyclic : " + is_acyclic_graph(m));
        System.out.println("Spanning tree : " + primsAlgorithm(m, 0));
        System.out.print("BFS : " + breadthFirstSearch(m, 0));

        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(m);
    }

    public static boolean is_acyclic_graph(ListGraph graph){
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph);
        return depthFirstSearch.check();
    }
    public static boolean is_undirected(Graph graph){
        if(graph.isDirected())
            return false;
        return true;
    }

    public static int[] breadthFirstSearch(Graph graph, int start) {
        Queue < Integer > theQueue = new LinkedList < Integer > ();
        int[] parent = new int[graph.getNumV()];
        for (int i = 0; i < graph.getNumV(); i++) {
            parent[i] = -1;
        }
        boolean[] identified = new boolean[graph.getNumV()];
        identified[start] = true;
        theQueue.offer(start);
        while (!theQueue.isEmpty()) {
            int current = theQueue.remove();
            Iterator < Edge > itr = graph.edgeIterator(current);
            while (itr.hasNext()) {
                Edge edge = itr.next();
                int neighbor = edge.getDest();
                if (!identified[neighbor]) {
                    identified[neighbor] = true;
                    theQueue.offer(neighbor);
                    parent[neighbor] = current;
                }
            }
        }
        return parent;
    }
    public static void plot_graph(ListGraph listGraph){
        System.out.println();
        System.out.println(listGraph.toString());
    }

    public static ArrayList < Edge > primsAlgorithm(Graph graph,int start) {

        class CompareEdges implements Comparator < Edge > {
            public int compare(Edge e1, Edge e2) {
                return Double.compare(e1.getWeight(), e2.getWeight());
            }
        }

        ArrayList < Edge > result = new ArrayList < Edge > ();
        int numV = graph.getNumV();
        Set < Integer > vMinusS = new HashSet < Integer > (numV);
        Queue < Edge > pQ = new PriorityQueue < Edge > (numV, new CompareEdges());

        for (int i = 0; i < numV; i++) {
            if (i != start) {
                vMinusS.add(i);
            }
        }
        int current = start;
        while (vMinusS.size() != 0) {
            Iterator < Edge > iter = graph.edgeIterator(current);
            while (iter.hasNext()) {
                Edge edge = iter.next();
                int dest = edge.getDest();
                if (vMinusS.contains(dest)) {
                    pQ.add(edge);
                }
            }
            int dest = -1;
            Edge edge = null;
            do {
                edge = pQ.remove();
                dest = edge.getDest();
            }
            while (!vMinusS.contains(dest));
            vMinusS.remove(dest);
            result.add(edge);
            current = dest;
        }
        return result;
    }
}