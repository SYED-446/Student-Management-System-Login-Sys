import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    @SuppressWarnings("null")
    public static void main(String[] args) {

        LoginService loginService = new LoginService();

        boolean loginSuccess = loginService.login();

        if (!loginSuccess) {
            return;
        }

        Scanner sc = new Scanner(System.in);

        StudentService studentService = new StudentService();
        ExamService examServie = new ExamService();

        while (true) {

            System.out.println("\n===== STUDENT EXAM SYSTEM =====");

            System.out.println("1 Add Student");
            System.out.println("2 View Students");
            System.out.println("3 Conduct Test");
            System.out.println("4 View Result");
            System.out.println("5 Search Student");
            System.out.println("6 Delete Student");
            System.out.println("7 Exit");

            System.out.print("Enter Choice: ");

            try {

                int choice = sc.nextInt();

                ExamService examService = new ExamService();
                switch (choice) {

                    case 1:

                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();

                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Course: ");
                        String course = sc.nextLine();

                        Student s = new Student(id, name, course);

                        studentService.addStudent(s);

                        break;

                    case 2:

                        studentService.viewStudents();

                        break;

                    case 3:

                        System.out.print("Enter Student ID: ");
                        int sid = sc.nextInt();

                        System.out.print("Enter Marks: ");
                        int marks = sc.nextInt();

                        examService.addMarks(sid, marks);

                        break;

                    case 4:

                        System.out.print("Enter Student ID: ");
                        int rid = sc.nextInt();

                        Student st = studentService.searchStudent(rid);

                        if (st != null) {
                            examService.viewResult(st);
                        } else {
                            System.out.println("Student Not Found");
                        }

                        break;

                    case 5:

                        System.out.print("Enter Student ID: ");
                        int searchId = sc.nextInt();

                        Student found = studentService.searchStudent(searchId);

                        if (found != null) {

                            System.out.println("Student Found");

                            System.out.println("Name: " + found.getName());
                            System.out.println("Course: " + found.getCourse());
                        }

                        else {

                            System.out.println("Student Not Found");
                        }

                        break;

                    case 6:

                        System.out.print("Enter Student ID: ");
                        int deleteId = sc.nextInt();

                        studentService.deleteStudent(deleteId);

                        break;

                    case 7:

                        System.out.println("Thank You");

                        System.exit(0);

                    default:

                        System.out.println("Invalid Choice");

                }

            }

            catch (InputMismatchException e) {

                System.out.println("Invalid Input! Enter Numbers Only");

                sc.nextLine();
            }

        }

}
}
