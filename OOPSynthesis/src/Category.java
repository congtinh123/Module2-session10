import java.util.Scanner;

public class Category {
    private static int idCounter = 1;
    private int id;
    private String name;
    private boolean status;

    public Category() {
        this.id = idCounter++;
    }

    public Category(String name, boolean status) {
        this.id = idCounter++;
        this.name = name;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputData(Scanner scanner) {
        while (true) {
            System.out.print("Nhập tên thể loại (6-30 kí tự): ");
            this.name = scanner.nextLine();
            if (name.length() >= 6 && name.length() <= 30) {
                break;
            }
            System.out.println("Tên thể loại không hợp lệ!");
            break;
        }

        while (true) {
            System.out.print("Nhập trạng thái thể loại (true/false): ");
            try {
                this.status = Boolean.parseBoolean(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Trạng thái không hợp lệ!");
            }
            break;
        }
    }

    public void displayData() {
        System.out.println("Mã thể loại: " + id + ", Tên: " + name + ", Trạng thái: " + (status ? "Hoạt động" : "Không hoạt động"));
    }
}
