package fizz.buzz.whizz;

/**
 * Created by hzhang3 on 9/19/2016.
 */
@FunctionalInterface
public interface Action {
    String to(int n);

    static Action to(String str){
        return n -> str;
    }

    static Action nop(){
        return n -> String.valueOf(n);
    }
}
