package class_25_02_12;

public class Stove extends Product {
    public Stove() {
        super();
    }
    private int burners;

    public void setBurners(int burners) {
        this.burners = burners;
    }

    public int getBurners() {
        return burners;
    }
}
