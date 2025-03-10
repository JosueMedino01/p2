package class_25_02_26.Bank.model.exceptions;

public class InsufficientBalance extends Exception {
    private Double withDraw;
    private Double balance;

    public InsufficientBalance(Double withDraw, Double balance) {
        super();
        this.withDraw = withDraw;
        this.balance = balance;
    }   

    @Override
    public String toString() {
        return "O valor digitado para saque *" +  withDraw + 
                "* está maior que o saldo atual *" + balance + "*";
    }
    
}