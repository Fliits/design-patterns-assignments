package bridge;

class Helicopter extends Vehicle {
    public Helicopter(Workshop workShop1, Workshop workShop2)
    {
        super(workShop1, workShop2);
    }

    @Override
    public void manufacture()
    {
        System.out.print("Helicopter ");
        workShop1.work();
        workShop2.work();
    }

    @Override
    public void go(){
        System.out.println("Helicopter takes off.");
    }
}
