import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Hotel {

    private String[] name;
    private String[] cols=new String[10];
    private String row;
    private int choice, type, roomNum, i=0;
    private Guest guest;
    private Receptionist receptionist;
    ArrayList<Room> rooms = new ArrayList<Room>(20); // ArrayList to hold read information from given file
    Scanner[] inputs = new Scanner[10]; // to get input from user

    public Hotel() throws IOException { // reading an existing csv file to get rooms' information into an ArrayList which is called 'rooms'

        BufferedReader b = new BufferedReader(new FileReader("Rooms.csv"));

        while ( (row = b.readLine())!=null) {
            cols = row.split(",");

            Room room = new Room(); // creating a temporary object to read a row

            // placing necessary information to the object
            room.setRoomNo(Integer.parseInt(cols[0]));
            room.setType(Integer.parseInt(cols[1]));
            room.setBedNum(Integer.parseInt(cols[2]));
            room.setPrice(Integer.parseInt(cols[3]));
            room.setView(Boolean.valueOf(cols[4]));
            room.setEmpty(Boolean.valueOf(cols[5]));
            room.setBooked(Boolean.valueOf(cols[6]));
            room.setName(cols[7]);

            // adding temporary object with the informations to the ArrayList
            rooms.add(room);

            i++;
        }

        // initializing scanner objects to get inputs from user
        for(int i=0; i<10; ++i){
            inputs[i] = new Scanner(System.in);
        }
        start();
    }

    // this function manages all the process
    // asks user some questions by giving her/him a couple of menus
    // after getting answers, it calls proper functions in order to make user's wish
    public void start() throws IOException {
        System.out.println("Welcome! Please choose.\n1 - Guest \n2 - Receptionist");
        choice = inputs[0].nextInt();

        if(choice ==1){ // when user chooes guest
            guest = new Guest();
            choice = guest.input();

            if(choice == 1){ // after guest chooses booking, it gets necessary informations and it has related room booked
                type = guest.inputs();
                try{
                    rooms = guest.book(rooms, type);
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
            else if(choice == 2){ // after guest chooses canceling, it takes room num from user and gets cancelled booking
                System.out.println("Enter room number.");
                roomNum = inputs[2].nextInt();
                rooms =  guest.cancel(rooms, roomNum);
            }
        }
        else if(choice == 2){ // when user chooes receptionist
            int choice, n;
            receptionist = new Receptionist();
            choice = receptionist.input(); // it gives 3 options to recetionist to choose

            switch (choice){ // it switches between cases by receptionist's decision
                case 1 : // if receptionist chooeses to book
                    type = receptionist.inputs(); // gets necesarry inputs to book her/him reservation
                    try{
                        rooms = receptionist.book(rooms, type); // calls book function and function returns rooms ArrayList back with changes
                    }
                    catch(Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 2 : // check-in
                    System.out.println("Enter room's number to check in");
                    n = inputs[3].nextInt();
                    try{
                        rooms = receptionist.checkIn(rooms, n); // calls check-in function, func returns rooms ArrayList back
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                    break;
                case 3 : // check-out
                    System.out.println("Enter room's number to check out");
                    n = inputs[3].nextInt();
                    try{
                        rooms = receptionist.checkOut(rooms, n); // calls check-out function, func returns rooms ArrayList back
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                    break;
                case 4: // cancel
                    System.out.println("Enter room number.");
                    roomNum = inputs[1].nextInt();
                    rooms =  receptionist.cancel(rooms, roomNum);
            }

        }
    }
}

