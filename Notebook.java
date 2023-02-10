public class Notebook {
    int sn;
    String name;
    int ram;
    int ssd;
    String os;
    String color;
    int size;
    public Notebook(int sn, String name, int ram, int ssd, String os, String color, int size){
        this.sn = sn;
        this.name = name;
        this.ram = ram;
        this.ssd = ssd;
        this.os = os;
        this.color = color;
        this.size = size;
    }

    public int getSN() {
        return sn;
    }
    public String getName() {
        return name;
    }
    public int getRAM() {
        return ram;
    }
    public int getSSD() {
        return ssd;
    }
    public String getOS() {
        return os;
    }
    public String getColor() {
        return color;
    }
    public int getSize() {
        return size;
    }
}