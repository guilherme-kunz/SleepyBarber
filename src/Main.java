public class Main {

    public static void main(String[] args) {

        Barber barber1 = new Barber("Robert", 2,5);

        Thread threadBarber1 = new Thread(barber1);

        threadBarber1.start();

    }

}
