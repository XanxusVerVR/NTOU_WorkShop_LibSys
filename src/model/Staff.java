package model;

import bean.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import operation.IFindchecked;
import operation.LibException;

public class Staff implements IFindchecked {

    Book book;
    private List<Book> bookList = new ArrayList<Book>();
    private String userName;

    public Staff(String userName) {
        this.userName = userName;
    }

    public void addBook(Book book) {
        LibraryRepository.addBookToList(book);
    }

    public void removeBook(int bookId) {
        book = LibraryRepository.findBookById(bookId);
        LibraryRepository.romoveBookByList(book);
    }

    public void checkout(String user, ArrayList<Integer> bookNumberList,int theBorrowerPredefinedBorrowBookNumber) {//員工把書借給借閱人
        try{
            checkLimitationNumber(bookNumberList.size(),theBorrowerPredefinedBorrowBookNumber);//確認要借給借閱人的書數量低於上限
        }
        catch(LibException e){
            e.predefinedBorrowBookNumberException();//如果高於，印出Can not check out since the number of books exceed the limitation of user can check-out
        }
        for (int i = 0; i < bookNumberList.size(); i++) {
            if(LibraryRepository.isCheckedOut(bookNumberList.get(i))){
                System.out.println("Can not check out since the book is checked out");
                break;
            }
            else{
                book = LibraryRepository.findBookById(bookNumberList.get(i));
                book.setBorrower(user);
                book.setIsCheck(true);
                LibraryRepository.checkoutBook(book);
            }
        }
    }
    
    
    

    public void theReturnBook(int bookId) {//還書
        if(LibraryRepository.isCheckedOut(bookId)){
            System.out.println("Can not return since the book isn't checked out");
        }
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
    
    public void checkLimitationNumber(int bookNumberListSize,int theBorrowerPredefinedBorrowBookNumber) throws LibException{
        if(bookNumberListSize > theBorrowerPredefinedBorrowBookNumber){
            throw new LibException();
        }
    }
    
    
    public void findBorrower(int bookId) {
        String checkoutUserB = LibraryRepository.findBorrower(bookId);
        System.out.println(checkoutUserB);
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
