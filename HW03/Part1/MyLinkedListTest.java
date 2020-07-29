import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    @Test
    void getByCode() throws IOException {
        MyLinkedList myLinkedList = new MyLinkedList();

        String row, plusSign="",code="CSE 241", course=null; // code is for course's code to test
        String[] temp = new String[3];
        String[] cols=new String[50];
        int i=0, credits=0;
        boolean found =false;

        BufferedReader b = new BufferedReader(new FileReader("Courses(CSV)(Updated).csv"));

        while ( (row = b.readLine())!=null) {
            if(i!=0){
                cols = row.split(",");
                Data data = new Data();
                // adding temporary object with the informations to the ArrayList
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
        for(Data d : myLinkedList.list)
            if(d.getCode().equals(code)) {
                course = d.getName();
                found = true;
            }

        assertEquals(course, myLinkedList.getByCode(code));
    }

    @Test
    void listSemesterCourses() throws IOException {
        MyLinkedList myLinkedList = new MyLinkedList();
        LinkedList<Data> mll = new LinkedList<>();

        String row, plusSign="",code="CSE 241", course="";
        String[] temp = new String[3];
        String[] cols=new String[50];
        int i=0, credits=0, semester=4; // semester is for testing

        BufferedReader b = new BufferedReader(new FileReader("Courses(CSV)(Updated).csv"));

        while ( (row = b.readLine())!=null) {
            if(i!=0){
                cols = row.split(",");
                Data data = new Data();
                // adding temporary object with the informations to the ArrayList
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
        for (Data d : myLinkedList.list){
            if(d.getSemester()==semester) {
                mll.add(d);
            }
        }
        assertEquals(mll, myLinkedList.listSemesterCourses(semester));
    }

    @Test
    void getByRange() throws IOException {
        MyLinkedList myLinkedList = new MyLinkedList();
        LinkedList<Data> mll = new LinkedList<>();

        String row, plusSign="",code="CSE 241", course="";
        String[] temp = new String[3];
        String[] cols=new String[50];
        int i=0, credits=0, semester=4, start_index=3, last_index=5; // start_index and last_index are for testing

        BufferedReader b = new BufferedReader(new FileReader("Courses(CSV)(Updated).csv"));

        while ( (row = b.readLine())!=null) {
            if(i!=0){
                cols = row.split(",");
                Data data = new Data();
                // adding temporary object with the informations to the ArrayList
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
        i=0;
        for (Data d : myLinkedList.list){
            if (i >= start_index && i <= last_index) {
                mll.add(d);
            }
            i++;
        }
        assertEquals(mll, myLinkedList.getByRange(start_index,last_index));
    }
}