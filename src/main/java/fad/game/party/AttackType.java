package fad.game.party;

public enum AttackType {
    D6("D6"),
    D6_MINUS_TWO("D6-2"),
    D6_PLUS_ONE("D6+1"),
    D6_PLUS_LEVEL("D6+LVL"),
    D6_PLUS_HALF_LEVEL("D6 + 1/2L");

    private String name;
    AttackType(String n){
        this.name = n;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
