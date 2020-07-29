/*
 * This class is an interface that has book and input methods.
 * */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface Person {
    public ArrayList<Room> book(ArrayList<Room> rooms, int roomType) throws FileNotFoundException, IOException;
    public int inputs();
    public ArrayList<Room> cancel(ArrayList<Room> room, int num) throws IOException;
}
