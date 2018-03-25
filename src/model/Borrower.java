package model;

import bean.Book;
import java.util.ArrayList;
import java.util.List;
import operation.IFindchecked;
import operation.LibException;

public class Borrower implements IFindchecked {

    private List<Book> bookList = new ArrayList<Book>();
    private String userName;//這個借閱人的名字
    private int predefinedBorrowBookNumber;//他最多能借的書的數量

    public Borrower(String userName, int predefinedBorrowBookNumber) {
        this.userName = userName;
        this.predefinedBorrowBookNumber = predefinedBorrowBookNumber;
    }

    public void addBook() {
        System.out.println("Borrower can not add book");
    }

    public void removeBook() {
        System.out.println("Borrower can not remove book");
    }

    public void checkout() {
        System.out.println("Borrower can not check out the books");
    }

    @Override
    public void findChecked(String userB) {//userB為被查的人，借閱人不能查別人，只能查自己
        if (!userB.equals(this.userName)) {//如果借閱人查別人
            System.out.println("Borrower can not find books checked out by other users");
        } else {//借閱人查自己
            bookList = LibraryRepository.findBookByBorrower(this.userName);
            for (int i = 0; i < bookList.size(); i++) {
                System.out.println(showFormatResult(i));
            }
        }
    }

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

    public void theReturnBook() {//還書
        System.out.println("Borrower can not return book");
    }

    public void findBorrower() {//查書被誰借走，借閱人不能使用此功能
        System.out.println("Borrower can not find borrower");
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

    public int getPredefinedBorrowBookNumber() {
        return predefinedBorrowBookNumber;
    }

    public void setPredefinedBorrowBookNumber(int predefinedBorrowBookNumber) {
        this.predefinedBorrowBookNumber = predefinedBorrowBookNumber;
    }
}
