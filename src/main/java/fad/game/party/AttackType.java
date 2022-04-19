package fad.game.party;

public enum AttackType {
    D6("D6"),
    D6_PLUS_ONE("D6+1");

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
