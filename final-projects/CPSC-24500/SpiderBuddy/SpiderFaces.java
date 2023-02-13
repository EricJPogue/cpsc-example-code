import javax.swing.JPanel;
import java.util.ArrayList;
import java.awt.Graphics;

public class SpiderFaces extends JPanel {
    private ArrayList<Heads> headList;
    private Heads currentHead;
    public int currentFace, positionX, positionY;

    public SpiderFaces(int positionX, int positionY, int character) {
        this.positionX = positionX;
        this.positionY = positionY;
        headList = new ArrayList<Heads>();
        for (int i = 0; i < 16; i++) {
            switch (i) {
                case 0:
                    headList.add(new CoveredFace(positionX, positionY, character));
                    break;
                case 1:
                    headList.add(new HappyFace(positionX, positionY, character));
                    break;
                case 2:
                    headList.add(new ConfusedFace(positionX, positionY, character));
                    break;
                case 3:
                    headList.add(new SurprisedFace(positionX, positionY, character));
                    break;
                case 4:
                    headList.add(new NeutralFace(positionX, positionY, character));
                    break;
                case 5:
                    headList.add(new SadFace(positionX, positionY, character));
                    break;
                case 6:
                    headList.add(new AngryFace(positionX, positionY, character));
                    break;
                case 7:
                    headList.add(new MadFace(positionX, positionY, character));
                    break;
                case 8:
                    headList.add(new YellingFace(positionX, positionY, character));
                    break;
                case 9:
                    headList.add(new ChattingFace(positionX, positionY, character));
                    break;
                case 10:
                    headList.add(new SleepyFace(positionX, positionY, character));
                    break;
                case 11:
                    headList.add(new LaughingFace(positionX, positionY, character));
                    break;
                case 12:
                    headList.add(new WinkingFace(positionX, positionY, character));
                    break;
                case 13:
                    headList.add(new SnoringFace(positionX, positionY, character));
                    break;
                case 14:
                    headList.add(new NormalFace(positionX, positionY, character));
                    break;
                case 15:
                    headList.add(new UltraLaughingFace(positionX, positionY, character));
                    break;

            }
        }
        currentHead = headList.get(0);
        currentFace = 0;
    }

    public void changeCharacter(int character) {
        headList.clear();
        for (int i = 0; i < 16; i++) {
            switch (i) {
                case 0:
                    headList.add(new CoveredFace(positionX, positionY, character));
                    break;
                case 1:
                    headList.add(new HappyFace(positionX, positionY, character));
                    break;
                case 2:
                    headList.add(new ConfusedFace(positionX, positionY, character));
                    break;
                case 3:
                    headList.add(new SurprisedFace(positionX, positionY, character));
                    break;
                case 4:
                    headList.add(new NeutralFace(positionX, positionY, character));
                    break;
                case 5:
                    headList.add(new SadFace(positionX, positionY, character));
                    break;
                case 6:
                    headList.add(new AngryFace(positionX, positionY, character));
                    break;
                case 7:
                    headList.add(new MadFace(positionX, positionY, character));
                    break;
                case 8:
                    headList.add(new YellingFace(positionX, positionY, character));
                    break;
                case 9:
                    headList.add(new ChattingFace(positionX, positionY, character));
                    break;
                case 10:
                    headList.add(new SleepyFace(positionX, positionY, character));
                    break;
                case 11:
                    headList.add(new LaughingFace(positionX, positionY, character));
                    break;
                case 12:
                    headList.add(new WinkingFace(positionX, positionY, character));
                    break;
                case 13:
                    headList.add(new SnoringFace(positionX, positionY, character));
                    break;
                case 14:
                    headList.add(new NormalFace(positionX, positionY, character));
                    break;
                case 15:
                    headList.add(new UltraLaughingFace(positionX, positionY, character));
                    break;

            }
        }
        currentHead = headList.get(currentFace);
    }

    public void changeHead(int headX, int headY) {
        positionX = headX;
        positionY = headY;
        currentHead.setHeadPositionX(headX);
        currentHead.setHeadPositionY(headY);

    }

    public void changeFace(int face) {
        currentHead = headList.get(face);
        currentFace = face;
    }

    public void paintComponent(Graphics g) {
        currentHead.paintComponent(g);
    }
}