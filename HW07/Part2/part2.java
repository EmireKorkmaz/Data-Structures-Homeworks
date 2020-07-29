import java.util.*;

public class part2 {
    public static void main(String[] args){

        ListGraph m = new ListGraph(30, false);

        Edge e = new Edge(0,1);
        Edge e1 = new Edge(1,2);
        Edge e2 = new Edge(2,7) ;
        Edge e3 = new Edge(3,7);
        Edge e4 = new Edge(4,7);
        Edge e5 = new Edge(5,0);
        Edge e6 = new Edge(6,2);
        Edge e7 = new Edge(7,9);
        Edge e8 = new Edge(8,0);
        Edge e9 = new Edge(5,10);
        Edge e10 = new Edge(13,11);
        Edge e11 = new Edge(14,0);
        Edge e12 = new Edge(12,14);
        Edge e13 = new Edge(10,5);
        Edge e14 = new Edge(11,13);
        Edge e15 = new Edge(5,8);
        Edge e16 = new Edge(9,8);
        Edge e17 = new Edge(13,10);
        Edge e18 = new Edge(7,12);
        Edge e19 = new Edge(5,14);
        Edge e20 = new Edge(8,9);
        Edge e21 = new Edge(1,8);
        Edge e22 = new Edge(5,1);
        Edge e23 = new Edge(10,12);
        Edge e24 = new Edge(12,7);
        Edge e25 = new Edge(13,14);
        Edge e26 = new Edge(11,7);
        Edge e27 = new Edge(11,0);
        Edge e28 = new Edge(2,6);
        Edge e29 = new Edge(1,2);

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
        m.insert(e20);
        m.insert(e21);
        m.insert(e22);
        m.insert(e23);
        m.insert(e24);
        m.insert(e25);
        m.insert(e26);
        m.insert(e27);
        m.insert(e28);
        m.insert(e29);

        plot_graph(m);
        System.out.println("Is this graph acyclic : " + is_acyclic_graph(m));
        System.out.println("Is this graph undirected : " +is_undirected(m));
        try{
            System.out.println("Are " + 10 + " and "+ 12 + " connected : "+ is_connected(m, 9, 8));
            System.out.println("Are " + 0 + " and "+ 1 + " connected : "+ is_connected(m, 0, 1));
            System.out.println("Are " + 5 + " and "+ 7 + " connected : "+ is_connected(m, 5, 7));
        }catch (Exception exc){
            System.out.println("Given vertices are not valid.");
        }
    }

    public static boolean is_connected(ListGraph g, int v1, int v2){
        int j;
        for(int i=0; i<g.edges.length; i++){
            if((g.edges[i].contains(v1) || g.edges[i].contains(v2)))
                throw new NoSuchElementException();
        }

        if(shortest_path(g, v1, v2)==Double.POSITIVE_INFINITY)
            return false;
        return true;
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
    public static double shortest_path(Graph g, int v1, int v2){
        int[] pred = new int[g.getNumV()];
        double[] dist = new double[g.getNumV()];
        double distance;
        dijkstrasAlgortihm(g, v1, pred, dist);
        System.out.println(pred);
        distance = dist[v2];
        return distance;
    }
    public static void dijkstrasAlgortihm(Graph graph, int start, int[] pred, double[] dist){
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
            int u=-1;
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
