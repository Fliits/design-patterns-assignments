package builder;

public class ComputerDirector {
    public void constructComputer(ComputerBuilder builder, String cpu, int ram, String storage, String gpu, String os) {
        builder.buildCPU(cpu);
        builder.buildRAM(ram);
        builder.buildStorage(storage);
        builder.buildGPU(gpu);
        builder.buildOS(os);
        builder.buildName(cpu + " " + ram + "GB " + storage + " " + gpu + " " + os);
    }
}
