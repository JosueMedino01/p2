package class_25_02_17;

public class Company extends Person{
    private int employeesNumber;

    public Company(String name, double annualIncome, int employeesNumber) {
        super(name, annualIncome);
        this.employeesNumber = employeesNumber;
    }

    public int getEmployeesNumber() {
        return employeesNumber;
    }

    public void setEmployeesNumber(int employeesNumber) {
        this.employeesNumber = employeesNumber;
    }
    
    @Override
    public double getTaxesPaid() {  
        double annualIncome = this.getAnnualIncome();
        return (employeesNumber > 10) ? annualIncome * 0.14 : annualIncome * 0.16;
    }

    
}
