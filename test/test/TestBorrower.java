package test;

import bean.Book;
import java.util.ArrayList;
import model.Borrower;
import model.Staff;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
public class TestBorrower {
    private ArrayList<Book> newBook;
    private ArrayList<Integer> checkoutBookNumber;

    public TestBorrower() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test() {
        newBook = new ArrayList<Book>();
        
        Staff s = new Staff("userA");
        Borrower b = new Borrower("userB",2);//借閱人名字叫userB,最多能借2本
        
        
        
    }
}
