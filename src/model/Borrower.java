package model;

import bean.Book;
import java.util.ArrayList;
import java.util.List;

public class Borrower extends User {

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
    public void checkout(User u, ArrayList<Integer> bookNumberList) {
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

    //借閱人查看自己借了哪些書，但借閱人不可查其他借閱人
    @Override
    public void findChecked(User u) {//userB為被查的人
        List<Book> bookList = null;
        Borrower queryPersoned = (Borrower) u;//queryPersoned為被查的人
        String queryPersonedName = queryPersoned.getUserName();
        if (super.getUserName().equals(queryPersonedName)) {//super.getUserName()為操作此方法的借閱者名字。如果此借閱者名字與被查的一樣，就查詢，表示自己查自己。
            bookList = LibraryRepository.findBookByBorrower(queryPersonedName);
            if (bookList == null) {
                System.out.println("Log: " + "名為"+queryPersonedName+"的借閱人，你目前沒借書出去");
            } else {
                for (int i = 0; i < bookList.size(); i++) {
                    System.out.println(showFormatResult(bookList.get(i)));
                }
            }
        } else {//如果借閱者去查其他人，就不給查。
            System.out.println("Borrower can not find books checked out by other users");
        }
    }

    public int getPredefinedBorrowBookNumber() {
        return predefinedBorrowBookNumber;
    }

    public void setPredefinedBorrowBookNumber(int predefinedBorrowBookNumber) {
        this.predefinedBorrowBookNumber = predefinedBorrowBookNumber;
    }

}
