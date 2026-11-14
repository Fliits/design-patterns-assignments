package bridge;

// Refine abstraction 2 in bridge pattern
class Bike extends Vehicle {
    boolean inTheShop = false;
    public Bike(Workshop workShop1, Workshop workShop2)
    {
        super(workShop1, workShop2);
    }

    @Override
    public void manufacture()
    {
        this.inTheShop = true;
        System.out.print("Bike ");
        workShop1.work();
        workShop2.work();
    }

    @Override
    public void go(boolean inTheShop) {
        System.out.println("Bike speeds off.");
        this.inTheShop = false;
    }

    @Override
    public void maintenance(boolean inTheShop) {
        System.out.println("Bike is undergoing maintenance.");
        this.inTheShop = true;
    }

    @Override
    public boolean isInTheShop() {
        System.out.println("Bike is in the shop: " + this.inTheShop);
        return this.inTheShop;
    }
}
