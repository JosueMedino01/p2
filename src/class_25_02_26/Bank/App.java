package class_25_02_26.Bank;

import class_25_02_26.Bank.model.entities.Bank;
import class_25_02_26.Bank.model.services.BankService;

public class App {
    public static void main(String[] args) {
        BankService service = new BankService();
        Bank bank = service.readData();
        bank = service.withDraw(bank);
        System.out.println("Saldo atual: " + bank.getBalance());
    }
}
