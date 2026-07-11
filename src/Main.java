import java.util.ArrayList;
import java.util.Scanner;


class Student {
    private int numTotal=0;
    private int id;
    private String name;
    private int age;
    Scanner scn = new Scanner(System.in);

    public Student(int id, String name, int age){
        this.id=id;
        this.name=name;
        this.age=age;
        numTotal++;
    }

    public int getID(){
        return id;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setAge(int age){
        this.age=age;
    }

    public void display(){
        System.out.printf("ID: %d%nName: %s%nAge: %d%n", id,name,age);
    }
}

class StdMng {
    Scanner scn = new Scanner(System.in);
    ArrayList<Student> students = new ArrayList<>();


    public void addStd(){
        System.out.printf("\nPlease enter following info:");
        System.out.printf("\nID : ");
        int id = scn.nextInt();
        if(findStd(id)!=null){
            System.out.println("ID already exists");
        }
        System.out.printf("\nName : ");
        String name = scn.next();
        System.out.printf("\nAge : ");
        int age = scn.nextInt();
        Student std = new Student(id,name,age);
        students.add(std);
    }

    public void dltStd(){
        System.out.printf("\nPlease enter ID: ");
        Student s = findStd(scn.nextInt());
        if(s!=null) {
            students.remove(s);
            System.out.printf("\nDeleted!");
        }else{
            System.out.printf("\nNo ID found");}
    }


    public void edtStd(){
        System.out.printf("\nPlease enter ID: ");
        Student s = findStd(scn.nextInt());
        if(s!=null) {
            System.out.printf("\nPlease enter new name:");
            s.setName(scn.next());
            System.out.printf("\nPlease enter new age:");
            s.setAge(scn.nextInt());
            System.out.printf("\nEdited!");
        }else{
            System.out.printf("\nNo ID found");}
    }



    public void srchStd(){
        System.out.printf("\nPlease enter ID: ");
        Student s = findStd(scn.nextInt());
        if(s!=null) {
            s.display();
        }else{
            System.out.printf("\nNo ID found");}
    }

    private Student findStd(int id){
        for(Student s : students){
            if(s.getID()==id){
                return s;
            }
        }
        return null;
    }

    private void DisplayAll(){
        if(students.isEmpty()){
            System.out.println("No Students!");
            return;
        }
        for(Student s : students) {
            s.display();
        }
    }
}


public class Main {
    public static void main(String[] args) {

        int choice = 0;
        StdMng obj = new StdMng();
        Scanner scn = new Scanner(System.in);
        while(true) {
            System.out.printf("Hello and welcome!\n" +
                    "What would you like to do today?\n" +
                    "1. Add Student ID\n" +
                    "2. Delete Student ID\n" +
                    "3. Edit Student Info\n" +
                    "4. Search\n" +
                    "5. Exit\n" +
                    "\n Enter : ");
            choice = scn.nextInt();

            switch (choice) {
                case 1:
                    obj.addStd();
                    break;
                case 2:
                    obj.dltStd();
                    break;
                case 3:
                    obj.edtStd();
                    break;
                case 4:
                    obj.srchStd();
                    break;
                case 5:
                    return;
                default:
                    System.out.printf("\nPlease enter correct choice");
            }
        }


    }
}