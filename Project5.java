import java.util.*;
public class User {
    private String firstName, lastName;
    private int numberOfCredit;
    private int idNumber; // idNumber ++
    private double gpa ;
    private static int nextID = 0; //nextID ++

    public User(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        setIdNumber(getNextID());
        setGpa(0.0);
        setNumberOfCredit(0);
    }
    public void setIdNumber(int idNumber){
        this.idNumber=idNumber;
    }
    public int getIdNumber(){
        return idNumber;
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }
    public String getLastName(){
        return lastName;
    }

    public void setGpa(double gpa){
        this.gpa = gpa;
    }
    public double getGpa(){
        return gpa;
    }
    public void setNumberOfCredit(int numberOfCredit){
        this.numberOfCredit = numberOfCredit;
    }
    public int getNumberOfCredit(){
        return numberOfCredit;
    }
    public static int getNextID(){
        nextID++;
        return nextID;
    }
    public void addCourse(int courseCredit, String grade){
        double emp = 0 ;
        int totalCredit = getNumberOfCredit() + courseCredit;
        if (grade.equals("A")){
            emp += 4.00;
        }else if (grade.equals("A-")){
            emp += 3.70;
        }else if (grade.equals("B+")){
            emp += 3.30;
        }else if (grade.equals("B")){
            emp += 3.00;
        }else if (grade.equals("B-")){
            emp += 2.70;
        }else if (grade.equals("C+")){
            emp += 2.30;
        }else if (grade.equals("C")){
            emp += 2.00;
        }else if (grade.equals("C-")){
            emp += 1.70;
        }else if (grade.equals("D+")){
            emp += 1.30;
        }else if (grade.equals("D")){
            emp += 1.00;
        }else if (grade.equals("F")){
            emp += 0.00;
        }
        double newGpa1 = getGpa() * getNumberOfCredit();
        double newGpa2 = emp * courseCredit;
        double theNewGpa = (newGpa1+newGpa2) / totalCredit ;
        setGpa(theNewGpa);
        setNumberOfCredit(totalCredit);
    }

    public void report(){
        System.out.println("User Name: " + getFirstName() +" "+ getLastName()
        + " " + " ID number: " + getIdNumber() + "   " + "Gpa: " + String.format("%.2f",getGpa()) +
                "  " + "Total Credit: " + getNumberOfCredit());

    }

    public boolean canGraduate(){
        if (getNumberOfCredit()>= 120 && getGpa() >= 2.0){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        // make three generic Users
        Student alicia = new User("Alicia", "Gallego");
        Student jess = new User("Jess", "Obs");
        Student mateo = new User("Mateo", "Monsalve");

        // starting report
        alicia.report();
        jess.report();
        mateo.report();

        // we randomly pull credit numbers and grades from these
        // arrays - this gives us reasonable testing data
        int[] credits = {1, 3, 3, 3, 3, 3, 3, 3, 4, 4};
        String[] grades = {"A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "F"};
        Random gen = new Random();

        // give them each 40 random classes
        for (int i = 0; i < 40; i++) {
            int creditIdx = gen.nextInt(credits.length);
            int gradeIdx = gen.nextInt(grades.length);
            jess.addCourse(credits[creditIdx], grades[gradeIdx]);

            creditIdx = gen.nextInt(credits.length);
            gradeIdx = gen.nextInt(grades.length);
            alicia.addCourse(credits[creditIdx], grades[gradeIdx]);

            creditIdx = gen.nextInt(credits.length);
            gradeIdx = gen.nextInt(grades.length);
            mateo.addCourse(credits[creditIdx], grades[gradeIdx]);
        }

        // print reports now
        System.out.println();
        alicia.report();
        jess.report();
        mateo.report();

        System.out.printf("Alicia %s graduate.\n", alicia.canGraduate() ? "can" : "CAN'T");
        System.out.printf("Jess %s graduate.\n", jess.canGraduate() ? "can" : "CAN'T");
        System.out.printf("Mateo %s graduate.\n", mateo.canGraduate() ? "can" : "CAN'T");
    }
 }

