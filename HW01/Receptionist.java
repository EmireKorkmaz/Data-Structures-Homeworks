/*
 * This class extends from User class. It has input, checkIn, checkOut and logIn methods
 *
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Receptionist extends User {
    private String userName;
    private int counter=0, password;
    public Receptionist() throws IOException {
        logIn();
    }
    public Receptionist(String user, int pass) throws IOException {
        logIn1(user,pass);
    }
    public int input(){
        int c;
        Scanner s = new Scanner(System.in);
        System.out.println("1 - Book\n2 - Check-in\n3 - Check-out\n4 - Cancel");
        c = s.nextInt();
        return c;
    }
    public ArrayList<Room> checkIn(ArrayList<Room> room, int n){
        room.get(n-1).setCheckIn(true);
        return room;
    }

    public ArrayList<Room> checkOut(ArrayList<Room> room, int n){
        room.get(n-1).setCheckIn(false);
        return room;
    }
    private boolean logIn() throws IOException {
        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);

        System.out.println("Username: ");
        userName = input.nextLine();
        System.out.println("Password: ");
        password = input1.nextInt();

        String line;
        BufferedReader b = new BufferedReader(new FileReader("Employees.csv"));
        while ( (line = b.readLine())!=null ) {
            cols = line.split(",");
            if(cols[0].equals(userName) && cols[1].equals(Integer.toString(password))){
                return true;
            }
        }
        counter++;
        if(counter==3) {
            System.err.println("You have failed to log in.");
            System.exit(-1);
        }
        return logIn();
    }
    private boolean logIn1(String userName, int password) throws IOException {
        String line;
        BufferedReader b = new BufferedReader(new FileReader("Employees.csv"));
        while ( (line = b.readLine())!=null ) {
            cols = line.split(",");
            if(cols[0].equals(userName) && cols[1].equals(Integer.toString(password))){
                return true;
            }
        }
        return false;
    }
}
