import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

class Quad extends JPanel {
    private SpiderColors characterPalate;
    private Boolean isRight;
    private int quadX, quadY, calfX, calfY;
    private double hip;

    public void setHip(double hipIn){
        hip = hipIn;
    }

    public double getHip(){
        return hip;
    }

    public void setColor(int character) {
        characterPalate = new SpiderColors(character);
    }

    public void setQuadX(int rQuadX) {
        quadX = rQuadX;
    }

    public int getQuadX() {
        return quadX;
    }

    public void setQuadY(int rQuadY) {
        quadY = rQuadY;
    }

    public int getQuadY() {
        return quadY;
    }

    public void setCalfX(int rCalfX) {
        calfX = rCalfX;
    }

    public int getCalfX() {
        return calfX;
    }

    public void setCalfY(int rCalfY) {
        calfY = rCalfY;
    }

    public int getCalfY() {
        return calfY;
    }

    public Quad(int isRightIn, int quadXIn, int quadYIn, int calfXIn, int calfYIn, double hipIn,
            int character) {
        characterPalate = new SpiderColors(character);
        if (isRightIn == 0) {
            isRight = true;
        } else {
            isRight = false;
        }
        quadX = quadXIn;
        quadY = quadYIn;
        calfX = calfXIn;
        calfY = calfYIn;
        hip = hipIn;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform base = g2d.getTransform();
        g2d.rotate(hip, quadX, quadY);
        g2d.setColor(characterPalate.getSuitSecondaryColor());
        g2d.fillArc(quadX - 11, quadY - 7, 22, 14, 0, 180);
        g2d.setColor(characterPalate.getSuitOutlineColor());
        g2d.drawArc(quadX - 11, quadY - 7, 22, 14, 0, 180);
        if (isRight) {
            g2d.setColor(characterPalate.getSuitSecondaryColor());
            g2d.fillPolygon(new int[] { quadX + 11, quadX + 12, quadX + 11, quadX + 10, quadX + 3, quadX - 4, quadX - 8,
                    quadX - 9, quadX - 10, quadX - 11, quadX - 11 },
                    new int[] { quadY, quadY + 6, quadY + 15, quadY + 26, quadY + 32, quadY + 32, quadY + 24,
                            quadY + 15, quadY + 11, quadY + 5, quadY },
                    11);
            g2d.setColor(characterPalate.getSuitOutlineColor());

            g2d.drawPolyline(
                    new int[] { quadX + 11, quadX + 12, quadX + 11, quadX + 10, quadX + 3, quadX - 4, quadX - 8,
                            quadX - 9, quadX - 10, quadX - 11, quadX - 11 },
                    new int[] { quadY, quadY + 6, quadY + 15, quadY + 26, quadY + 32, quadY + 32, quadY + 24,
                            quadY + 15, quadY + 11, quadY + 5, quadY },
                    11);

        } else {
            g2d.setColor(characterPalate.getSuitSecondaryColor());
            g2d.fillPolygon(new int[] { quadX - 11, quadX - 12, quadX - 11, quadX - 10, quadX - 3, quadX + 4, quadX + 8,
                    quadX + 9, quadX + 10, quadX + 11, quadX + 11 },
                    new int[] { quadY, quadY + 6, quadY + 15, quadY + 26, quadY + 32, quadY + 32, quadY + 24,
                            quadY + 15, quadY + 11, quadY + 5, quadY },
                    11);
            g2d.setColor(characterPalate.getSuitOutlineColor());
            g2d.drawPolyline(
                    new int[] { quadX - 11, quadX - 12, quadX - 11, quadX - 10, quadX - 3, quadX + 4, quadX + 8,
                            quadX + 9, quadX + 10, quadX + 11, quadX + 11 },
                    new int[] { quadY, quadY + 6, quadY + 15, quadY + 26, quadY + 32, quadY + 32, quadY + 24,
                            quadY + 15, quadY + 11, quadY + 5, quadY },
                    11);
        }
        g2d.setTransform(base);
    }
}

class Calf extends JPanel {
    private SpiderColors characterPalate;
    private Boolean isRight;
    private int calfType, calfX, calfY, footX, footY;
    private double knee;

    public void setKnee(double kneeIn){
        knee = kneeIn;
    }

    public double getKnee(){
        return knee;
    }

    public void setColor(int character) {
        characterPalate = new SpiderColors(character);
    }

    public void setCalfX(int rCalfX) {
        calfX = rCalfX;
    }

    public int getCalfX() {
        return calfX;
    }

