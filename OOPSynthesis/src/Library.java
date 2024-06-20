import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Library {
    private Category[] categories = new Category[10];
    private Book[] books = new Book[10];
    private int categoryCount = 0;
    private int bookCount = 0;
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("===== QUẢN LÝ THƯ VIỆN =====");
            System.out.println("1. Quản lý Thể loại");
            System.out.println("2. Quản lý Sách");
            System.out.println("3. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    manageCategory();
                    break;
                case 2:
                    manageBook();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Chức năng không hợp lệ!");
            }
        }
    }

    private void manageCategory() {
        while (true) {
            System.out.println("===== QUẢN LÝ THỂ LOẠI =====");
            System.out.println("1. Thêm mới thể loại");
            System.out.println("2. Hiển thị danh sách theo tên thể loại A – Z");
            System.out.println("3. Thống kê thể loại và số sách có trong mỗi thể loại");
            System.out.println("4. Cập nhật thể loại");
            System.out.println("5. Xóa thể loại");
            System.out.println("6. Quay lại");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addCategory();
                    break;
                case 2:
                    displayCategories();
                    break;
                case 3:
                    statisticsCategory();
                    break;
                case 4:
                    updateCategory();
                    break;
                case 5:
                    deleteCategory();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Chức năng không hợp lệ!");
            }
        }
    }

    private void manageBook() {
        while (true) {
            System.out.println("===== QUẢN LÝ SÁCH =====");
            System.out.println("1. Thêm mới sách");
            System.out.println("2. Cập nhật thông tin sách");
            System.out.println("3. Xóa sách");
            System.out.println("4. Tìm kiếm sách");
            System.out.println("5. Hiển thị danh sách sách theo nhóm thể loại");
            System.out.println("6. Quay lại");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    updateBook();
                    break;
                case 3:
                    deleteBook();
                    break;
                case 4:
                    searchBooks();
                    break;
                case 5:
                    displayBooksByCategory();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Chức năng không hợp lệ!");
            }
        }
    }

    private void addCategory() {
        if (categoryCount >= categories.length) {
            System.out.println("Không thể thêm thể loại mới. Danh sách thể loại đã đầy.");
            return;
        }
        Category category = new Category();
        category.inputData(scanner);
        categories[categoryCount++] = category;
        System.out.println("Thêm thể loại thành công!");
    }

    private void displayCategories() {
        Arrays.sort(categories, 0, categoryCount, Comparator.comparing(Category::getName));
        for (int i = 0; i < categoryCount; i++) {
            categories[i].displayData();
        }
    }

    private void statisticsCategory() {
        for (int i = 0; i < categoryCount; i++) {
            Category category = categories[i];
            long count = Arrays.stream(books, 0, bookCount).filter(book -> book.getCategory().getId() == category.getId()).count();
            System.out.println("Thể loại: " + category.getName() + ", Số sách: " + count);
        }
    }

    private void updateCategory() {
        System.out.print("Nhập mã thể loại cần cập nhật: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < categoryCount; i++) {
            if (categories[i].getId() == id) {
                categories[i].inputData(scanner);
                System.out.println("Cập nhật thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy thể loại!");
    }

    private void deleteCategory() {
        System.out.print("Nhập mã thể loại cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < categoryCount; i++) {
            if (categories[i].getId() == id) {
                boolean hasBooks = Arrays.stream(books, 0, bookCount).anyMatch(book -> book.getCategory().getId() == id);
                if (hasBooks) {
                    System.out.println("Thể loại đang có sách, không thể xóa!");
                } else {
                    for (int j = i; j < categoryCount - 1; j++) {
                        categories[j] = categories[j + 1];
                    }
                    categories[--categoryCount] = null;
                    System.out.println("Xóa thành công!");
                }
                return;
            }
        }
        System.out.println("Không tìm thấy thể loại!");
    }

    private void addBook() {
        if (categoryCount == 0) {
            System.out.println("Kho sách rỗng.Vui lòng thêm sách mới vào!");
            return;
        }
        if (bookCount >= books.length) {
            System.out.println("Không thể thêm sách mới. Danh sách sách đã đầy.");
            return;
        }
        Book book = new Book();
        book.inputData(scanner, categories);
        books[bookCount++] = book;
        System.out.println("Thêm sách thành công!");
    }

    private void updateBook() {
        System.out.print("Nhập mã sách cần cập nhật: ");
        String id = scanner.nextLine();
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getId().equals(id)) {
                books[i].inputData(scanner, categories);
                System.out.println("Cập nhật sách thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sách!");
    }

    private void deleteBook() {
        System.out.print("Nhập mã sách cần xóa: ");
        String id = scanner.nextLine();
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getId().equals(id)) {
                for (int j = i; j < bookCount - 1; j++) {
                    books[j] = books[j + 1];
                }
                books[--bookCount] = null;
                System.out.println("Xóa sách thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sách!");
    }

    private void searchBooks() {
        System.out.print("Nhập từ khóa tìm kiếm: ");
        String keyword = scanner.nextLine().toLowerCase();
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().toLowerCase().contains(keyword) || books[i].getAuthor().toLowerCase().contains(keyword)) {
                books[i].displayData();
            }
        }
    }

    private void displayBooksByCategory() {
        for (int i = 0; i < categoryCount; i++) {
            System.out.println("Thể loại: " + categories[i].getName());
            for (int j = 0; j < bookCount; j++) {
                if (books[j].getCategory().getId() == categories[i].getId()) {
                    books[j].displayData();
                }
            }
        }
    }
}
