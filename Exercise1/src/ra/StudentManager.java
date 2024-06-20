package ra;

public class StudentManager {

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        manager.startApplication();
    }

    public void startApplication() {
        // Initialize students
        Student student1 = new Student("Nguyễn Văn Nam", 19, "HN");
        Student student2 = new Student("Trần Thùy Trang", 18, "TH");
        Student student3 = new Student("Tống Mạnh Hùng", 18, "ND");

        // Display student information
        displayStudentInformation(student1);
        displayStudentInformation(student2);
        displayStudentInformation(student3);
    }

    private void displayStudentInformation(Student student) {
        System.out.println("------------------------------------------");
        System.out.println("     Thông tin Sinh Viên");
        System.out.println("Tên Sinh Viên : " + student.getName());
        System.out.println("Tuổi          : " + student.getAge());
        System.out.println("Địa chỉ       : " + student.getAddress());
    }
}

class Student {

    private String name;
    private int age;
    private String address;

    public Student() {
    }

    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
