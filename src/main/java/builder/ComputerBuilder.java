package builder;

public interface ComputerBuilder {
    void buildCPU(String cpu);
    void buildRAM(int ram);
    void buildStorage(String storage);
    void buildGPU(String gpu);
    void buildOS(String os);
    void buildName(String name);
    Computer getComputer();
}