    public void setCalfY(int rCalfY) {
        calfY = rCalfY;
    }

    public int getCalfY() {
        return calfY;
    }

    public void setFootX(int rFootX) {
        footX = rFootX;
    }

    public int getFootX() {
        return footX;
    }

    public void setFootY(int rFootY) {
        footY = rFootY;
    }

    public int getFootY() {
        return footY;
    }

    public void setCalfType(int type) {
        calfType = type;
    }

    public int getCalfType() {
        return calfType;
    }

    public Calf(int isRightIn, int calfTypeIn, int calfXIn, int calfYIn, int footXIn, int footYIn, double kneeIn,
            int character) {
        characterPalate = new SpiderColors(character);
        if (isRightIn == 0) {
            isRight = true;
        } else {
            isRight = false;
        }

        calfX = calfXIn;
        calfY = calfYIn;
        footX = footXIn;
        footY = footYIn;
        knee = kneeIn;
        setCalfType(calfTypeIn);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform base = g2d.getTransform();
        g2d.rotate(knee, calfX, calfY);

        // Side View
        if (getCalfType() == 0) {

            // Right Calf
            if (isRight) {
                g2d.setColor(characterPalate.getSuitSecondaryColor());
                g2d.fillPolygon(
                        new int[] { calfX, calfX + 6, calfX + 7, calfX + 5, calfX + 4, calfX + 5, calfX - 5,
                                calfX - 5, calfX - 8, calfX - 9, calfX - 8, calfX - 6, calfX - 4, calfX - 2 },
                        new int[] { calfY - 5, calfY - 4, calfY + 7, calfY + 17, calfY + 35, calfY + 41, calfY + 41,
                                calfY + 35, calfY + 24, calfY + 15, calfY + 8, calfY + 3, calfY + 1, calfY - 3 },
                        14);
                g2d.setColor(characterPalate.getSuitPrimaryColor());
                g2d.fillPolygon(
                        new int[] { calfX + 7, calfX + 5, calfX + 4, calfX + 5, calfX - 5,
                                calfX - 5, calfX - 8, calfX - 9, calfX - 4, calfX + 3 },
                        new int[] { calfY + 7, calfY + 17, calfY + 35, calfY + 41, calfY + 41,
                                calfY + 35, calfY + 24, calfY + 15, calfY + 11, calfY + 9 },
                        10);
                g2d.setColor(characterPalate.getSuitOutlineColor());
                g2d.drawPolygon(
                        new int[] { calfX + 7, calfX + 5, calfX + 4, calfX + 5, calfX - 5,
                                calfX - 5, calfX - 8, calfX - 9, calfX - 4, calfX + 3 },
                        new int[] { calfY + 7, calfY + 17, calfY + 35, calfY + 41, calfY + 41,
                                calfY + 35, calfY + 24, calfY + 15, calfY + 11, calfY + 9 },
                        10);
                g2d.drawPolygon(
                        new int[] { calfX, calfX + 6, calfX + 7, calfX + 5, calfX + 4, calfX + 5, calfX - 5,
                                calfX - 5, calfX - 8, calfX - 9, calfX - 8, calfX - 6, calfX - 4, calfX - 2 },
                        new int[] { calfY - 5, calfY - 4, calfY + 7, calfY + 17, calfY + 35, calfY + 41, calfY + 41,
                                calfY + 35, calfY + 24, calfY + 15, calfY + 8, calfY + 3, calfY + 1, calfY - 3 },
                        14);

                // Left Calf
            } else {
                g2d.setColor(characterPalate.getSuitSecondaryColor());
                g2d.fillPolygon(
                        new int[] { calfX, calfX - 6, calfX - 7, calfX - 5, calfX - 4, calfX - 5, calfX + 5,
                                calfX + 5, calfX + 8, calfX + 9, calfX + 8, calfX + 6, calfX + 4, calfX + 2 },
                        new int[] { calfY - 5, calfY - 4, calfY + 7, calfY + 17, calfY + 35, calfY + 41, calfY + 41,
                                calfY + 35, calfY + 24, calfY + 15, calfY + 8, calfY + 3, calfY + 1, calfY - 3 },
                        14);
                g2d.setColor(characterPalate.getSuitPrimaryColor());
                g2d.fillPolygon(
                        new int[] { calfX - 7, calfX - 5, calfX - 4, calfX - 5, calfX + 5,
                                calfX + 5, calfX + 8, calfX + 9, calfX + 4, calfX - 3 },
                        new int[] { calfY + 7, calfY + 17, calfY + 35, calfY + 41, calfY + 41,
                                calfY + 35, calfY + 24, calfY + 15, calfY + 11, calfY + 9 },
                        10);
                g2d.setColor(characterPalate.getSuitOutlineColor());
                g2d.drawPolygon(
                        new int[] { calfX, calfX - 6, calfX - 7, calfX - 5, calfX - 4, calfX - 5, calfX + 5,
                                calfX + 5, calfX + 8, calfX + 9, calfX + 8, calfX + 6, calfX + 4, calfX + 2 },
                        new int[] { calfY - 5, calfY - 4, calfY + 7, calfY + 17, calfY + 35, calfY + 41, calfY + 41,
                                calfY + 35, calfY + 24, calfY + 15, calfY + 8, calfY + 3, calfY + 1, calfY - 3 },
                        14);

            }

            // Front View ***IF NEEDED***
        } else if (getCalfType() == 1) {

        }

        g2d.setTransform(base);
    }

}

