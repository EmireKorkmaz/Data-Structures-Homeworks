/*
 * This class is an abstract class that implements Person interface
 * It overrode 2 methods; book and inputs and has an abstract method; input.
 *
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public abstract class User implements Person {

    protected String name, row;
    protected String[] cols=new String[10];
    private int lineNum=0, j=0, i=0;
    ArrayList<Room> rooms = new ArrayList<Room>(20);
    protected boolean bool;
    protected int room;
    Scanner inp, inp2, inp3, inp4, inp5, inp6; // scanner objects to get input from user

    public abstract int input();

    public ArrayList<Room> cancel(ArrayList<Room> room, int num) throws IOException {
        for (Room r: room) {
            if (r.getRoomNo() == num) {
                r.setEmpty(true);
                r.setName("none");
                r.setCheckIn(false);
                r.setBooked(false);
            }
        }
        FileWriter w = new FileWriter("Rooms.csv"); // after room got booked, it writes
        // changed room ArrayList right back to csv file.

        for(int i=0; i<room.size(); ++i){
            w.write(room.get(i).toString());
        }

        w.flush();
        w.close();
        System.out.println("Your reservation has been cancelled.");
        return room;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User() throws IOException {
        inp = new Scanner(System.in);
        inp2 = new Scanner(System.in);
        inp3 = new Scanner(System.in);  // initializing scanner objects
        inp4 = new Scanner(System.in);
        inp5 = new Scanner(System.in);
        inp6 = new Scanner(System.in);
    }

    // this method gets an ArrayList of rooms and books given type of room after checking if it is empty

    @Override
    public ArrayList<Room> book(ArrayList<Room> room, int roomType) throws FileNotFoundException, IOException {
        int checker=0, ty;
        for (Room r: room) {
            if(r.isEmpty() && (r.getType()==roomType)) {
                r.setBooked(true);
                r.setName(name);
                r.setEmpty(false);
                System.out.println("Your room is "+ r.getRoomNo());
                break;
            }
            else if((r.getType()==roomType) && !r.isEmpty())
                checker++;
        }

        if (checker==5){ // if room is full, asks user to choose another room
            System.out.println("Sorry that room is full.");
            ty = inputs();
            room = book(room, ty);
        }

        FileWriter w = new FileWriter("C:\\Users\\Msegd Korkmaz\\Desktop\\Rooms.csv"); // after room got booked, it writes
        // changed room ArrayList right back to csv file.

        for(int i=0; i<room.size(); ++i){
            w.write(room.get(i).toString());
        }

        // w.flush();
        w.close();

        System.out.println("Your reservation has been made.");

        return room;
    }

    @Override  // gets necessary information from user to book a room
    public int inputs() {

        System.out.println("Name");
        setName(inp.nextLine());

        System.out.println("Room type 1\nBeds = 2 Price = $3000 View = Yes\n\n");
        System.out.println("Room type 2\nBeds = 2 Price = $2000 View = No\n\n");
        System.out.println("Room type 3\nBeds = 1 Price = $2000 View = Yes\n\n");
        System.out.println("Room type 4\nBeds = 1 Price = $1000 View = No\n\n");

        int roomType = inp5.nextInt();
        return roomType;
    }
}
