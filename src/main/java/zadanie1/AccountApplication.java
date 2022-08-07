package src.main.java.zadanie1;

public class AccountApplication {

    public static void main(String[] args) {

        Account account = new Account();
        account.setName("Test wpłata");
        System.out.println("Nazwa: " + account.getName());
        account.deposit(300);
        System.out.println();
        account.deposit(250);
        System.out.println(account);


        System.out.println();
        System.out.println("=====================================================================");
        System.out.println();
        Account account1 = new Account();
        account1.setName("Test wypłata");
        System.out.println("Nazwa: " + account1.getName());
        account1.deposit(200);
        System.out.println();
        account1.withdraw(500);
        System.out.println(account1);


        System.out.println();
        System.out.println("=====================================================================");
        System.out.println();
        Account account2 = new Account();
        account2.setName("Test debet");
        System.out.println("Nazwa: " + account2.getName());
        account2.withdraw(900);
        System.out.println(account2);

        System.out.println();
        account2.withdraw(100);
        System.out.println(account2);

        System.out.println();
        account2.withdraw(100);
        System.out.println(account2);

        System.out.println();
        account2.withdraw(50);
        System.out.println(account2);


        System.out.println();
        System.out.println("=====================================================================");
        System.out.println();
        Account accountTransfer = new Account();
        accountTransfer.setName("Test transfer");
        System.out.println("Transfering....");
        account.transfer(accountTransfer, 300);
        System.out.println(account);
        System.out.println(accountTransfer);

    }
}
