package test;

import java.util.ArrayList;
import java.util.Collection;
import model.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class testStaff {

    @Test
    public void checkoutUpperLimit() throws Exception {
//        Staff s = new Staff("userA");
//        Borrower b = new Borrower("userB", 2);//借閱人名字叫userB,最多能借2本
//        ArrayList<Integer> bookNumber = new ArrayList<Integer>();//存放要借哪幾本書
//        bookNumber.add(1);
//        bookNumber.add(3);
//        assertEquals("", s.checkout(b.getUserName(), bookNumber, b.getPredefinedBorrowBookNumber()));
        
        Collection collection = new ArrayList();
        assertEquals(0, collection.size());
        collection.add("itemA");
        assertEquals(1, collection.size());
        collection.add("itemB");
        assertEquals(2, collection.size());
    }
}
