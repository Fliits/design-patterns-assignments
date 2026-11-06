package builder;

public class Computer {
    private String cpu;
    private int ram;
    private String storage;
    private String gpu;
    private String os;
    private String name;

    public int getRam() {
        return ram;
    }

    public String getCpu() {
        return cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public String getOs() {
        return os;
    }

    public String getStorage() {
        return storage;
    }

    public String getName() {
        return name;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public void setName(String name) {
        this.name = name;
    }
}
