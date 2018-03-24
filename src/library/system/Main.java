package library.system;

import bean.Book;
import java.util.ArrayList;
import model.*;

public class Main {
    static ArrayList<Book> newBook;
    static ArrayList<Integer> checkoutBookNumber;
    public static void main(String[] args) {
        newBook = new ArrayList<Book>();
        
        Staff s = new Staff("userA");
        Borrower b = new Borrower("userB",2);//借閱人名字叫userB,最多能借2本
        
        Book book0 = new Book();
        book0.setAuthor("戴碩宏");
        book0.setSubject("Lua");
        book0.setIsCheck(false);
        newBook.add(book0);
        
        Book book1 = new Book();
        book1.setAuthor("馬上斌");
        book1.setSubject("Java");
        book1.setIsCheck(false);
        newBook.add(book1);
        
        for(int i = 0 ;i<newBook.size() ; i++){
            s.addBook(newBook.get(i));
        }
        
        Book book2 = new Book();
        book2.setAuthor("郭忠義");
        book2.setSubject("python");
        book2.setIsCheck(false);
        s.addBook(book2);
        
        s.listAuthor("戴碩宏");
        s.removeBook(1);
        
        s.listAuthor("馬上斌");
        s.listAuthor("郭忠義");
        
        
        checkoutBookNumber = new ArrayList<Integer>(); 
        checkoutBookNumber.add(0);
        checkoutBookNumber.add(2);
        s.checkout(b.getUserName(), checkoutBookNumber, b.getPredefinedBorrowBookNumber());//有問題
        s.theReturnBook(0);//有問題
        
        
//        s.findChecked("userB");
//        
//        
//        
//        System.out.println(b.testClassName());
//        b.findChecked("userA");
//        ArrayList<Integer> bookNumber = new ArrayList<Integer>();//存放要借哪幾本書
//        bookNumber.add(1);
//        bookNumber.add(3);
//        s.checkout(b.getUserName(),bookNumber,b.getPredefinedBorrowBookNumber());
    }
    
}