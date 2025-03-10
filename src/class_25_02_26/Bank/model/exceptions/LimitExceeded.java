package class_25_02_26.Bank.model.exceptions;

public class LimitExceeded extends Exception {
    private Double withDraw;
    private Double withDrawLimit;

    public LimitExceeded(Double withDraw, Double withDrawLimit) {
        super();
        this.withDraw = withDraw;
        this.withDrawLimit = withDrawLimit;
    }   

    @Override
    public String toString() {
        return "O valor digitado para saque *" +  withDraw + 
                "* está maior que o limite permitido *" + withDrawLimit + "*";
    }
    
}
