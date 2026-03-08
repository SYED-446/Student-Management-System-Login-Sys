import java.util.HashMap;

public class ExamService {
    HashMap<Integer, Integer> marks = new HashMap<>();

    public void addMarks(int studentId, int mark) {

        marks.put(studentId, mark);
        System.out.println("Marks Added Successfully");
    }

    public void viewResult(Student s) {

        if (!marks.containsKey(s.getId())) {
            System.out.println("Marks Not Found");
            return;
        }

        int mark = marks.get(s.getId());

        System.out.println("Student ID: " + s.getId());
        System.out.println("Name: " + s.getName());
        System.out.println("Marks: " + mark);

        if (mark >= 40) {
            System.out.println("Result: PASS");
        } else {
            System.out.println("Result: FAIL");
        }
    }

}
