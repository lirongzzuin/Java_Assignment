import java.util.Objects;

class Bus {
    boolean state = true;
    int currentPassenger;
    int maxPassenger;
    final String num;
    int fee;
    int fuel;
    int speed;

    public Bus(int currentPassenger, int maxPassenger, String num, int fee, int fuel, int speed) {
        this.currentPassenger = currentPassenger;
        this.maxPassenger = maxPassenger;
        this.num = num;
        this.fee = fee;
        this.fuel = fuel;
        this.speed = speed;
    }

    public String getBusStateStr(){
        if(fuel < 10) {
            state = false;
        } else {
            state = true;
        }
        return state ? "Running" : "going to Garage";
    }

    public void takePassenger(){
        if (fuel >= 10 && currentPassenger < maxPassenger) {
            currentPassenger++;
        } else {
            System.out.println("This bus is too crowded for new passenger.");
        }
    }

    public void speedUp(){
        if (fuel >= 10) {
            speed += 10;
        } else {
            System.out.println("fuel needed.");
        }
    }

    public void speedDown() {
        if (fuel >= 10) {
            speed -= 10;
        } else {
            System.out.println("fuel needed.");
        }
    }

    public void start() {
        System.out.println("Let get it started!!");
    }
}
class Taxi {
    final String name;
    int fuel;
    int speed;
    String destination;
    int distance;
    int totalDistance;
    int fee;
    int totalFee;
    int passenger;
    String state = "";
//    boolean ready = true;

    public Taxi(String name, int passenger, int fuel, int speed, String destination, int totalDistance) {
        this.name = name;
        this.passenger = passenger;
        this.fuel = fuel;
        this.speed = speed;
        this.destination = destination;
        this.totalDistance = totalDistance;

    }

    public String getTaxiStateStr(){
        if (fuel < 10 && passenger<1) {
            state = "waiting for gas station";
        } if (fuel < 10 && passenger>= 1){
            state = "going to gas station";
            System.out.println("Out of Service");
        } if (fuel>=10 && passenger>=1) {
            state = "Running";
        } else if(fuel>=10 && passenger<1){
            state = "Waiting";
        }
        return state;
    }
    public void takePassenger(){
        getTaxiStateStr();
        if(state.equals("Waiting")) {
            passenger++;
            System.out.println(passenger);
        } else {
            System.out.println("get out!");
        }
    }

    public void speedUp(int changeSpeed){
        if (state.equals("Running")) {
            speed += changeSpeed;
        } else {
            System.out.println("fuel needed.");
        }
    }

    public void speedDown(int changeSpeed) {
        if (state.equals("Running")) {
            speed -= changeSpeed;
        } else {
            System.out.println("fuel needed.");
        }
    }
    public void setDistance(){
        distance = 2;
    }
    public void setFee(){
        fee = 3800;
    }
    public int cost(){
        setFee();
        setDistance();
        totalFee = fee + (totalDistance - distance)*750;
        return totalFee;
    }

    public void start() {
        System.out.println("Let get it started!!");
    }
}


public class Main {
    public static void main(String[] args) {
//        Bus bus = new Bus(25, 20, "BUS1122", 1500,10, 30);
//        bus.start();
//        bus.takePassenger();
////        bus.speedUp();
////        bus.speedDown();
//        System.out.println(bus.num + " is " + bus.getBusStateStr() + " and " + " # of passenger is " + bus.currentPassenger + " , " + bus.fuel +
//                "% of fuel is remaining." + " fee of this bus is " + bus.fee + "KRW and current speed is " + bus.speed +"km/hr.");

        Taxi taxi = new Taxi("Taxi99", 0, 15, 70, "GangNam", 8);
        taxi.start();
        taxi.takePassenger();
        System.out.println(taxi.name + " is " + taxi.getTaxiStateStr() + " and " + taxi.fuel + "% of fuel is remaining" + ", " + "the speed of this taxi is " +
                taxi.speed +"km/hr and our destination is " + taxi.destination + " , total distance and fee to destination would be " + taxi.totalDistance + "km and "
                + taxi.cost() + "KRW.");
    }
}