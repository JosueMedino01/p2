package class_25_02_17;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args) {
        ArrayList<Person> personList = new ArrayList<Person>(); 

        Scanner scan = new Scanner(System.in);
        
        System.out.println("Digite o número de funcionários para cadastrar: ");
        int n = scan.nextInt();
        
        for(int i  = 0; i < n; i++) {
            System.out.println("Digite o tipo de pessoa: Fisico (f) ou Jurídica(j) ");
            char typePerson = scan.next().charAt(0);

            System.out.println("Digite o nome: ");
            String name = scan.next();
            System.out.println("Digite o valor arrecadado anualmente: ");
            double annualIncome = scan.nextDouble();
    

            if(typePerson == 'f') {
                System.out.println("Digite os gastos com saúde: ");
                double healthExpenditures = scan.nextDouble();
                
                Individual newPerson = new Individual(name, annualIncome, healthExpenditures);
                System.out.println();
                personList.add((Person)newPerson);
            }
            else {
                System.out.println("Digite o número de funcionários: ");
                int employeesNumber = scan.nextInt();

                Person newPerson = new Company(name, annualIncome, employeesNumber);
                personList.add(newPerson);
            }
        }

        double totalTaxesPaid = 0;

        for (Person person : personList) {
            System.out.printf("%s: %.2f%n", person.getName(), person.getTaxesPaid());
            totalTaxesPaid += person.getTaxesPaid();
        }

        System.out.printf("%s: %.2f%n", "TOTAL TAXES PAID", totalTaxesPaid);
    }
}
