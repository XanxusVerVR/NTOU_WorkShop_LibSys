package model;

import bean.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import operation.LibException;

public class Staff extends User {

    private String userName;

    public Staff(String userName) {
        super(userName);
    }

    @Override
    public void addBook(Book book) {
        LibraryRepository.addBookToList(book);
    }

    @Override
    public void removeBook(int bookId) {
        Book book;
        book = LibraryRepository.findBookById(bookId);
        LibraryRepository.romoveBookByList(book);
    }

    @Override
    public void checkout(User u, ArrayList<Integer> bookNumberList) {//員工把書借給借閱人
        Book book;
        Borrower newB = (Borrower) u;
        try {
            checkLimitationNumber(bookNumberList.size(), newB.getPredefinedBorrowBookNumber());//確認要借給借閱人的書數量低於上限
        } catch (LibException e) {
            e.predefinedBorrowBookNumberException();//如果高於，印出Can not check out since the number of books exceed the limitation of user can check-out
        }
        if (!newB.getUserName().equals(this.userName)) {//判斷管理員借書給自己，如果true就不做事、false就借書
            for (int i = 0; i < bookNumberList.size(); i++) {
                if (LibraryRepository.isCheckedOut(bookNumberList.get(i))) {//書已經被借走
                    System.out.println("Can not check out since the book is checked out");
                } else {
                    book = LibraryRepository.findBookById(bookNumberList.get(i));
                    book.setBorrower(newB.getUserName());
                    LibraryRepository.checkoutBook(book);
                }
            }
        }

    }

    @Override
    public void theReturnBook(int bookId) {//還書
        Book book;
        if (!LibraryRepository.isCheckedOut(bookId)) {//不能歸還沒有被借走的書，書還在圖書館裡
            System.out.println("Can not return since the book isn't checked out");
        }
        book = new Book();
        book.setBookId(bookId);
        LibraryRepository.returnBook(book);
    }

    @Override
    public void findChecked(User userA) {//員工查看借閱人借了哪些書
        List<Book> bookList;
        Borrower newA = (Borrower) userA;//userA為借閱人
        bookList = LibraryRepository.findBookByBorrower(newA.getUserName());
        try {
            for (int i = 0; i < bookList.size(); i++) {
                System.out.println(showFormatResult(bookList.get(i)));
            }
        } catch (NullPointerException e) {

        }
    }

    @Override
    public void findBorrower(int bookId) {
        String checkoutUserB = LibraryRepository.findBorrower(bookId);
        System.out.println("User: " + checkoutUserB);
    }

    public void checkLimitationNumber(int bookNumberListSize, int theBorrowerPredefinedBorrowBookNumber) throws LibException {
        if (bookNumberListSize > theBorrowerPredefinedBorrowBookNumber) {
            throw new LibException();
        }
    }
}
