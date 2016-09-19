package fizz.buzz.whizz;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;

/**
 * Created by hzhang3 on 9/19/2016.
 */
public final class Rules {

    public static Rule atom(Matcher matcher, Action action) {
        return n -> matcher.matches(n) ? action.to(n) : "";
    }

    public static Rule anyof(Rule... rules) {
        return n -> Arrays.asList(rules).stream()
                .map( rule -> rule.apply(n) )
                .filter( s -> !s.isEmpty() )
                .findFirst()
                .orElse("");
    }

    public static Rule allof(Rule... rules) {
        return n -> Arrays.asList(rules).stream()
                .map( rule -> rule.apply(n) )
                .collect( joining() );
    }
}
