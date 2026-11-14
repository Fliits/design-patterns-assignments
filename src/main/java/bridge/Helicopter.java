package bridge;

class Helicopter extends Vehicle {
    boolean inTheShop = false;

    public Helicopter(Workshop workShop1, Workshop workShop2)
    {
        super(workShop1, workShop2);
    }

    @Override
    public void manufacture()
    {
        this.inTheShop = true;
        System.out.print("Helicopter ");
        workShop1.work();
        workShop2.work();
    }

    @Override
    public void go(boolean inTheShop){
        System.out.println("Helicopter takes off.");
        this.inTheShop = false;
    }

    @Override
    public void maintenance(boolean inTheShop) {
        System.out.println("Helicopter is undergoing maintenance.");
        this.inTheShop = true;
    }

    @Override
    public boolean isInTheShop() {
        System.out.println("Helicopter is in the shop: " + this.inTheShop);
        return this.inTheShop;
    }
}
