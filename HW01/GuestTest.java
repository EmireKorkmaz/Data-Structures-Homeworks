import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GuestTest {

    @Test
    void cancel() throws IOException {

        Guest guest = new Guest();

        int num=1, i=0;
        ArrayList<Room> rooms = new ArrayList<Room>(20);
        ArrayList<Room> rooms1 = new ArrayList<Room>(20);

        BufferedReader b = new BufferedReader(new FileReader("Rooms.csv"));
        String row;
        String[] cols=new String[10];
        while ( (row = b.readLine())!=null) {
            cols = row.split(",");

            Room room = new Room(); // creating a temporary object to read a row

            // placing necesarry informations to the object
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
            rooms1.add(room);
            i++;
        }
        for (Room r: rooms1) {
            if (r.getRoomNo() == num) {
                r.setEmpty(true);
                r.setName("none");
                r.setCheckIn(false);
                r.setBooked(false);
            }
        }
        assertEquals(rooms1,guest.cancel(rooms, num));

    }

    @Test
    void book() throws IOException {
        Guest guest = new Guest();

        int num=1, i=0, roomType=1;
        ArrayList<Room> rooms = new ArrayList<Room>(20);
        ArrayList<Room> rooms1 = new ArrayList<Room>(20);

        BufferedReader b = new BufferedReader(new FileReader("Rooms.csv"));
        String row;
        String[] cols=new String[10];
        while ( (row = b.readLine())!=null) {
            cols = row.split(",");

            Room room = new Room(); // creating a temporary object to read a row

            // placing necesarry informations to the object
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
            rooms1.add(room);
            i++;
        }

        for (Room r: rooms1) {
            if(r.isEmpty() && (r.getType()==roomType)) {
                r.setBooked(true);
                r.setName("Ahmet");
                r.setEmpty(false);
                System.out.println("Your room is "+ r.getRoomNo());
                break;
            }
        }
        assertEquals(rooms1,guest.book(rooms, roomType));
    }
}