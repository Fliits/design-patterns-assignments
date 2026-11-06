package builder;

public class Main {
    public static void main(String[] args) {
        ComputerDirector director = new ComputerDirector();

        // Build a gaming computer
        GamingComputerBuilder gamingBuilder = new GamingComputerBuilder();
        director.constructComputer(gamingBuilder, "Intel i9", 32, "1TB SSD", "NVIDIA RTX 3080", "Windows 11");
        System.out.println("Gaming Computer: " + gamingBuilder.getComputer().getName());


        // Build an office computer
        OfficeComputerBuilder officeBuilder = new OfficeComputerBuilder();
        director.constructComputer(officeBuilder, "Intel i5", 16, "512GB SSD", "Integrated Graphics", "Windows 10");
        System.out.println("Office Computer: " + officeBuilder.getComputer().getName());
    }
}
