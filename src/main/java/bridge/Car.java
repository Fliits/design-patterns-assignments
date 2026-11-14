package bridge;

// Refine abstraction 1 in bridge pattern
class Car extends Vehicle {
    boolean inTheShop = false;
    public Car(Workshop workShop1, Workshop workShop2)
    {
        super(workShop1, workShop2);
    }

    @Override
    public void manufacture()
    {
        this.inTheShop = true;
        System.out.print("Car ");
        workShop1.work();
        workShop2.work();
    }

    @Override
    public void go(boolean inTheShop) {
        System.out.println("Car drives out.");
        this.inTheShop = false;
    }

    @Override
    public void maintenance(boolean inTheShop) {
        System.out.println("Car is undergoing maintenance.");
        this.inTheShop = true;
    }

    @Override
    public boolean isInTheShop() {
        System.out.println("Car is in the shop: " + this.inTheShop);
        return this.inTheShop;
    }
}
