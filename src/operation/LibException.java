package operation;

public class LibException extends Exception{

    public LibException() {
        super("ERROR");
    }
    public void predefinedBorrowBookNumberException(){
        System.out.println("Can not check out since the number of books exceed the limitation of user can check-out");
    }
}
