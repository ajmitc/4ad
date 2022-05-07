package fad.view;

import fad.Model;
import fad.game.dungeon.RoomSpace;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author aaron.mitchell
 */
public class DungeonPanel extends JPanel{
    public static final int XOFFSET = 10;
    public static final int YOFFSET = 10;
    public static final int ROOM_SPACE_SIZE = 10;

    private Model model;
    private View view;

    public DungeonPanel(Model model, View view){
        super();
        this.model = model;
        this.view = view;
    }

    public void refresh(){
        repaint();
    }

    @Override
    public void paintComponent(Graphics graphics){
        if (model.getGame() == null){
            return;
        }

        Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.black);
        g.drawLine(0, 0, 100, 100);

        List<RoomSpace> roomSpaces = model.getGame().getDungeon().getRoomSpaces();

        roomSpaces.stream().forEach(space -> {
            int x = XOFFSET + (space.getX() * ROOM_SPACE_SIZE);
            int y = YOFFSET + (space.getY() * ROOM_SPACE_SIZE);
            switch (space.getType()){
                case DOOR: {
                    g.setColor(Color.lightGray);
                    g.fillRect(x, y, ROOM_SPACE_SIZE, ROOM_SPACE_SIZE);
                    g.setColor(Color.black);
                    g.drawRect(x, y, ROOM_SPACE_SIZE, ROOM_SPACE_SIZE);
                    break;
                }
                case WALL: {
                    g.setColor(Color.black);
                    g.fillRect(x, y, ROOM_SPACE_SIZE, ROOM_SPACE_SIZE);
                    break;
                }
                case OPEN:
                case HALLWAY: {
                    g.setColor(Color.lightGray);
                    g.fillRect(x, y, ROOM_SPACE_SIZE, ROOM_SPACE_SIZE);
                    break;
                }
            }
        });
    }
}
