public class Teacher {
  private int teacherId;
  private String name;

  public Teacher(int teacherId, String name) {
      this.teacherId = teacherId;
      this.name = name;
  }

  public int getTeacherId() {
      return teacherId;
  }

  public String getName() {
      return name;
  }

  @Override
  public String toString() {
      return "Teacher{id=" + teacherId + ", name='" + name + "'}";
  }
}
