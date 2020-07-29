import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Guest extends User{
    @Override
    public int input() {
        int c;
        Scanner s = new Scanner(System.in);
        System.out.println("1 - Book\n2 - Cancel Reservation");
        c = s.nextInt();
        if(!(c==1 || c==2)){
            System.out.println("You have entered wrong number.");

        }
        return c;
    }

    public Guest() throws IOException {
    }

}
