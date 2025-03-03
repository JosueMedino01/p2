package class_25_02_17;

public class Individual extends Person {
    private double healthExpenditures;

    public Individual(String name, double annualIncome, double healthExpenditures) {
        super(name, annualIncome);
        this.healthExpenditures = healthExpenditures;
    }
    
    public double getHealthExpenditures() {
        return healthExpenditures;
    }


    public void setHealthExpenditures(double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public double getTaxesPaid() {
        double taxesPaid = 0;
        double annualIncome = this.getAnnualIncome();
    
        taxesPaid = (annualIncome <= 20000) ? annualIncome * 0.15 : annualIncome * 0.25;
        if (this.getHealthExpenditures() > 0){
            taxesPaid = taxesPaid - this.getHealthExpenditures() * 0.5;
        }  

        return taxesPaid;   
    }
}
