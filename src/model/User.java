package model;

import bean.Book;
import java.util.ArrayList;
import java.util.List;

public abstract class User {

    private String userName;
    private List<Book> bookList = new ArrayList<Book>();

    public User(String userName) {
        this.userName = userName;
    }

    public abstract void addBook(Book book);

    public abstract void removeBook(int bookId);

    public abstract void checkout(User thisUser, ArrayList<Integer> bookNumberList);

    public abstract void theReturnBook(int bookId);

    public abstract void findBorrower(int bookId);

    public abstract void findChecked(User thisUser);

    public void listAuthor(String authorName) {
        bookList = LibraryRepository.findBookByAuthor(authorName);
        try {
            for (int i = 0; i < bookList.size(); i++) {
                System.out.println(showFormatResult(i));
            }
        } catch (NullPointerException e) {//如果為空就不動作

        }
    }

    public void listSubject(String subjectName) {
        bookList = LibraryRepository.findBookBySubject(subjectName);
        try {

            for (int i = 0; i < bookList.size(); i++) {
                System.out.println(showFormatResult(i));
            }
        } catch (NullPointerException e) {//如果為空就不動作

        }
    }

    public String showFormatResult(int i) {
        return "ID: " + bookList.get(i).getBookId() + " Author: " + bookList.get(i).getAuthor() + " Subject: " + bookList.get(i).getSubject() + "";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
