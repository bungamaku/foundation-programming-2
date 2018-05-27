public class TrainCar {

    public static final double EMPTY_WEIGHT = 20; // In kilograms
    private WildCat cat;
    private TrainCar next;
    
    public TrainCar(WildCat cat) {
        this.cat = cat;
    }

    public TrainCar(WildCat cat, TrainCar next) {
        this.cat = cat;
        this.next = next;
    }

    public double computeTotalWeight() {
        if (this.next == null) {
            return this.cat.weight + EMPTY_WEIGHT;
        } else {
            return this.cat.weight + EMPTY_WEIGHT + this.next.computeTotalWeight();
        }
    }

    public double computeTotalMassIndex() {
        if (this.next == null) {
            return this.cat.computeMassIndex();
        } else {
            return this.cat.computeMassIndex() + this.next.computeTotalMassIndex();
        }
    }

    public void printCar() {
        if (this.next == null) {
            System.out.print("(" + this.cat.name + ")");
        } else {
            System.out.print("(" + this.cat.name + ")--");
            this.next.printCar();
        }
    }
}
