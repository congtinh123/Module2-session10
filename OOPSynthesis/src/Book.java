import java.util.Calendar;
import java.util.Scanner;

public class Book {
    private String id;
    private String title;
    private String author;
    private int year;
    private String description;
    private Category category;

    public Book() {}

    public Book(String id, String title, String author, int year, String description, Category category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.description = description;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void inputData(Scanner scanner, Category[] categories) {
        while (true) {
            System.out.print("Nhập mã sách (Bxxx): ");
            this.id = scanner.nextLine();
            if (id.matches("B\\d{3}")) {
                break;
            }
            System.out.println("Mã sách không hợp lệ!");
        }

        while (true) {
            System.out.print("Nhập tiêu đề sách (6-50 kí tự): ");
            this.title = scanner.nextLine();
            if (title.length() >= 6 && title.length() <= 50) {
                break;
            }
            System.out.println("Tiêu đề sách không hợp lệ!");
        }

        while (true) {
            System.out.print("Nhập tên tác giả: ");
            this.author = scanner.nextLine();
            if (!author.trim().isEmpty()) {
                break;
            }
            System.out.println("Tên tác giả không hợp lệ!");
        }

        while (true) {
            System.out.print("Nhập năm xuất bản (>=1970 và <=năm hiện tại): ");
            try {
                this.year = Integer.parseInt(scanner.nextLine());
                if (year >= 1970 && year <= Calendar.getInstance().get(Calendar.YEAR)) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Năm xuất bản không hợp lệ!");
            }
        }

        while (true) {
            System.out.print("Nhập mô tả sách: ");
            this.description = scanner.nextLine();
            if (!description.trim().isEmpty()) {
                break;
            }
            System.out.println("Mô tả sách không hợp lệ!");
        }

        System.out.println("Chọn mã thể loại từ danh sách:");
        for (Category category : categories) {
            if (category != null) {
                System.out.println(category.getId() + ": " + category.getName());
            }
        }

        while (true) {
            System.out.print("Nhập mã thể loại: ");
            try {
                int categoryId = Integer.parseInt(scanner.nextLine());
                for (Category category : categories) {
                    if (category != null && category.getId() == categoryId) {
                        this.category = category;
                        return;
                    }
                }
                System.out.println("Mã thể loại không hợp lệ!");
            } catch (NumberFormatException e) {
                System.out.println("Mã thể loại không hợp lệ!");
            }
        }
    }

    public void displayData() {
        System.out.println("Mã sách: " + id + ", Tiêu đề: " + title + ", Tác giả: " + author +
                ", Năm xuất bản: " + year + ", Thể loại: " + category.getName());
    }
}
