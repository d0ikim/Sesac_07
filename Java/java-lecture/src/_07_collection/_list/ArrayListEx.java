package _07_collection._list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx {
    public static void main(String[] args) {
        List<Book> list = new ArrayList<>();

        list.add(new Book("title1","author1")); // 0
        list.add(new Book("title2","author2")); // 1
        list.add(new Book("title3","author3")); // 2
        list.add(new Book("title4","author4")); // 3
        list.add(new Book("title5","author5")); // 4
        System.out.println(list.toString());

        int size = list.size();
        System.out.printf("책은 총 %d 권이 있어요.\n", size);

        // index 3 번 요소 접근해서 얻어오기
        Book index3Book = list.get(3);
        System.out.println(index3Book); // Book{ title ='title4', author ='author4' }

        list.remove(3); // title4 삭제
        list.remove(3); // title5 삭제
        System.out.println("=== 삭제 후 출력 ===");
        for(Book b: list){
            System.out.println(b);
        }

        System.out.println("비어있나요? "+list.isEmpty());
        list.clear();   // 전부 비우기(삭제)
        System.out.println("삭제 후 비어있나요? "+list.isEmpty());
    }
}

class Book{
    private String title;
    private String author;

    public Book(String title, String author){
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString(){
        return "Book{ title ='"+title+"', author ='"+author+"' }";
    }
}