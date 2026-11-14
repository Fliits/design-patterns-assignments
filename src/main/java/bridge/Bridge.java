package bridge;

// Demonstration of bridge design pattern
class Bridge {
    public static void main(String[] args)
    {
        Vehicle vehicle1 = new Car(new Produce(), new Assemble());
        vehicle1.manufacture();
        Vehicle vehicle2 = new Bike(new Produce(), new Assemble());
        vehicle2.manufacture();
        Vehicle vehicle3 = new Helicopter(new Produce(), new Assemble());
        vehicle3.manufacture();

        //All vehicles go out of the shop
        vehicle1.go(vehicle1.inTheShop);
        vehicle2.go(vehicle2.inTheShop);
        vehicle3.go(vehicle3.inTheShop);

        //Bike and helicopter go for maintenance
        vehicle2.maintenance(vehicle2.inTheShop);
        vehicle3.maintenance(vehicle3.inTheShop);

        //Helicopter stays in maintenance, bike goes out again
        vehicle2.go(vehicle2.inTheShop);

        vehicle1.isInTheShop();
        vehicle2.isInTheShop();
        vehicle3.isInTheShop();
    }
}
