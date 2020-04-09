package statistics;

import statistics.matcher.*;

public class QueryBuilder {

    Matcher stack;

    public QueryBuilder() {
        stack = new All();
    }

    public Matcher clear() {
        Matcher stack1 = stack;
        stack = new All();
        return stack1;
    }

    public Matcher build() {
        return clear();
    }

    public QueryBuilder playsIn(String team) {
        this.stack = new And(this.stack, new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        this.stack = new And(this.stack, new HasAtLeast(value, category));
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        this.stack = new And(this.stack, new HasFewerThan(value, category));
        return this;
    }

    public QueryBuilder oneOf(Matcher...matchers) {
        this.stack = new And(stack, new Or(matchers));
        return this;
        
    }

}