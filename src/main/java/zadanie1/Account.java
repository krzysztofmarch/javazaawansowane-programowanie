package src.main.java.zadanie1;

public class Account {
    private String name;
    private int balance = 0;
    private boolean debit = false;
    private int maxDebit = -1000;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        try {
                int balanceBeforeDeposit = balance;
                validateAmount(amount);
                balance += amount;
                validateDebit();
                System.out.println("Stan konta przed operacją: " + balanceBeforeDeposit
                        + "\nWpłata: " + amount
                        + "\nStan konta po operacji: " + balance);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Przechwycono wyjatek: " + e.getMessage());
        }
    }

    public boolean withdraw(int amount) {
        try {
            int balanceBeforeWithdraw = balance;
            validateAmount(amount);
            if (isBalanceAvailable(amount)) {
                balance -= amount;
                System.out.println("Stan konta przed operacją: " + balanceBeforeWithdraw
                        + "\nWypłata: " + amount
                        + "\nStan konta po operacji: " + balance);

                validateDebit();
                return true;
            }

        } catch (MaxDebit a) {
            a.printStackTrace();
            System.out.println("Przechwycono wyjatek: " + a.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Przechwycono wyjatek: " + e.getMessage());
        }
        return false;
    }

    private void validateDebit() {
        debit = balance < 0;
        if (debit) {
            System.out.println("Ujemny stan konta");
        }
    }

    private boolean isAmountValid(int amount) {
        return amount > 0;
    }

    private void validateAmount(int amount) {
        if (amount < 0) {
            throw new InvalidAmountException("Invalid amount: " + amount);
        }
    }

    private void balanceAvailable(int amount){
        if (balance - amount >= maxDebit){
            throw new MaxDebit("Blad wyplaty: " + amount + "\nOsiagnales maxymalny limit debetu!");
        }
    }

    private boolean isBalanceAvailable(int amount){
        boolean result = balance - amount >= maxDebit;
        if (!result){
            System.out.println("Blad wyplaty: " + amount + "\nOsiagnales maxymalny limit debetu!");
        }
        return result;
    }

    public void transfer(Account other, int amount){
        System.out.println("Transfer srodkow na konto: " + other.getName());
        if (withdraw(amount)) {
            System.out.println("\nKonto : " + other.getName());
            other.deposit(amount);
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", debit=" + debit +
                '}';
    }
}
