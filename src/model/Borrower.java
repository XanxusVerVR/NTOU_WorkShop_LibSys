package model;

import bean.Book;
import java.util.List;
import operation.IFindchecked;

public class Borrower implements IFindchecked {

    private String userName;

    public Borrower() {

    }

    public Borrower(String userName) {
        this.userName = userName;
    }

    @Override
    public List<Book> findChecked(String userB) {//借閱人查自己借了哪些書，但借閱人不能查別的借閱人
        if (!userB.equals(this.userName)) {
            System.out.println("Borrower can not find books checked out by other users");
        }
//        throw new UnsupportedOperationException("the Borrower"); //To change body of generated methods, choose Tools | Templates.
        return null;//未完成
    }

}
