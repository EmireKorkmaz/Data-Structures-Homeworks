import java.util.*;

public class ListGraph<T> extends AbstractGraph {
    public List < Edge > [] edges;

    public ListGraph(int numV, boolean directed) {
        super(numV, directed);
        edges = new List[numV];
        for (int i = 0; i < numV; i++) {
            edges[i] = new LinkedList < Edge > ();
        }
    }
    public boolean isEdge(int source, int dest) {
        return edges[source].contains(new Edge(source, dest));
    }
    public void insert(Edge edge) {
        edges[edge.getSource()].add(edge);
        if (!isDirected()) {
            edges[edge.getDest()].add(new Edge(edge.getDest(), edge.getSource(), edge.getWeight()));
        }
    }

    public Iterator < Edge > edgeIterator(int source) {
        return edges[source].iterator();
    }

    public Edge getEdge(int source, int dest) {
        Edge target =
                new Edge(source, dest, Double.POSITIVE_INFINITY);
        for (Edge edge : edges[source]) {
            if (edge.equals(target))
                return edge; // Desired edge found, return it.
        }
        // Assert: All edges for source checked.
        return target; // Desired edge not found.
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        int j;
        for(int i=0; i<edges.length; i++){
            j=0;
            while(edges[i].size()>0 && j<edges[i].size()){
                System.out.print(edges[i].get(j).getSource());
                if(edges[i].get(j).isWeighted())
                    System.out.print(" --<"+ edges[i].get(j).getWeight()+ ">-->");
                else
                    System.out.print(" -->");
                System.out.println(edges[i].get(j).getDest());
                j++;
            }
        }

        return sb.toString();
    }


}
