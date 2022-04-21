package fad.game.party;

public class Warrior extends Hero{

    @Override
    public int getMaxLifePoints(){
        return 6 + level;
    }
}
