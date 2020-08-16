
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Đỗ Nam
 */
public class AccountManager {
    public static int InputAmount(CustomerAccount cus) {
        int amount;
        Scanner input = new Scanner(System.in);
        do {
            amount = input.nextInt();
            if (amount > cus.getBalance())
                System.out.println("The tranfered amount should be less than " + cus.getBalance());               
        } while ( amount > cus.getBalance());
        return amount;
    }
    
    public static void main(String[] args) throws InterruptedException {
        int amount;
        ExecuteTranfer objTran = new ExecuteTranfer();
        CustomerAccount tom = new CustomerAccount("Tom", 100);
        CustomerAccount jerry = new CustomerAccount("Jerry", 200);
        System.out.println("How much do you want tranfer (first) ?");
        amount = InputAmount(tom);
        TranferManager tranfer1 = new TranferManager(objTran, tom, jerry, amount, 1);
        System.out.println("How much do you want tranfer (second) ?");
        amount = InputAmount(tom);
        //nhập số tiền chuyển lần 2
        TranferManager tranfer2 = new TranferManager(objTran, tom, jerry, amount, 2);
        //Thuc hien chuyen tien
        
        tranfer1.start();
        tranfer2.start();
        tranfer1.join();
        tranfer2.join();
        System.out.println("Tranfer completed.");
    }
}
