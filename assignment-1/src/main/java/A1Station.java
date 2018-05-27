import java.util.Scanner;

public class A1Station {

    private static final double THRESHOLD = 250; // in kilograms

    public static void departs(TrainCar train, int sumCat) {
        String category;
        double averageMassIndex = train.computeTotalMassIndex()/sumCat;

        if (averageMassIndex < 18.5) {
            category = "*underweight*";
        } else if (averageMassIndex < 25) {
            category = "*normal*";
        } else if (averageMassIndex < 30) {
            category = "*overweight*";
        } else {
            category = "*obese*";
        }

        System.out.println("The train departs to Javari Park");
        System.out.print("[LOCO]<--");
        train.printCar();
        System.out.printf("\nAverage mass index of all cats: %.2f\n", averageMassIndex);
        System.out.println("In average, the cats in the train are " + category);
    }

    public static void main(String[] args) {
        int sumCat = 0;
        TrainCar train = null;

        Scanner input = new Scanner(System.in);
        String n = input.nextLine();
        int amount = Integer.parseInt(n);

        for (int i = 0; i < amount; i++) {
            String[] inputString = input.nextLine().split(",");
            WildCat cat = new WildCat(inputString[0], Double.parseDouble(inputString[1]), Double.parseDouble(inputString[2]));
            sumCat++;

            if (train == null) {
                train = new TrainCar(cat);
            } else {
                train = new TrainCar(cat, train);
            }

            if (train.computeTotalWeight() > THRESHOLD) {
                departs(train, sumCat);
                train = null;
                sumCat = 0;
            }
        }

        departs(train, sumCat);
    }
}
