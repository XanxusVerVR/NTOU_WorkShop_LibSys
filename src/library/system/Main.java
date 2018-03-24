package library.system;

import model.*;

public class Main {
    public static void main(String[] args) {
        
//        Staff userA = new Staff("userA");
//        userA.findChecked("userB");
//        
        
        
        
        
        Borrower userB = new Borrower("userB");
        userB.findChecked("userA");
    }
    
}