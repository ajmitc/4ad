package fad.game.party;

public enum DefenseType {
    D6("D6"),
    D6_PLUS_LEVEL("D6+L"),
    D6_PLUS_HALF_LEVEL("D6 + 1/2L"),
    D6_PLUS_ONE("D6+1");

    private String name;
    DefenseType(String n){
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
