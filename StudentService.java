import java.util.HashMap;

public class StudentService {
    HashMap<Integer, Student> students = new HashMap<>();

    public void addStudent(Student s) {
        students.put(s.getId(), s);
        System.out.println("Student Added Successfully");
    }

    public void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No Students Found");
            return;
        }

        System.out.println("----- Student List -----");

        for (Student s : students.values()) {

            System.out.println(
                    "ID: " + s.getId() +
                    " Name: " + s.getName() +
                    " Course: " + s.getCourse());
        }
    }

    public Student searchStudent(int id) {

        if (students.containsKey(id)) {
            return students.get(id);
        }

        return null;
    }

    public void deleteStudent(int id) {

        if (students.containsKey(id)) {
            students.remove(id);
            System.out.println("Student Removed Successfully");
        } else {
            System.out.println("Student Not Found");
        }
    }
}
