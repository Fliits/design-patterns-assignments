package builder;

public class OfficeComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public OfficeComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildCPU(String cpu) {
        // Implementation for building CPU for office computer
        this.computer.setCpu(cpu);
    }

    @Override
    public void buildRAM(int ram) {
        // Implementation for building RAM for office computer
        this.computer.setRam(ram);
    }

    @Override
    public void buildStorage(String storage) {
        // Implementation for building storage for office computer
        this.computer.setStorage(storage);
    }

    @Override
    public void buildGPU(String gpu) {
        // Implementation for building GPU for office computer
        this.computer.setGpu(gpu);
    }

    @Override
    public void buildOS(String os) {
        // Implementation for building OS for office computer
        this.computer.setOs(os);
    }

    @Override
    public void buildName(String name) {
        // Implementation for building name for office computer
        this.computer.setName(name);
    }

    @Override
    public Computer getComputer() {
        return this.computer;
    }
}
