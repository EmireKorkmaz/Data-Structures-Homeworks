import java.io.IOException;
import java.util.LinkedList;

public class MyLinkedList {

    LinkedList<Data> list = new LinkedList<>(); // created a LinkedList to hold course information

    public String getByCode (String code) throws IndexOutOfBoundsException{
        boolean found = false;
        for (Data d : list){
            if(d.getCode().equals(code)) {  // comparing given code with existing course codes
                found=true;
                return d.getName(); // if any of them matches, returns course's name
            }
        }
        if (found == false)
            throw new IndexOutOfBoundsException("No matching course");
        return null;
    }
    public LinkedList<Data> listSemesterCourses (int semester) throws IndexOutOfBoundsException{

        LinkedList<Data> mll = new LinkedList<>(); // created a LinkedList to hold the courses in a semester

        for (Data d : list){
            if(d.getSemester()==semester) { // comparing given semester number with existing courses' semester's
                mll.add(d); // if any matches, it adds them into the LinkedList that I just created
            }
        }
        if (mll == null)
            throw new IndexOutOfBoundsException("No matching course");
        return mll; // returns all the courses being in the same semester
    }

    public LinkedList<Data> getByRange(int start_index, int last_index) throws IndexOutOfBoundsException{
        LinkedList<Data> mll = new LinkedList<>(); // created a LinkedList to hold the courses
        int i = 0;
        for (Data d : list) {
            if (i >= start_index && i <= last_index) {
                mll.add(d); // lists the courses
            }
            i++;
        }
        if (mll==null)
            throw new IndexOutOfBoundsException("No matching course");
        return  mll; // returns listed courses
    }
}
