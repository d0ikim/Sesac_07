package codingon.spring_boot_default.dto_vo;

class BookDTO{
    private String title;
    private String author;
    private int price;

    public BookDTO(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
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
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "제목: '" + title +
                ", 저자: '" + author +
                ", 가격: " + price + "원";
    }
}

class BookMain{
    public static void main(String[] args) {
        BookDTO b1 = new BookDTO("Effective Java","Joshua Bloch",35000);
        BookDTO b2 = new BookDTO("Clean code","Robert C. Martin",45000);

        System.out.println(b1);
        System.out.println(b2);
    }
}

public class DTOPractice {}
