package fizz.buzz.whizz;

/**
 * Created by hzhang3 on 9/19/2016.
 */
@FunctionalInterface
public interface Matcher {
    boolean matches(int n);

    static Matcher times(int base){
        return n -> n % base == 0;
    }

    static Matcher contains(int num){
        return n -> String.valueOf(n).contains(String.valueOf(num));
    }

    static Matcher always(boolean bool){
        return n -> bool;
    }
}
