package fad.game.party;

public class Warrior extends Hero{
    @Override
    public void setLifePoints(int lifePoints){
        super.setLifePoints(lifePoints);
        if (getLifePoints() > 6 + getLevel()){
            setLifePoints(6 + getLevel());
        }
    }
}
