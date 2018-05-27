package javari.animal;

/**
 * This class describes possible health conditions for an animal.
 *
 * @author Programming Foundations 2 Teaching Team
 * @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
 */

public enum Condition {

    HEALTHY, UNHEALTHY;
    private static final String HEALTHY_STR = "healthy";
    private static final String UNHEALTHY_STR = "not healthy";

    /**
     * Returns the correct condition enum based on given string representation
     * of a condition.
     *
     * @param str   condition description
     * @return
     */
    
    public static Condition parseCondition(String str) {
        if (str.equalsIgnoreCase(HEALTHY_STR)) {
            return Condition.HEALTHY;
        } else if (str.equalsIgnoreCase(UNHEALTHY_STR)) {
            return Condition.UNHEALTHY;
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
