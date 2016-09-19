package fizz.buzz.whizz

import spock.lang.Specification

import static fizz.buzz.whizz.Action.nop
import static fizz.buzz.whizz.Action.to
import static fizz.buzz.whizz.Matcher.always
import static fizz.buzz.whizz.Matcher.contains
import static fizz.buzz.whizz.Matcher.times
import static fizz.buzz.whizz.Rules.allof
import static fizz.buzz.whizz.Rules.anyof
import static fizz.buzz.whizz.Rules.atom

/**
 * Created by hzhang3 on 9/19/2016.
 */
class RuleSpec extends Specification{
    private static def spec(){
        Rule r1_3 = atom(times(3), to("Fizz"))
        Rule r1_5 = atom(times(5), to("Buzz"))
        Rule r1_7 = atom(times(7), to("Whizz"))

        Rule r1 = anyof(r1_3,r1_5,r1_7)

        Rule r2 = anyof(
                allof(r1_3,r1_5,r1_7),
                allof(r1_3,r1_5),
                allof(r1_3,r1_7),
                allof(r1_5,r1_7)
        )

        Rule r3 = atom(contains(3), to("Fizz"))

        Rule rd = atom(always(true), nop())

        anyof(r3,r2,r1,rd)
    }

    def "fizz buzz whizz"(){
        expect:
        spec().apply(n) == expection

        where:
        n       | expection
        3       | "Fizz"
        5       | "Buzz"
        7       | "Whizz"
        5 * 7   | "Fizz"
        13      | "Fizz"
        3 * 5   | "FizzBuzz"
        3 * 7   | "FizzWhizz"
        2 * 5*7 | "BuzzWhizz"
        3 * 5*7 | "FizzBuzzWhizz"
        4       | "4"
    }
}
