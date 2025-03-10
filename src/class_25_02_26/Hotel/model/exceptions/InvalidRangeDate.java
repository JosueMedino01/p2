package class_25_02_26.Hotel.model.exceptions;

import java.time.LocalDate;

public class InvalidRangeDate extends Exception {
    private LocalDate startDate;
    private LocalDate endDate;

    public InvalidRangeDate(LocalDate startDate, LocalDate endDate) {
        super();
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Data final " + this.endDate + " é inferior a data inicial " + this.startDate;
    }
}