class Foot extends JPanel {
    private SpiderColors characterPalate;
    private Boolean isRight, isSide;
    private int footType, footX, footY;
    private double ankle;

    public void setAnkle(double ankleIn){
        ankle = ankleIn;
    }

    public double getAnkle(){
        return ankle;
    }

    public void setColor(int character) {
        characterPalate = new SpiderColors(character);
    }

    public void setFootX(int rFootX) {
        footX = rFootX;
    }

    public int getFootX() {
        return footX;
    }

    public void setFootY(int rFootY) {
        footY = rFootY;
    }

    public int getFootY() {
        return footY;
    }

    public void setFootType(int type) {
        footType = type;
    }

    public int getFootType() {
        return footType;
    }

    public Foot(int isRightIn, int footTypeIn, int footXIn, int footYIn, double ankleIn,
            int character) {
        characterPalate = new SpiderColors(character);
        if (isRightIn == 0) {
            isRight = true;
        } else {
            isRight = false;
        }
        footX = footXIn;
        footY = footYIn;
        ankle = ankleIn;
        setFootType(footTypeIn);

    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform base = g2d.getTransform();
        g2d.rotate(ankle, footX, footY);

        // Side View
        if (getFootType() == 0) {
            if (isRight) {
                g2d.setColor(characterPalate.getSuitPrimaryColor());
                g2d.fillPolygon(new int[] { footX + 4, footX + 6, footX + 8, footX + 20, footX + 20, footX + 7,
                        footX + 5, footX, footX - 2, footX - 6, footX - 7, footX - 4 },
                        new int[] { footY - 3, footY, footY + 2, footY + 7, footY + 9, footY + 9, footY + 8, footY + 8,
                                footY + 9, footY + 9, footY + 4, footY - 3 },
                        12);
                g2d.setColor(characterPalate.getSuitOutlineColor());
                g2d.drawPolygon(new int[] { footX + 4, footX + 6, footX + 8, footX + 20, footX + 20, footX + 7,
                        footX + 5, footX, footX - 2, footX - 6, footX - 7, footX - 4 },
                        new int[] { footY - 3, footY, footY + 2, footY + 7, footY + 9, footY + 9, footY + 8, footY + 8,
                                footY + 9, footY + 9, footY + 4, footY - 3 },
                        12);
            } else {
                g2d.setColor(characterPalate.getSuitPrimaryColor());
                g2d.fillPolygon(new int[] { footX - 4, footX - 6, footX - 8, footX - 20, footX - 20, footX - 7,
                        footX - 5, footX, footX + 2, footX + 6, footX + 7, footX + 4 },
                        new int[] { footY - 3, footY, footY + 2, footY + 7, footY + 9, footY + 9, footY + 8, footY + 8,
                                footY + 9, footY + 9, footY + 4, footY - 3 },
                        12);
                g2d.setColor(characterPalate.getSuitOutlineColor());
                g2d.drawPolygon(new int[] { footX - 4, footX - 6, footX - 8, footX - 20, footX - 20, footX - 7,
                        footX - 5, footX, footX + 2, footX + 6, footX + 7, footX + 4 },
                        new int[] { footY - 3, footY, footY + 2, footY + 7, footY + 9, footY + 9, footY + 8, footY + 8,
                                footY + 9, footY + 9, footY + 4, footY - 3 },
                        12);

            }
            // Front View
        } else {
            System.out.println("TO BE MADE");
        }

        g2d.setTransform(base);
    }

}