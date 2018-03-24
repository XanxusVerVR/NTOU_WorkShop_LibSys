package model;

import bean.Book;
import java.util.ArrayList;
import java.util.List;
import operation.IFindchecked;

public class Staff implements IFindchecked {

    Book book;
    private List<Book> bookList = new ArrayList<Book>();
    private String userName;

    public Staff() {

    }

    public Staff(String userName) {
        this.userName = userName;
    }

    public void addBook(Book book) {
        LibraryRepository.addBookToList(book);
    }

    public void removeBook(int bookId) {
        book = new Book();
        book.setBookId(bookId);
        LibraryRepository.romoveBookByList(book);
    }

    public void checkout(String user, int[] bookNumberList) {
        book = new Book();
        book.setBorrower(user);
        for (int i = 0; i < bookNumberList.length; i++) {
            book.setBookId(bookNumberList[i]);
        }
        LibraryRepository.checkoutBook(book);
    }

    public void theReturnBook(int bookId) {
        book = new Book();
        book.setBookId(bookId);
        LibraryRepository.returnBook(book);
    }

    public void listAuthor(String authorName) {
        bookList = LibraryRepository.findBookByAuthor(authorName);
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println(showFormatResult(i));
        }
    }

    public void listSubject(String subjectName) {
        bookList = LibraryRepository.findBookBySubject(subjectName);
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println(showFormatResult(i));
        }
    }

    @Override
    public void findChecked(String userA) {//員工查看借閱人借了哪些書
        bookList = LibraryRepository.findBookByBorrower(userA);
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println(showFormatResult(i));
        }
    }

    public void findBorrower(int bookId) {
        String checkoutUserB = LibraryRepository.findBorrower(bookId);
        System.out.println(checkoutUserB);
    }

    public String showFormatResult(int i) {
        return "ID: " + bookList.get(i).getBookId() + " Author: " + bookList.get(i).getAuthor() + " Subject: " + bookList.get(i).getSubject() + "";
    }

}
