package model;

import bean.Book;
import java.util.List;

public abstract class User {
    public abstract List<Book> findChecked(String userA,String userB);
    //員工查看這個人借走了哪些書，或使用者查自己借了哪些書
}
