package class_25_02_26.model.exceptions;

import java.time.LocalDate;

public class InvalidUpdateDate extends Exception {
    private LocalDate currDate;
    private LocalDate newDate;

    public InvalidUpdateDate(LocalDate currDate, LocalDate newDate) {
        super();
        this.currDate = currDate;
        this.newDate = newDate;
    }

    @Override
    public String toString() {
        return "Nova data inferior a data atual. Não é possível modificar" + 
            this.currDate + "para" + this.newDate;
    }
    
}
