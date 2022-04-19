package fad;

import fad.game.Game;

public class Model {
   private Game game;

   public Model(){
       game = new Game();
   }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
