import java.util.*;

public class part1 {
    public static void main(String[] args){
        ListGraph m = new ListGraph(10, true);
        Edge e = new Edge(0,1, 1.1);
        Edge e1 = new Edge(1,2, 9.5);
        Edge e2 = new Edge(2,7,8.9) ;
        Edge e3 = new Edge(3,7, 3.3);
        Edge e4 = new Edge(4,7,0.1);
        Edge e5 = new Edge(5,0, 0.8);
        Edge e6 = new Edge(9,8, 5.7);
        Edge e7 = new Edge(6,5, 2.1);
        Edge e8 = new Edge(9,2, 2.3);
        Edge e9 = new Edge(5,3, 1.9);
        Edge e10 = new Edge(1,4, 2.2);
        Edge e11 = new Edge(1,3, 3.4);
        Edge e12 = new Edge(5,8, 9.0);
        Edge e13 = new Edge(5,9, 3.0);
        Edge e14 = new Edge(3,9, 4.1);
        Edge e15 = new Edge(3,1, 7.1);
        Edge e16 = new Edge(6,1, 6.3);
        Edge e17 = new Edge(1,8, 8.3);
        Edge e18 = new Edge(0,7, 7.5);
        Edge e19 = new Edge(7,4, 7.7);

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
        System.out.print("Shortest distance between " + 0 + " and " + 9 + " is ");
        shortest_path(m, 0, 9);
        System.out.print("Shortest distance between " + 2 + " and " + 7 + " is ");
        shortest_path(m, 2, 7);
        System.out.print("Shortest distance between " + 5 + " and " + 9 + " is ");
        shortest_path(m, 5, 9);

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

    public static void shortest_path(ListGraph g, int v1, int v2){
        int[] pred = new int[g.getNumV()];
        double[] dist = new double[g.getNumV()];
        double distance;
        dijkstrasAlgortihm(g, v1, pred, dist);
        int i=v2;
        while(pred[i]!=v1){
            System.out.print(pred[i]);
            i = pred[i];
        }
    }
    public static void dijkstrasAlgortihm(ListGraph graph, int start, int[] pred, double[] dist){
        int numV = graph.getNumV();
        HashSet<Integer> vMinusS = new HashSet<Integer>(numV);

        for(int i=0; i<numV; i++){
            if(i!=start)
                vMinusS.add(i);
        }
        for(int v : vMinusS){
            pred[v] = start;
            dist[v] = graph.getEdge(start, v).getWeight();
        }
        while (vMinusS.size() != 0){
            double minDist = Double.POSITIVE_INFINITY;
            int u=0;
            for (int v : vMinusS){
                if(dist[v] < minDist){
                    minDist = dist[v];
                    u = v;
                }
            }
            vMinusS.remove(u);
            Iterator<Edge> edgeIter = graph.edgeIterator(u);
            while (edgeIter.hasNext()) {
                Edge edge = edgeIter.next();
                int v = edge.getDest();
                if (vMinusS.contains(new Integer(v)));
                double weight = edge.getWeight();
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pred[v] = u;
                }
            }

        }
    }
    public static void plot_graph(ListGraph listGraph){
        System.out.println();
        System.out.println(listGraph.toString());
    }

}
