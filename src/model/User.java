package model;

import bean.Book;
import java.util.ArrayList;
import java.util.List;

public abstract class User {

    private String userName;

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
        List<Book> bookList = LibraryRepository.findBookByAuthor(authorName);
        if (bookList == null) {
            System.out.println("Log: " + "沒有名為"+authorName+"此作者的書");
        } else {
            for (int i = 0; i < bookList.size(); i++) {
                System.out.println(showFormatResult(bookList.get(i)));
            }
        }
    }

    public void listSubject(String subjectName) {
        List<Book> bookList = LibraryRepository.findBookBySubject(subjectName);
        if (bookList == null) {
            System.out.println("Log: " + "沒有名為"+subjectName+"此作者的書");

        } else {
            for (int i = 0; i < bookList.size(); i++) {
                System.out.println(showFormatResult(bookList.get(i)));
            }
        }
    }

    public String showFormatResult(Book book) {
        return "ID: " + book.getBookId() + " Author: " + book.getAuthor() + " Subject: " + book.getSubject() + "";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
