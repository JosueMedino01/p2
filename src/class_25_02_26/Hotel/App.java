package class_25_02_26.Hotel;

import java.util.Scanner;

import class_25_02_26.Hotel.model.entities.Reservation;
import class_25_02_26.Hotel.model.services.ReservationService;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ReservationService service = new ReservationService();

        Reservation reservation = service.readReservation();
        service.showReservation(reservation);

        System.out.println("Deseja atualizar a data? (s/n)"); 
        char yesOrNot = scan.next().charAt(0);

        while(yesOrNot == 's') {
            reservation = service.updateDates(reservation);
            service.showReservation(reservation);
        }
    }   
}
