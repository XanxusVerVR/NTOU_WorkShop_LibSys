package library.system;

import bean.Book;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import model.*;

public class Main {
    static ArrayList<Book> newBook;
    static ArrayList<Integer> checkoutBookNumber;
//    static ArrayList<Book> book = new ArrayList<Book>();
//    static Queue<String> commandList = new LinkedList<String>();
//    static ArrayList<Staff> staff = new ArrayList<Staff>();
//    static ArrayList<Borrower> brrower = new ArrayList<Borrower>();
    public static void main(String[] args) {
//        String path = "";
//        path = ""+ InputHandler.class.getClassLoader().getResource("");
//        path = path.substring(6)+"sampleInput";
//        InputHandler inputHandler = new InputHandler(path);
//        String content = inputHandler.getInputByFile();
//
//        final String[] splittedStr = content.split("\n");
//        for (String s : splittedStr) {
//            commandList.add(s);
//
//        }
//        getBookByCommand();
//        getUserByCommand();
//        getBehaviorByCommand();


        newBook = new ArrayList<Book>();

        User s = new Staff("userA");
        User b = new Borrower("userB",2);//借閱人名字叫userB,最多能借2本
        User b2 = new Borrower("userC",3);//借閱人名字叫userB,最多能借2本
        
        Book book0 = new Book();
        book0.setAuthor("戴碩宏");
        book0.setSubject("Lua");
//        book0.setIsCheck(true);
        newBook.add(book0);
//
        Book book1 = new Book();
        book1.setAuthor("馬尚彬");
        book1.setSubject("Java");
        newBook.add(book1);
//
        for(int i = 0 ;i<newBook.size() ; i++){
            s.addBook(newBook.get(i));
        }
//
        Book book2 = new Book();
        book2.setAuthor("馬英九");
        book2.setSubject("商業理財");
        s.addBook(book2);
//        
        Book book3 = new Book();
        book3.setAuthor("郭忠義");
        book3.setSubject("心理勵志");
        s.addBook(book3);
//
        s.listAuthor("馬尚彬");
        System.out.println("-----remove-----");
        s.removeBook(0);
        System.out.println("----------");
        s.listAuthor("戴碩宏");
        s.listAuthor("馬尚彬");
        s.listAuthor("馬英九");
        s.listAuthor("郭忠義");
//        System.out.println("----------");

//        checkoutBookNumber = new ArrayList<Integer>();
//        checkoutBookNumber.add(0);
//        checkoutBookNumber.add(2);
//        s.checkout(b, checkoutBookNumber);//OK!有借出兩本書
////        s.checkout(s, checkoutBookNumber);
//        s.findChecked(b);//OK，有兩本書
//        System.out.println("---------");
//        
//        System.out.println("歸還：");
//        s.theReturnBook(0);
//        s.findChecked(b);//OK!!只有一本書，且是編號2、馬英九
//        System.out.println("----------");
////
//        s.listAuthor("戴碩宏");//測試以作者找書。OK!!
//        System.out.println("----------");
//        s.listSubject("心理勵志");//測試以主題找書。OK!!
//        System.out.println("----------");
//        s.findChecked(b);//測試 查詢此借閱人借了哪些書。OK!!
//        System.out.println("----------");
//        s.findBorrower(2);//測試 查詢此編號的書被誰借走。
//        
//        
//        System.out.println("------");
//        b.findChecked(b);//測試通過，可以查自己
//        b.findChecked(b2);//測試通過，不可查別人
//        System.out.println("------");
//        b.findBorrower(0);//測試通過，借閱人不能操作此功能
//        System.out.println("------");
//        s.findChecked(s);
        
        
    }

//    public static void getBookByCommand() {
//        for (int i = 0; i < commandList.size(); i++) {
//            String currentCmd = commandList.poll();
//            if (currentCmd.matches("\\d")) {
//                int bookNum = Integer.parseInt(currentCmd);
//                for (int j = 0; j < bookNum; j++) {
//                    Book book1 = new Book();
//                    String[] s = commandList.poll().split(" ");
//                    String bookAuthor = s[0];
//                    String bookSubject = s[1];
//                    
//                    book1.setAuthor(bookAuthor);
//                    book1.setSubject(bookSubject);
//                    book.add(book1);
//                    System.out.println(bookAuthor + "," + bookSubject);
//                }
//                return;
//            }
//        }
//    }
//
//    public static void getUserByCommand() {
//        for (int i = 0; i < commandList.size(); i++) {
//            String currentCmd = commandList.poll();
//            if (currentCmd.matches("\\d")) {
//                int userNum = Integer.parseInt(currentCmd);
//                for (int j = 0; j < userNum; j++) {
//                    String[] s = commandList.poll().split(" ");
//                    String userType = s[0];
//                    String userName = s[1];
//                    System.out.println(userType + "," + userName);
//                }
//                return;
//            }
//        }
//    }
//
//    public static void getBehaviorByCommand() {
//        while (!commandList.isEmpty()) {
//            String currentCmd = commandList.poll();
//            if (currentCmd.contains("addBook")) {
//
//            } else if (currentCmd.contains("addBook")) {
//
//            } else if (currentCmd.contains("removeBook")) {
//
//            } else if (currentCmd.contains("checkout")) {
//
//            } else if (currentCmd.contains("return")) {
//
//            } else if (currentCmd.contains("listAuthor")) {
//
//            } else if (currentCmd.contains("listSubject")) {
//
//            } else if (currentCmd.contains("listSubject")) {
//
//            } else if (currentCmd.contains("findBorrower")) {
//
//            }
//        }
//    }
}
