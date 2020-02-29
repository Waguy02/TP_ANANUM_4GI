package auto_tester.data_generation;

/**
 * This class simply returns values for the various scenarios
 * as a function of the key given and the equation type. The data
 * returned varies as a function of the type of equation.
 *
 * If for a given equation the key is not found a default value of zero
 * is returned. If the given equation type is not found, a default value of 1
 * is returned.
 *
 * @author suuynyuy
 * @version 1.0
 */
public class ValueBag {
    public static Double getValue(String key, EquationType type){
        switch (type){
            case LINEAR:
                return getLinearValue(key);
            case QUADRATIC:
                return getQuadraticValue(key);
            case SQUARE_ROOT:
                return getSquareRootValue(key);
            case SUM:
                return getSumValue(key);
            case INEQUALITY:
                return getInequalityValue(key);
        }
        return 1d;
    }

    /**
     * Returns values for a quadratic equation <b>ax^2 +bx +c =0</b>
     *
     * @param key
     * @return Double
     */
    private static Double getQuadraticValue(String key){
        switch (key.toCharArray()[0]){
            case 'a':
                return 0d;
            case 'b':
                return 1E-8;
            case 'c':
                return -1E-8;
            case 'd':
                return 2d;
            case 'e':
                return -2d;
            case 'f':
                return Double.NEGATIVE_INFINITY;
            case 'g':
                return Double.POSITIVE_INFINITY;
        }
        return 0d;
    }

    /**
     * Returns values for a linear equation <b>ax+b=0</b>
     * @param key
     * @return
     */
    private static Double getLinearValue(String key){
        switch (key.toCharArray()[0]){
            case 'a':
                return 0d;
            case 'b':
                return 1E-8;
            case 'c':
                return -1E-8;
            case 'd':
                return 2d;
            case 'e':
                return -2d;
            case 'f':
                return Double.NEGATIVE_INFINITY;
            case 'g':
                return Double.POSITIVE_INFINITY;
        }
        return 0d;
    }

    /**
     * Returns values for the square root <b>sqrt(x)</b>
     *
     * @param key
     * @return
     */
    private static Double getSquareRootValue(String key){
        switch (key.toCharArray()[0]){
            case 'a':
                return 0d;
            case 'b':
                return 1E-8;
            case 'c':
                return -1E-8;
            case 'd':
                return 2d;
            case 'e':
                return -2d;
            case 'f':
                return Double.NEGATIVE_INFINITY;
            case 'g':
                return Double.POSITIVE_INFINITY;
        }
        return 0d;
    }

    /**
     * Returns values for the sum equation <b>x+y</b>
     * @param key
     * @return
     */
    private static Double getSumValue(String key){
        switch (key.toCharArray()[0]){
            case 'a':
                return 0d;
            case 'b':
                return 1E-8;
            case 'c':
                return -1E-8;
            case 'd':
                return 2d;
            case 'e':
                return -2d;
            case 'f':
                return Double.NEGATIVE_INFINITY;
            case 'g':
                return Double.POSITIVE_INFINITY;
        }
        return 0d;
    }

    /**
     * Returns values for the inequality <b>x>=0</b>
     * @param key
     * @return
     */
    private static Double getInequalityValue(String key){
        switch (key.toCharArray()[0]){
            case 'a':
                return 0d;
            case 'b':
                return 1E-8;
            case 'c':
                return -1E-8;
            case 'd':
                return 2d;
            case 'e':
                return -2d;
            case 'f':
                return Double.NEGATIVE_INFINITY;
            case 'g':
                return Double.POSITIVE_INFINITY;
        }
        return 0d;
    }
}
