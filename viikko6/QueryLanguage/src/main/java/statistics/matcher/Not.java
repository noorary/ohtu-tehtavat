package statistics.matcher;
import statistics.Player;

public class Not implements Matcher {

    private Matcher[] matchers;

    public Not(Matcher... matchers) {
        this.matchers = matchers;
    }

    public boolean matches(Player player) {
        for(Matcher matcher : matchers) {
            if(!matcher.matches(player)) {
                return true;
            } 
        }
        return false;
    }

}