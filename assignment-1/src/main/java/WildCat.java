public class WildCat {

    String name;
    double weight; // In kilograms
    double length; // In centimeters
    double computeMassIndex;

    public WildCat(String name, double weight, double length) {
        super();
        this.name = name;
        this.weight = weight;
        this.length = length;
    }

    public double computeMassIndex() {
        return weight * 10000/(length * length);
    }
}
