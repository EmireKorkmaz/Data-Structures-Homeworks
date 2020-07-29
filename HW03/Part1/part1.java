/*
*  CSE 222 - HW03
*  1401044043 Emire Korkmaz
*
* */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class part1 {
    public static void main(String[] args) throws IOException {
        String row, plusSign="";
        String[] temp = new String[3];
        String[] cols=new String[50];
        int i=0, credits=0;
        MyLinkedList myLinkedList = new MyLinkedList();

        BufferedReader b = new BufferedReader(new FileReader("Courses(CSV)(Updated).csv"));

        while ( (row = b.readLine())!=null) {
            if(i!=0){
                cols = row.split(",");
                Data data = new Data();
                // adding temporary object with the information to MyLinkedList
                data.setSemester(Integer.parseInt(cols[0]));
                data.setCode(cols[1]);
                data.setName(cols[2]);
                data.setECTS(Integer.parseInt(cols[3]));
                data.setGTU(Integer.parseInt(cols[4]));

                plusSign = plusSign.replaceAll("\\+", "+");

                temp = cols[5].split("\\+");
                credits =Integer.parseInt(temp[0])+Integer.parseInt(temp[1])+Integer.parseInt(temp[2]);

                data.setCredits(credits);
                myLinkedList.list.add(data);
            }
            i++;
        }

    }
}
