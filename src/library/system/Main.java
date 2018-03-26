package library.system;

import bean.Book;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import model.*;

public class Main {

    static ArrayList<Book> books = new ArrayList<Book>();
    static ArrayList<User> users = new ArrayList<User>();
    static Queue<String> commandList = new LinkedList<String>();

    public static void main(String[] args) {
//        String path = "";
//        path = "" + InputHandler.class.getClassLoader().getResource("");
//        
//        path = path.substring(6) + "sampleInput";
//        System.out.println(path);
        InputHandler inputHandler = new InputHandler("/Users/xanxus/Desktop/NTOU_WorkShop_LibSys/file/sampleInput");
        String content = inputHandler.getInputByFile();

        final String[] splittedStr = content.split("\n");
        for (String s : splittedStr) {
            commandList.add(s);

        }
        createBookByCommand();
        createUserByCommand();
        getBehaviorByCommand();
    }

    public static void createBookByCommand() {
        User staff = new Staff("test");
        for (int i = 0; i < commandList.size(); i++) {
            String currentCmd = commandList.poll();
            if (currentCmd.matches("\\d")) {
                int bookNum = Integer.parseInt(currentCmd);
                for (int j = 0; j < bookNum; j++) {
                    Book book1 = new Book();
                    String[] s = commandList.poll().split(" ");
                    String bookAuthor = s[0];
                    String bookSubject = s[1];
                    book1.setAuthor(bookAuthor);
                    book1.setSubject(bookSubject);
                    books.add(book1);
                    staff.addBook(book1);
                }
                return;
            }
        }
    }

    public static void createUserByCommand() {
        for (int i = 0; i < commandList.size(); i++) {
            String currentCmd = commandList.poll();
            if (currentCmd.matches("\\d")) {
                int userNum = Integer.parseInt(currentCmd);
                for (int j = 0; j < userNum; j++) {
                    String[] s = commandList.poll().split(" ");
                    User user;
                    if (s.length == 2) { //2表示是員工
                        user = new Staff(s[1]); //s[1]為員工名字
                    } else { //不然就是借閱人
                        user = new Borrower(s[1], Integer.parseInt(s[2])); //s[1]為借閱人名字、s[2]為此借閱人最多可借的書數量
                    }
                    users.add(user); //將此使用者存入ArrayList<User>這個容器
                }
                return;
            }
        }
    }

    public static void getBehaviorByCommand() {
        while (!commandList.isEmpty()) {
            String currentCmd = commandList.poll();
            String[] s = currentCmd.split(" ");
            String userName = s[0];
            if (currentCmd.contains("addBook")) {
                currentCmd = commandList.poll();
                String[] bookInfo = currentCmd.split(" ");
                String bookAuthor = bookInfo[0];
                String bookSubject = bookInfo[1];
                Book book = new Book();
                book.setAuthor(bookAuthor);
                book.setSubject(bookSubject);
                findUser(userName).addBook(book);
            } else if (currentCmd.contains("removeBook")) {
                int bookId = Integer.parseInt(s[2]);
                findUser(userName).removeBook(bookId);
            } else if (currentCmd.contains("checkout")) {
                String borrower = s[2];
                currentCmd = commandList.poll();
                String[] bookId = currentCmd.split(" ");
                ArrayList<Integer> bookIdList = new ArrayList<Integer>();
                for (int i = 0; i < bookId.length; i++) {
                    bookIdList.add(Integer.parseInt(bookId[i]));
                }
                findUser(userName).checkout(findUser(borrower), bookIdList);
            } else if (currentCmd.contains("return")) {
                int bookId = Integer.parseInt(s[2]);
                findUser(userName).theReturnBook(bookId);
            } else if (currentCmd.contains("listAuthor")) {
                String author = s[2];
                findUser(userName).listAuthor(author);
            } else if (currentCmd.contains("listSubject")) {
                String subject = s[2];
                findUser(userName).listSubject(subject);
            } else if (currentCmd.contains("findChecked")) {
                String borrower = s[2];
                findUser(userName).findChecked(findUser(borrower));
            } else if (currentCmd.contains("findBorrower")) {
                int bookId = Integer.parseInt(s[2]);
                findUser(userName).findBorrower(bookId);
            }
        }
    }

    public static User findUser(String userName) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserName().equals(userName)) {
                return users.get(i);
            }
        }
        return null;
    }
}
