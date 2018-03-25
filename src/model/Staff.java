package model;

import bean.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import operation.IFindchecked;
import operation.LibException;

public class Staff extends User implements IFindchecked {

    private Book book;
    private List<Book> bookList = new ArrayList<Book>();
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
        book = LibraryRepository.findBookById(bookId);
        LibraryRepository.romoveBookByList(book);
    }

    @Override
    public void checkout(String user, ArrayList<Integer> bookNumberList, int theBorrowerPredefinedBorrowBookNumber) {//員工把書借給借閱人
        try {
            checkLimitationNumber(bookNumberList.size(), theBorrowerPredefinedBorrowBookNumber);//確認要借給借閱人的書數量低於上限
        } catch (LibException e) {
            e.predefinedBorrowBookNumberException();//如果高於，印出Can not check out since the number of books exceed the limitation of user can check-out
        }
        if (!user.equals(this.userName)) {//判斷管理員借書給自己，如果true就不做事、false就借書
            for (int i = 0; i < bookNumberList.size(); i++) {
                if (LibraryRepository.isCheckedOut(bookNumberList.get(i))) {//書已經被借走
                    System.out.println("Can not check out since the book is checked out");
                } else {
                    book = LibraryRepository.findBookById(bookNumberList.get(i));
                    book.setBorrower(user);
                    LibraryRepository.checkoutBook(book);
                }
            }
        }

    }

    @Override
    public void theReturnBook(int bookId) {//還書
        if (!LibraryRepository.isCheckedOut(bookId)) {//不能歸還沒有被借走的書，書還在圖書館裡
            System.out.println("Can not return since the book isn't checked out");
        }
        book = new Book();
        book.setBookId(bookId);
        LibraryRepository.returnBook(book);
    }

    @Override
    public void findChecked(String userA) {//員工查看借閱人借了哪些書
        bookList = LibraryRepository.findBookByBorrower(userA);
        try {
            for (int i = 0; i < bookList.size(); i++) {
                System.out.println(showFormatResult(i));
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
