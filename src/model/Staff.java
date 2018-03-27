package model;

import bean.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import operation.LibException;

public class Staff extends User {

    public Staff(String userName) {
        super(userName);
    }

    @Override
    public void addBook(Book book) {
        LibraryRepository.addBookToList(book);
    }

    @Override
    public void removeBook(int bookId) {
        Book book = LibraryRepository.findBookById(bookId);
        if (book == null) {//如果沒有這本書存在，就不做動作。
            System.out.println("Log: " + "此bookId為"+bookId+"的書不存在");
        } else if (book.getIsCheck()) {//如果這本書被借走了，也不做動作
            System.out.println("Log: " + "此bookId為"+bookId+"的書被借走了");
        } else {
            LibraryRepository.romoveBookByList(book);
        }
    }

    @Override
    public void checkout(User u, ArrayList<Integer> bookNumberList) {//員工把書借給借閱人
        boolean isStaff = false;
        if (super.getClass().getName().equals(u.getClass().getName())) {//判斷借與被借的人是不是都是員工
            System.out.println("Log: " + "員工不能借員工書");
            isStaff = true;
        }
        if (!isStaff) {
            Book book = null;
            Borrower wantCheckoutPerson = (Borrower) u;//wantCheckoutPerson為想要借書的人
            if(bookNumberList.size() > wantCheckoutPerson.getPredefinedBorrowBookNumber()){
                System.out.println("Can not check out since the number of books exceed the limitation of user can check-out");
            }
            else{
                for (int i = 0; i < bookNumberList.size(); i++) {
                    if (LibraryRepository.isCheckedOut(bookNumberList.get(i))) {//書已經被借走
                        System.out.println("Can not check out since the book is checked out");
                    } else {
                        book = LibraryRepository.findBookById(bookNumberList.get(i));
                        if (book == null) {//如果圖書館裡根本沒有這個書的ID，根本沒此書的存在就不動作
                            System.out.println("Log: " + "此書不存在");
                        } else {
                            book.setBorrower(wantCheckoutPerson.getUserName());
                            LibraryRepository.checkoutBook(book);
                        }
                    }
                }
            }
//            try {
//                checkLimitationNumber(bookNumberList.size(), wantCheckoutPerson.getPredefinedBorrowBookNumber());//確認要借給借閱人的書數量低於上限
//            } catch (LibException e) {
//                e.predefinedBorrowBookNumberException();//如果高於，印出Can not check out since the number of books exceed the limitation of user can check-out
//            }
            
        }
    }

    @Override
    public void theReturnBook(int bookId) {//還書
        Book book = LibraryRepository.findBookById(bookId);
        if (book == null) {//如果這本書不存在，就不做動作
            System.out.println("Log: " + "此bookId為"+bookId+"的書不存在");
        } else if (!LibraryRepository.isCheckedOut(bookId)) {//不能歸還沒有被借走的書，書還在圖書館裡
            System.out.println("Can not return since the book isn't checked out");
        } else {
            book = new Book();
            book.setBookId(bookId);
            LibraryRepository.returnBook(book);
        }

    }

    @Override
    public void findChecked(User u) {//員工查看借閱人借了哪些書
        boolean isStaff = false;
        if (super.getClass().getName().equals(u.getClass().getName())) {//如果員工查員工
            System.out.println("Log: " + "員工不能查員工");
            isStaff = true;
        }
        if (!isStaff) {//如果是員工查員工，就不動作
            List<Book> bookList = null;
            Borrower queryPersoned = (Borrower) u;//queryPersoned為被查的借閱人
            bookList = LibraryRepository.findBookByBorrower(queryPersoned.getUserName());
            if (bookList == null) {
                System.out.println("Log: " + "名為"+queryPersoned.getUserName()+"的借閱人沒有借書");
            } else {
                for (int i = 0; i < bookList.size(); i++) {
                    System.out.println(showFormatResult(bookList.get(i)));
                }
            }

        }
    }

    @Override
    public void findBorrower(int bookId) {
        String checkoutUserB = LibraryRepository.findBorrower(bookId);
        if (checkoutUserB == null) {
            System.out.println("Log: " + "此bookId為"+bookId+"的書已移除or沒有借出去");
        } else {
            System.out.println("User: " + checkoutUserB);
        }

    }

//    public Boolean checkLimitationNumber(int bookNumberListSize, int theBorrowerPredefinedBorrowBookNumber) throws LibException {
//        if (bookNumberListSize > theBorrowerPredefinedBorrowBookNumber) {
////            throw new LibException();
//        }
//    }
}
