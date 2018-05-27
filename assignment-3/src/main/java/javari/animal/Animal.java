package javari.animal;

/**
 * This class represents common attributes and behaviours found in all animals
 * in Javari Park.
 *
 * @author Programming Foundations 2 Teaching Team
 * @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
 */

public abstract class Animal {

    private Integer id;
    private String type;
    private String name;
    private Body body;
    private Condition condition;
    private String category;
    private String specialStatus;

    /**
     * Constructs an instance of {@code Animal}.
     *
     * @param id        unique identifier
     * @param type      type of animal, e.g. Hamster, Cat, Lion, Parrot
     * @param name      name of animal, e.g. hamtaro, simba
     * @param gender    gender of animal (male/female)
     * @param length    length of animal in centimeters
     * @param weight    weight of animal in kilograms
     * @param condition health condition of the animal
     */
    
    public Animal(Integer id, String type, String name, Gender gender, double length,
                  double weight, String specialStatus, Condition condition) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.body = new Body(length, weight, gender);
        this.specialStatus = specialStatus;
        this.condition = condition;
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    /**
     * Returns {@code Gender} identification of the animal.
     *
     * @return
     */
    public Gender getGender() {
        return body.getGender();
    }

    public double getLength() {
        return body.getLength();
    }

    public double getWeight() {
        return body.getWeight();
    }

    /**
     * Returns {@code Condition} of the animal.
     *
     * @return
     */
    public Condition getCondition() {
        return condition;
    }

    public String getCategory() {
        return category;
    }

    public String getSpecialStatus() {
        return specialStatus;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Determines whether the animal can perform their attraction or not.
     *
     * @return
     */
    public boolean isShowable() {
        return condition == Condition.HEALTHY && specificCondition();
    }

    /**
     * Performs more specific checking to know whether an animal is able
     * to perform or not.
     *
     * @return
     */
    public abstract boolean specificCondition();
}
