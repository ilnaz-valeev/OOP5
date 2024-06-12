import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
    private List<Student> students;
    private Teacher teacher;
    private StudyGroupService studyGroupService;

    public Controller() {
        this.students = new ArrayList<>();
        this.studyGroupService = new StudyGroupService();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Integer> getStudentIds() {
        List<Integer> studentIds = new ArrayList<>();
        for (Student student : students) {
            studentIds.add(student.getStudentId());
        }
        return studentIds;
    }

    public Integer getTeacherId() {
        return teacher != null ? teacher.getTeacherId() : null;
    }

    public StudyGroup createStudyGroup() {
        if (teacher == null || students.isEmpty()) {
            throw new IllegalArgumentException("Teacher or students are not defined");
        }
        return studyGroupService.createStudyGroup(teacher, students);
    }

    public static void main(String[] args) {
        
        Teacher teacher = new Teacher(1, "Dr. Smith");
        List<Student> students = Arrays.asList(
                new Student(1, "John Doe"),
                new Student(2, "Jane Doe")
        );

        Controller controller = new Controller();
        controller.setTeacher(teacher);
        for (Student student : students) {
            controller.addStudent(student);
        }

        StudyGroup studyGroup = controller.createStudyGroup();
        System.out.println(studyGroup);
    }
}
