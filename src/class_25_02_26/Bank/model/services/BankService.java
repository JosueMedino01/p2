package class_25_02_26.Bank.model.services;

import java.util.Scanner;


import class_25_02_26.Bank.model.entities.Bank;
import class_25_02_26.Bank.model.exceptions.InsufficientBalance;
import class_25_02_26.Bank.model.exceptions.LimitExceeded;

public class BankService {
    Scanner scan = new Scanner(System.in);

    public Bank readData() {
        System.out.print("Digite o numero da conta: ");
        int number = scan.nextInt();
        scan.nextLine();

        System.out.print("Digite seu nome: ");
        String holder = scan.nextLine();

        System.out.print("Digite o saldo da conta: ");
        double balance = scan.nextDouble();

        System.out.print("Digite o limite por saque: ");
        double withDrawLimit = scan.nextDouble();

        return new Bank(number, holder, balance, withDrawLimit);
    }

    public Bank withDraw(Bank account) {
        while (true) {
            try {
                System.out.println("Digite o valor do saque: ");
                Double withDraw = scan.nextDouble();

                if(withDraw > account.getWithDrawLimit()) {
                    throw new LimitExceeded(withDraw, account.getWithDrawLimit());
                }

                if(withDraw > account.getBalance()) {
                    throw new InsufficientBalance(withDraw, account.getBalance());   
                }

                account.withDraw(withDraw);

                return account;

                
            } catch (LimitExceeded e) {
                System.err.println(e.toString());
            } catch (InsufficientBalance e) {
                System.err.println(e.toString());
            } catch (Exception e) {
                System.err.println(e.toString());
            }

        }
    }
}
