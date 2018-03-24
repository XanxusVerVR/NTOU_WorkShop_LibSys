package model;

import bean.Book;
import java.util.ArrayList;
import java.util.List;
import operation.IFindchecked;

public class Borrower implements IFindchecked {

    private List<Book> bookList = new ArrayList<Book>();
    private String userName;

    public Borrower() {

    }

    public Borrower(String userName) {//為要查詢的人
        this.userName = userName;
    }

    @Override
    public void findChecked(String userB) {//借閱人查自己借了哪些書，但借閱人不能查別的借閱人
        if (!userB.equals(this.userName)) {//如果借閱人查別人
            System.out.println("Borrower can not find books checked out by other users");
        } else {//借閱人查自己
            bookList = LibraryRepository.findBookByBorrower(this.userName);
            for (int i = 0; i < bookList.size(); i++) {
                System.out.println(showFormatResult(i));
            }
        }
    }

    public String showFormatResult(int i) {
        return "ID: " + bookList.get(i).getBookId() + " Author: " + bookList.get(i).getAuthor() + " Subject: " + bookList.get(i).getSubject() + "";
    }
}
