package model;

import bean.Book;
import java.util.ArrayList;
import java.util.List;
import operation.IFindchecked;
import operation.LibException;

public class Borrower extends User implements IFindchecked {

    private List<Book> bookList = new ArrayList<Book>();
    private String userName;//這個借閱人的名字
    private int predefinedBorrowBookNumber;//他最多能借的書的數量

    public Borrower(String userName, int predefinedBorrowBookNumber) {
        super(userName);
        this.predefinedBorrowBookNumber = predefinedBorrowBookNumber;
    }

    @Override
    public void addBook(Book book) {
        System.out.println("Borrower can not add book");
    }

    @Override
    public void removeBook(int bookId) {
        System.out.println("Borrower can not remove book");
    }

    @Override
    public void checkout(String user, ArrayList<Integer> bookNumberList, int theBorrowerPredefinedBorrowBookNumber) {
        System.out.println("Borrower can not check out the books");
    }

    @Override
    public void theReturnBook(int bookId) {
        System.out.println("Borrower can not return book");
    }

    @Override
    public void findBorrower(int bookId) {
        System.out.println("Borrower can not find borrower");
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

    public int getPredefinedBorrowBookNumber() {
        return predefinedBorrowBookNumber;
    }

    public void setPredefinedBorrowBookNumber(int predefinedBorrowBookNumber) {
        this.predefinedBorrowBookNumber = predefinedBorrowBookNumber;
    }

}
