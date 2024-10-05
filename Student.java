
package exx5;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Student extends Person {
    private float gpa;
    private String major;

    public Student(String id, String fullName, Date dateOfBirth, Date bookBorrowDate, Date bookReturnDate, float gpa, String major) {
        super(id, fullName, dateOfBirth, bookBorrowDate, bookReturnDate);
        this.gpa = gpa;
        this.major = major;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public void addPerson() {
        System.out.println("Adding new student: " + getFullName());
    }

    @Override
    public void updatePerson(String id) {
        if (this.getId().equals(id)) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Updating student: " + getFullName());
            
            System.out.print("Enter new full name: ");
            String newFullName = scanner.nextLine();
            this.setFullName(newFullName);

            System.out.print("Enter new date of birth (dd/MM/yyyy): ");
            String dobStr = scanner.nextLine();
            try {
                Date newDateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(dobStr);
                this.setDateOfBirth(newDateOfBirth);
            } catch (ParseException e) {
                System.out.println("Invalid date format.");
            }

            System.out.print("Enter new GPA: ");
            float newGpa = scanner.nextFloat();
            this.setGpa(newGpa);
            scanner.nextLine(); 

            System.out.print("Enter new Major: ");
            String newMajor = scanner.nextLine();
            this.setMajor(newMajor);

            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student ID not found.");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Student Info:");
        System.out.println("ID: " + getId());
        System.out.println("Full Name: " + getFullName());
        System.out.println("Date of Birth: " + getDateOfBirth());
        System.out.println("GPA: " + gpa);
        System.out.println("Major: " + major);
        System.out.println("Book Borrow Date: " + getBookBorrowDate());
        System.out.println("Book Return Date: " + getBookReturnDate());
        System.out.println("Book Overdue: " + (isBookOverdue() ? "Yes" : "No"));
    }
}