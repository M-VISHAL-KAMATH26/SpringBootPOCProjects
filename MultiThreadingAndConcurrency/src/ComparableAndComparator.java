import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student implements Comparable<Student>{
    public String stud_name;
    public int marks;
    public int age;

    public Student(){};
    public Student(String stud_name,int age ,int marks){
        this.stud_name=stud_name;
        this.age=age;
        this.marks=marks;
    }

    @Override
    public int compareTo(Student obj){
        return this.marks-obj.marks;
    }
    @Override
    public String toString(){
        return stud_name+" "+age+" "+marks;
    }
}

public class ComparableAndComparator {
    public static void main(String[] args) {
        List<Student> students=new ArrayList<>();
        students.add(new Student("vishal",22,100));
        students.add(new Student("delson",23,86));
        students.add(new Student("anush",20,95));

        Collections.sort(students);
        for(Student s :students){
            System.out.println(s);
        }
        Comparator<Student> sortByName=(s1,s2)->s1.stud_name.compareTo( s2.stud_name);
        students.sort(sortByName);
        for(Student s :students){
            System.out.println(s);
        }
    }
}
