package model;

import bean.Book;
import java.util.List;
import operation.IFindchecked;

public class Staff implements IFindchecked {

    private String userName;

    public Staff() {

    }

    public Staff(String userName) {
        this.userName = userName;
    }

    @Override
    public List<Book> findChecked(String userA) {//員工查看借閱人借了哪些書
        throw new UnsupportedOperationException("the Staff");
    }

}
