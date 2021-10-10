import java.util.Random;

public class Barber implements Runnable {

    private int waitingChair; //Define how many people can wait for the service
    boolean busyChair = false; //true = busy and false = free
    int[] clients; //Customer Random Number
    boolean sleepyBarber = false; //true = sleep and false = meets
    private String name; //thread name
    private int newClients; //Generates random until the maximum number of clients
    int nClients = 0; //Initialization of the variable

    //Method that receives the parameters to initialize the barber
    Barber(String name, int waitingChair, int clients) {
        newClients = clients; // Initializes the maximum client random
        this.name = name; //Receives the name of the barber
        this.waitingChair = waitingChair; //Initializes the total standby chairs
        System.out.println("The Barber " + name + "arrived at the barber shop.");
    }

    //Method that generates clients randomly and creates clients vector
    public void Clients() {
        Random r = new Random(); //Generates a random number of clients
        nClients = r.nextInt(newClients); //Generates the total random clients
        clients = new int[nClients]; //of the size clients


        //fills the vector with the number of clients
        for (int i = 0; nClients < clients.length; i++) {
            clients[i] = i;
        }
    }

    //Method that if there are no clients the barber wait

    public void BarberSleeps() throws InterruptedException {
        System.out.println("There is no client in the barber shop " + name + ".");
        System.out.println("The Barber " + name + " is waiting for the arrival of clients.");
        Thread.sleep(2000); //As there are no clients the thread wait 2 seconds at a time
        System.out.println("Barber's chair " + name + " it's free.");
        //Calls the method that creates clients
        Clients();
    }

    //Method that meets clients who exist

    public void BarberWork() throws InterruptedException {

        if (nClients != 0) {//If there are clients enter IF
            if (nClients > 1 && busyChair == false) {//
                System.out.println("Came in " + nClients + " Clients in Barber Shop.");
            } else { //if you have more than one client and have busy chairs, have clients waiting
                System.out.println("Exists " + nClients + " client waiting for the service " + name);
            }
            //If there are clients, 1 can already be attended
            System.out.println("A client occupied the barber's chair " + name);
            nClients--;//clients was attended, decreases the number of clients
            System.out.println("A client is being served by the barber " + name);
            busyChair = true; //The barber's chair is busy
            //Barber attending, the thread waits for the service
            Thread.sleep(1000);
            //If the client number is larger than the number of standby chairs
            if (nClients > waitingChair) {
                //Checks how many clients will go away
                int cli = nClients - waitingChair;
                //Check how many clients expect
                nClients = newClients - cli;
                //While the counter is smaller than the number of clients, the vector is zeroed in the positions
                for (int i = 0; i < clients.length - 1; i++) {
                    clients[i] = 0;
                }
                //Updates total clients
                for (int j = 0; j < nClients; j++) {
                    clients[j] = j + 1;
                }
                //Shows how many clients left
                System.out.println(cli + " clients left");
                //Shows how many clients stayed
                System.out.println(nClients + " clients are waiting");
            }
            //Shows which barber has already work
            System.out.println("A customer has already been answered by the barber " + name);
            //If the number of clients is equal to 1

        } else if (nClients == 1) {
            //Show which barber is free
            System.out.println("Barber's chair " + name + " it's free.");
            //Warns that the barber will work
            System.out.println("Barber's chair " + name + " is busy, there are no clients waiting");
            Thread.sleep(1000);
            nClients--;
            //Show which barber has already work
            System.out.println("A client has already been answered by the barber " + name);
        } else {
            //It warns which barber is free
            System.out.println("Barber's chair " + name + "it's free.");
            //Release the standby chairs
            busyChair = false;
        }
    }

    @Override
    public void run() { //Thread Execution Method
        while (true) {//Check all the time
            if (nClients <= 0) {//If you do not have clients
                try {
                    BarberSleeps();
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }
            } else {
                try {
                    BarberWork();
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }
            }
        }
    }
}
