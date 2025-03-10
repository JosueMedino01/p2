package class_25_02_26.model.services;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

import class_25_02_26.model.entities.Reservation;
import class_25_02_26.model.exceptions.InvalidRangeDate;
import class_25_02_26.model.exceptions.InvalidUpdateDate;

public class ReservationService {
    Scanner scan = new Scanner(System.in);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reservation readReservation() {
        int roomNumber;
        LocalDate checkIn, checkOut;
    
        while (true) {
            try {
                System.out.println("Digite o número do quarto: ");
                roomNumber = scan.nextInt();
    
                System.out.println("Digite a data de Check In (dd/MM/yyyy): ");
                String checkInStr = scan.next();
                checkIn = LocalDate.parse(checkInStr, formatter);
    
                System.out.println("Digite a data de Check Out (dd/MM/yyyy): ");
                String checkOutStr = scan.next();
                checkOut = LocalDate.parse(checkOutStr, formatter);
    
                if (ChronoUnit.DAYS.between(checkIn, checkOut) < 0) {
                    throw new InvalidRangeDate(checkIn, checkOut);
                }
    
                return new Reservation(roomNumber, checkIn, checkOut);
            } catch (InvalidRangeDate e) {
                System.out.println("Erro: A data de check-out deve ser depois do check-in. Tente novamente.");
            } catch (Exception e) {
                System.out.println("Erro: Entrada inválida. Certifique-se de digitar as datas no formato correto (dd/MM/yyyy).");
                scan.nextLine(); 
            }
        }
    }
    

    public void showReservation(Reservation reservation) {
        System.out.println("Reserva: " +"Quarto " +  
            reservation.getRoomNumber() +  ", Check-in: " +
            reservation.getCheckIn() + ", Check-out: " + 
            reservation.getCheckOut()+ ", " + 
            reservation.duration() + " noites." 
        );
    }

    public Reservation updateDates(Reservation reservation) {
        LocalDate checkIn, checkOut;

        while (true) {
            try 
            {
                System.out.println("Digite a data de Check In (dd/MM/yyyy): ");
                String checkInStr = scan.next();
                checkIn = LocalDate.parse(checkInStr, formatter);

                if(reservation.getCheckIn().isAfter(checkIn)) {
                    throw new InvalidUpdateDate(reservation.getCheckIn(), checkIn);
                }

                System.out.println("Digite a data de Check Out (dd/MM/yyyy): ");
                String checkOutStr  = scan.next();
                checkOut = LocalDate.parse(checkOutStr, formatter);

                if(reservation.getCheckOut().isAfter(checkOut)) {
                    throw new InvalidUpdateDate(reservation.getCheckOut(), checkOut);

                }

                reservation.setCheckIn(checkIn);
                reservation.setCheckOut(checkOut);
                return reservation;
            } 
            catch(InvalidUpdateDate e) {
                System.out.println("Erro: Data deve ser menor que as datas atuais. Tente novamente.");
            } 
            catch (Exception e) {
                System.out.println("Erro: Entrada inválida. Tente novamente.");
                scan.nextLine(); 
            }
        }

       
    }
}
