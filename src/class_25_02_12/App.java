package class_25_02_12;

public class App {
    public static void main(String[] args) {
        Refrigerator my = new Refrigerator();
        my.setPrice(12900);
        my.setName("LG Revolution Freezer");
        my.setSize(2);
        
        System.out.println("Meu produto (refrigerator): ");
        System.out.println("Nome: " + my.getName());

        System.out.println("Valor: " + my.getPrice());
        System.out.println("Tamanho: " + my.getSize());

    }
}
