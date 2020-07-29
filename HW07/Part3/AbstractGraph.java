import java.io.IOException;
import java.util.Scanner;

public abstract class AbstractGraph implements Graph {
    private int numV;

    private boolean directed;

    public AbstractGraph(int numV, boolean directed) {
        this.numV = numV;
        this.directed = directed;
    }

    public int getNumV() {
        return numV;
    }

    public boolean isDirected() {
        return directed;
    }

    public static Graph createGraph(Scanner scan, boolean isDirected,String type) throws IOException {
        int numV = scan.nextInt();
        scan.nextLine();
        AbstractGraph returnValue = null;
        if (type.equalsIgnoreCase("List")) {
            returnValue = new ListGraph(numV, isDirected);
        } else {
            throw new IllegalArgumentException();
        }
        // returnValue.loadEdgesFromFile(scan);
        return returnValue;
    }
}

