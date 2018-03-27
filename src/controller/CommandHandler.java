package controller;

import bean.Book;
import model.Borrower;
import model.Staff;
import model.User;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CommandHandler {
    private ArrayList<Book> books;
    private ArrayList<User> users;
    private Queue<String> commandList;

    public CommandHandler(Queue<String> commandList){
        books = new ArrayList<Book>();
        users = new ArrayList<User>();
        this.commandList = commandList;
        createBookByCommand();
        createUserByCommand();
    }

    public void createBookByCommand() {
        User staff = new Staff("test");
        for (int i = 0; i < commandList.size(); i++) {
            String currentCmd = commandList.poll();
            if (currentCmd.matches("\\d")) {
                int bookNum = Integer.parseInt(currentCmd);
                for (int j = 0; j < bookNum; j++) {
                    Book book1 = new Book();
                    String[] s = commandList.poll().split("\\s+");
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

    public void createUserByCommand() {
        for (int i = 0; i < commandList.size(); i++) {
            String currentCmd = commandList.poll();
            if (currentCmd.matches("\\d")) {
                int userNum = Integer.parseInt(currentCmd);
                for (int j = 0; j < userNum; j++) {
                    String[] s = commandList.poll().split("\\s+");
                    User user;
                    if (s.length == 2) {
                        user = new Staff(s[1]);
                    } else {
                        user = new Borrower(s[1], Integer.parseInt(s[2])); //s[1]為借閱人名字、s[2]為此借閱人最多可借的書數量
                    }
                    users.add(user); //將此使用者存入ArrayList<User>這個容器
                }
                return;
            }
        }
    }

    public void runBehaviorByCommand(){
        while (!commandList.isEmpty()){
            String currentCmd = commandList.poll();
            String[] s = currentCmd.split("\\s+");
            String userName = s[0];
            User commander = findUser(userName);
            if(commander == null) continue;
            if(currentCmd.contains("addBook")){
                currentCmd = commandList.poll();
                String[] bookInfo = currentCmd.split("\\s+");
                String bookAuthor = bookInfo[0];
                String bookSubject = bookInfo[1];
                Book book = new Book();
                book.setAuthor(bookAuthor);
                book.setSubject(bookSubject);
                commander.addBook(book);
            }else if(currentCmd.contains("removeBook")){
                int bookId = Integer.parseInt(s[2]);
                commander.removeBook(bookId);
            }else if(currentCmd.contains("checkout")){
                String borrower = s[2];
                currentCmd = commandList.poll();
                String[] bookId = currentCmd.split("\\s+");
                ArrayList<Integer> bookIdList = new ArrayList<Integer>();
                for(int i = 0;i< bookId.length;i++){
                    bookIdList.add(Integer.parseInt(bookId[i]));
                }
                if(findUser(borrower) !=null) {
                    commander.checkout(findUser(borrower), bookIdList);
                }
            }else if(currentCmd.contains("return")){
                int bookId = Integer.parseInt(s[2]);
                commander.theReturnBook(bookId);
            }else if(currentCmd.contains("listAuthor")){
                String author = s[2];
                commander.listAuthor(author);
            }else if(currentCmd.contains("listSubject")){
                String subject = s[2];
                commander.listSubject(subject);
            }else if(currentCmd.contains("findChecked")){
                String borrower = s[2];
                if(findUser(borrower) !=null) {
                    commander.findChecked(findUser(borrower));
                }
            }else if(currentCmd.contains("findBorrower")){
                int bookId = Integer.parseInt(s[2]);
                commander.findBorrower(bookId);
            }
        }
    }

    public User findUser(String userName){
        for(int i=0;i<users.size();i++){
            if(users.get(i).getUserName().equals(userName)){
                return users.get(i);
            }
        }
        return null;
    }
}