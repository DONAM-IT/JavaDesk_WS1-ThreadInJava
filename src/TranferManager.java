/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Đỗ Nam
 */
class ExecuteTranfer {
    synchronized void Tranfer(Thread t, CustomerAccount acc1, CustomerAccount acc2,
            int amount, int numTran)
    {
        try {
            System.out.println("Tranfer processing: " + numTran);
            Thread.sleep(3000);
            System.out.println("THe balance before tranfer: ");
            System.out.println(acc1.accountName +" : $" + acc1.getBalance());
            System.out.println(acc2.accountName +" : $" + acc2.getBalance());
            
            acc1.setBalance(acc1.getBalance() - amount);
            acc2.setBalance(acc2.getBalance() + amount);
            
            System.out.println("THe balance amount after tranfer: " + amount);
            System.out.println(acc1.accountName +" : $" + acc1.getBalance());
            System.out.println(acc2.accountName +" : $" + acc2.getBalance());
        } catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }
            System.out.println("Successful");
    }
}

public class TranferManager extends Thread {
    CustomerAccount acc1, acc2;
    int amount;
    ExecuteTranfer objTran;
    int numTran;

//    public TranferManager(CustomerAccount acc1, CustomerAccount acc2, int amount, ExecuteTranfer objTran, int numTran) {
//        this.acc1 = acc1;
//        this.acc2 = acc2;
//        this.amount = amount;
//        this.objTran = objTran;
//        this.numTran = numTran;
//    }
    public TranferManager(ExecuteTranfer tran, CustomerAccount a, CustomerAccount b, int m, int num) {
        acc1 = a;
        acc2 = b;
        amount = m;
        objTran = tran;
        numTran = num;
    }

//    TranferManager(ExecuteTranfer objTran, CustomerAccount tom, CustomerAccount jerry, int amount, int i) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    @Override
    public void run() {
        objTran.Tranfer(this, acc1, acc2, amount, numTran);
    }
}
