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
        newBook.add(book0);
        
        Book book1 = new Book();
        book1.setAuthor("馬上斌");
        book1.setSubject("Java");
        newBook.add(book1);
        
        for(int i = 0 ;i<newBook.size() ; i++){
            s.addBook(newBook.get(i));
        }
        
        Book book2 = new Book();
        book2.setAuthor("郭忠義");
        book2.setSubject("python");
        s.addBook(book2);
        
        s.listAuthor("馬上斌");
        s.removeBook(1);
        
        s.listAuthor("馬上斌");//沒印出 OK!
        s.listAuthor("戴碩宏");
        s.listAuthor("郭忠義");
        System.out.println("----------");
//        
        checkoutBookNumber = new ArrayList<Integer>(); 
        checkoutBookNumber.add(0);
        checkoutBookNumber.add(2);
        s.checkout(b.getUserName(), checkoutBookNumber, b.getPredefinedBorrowBookNumber());//OK!有借出兩本書
        s.findChecked("userB");//OK，有兩本書
        System.out.println("---------");
        
        s.theReturnBook(0);
        s.findChecked("userB");//OK!!只有一本書，且是編號2、郭忠義
        System.out.println("----------");
        
        s.listAuthor("戴碩宏");//測試以作者找書。OK!!
        System.out.println("----------");
        s.listSubject("Lua");//測試以主題找書。OK!!
        System.out.println("----------");
        s.findChecked(b.getUserName());//測試 查詢此借閱人借了哪些書。OK!!
        System.out.println("----------");
        s.findBorrower(2);//測試 查詢此編號的書被誰借走。
    }
    
}