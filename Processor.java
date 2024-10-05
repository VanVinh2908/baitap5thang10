
package exx5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Processor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PersonList personList = new PersonList();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add new student");
            System.out.println("2. Add new teacher");
            System.out.println("3. Update person by id");
            System.out.println("4. Delete person by id");
            System.out.println("5. Display all students and teachers");
            System.out.println("6. Find the student with the highest GPA");
            System.out.println("7. Find teachers by department");
            System.out.println("8. Notify whether the book's return due date has arrived or not");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                  
                    try {
                        System.out.print("Enter ID: ");
                        String studentId = scanner.nextLine();
                        System.out.print("Enter Full Name: ");
                        String studentName = scanner.nextLine();
                        System.out.print("Enter Date of Birth (dd/MM/yyyy): ");
                        Date studentDob = dateFormat.parse(scanner.nextLine());
                        System.out.print("Enter Book Borrow Date (dd/MM/yyyy): ");
                        Date studentBorrowDate = dateFormat.parse(scanner.nextLine());
                        System.out.print("Enter Book Return Date (dd/MM/yyyy): ");
                        Date studentReturnDate = dateFormat.parse(scanner.nextLine());
                        System.out.print("Enter GPA: ");
                        float studentGpa = scanner.nextFloat();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter Major: ");
                        String studentMajor = scanner.nextLine();

                        personList.addStudent(studentId, studentName, studentDob, studentBorrowDate, studentReturnDate, studentGpa, studentMajor);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please enter in dd/MM/yyyy.");
                    }
                    break;

                case 2:
                   
                    try {
                        System.out.print("Enter ID: ");
                        String teacherId = scanner.nextLine();
                        System.out.print("Enter full name: ");
                        String teacherName = scanner.nextLine();
                        System.out.print("Enter date of birth (dd/MM/yyyy): ");
                        Date teacherDob = dateFormat.parse(scanner.nextLine());
                        System.out.print("Enter book borrow date (dd/MM/yyyy): ");
                        Date teacherBorrowDate = dateFormat.parse(scanner.nextLine());
                        System.out.print("Enter book return date (dd/MM/yyyy): ");
                        Date teacherReturnDate = dateFormat.parse(scanner.nextLine());
                        System.out.print("Enter department: ");
                        String teacherDepartment = scanner.nextLine();
                        System.out.print("Enter Teaching subject: ");
                        String teacherSubject = scanner.nextLine();

                        personList.addTeacher(teacherId, teacherName, teacherDob, teacherBorrowDate, teacherReturnDate, teacherDepartment, teacherSubject);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please enter in dd/MM/yyyy.");
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    String updateId = scanner.nextLine();
                    personList.updatePersonById(updateId);
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    String deleteId = scanner.nextLine();
                    personList.deletePersonById(deleteId);
                    break;

                case 5:
                    personList.displayEveryone();
                    break;

                case 6:
                    
                    Student topStudent = personList.findTopStudent();
                    if (topStudent != null) {
                        System.out.println("Top Student:");
                        topStudent.displayInfo();
                    } else {
                        System.out.println("No students found.");
                    }
                    break;

                case 7:
                    System.out.print("Enter department: ");
                    String department = scanner.nextLine();
                    personList.findTeachersByDepartment(department);
                    break;

                case 8:
                
                    System.out.print("Enter ID to check book status: ");
                    String checkId = scanner.nextLine();
                    personList.checkBookBorrowing(checkId);
                    break;

                case 9:
                  
                    System.out.println("Exit");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}