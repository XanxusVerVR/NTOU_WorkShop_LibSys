package library.system;

import model.*;

public class Main {
    public static void main(String[] args) {
        
//        Staff userA = new Staff("userA");
//        userA.findChecked("userB");
//        
        
        
        
        
        Borrower b = new Borrower("userB");
        b.findChecked("userA");
    }
    
}