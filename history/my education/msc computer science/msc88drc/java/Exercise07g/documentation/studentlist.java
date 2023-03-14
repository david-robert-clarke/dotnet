import java.util.*;

// last edit: 26-Mar-2002  rfrank@rfrank.net

public class StudentList
{
    public static void main(String[] args)
    {
        ArrayList students = new ArrayList();

        students.add(new Student(1452, "Emmylou Harris"));
        students.add(new Student(1230, "Tammy Wynette "));
        students.add(new Student(1679, "Linda Rondstat"));
        students.add(new Student(1120, "Crystal Gayle "));
        students.add(new Student(1369, "Tanya Tucker  "));
        System.out.println("added five students, size now: "+students.size());

        // display the student list
        for (int i = 0; i < students.size(); i++)
            ((Student)students.get(i)).print();
        System.out.println();

        students.remove(4);
        System.out.println("removed student 4, size now: "+students.size());

        // another way to display, with an iterator
        Iterator i = students.iterator();
        while(i.hasNext())
            ((Student)i.next()).print();
        System.out.println();

        students.add( 2, new Student(1812, "Reba McEntire ") );
        System.out.println("inserted student at 2, size now: "+students.size());

        i = students.iterator();
        while(i.hasNext())
            ((Student)i.next()).print();
        System.out.println();

        System.out.println("sort the student ArrayList by student ID");
        Collections.sort( students );
        i = students.iterator();
        while(i.hasNext())
            ((Student)i.next()).print();
        System.out.println();
    }
}
