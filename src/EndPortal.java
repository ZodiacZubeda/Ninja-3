import mayflower.Actor;
import mayflower.Mayflower;

/**
 * @author Shivashriganesh Mahato
 */
public class EndPortal extends Actor {
    @Override
    public void update() {
        setPicture("resources/sprites/EndPortal.png");

        // Check for contact with level's Ninja
        for (Actor actor : getTouching()) {
            if (actor instanceof Ninja) {
                // Once contact has been made, check current level of GameStage. If it is level 3 (which is the last
                // level), display the win screen. Otherwise, go to the next level, inputting the score from the current
                // level (a property of GameStage)
                Mayflower mf = getMayflower();
                GameStage curStage = (GameStage) getStage();
                if (curStage.getCurLevel() == 3)
                    mf.setStage(new WinStage(curStage.getScore()));
                else
                    mf.setStage(new GameStage(curStage.getCurLevel() + 1, curStage.getScore()));
            }
        }
    }
}
