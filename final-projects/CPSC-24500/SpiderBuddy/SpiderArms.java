import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

class Shoulder extends JPanel {
    private SpiderColors characterPalate;
    private Boolean isRight;
    private int shoulderX, shoulderY, armX, armY;
    public double delt;

    public void setColor(int character) {
        characterPalate = new SpiderColors(character);
    }

    public void setShoulderX(int rShoulderX) {
        shoulderX = rShoulderX;
    }

    public int getShoulderX() {
        return shoulderX;
    }

    public void setShoulderY(int rShoulderY) {
        shoulderY = rShoulderY;
    }

    public int getShoulderY() {
        return shoulderY;
    }

    public void setArmX(int rArmX) {
        armX = rArmX;
    }

    public int getArmX() {
        return armX;
    }

    public void setArmY(int rArmY) {
        armY = rArmY;
    }

    public int getArmY() {
        return armY;
    }

    public void setDelt(double deltIn) {
        delt = deltIn;
    }

    public double getDelt() {
        return delt;
    }

    public Shoulder(int isRightIn, int shoulderXIn, int shoulderYIn, int armXIn, int armYIn, double deltIn,
            int character) {
        characterPalate = new SpiderColors(character);
        if (isRightIn == 0) {
            isRight = true;
        } else {
            isRight = false;
        }
        shoulderX = shoulderXIn;
        shoulderY = shoulderYIn;
        armX = armXIn;
        armY = armYIn;
        delt = deltIn;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform base = g2d.getTransform();
        g2d.rotate(delt, shoulderX, shoulderY);
        g2d.setColor(characterPalate.getSuitPrimaryColor());
        g2d.fillOval(shoulderX - 11, shoulderY - 15, 22, 30);
        if (isRight) {
            g2d.setColor(characterPalate.getSuitSecondaryColor());
            g2d.fillArc(shoulderX - 11, shoulderY - 15, 22, 30, -90, (int) Math.toDegrees(delt) - 30);
            g2d.setColor(characterPalate.getSuitOutlineColor());
            g2d.drawArc(shoulderX - 11, shoulderY - 15, 22, 30, -90, (int) Math.toDegrees(delt) - 30);
        } else {
            g2d.setColor(characterPalate.getSuitSecondaryColor());
            g2d.fillArc(shoulderX - 11, shoulderY - 15, 22, 30, -90, (int) Math.toDegrees(delt) + 30);
            g2d.setColor(characterPalate.getSuitOutlineColor());
            g2d.drawArc(shoulderX - 11, shoulderY - 15, 22, 30, -90, (int) Math.toDegrees(delt) + 30);
        }
        g2d.setColor(characterPalate.getSuitOutlineColor());
        g2d.drawOval(shoulderX - 11, shoulderY - 15, 22, 30);

        g2d.setTransform(base);
    }
}

class UpperArm extends JPanel {
    private SpiderColors characterPalate;
    private Boolean isRight;
    private int armX, armY, forearmX, forearmY;
    private double delt;

    public void setColor(int character) {
        characterPalate = new SpiderColors(character);
    }

    public void setArmX(int rArmX) {
        armX = rArmX;
    }

    public int getArmX() {
        return armX;
    }

    public void setArmY(int rArmY) {
        armY = rArmY;
    }

    public int getArmY() {
        return armY;
    }

    public void setForearmX(int rForearmX) {
        forearmX = rForearmX;
    }

    public int getForearmX() {
        return forearmX;
    }

    public void setForearmY(int rForearmY) {
        forearmY = rForearmY;
    }

    public int getForearmY() {
        return forearmY;
    }

    public void setDelt(double deltIn) {
        delt = deltIn;
    }

    public double getDelt() {
        return delt;
    }

    public UpperArm(int isRightIn, int armXIn, int armYIn, int forearmXIn, int forearmYIn, double deltIn,
            int character) {
        characterPalate = new SpiderColors(character);
        if (isRightIn == 0) {
            isRight = true;
        } else {
            isRight = false;
        }
        armX = armXIn;
        armY = armYIn;
        forearmX = forearmXIn;
        forearmY = forearmYIn;
        delt = deltIn;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform base = g2d.getTransform();
        g2d.rotate(delt, armX, armY);
        g2d.setColor(characterPalate.getSuitPrimaryColor());
        g2d.fillPolygon(new int[] { armX - 4, armX - 9, armX - 7, armX - 4, armX + 4, armX + 7, armX + 9, armX + 4 },
                new int[] { armY - 5, armY + 5, armY + 13, armY + 20, armY + 20, armY + 13, armY + 5, armY - 5 }, 8);

        if (isRight) {
            g2d.setColor(characterPalate.getSuitSecondaryColor());
            g2d.fillPolygon(new int[] { armX - 4, armX - 9, armX - 7, armX - 4, armX, armX },
                    new int[] { armY - 5, armY + 5, armY + 13, armY + 20, armY + 20, armY - 5 }, 6);
            g2d.setColor(characterPalate.getSuitOutlineColor());
            g2d.drawPolygon(new int[] { armX - 4, armX - 9, armX - 7, armX - 4, armX, armX },
                    new int[] { armY - 5, armY + 5, armY + 13, armY + 20, armY + 20, armY - 5 }, 6);
        } else {
            g2d.setColor(characterPalate.getSuitSecondaryColor());
            g2d.fillPolygon(
                    new int[] { armX, armX, armX + 4, armX + 7, armX + 9, armX + 4 },
                    new int[] { armY - 5, armY + 20, armY + 20, armY + 13, armY + 5, armY - 5 },
                    6);
            g2d.setColor(characterPalate.getSuitOutlineColor());
            g2d.drawPolygon(
                    new int[] { armX, armX, armX + 4, armX + 7, armX + 9, armX + 4 },
                    new int[] { armY - 5, armY + 20, armY + 20, armY + 13, armY + 5, armY - 5 },
                    6);
        }
        g2d.setColor(characterPalate.getSuitOutlineColor());
        g2d.drawPolygon(new int[] { armX - 4, armX - 9, armX - 7, armX - 4, armX + 4, armX + 7, armX + 9, armX + 4 },
                new int[] { armY - 5, armY + 5, armY + 13, armY + 20, armY + 20, armY + 13, armY + 5, armY - 5 }, 8);

        g2d.setTransform(base);
    }

}

class Forearm extends JPanel {
    private SpiderColors characterPalate;
    private Boolean isRight;
    private int forearmX, forearmY, handX, handY;
    private double elbow;

    public void setColor(int character) {
        characterPalate = new SpiderColors(character);
    }

    public void setForearmX(int rForearmX) {
        forearmX = rForearmX;
    }

    public int getForearmX() {
        return forearmX;
    }

    public void setForearmY(int rForearmY) {
        forearmY = rForearmY;
    }

    public int getForearmY() {
        return forearmY;
    }

    public void setHandX(int lHandX) {
        handX = lHandX;
    }

    public int getHandX() {
        return handX;
    }

    public void setHandY(int lHandY) {
        handY = lHandY;
    }

    public int getHandY() {
        return handY;
    }

    public void setElbow(double elbowIn) {
        elbow = elbowIn;
    }

    public double getElbow() {
        return elbow;
    }

    public Forearm(int isRightIn, int forearmXIn, int forearmYIn, int handXIn, int handYIn, double elbowIn,
            int character) {
        characterPalate = new SpiderColors(character);
        if (isRightIn == 0) {
            isRight = true;
        } else {
            isRight = false;
        }
        forearmX = forearmXIn;
        forearmY = forearmYIn;
        handX = handXIn;
        handY = handYIn;
        elbow = elbowIn;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform base = g2d.getTransform();
        g2d.rotate(elbow, forearmX, forearmY);
        g2d.setColor(characterPalate.getSuitPrimaryColor());
        g2d.fillPolygon(new int[] { forearmX - 3, forearmX - 4, forearmX - 5, forearmX - 8, forearmX - 6, forearmX - 3,
                forearmX + 3, forearmX + 6, forearmX + 8, forearmX + 5, forearmX + 4, forearmX + 3 },
                new int[] { forearmY, forearmY + 1, forearmY + 3, forearmY + 10, forearmY + 22, forearmY + 35,
                        forearmY + 35, forearmY + 22, forearmY + 10, forearmY + 3, forearmY + 1, forearmY },
                12);

        if (isRight) {
            g2d.setColor(characterPalate.getSuitSecondaryColor());
            g2d.fillPolygon(new int[] { forearmX - 3, forearmX - 4, forearmX - 5, forearmX - 8, forearmX, forearmX },
                    new int[] { forearmY, forearmY + 1, forearmY + 3, forearmY + 8, forearmY + 7, forearmY },
                    6);
            g2d.setColor(characterPalate.getSuitOutlineColor());
            g2d.drawPolygon(new int[] { forearmX, forearmX, forearmX + 8, forearmX + 5, forearmX + 4, forearmX + 3 },
                    new int[] { forearmY, forearmY + 8, forearmY + 8, forearmY + 3, forearmY + 1, forearmY },
                    6);
            g2d.drawPolygon(new int[] { forearmX - 3, forearmX - 4, forearmX - 5, forearmX - 8, forearmX, forearmX },
                    new int[] { forearmY, forearmY + 1, forearmY + 3, forearmY + 8, forearmY + 7, forearmY },
                    6);
        } else {
            g2d.setColor(characterPalate.getSuitSecondaryColor());
            g2d.fillPolygon(new int[] { forearmX, forearmX, forearmX + 8, forearmX + 5, forearmX + 4, forearmX + 3 },
                    new int[] { forearmY, forearmY + 8, forearmY + 8, forearmY + 3, forearmY + 1, forearmY },
                    6);
            g2d.setColor(characterPalate.getSuitOutlineColor());
            g2d.drawPolygon(new int[] { forearmX, forearmX, forearmX + 8, forearmX + 5, forearmX + 4, forearmX + 3 },
                    new int[] { forearmY, forearmY + 8, forearmY + 8, forearmY + 3, forearmY + 1, forearmY },
                    6);
            g2d.drawPolygon(new int[] { forearmX - 3, forearmX - 4, forearmX - 5, forearmX - 8, forearmX, forearmX },
                    new int[] { forearmY, forearmY + 1, forearmY + 3, forearmY + 8, forearmY + 7, forearmY },
                    6);
        }
        g2d.setColor(characterPalate.getSuitOutlineColor());
        g2d.drawPolygon(new int[] { forearmX - 3, forearmX - 4, forearmX - 5, forearmX - 8, forearmX - 6, forearmX - 3,
                forearmX + 3, forearmX + 6, forearmX + 8, forearmX + 5, forearmX + 4, forearmX + 3 },
                new int[] { forearmY, forearmY + 1, forearmY + 3, forearmY + 10, forearmY + 22, forearmY + 35,
                        forearmY + 35, forearmY + 22, forearmY + 10, forearmY + 3, forearmY + 1, forearmY },
                12);

        g2d.setTransform(base);

    }
}

class Hand extends JPanel {
    private SpiderColors characterPalate;
    private Boolean isRight;
    private int handType, handX, handY, thumbX, thumbY, indexX, indexY, middleX, middleY, ringX, ringY, pinkieX,
            pinkieY;
    private double wrist, thumb, index, middle, ring, pinkie;

    public void setColor(int character) {
        characterPalate = new SpiderColors(character);
    }

    public void setHandX(int lHandX) {
        handX = lHandX;
    }

    public int getHandX() {
        return handX;
    }

    public void setHandY(int lHandY) {
        handY = lHandY;
    }

    public int getHandY() {
        return handY;
    }

    public void setWrist(double wristIn) {
        wrist = wristIn;
    }

    public double getWrist() {
        return wrist;
    }

    public void setHandType(int type) {
        handType = type;
    }

    public int getHandType() {
        return handType;
    }

    public void setThumb(double thumbIn) {
        thumb = thumbIn;
    }

    public double getThumb() {
        return thumb;
    }

    public void setIndex(double indexIn) {
        index = indexIn;
    }

    public double getIndex() {
        return index;
    }

    public void setMiddle(double middleIn) {
        middle = middleIn;
    }

    public double getMiddle() {
        return middle;
    }

    public void setRing(double ringIn) {
        ring = ringIn;
    }

    public double getRing() {
        return ring;
    }

    public void setPinkie(double pinkieIn) {
        pinkie = pinkieIn;
    }

    public double getPinkie() {
        return pinkie;
    }

    public void setThumbX(int thumbXIn) {
        thumbX = thumbXIn;
    }

    public int getThumbX() {
        return thumbX;
    }

    public void setIndexX(int indexXIn) {
        indexX = indexXIn;
    }

    public int getIndexX() {
        return indexX;
    }

    public void setMiddleX(int middleXIn) {
        middleX = middleXIn;
    }

    public int getMiddleX() {
        return middleX;
    }

    public void setRingX(int ringXIn) {
        ringX = ringXIn;
    }

    public int getRingX() {
        return ringX;
    }

    public void setPinkieX(int pinkieXIn) {
        pinkieX = pinkieXIn;
    }

    public int getPinkieX() {
        return pinkieX;
    }

    public void setThumbY(int thumbYIn) {
        thumbY = thumbYIn;
    }

    public int getThumbY() {
        return thumbY;
    }

    public void setIndexY(int indexYIn) {
        indexY = indexYIn;
    }

    public int getIndexY() {
        return indexY;
    }

    public void setMiddleY(int middleYIn) {
        middleY = middleYIn;
    }

    public int getMiddleY() {
        return middleY;
    }

    public void setRingY(int ringYIn) {
        ringY = ringYIn;
    }

    public int getRingY() {
        return ringY;
    }

    public void setPinkieY(int pinkieYIn) {
        pinkieY = pinkieYIn;
    }

    public int getPinkieY() {
        return pinkieY;
    }

    public Hand(int isRightIn, int handTypeIn, int handXIn, int handYIn, double wristIn, int character) {
        characterPalate = new SpiderColors(character);
        if (isRightIn == 0) {
            isRight = true;
        } else {
            isRight = false;
        }
        handX = handXIn;
        handY = handYIn;
        wrist = wristIn;
        handType = handTypeIn;
        thumb = wristIn + Math.toRadians(90);
        index = wristIn + Math.toRadians(10);
        middle = wristIn + Math.toRadians(0);
        ring = wristIn + Math.toRadians(-8);
        pinkie = wristIn + Math.toRadians(-16);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform base = g2d.getTransform();
        g2d.rotate(wrist, handX, handY);

        // Fist
        if (handType == 0) {
            if (isRight) {
                // Palm
                g2d.setColor(characterPalate.getSuitPrimaryColor());
                g2d.fillPolygon(
                        new int[] { handX + 3, handX + 6, handX + 6, handX + 4, handX - 4, handX - 6, handX - 6,
                                handX - 5 },
                        new int[] { handY - 1, handY + 2, handY + 7, handY + 9, handY + 9, handY + 7, handY + 1,
                                handY - 1 },
                        8);
                g2d.setColor(characterPalate.getSuitOutlineColor());
                g2d.drawPolygon(new int[] { handX + 3, handX + 6, handX + 6, handX + 4, handX - 4, handX - 6, handX - 6,
                        handX - 5 },
                        new int[] { handY - 1, handY + 2, handY + 7, handY + 9, handY + 9, handY + 7, handY + 1,
                                handY - 1 },
                        8);

                // Fingers
                g2d.setColor(characterPalate.getSuitPrimaryColor());
                // setIndexX(indexXIn);
                // setIndexY(indexYIn);
                // setMiddleX(middleXIn);
                // setMiddleY(middleYIn);
                // setRingX(ringXIn);
                // setRingY(ringYIn);
                // setPinkieX(pinkieXIn);
                // setPinkieY(pinkieYIn);
                g2d.fillRoundRect(handX + 3, handY + 5, 3, 6, 2, 3);
                g2d.fillRoundRect(handX, handY + 5, 3, 7, 2, 3);
                g2d.fillRoundRect(handX - 3, handY + 5, 3, 7, 2, 3);
                g2d.fillRoundRect(handX - 6, handY + 5, 3, 6, 2, 3);
                g2d.setColor(characterPalate.getSuitOutlineColor());
                g2d.drawRoundRect(handX + 3, handY + 5, 3, 6, 1, 1);
                g2d.drawRoundRect(handX, handY + 5, 3, 7, 2, 3);
                g2d.drawRoundRect(handX - 3, handY + 5, 3, 7, 2, 3);
                g2d.drawRoundRect(handX - 6, handY + 5, 3, 6, 2, 3);

                // Thumb
                g2d.setColor(characterPalate.getSuitPrimaryColor());
                g2d.fillPolygon(new int[] { handX + 4, handX + 6, handX + 5, handX - 1, handX - 1, handX + 1, handX + 2,
                        handX + 2, handX - 2, handX - 1 },
                        new int[] { handY - 2, handY + 2, handY + 9, handY + 10, handY + 8, handY + 6, handY + 6,
                                handY + 4, handY + 1, handY - 2 },
                        10);
                g2d.setColor(characterPalate.getSuitOutlineColor());
                g2d.drawPolygon(new int[] { handX + 4, handX + 6, handX + 5, handX - 1, handX - 1, handX + 1, handX + 2,
                        handX + 2, handX - 2, handX - 1 },
                        new int[] { handY - 2, handY + 2, handY + 9, handY + 10, handY + 8, handY + 6, handY + 6,
                                handY + 4, handY + 1, handY - 2 },
                        10);

            } else {
                // Palm
                g2d.setColor(characterPalate.getSuitPrimaryColor());
                g2d.fillPolygon(
                        new int[] { handX - 3, handX - 6, handX - 6, handX - 4, handX + 4, handX + 6, handX + 6,
                                handX + 5 },
                        new int[] { handY - 1, handY + 2, handY + 7, handY + 9, handY + 9, handY + 7, handY + 1,
                                handY - 1 },
                        8);

                g2d.setColor(characterPalate.getSuitOutlineColor());
                g2d.drawPolygon(new int[] { handX - 3, handX - 6, handX - 6, handX - 4, handX + 4, handX + 6, handX + 6,
                        handX + 5 },
                        new int[] { handY - 1, handY + 2, handY + 7, handY + 9, handY + 9, handY + 7, handY + 1,
                                handY - 1 },
                        8);
                g2d.setColor(characterPalate.getSuitPrimaryColor());

                // Fingers
                g2d.fillRoundRect(handX + 3, handY + 5, 3, 6, 2, 3);
                g2d.fillRoundRect(handX, handY + 5, 3, 7, 2, 3);
                g2d.fillRoundRect(handX - 3, handY + 5, 3, 7, 2, 3);
                g2d.fillRoundRect(handX - 6, handY + 5, 3, 6, 2, 3);
                g2d.setColor(characterPalate.getSuitOutlineColor());
                g2d.drawRoundRect(handX + 3, handY + 5, 3, 6, 1, 1);
                g2d.drawRoundRect(handX, handY + 5, 3, 7, 2, 3);
                g2d.drawRoundRect(handX - 3, handY + 5, 3, 7, 2, 3);
                g2d.drawRoundRect(handX - 6, handY + 5, 3, 6, 2, 3);

                // Thumb
                g2d.setColor(characterPalate.getSuitPrimaryColor());
                g2d.fillPolygon(new int[] { handX - 4, handX - 6, handX - 5, handX + 1, handX + 1, handX - 1, handX - 2,
                        handX - 2, handX + 2, handX + 1 },
                        new int[] { handY - 2, handY + 2, handY + 9, handY + 10, handY + 8, handY + 6, handY + 6,
                                handY + 4, handY + 1, handY - 2 },
                        10);
                g2d.setColor(characterPalate.getSuitOutlineColor());
                g2d.drawPolygon(new int[] { handX - 4, handX - 6, handX - 5, handX + 1, handX + 1, handX - 1, handX - 2,
                        handX - 2, handX + 2, handX + 1 },
                        new int[] { handY - 2, handY + 2, handY + 9, handY + 10, handY + 8, handY + 6, handY + 6,
                                handY + 4, handY + 1, handY - 2 },
                        10);
            }
            // Open Hand
        } else if (handType == 1) {
            if (isRight) {
                // Palm
                g2d.setColor(characterPalate.getSuitPrimaryColor());
                g2d.fillPolygon(
                        new int[] { handX + 3, handX + 6, handX + 6, handX + 4, handX + 1, handX - 4, handX - 6,
                                handX - 6,
                                handX - 5 },
                        new int[] { handY - 1, handY + 2, handY + 7, handY + 9, handY + 11, handY + 9, handY + 7,
                                handY + 1,
                                handY - 1 },
                        9);
                g2d.setColor(characterPalate.getSuitOutlineColor());
                g2d.drawPolygon(
                        new int[] { handX + 3, handX + 6, handX + 6, handX + 4, handX + 1, handX - 4, handX - 6,
                                handX - 6,
                                handX - 5 },
                        new int[] { handY - 1, handY + 2, handY + 7, handY + 9, handY + 11, handY + 9, handY + 7,
                                handY + 1,
                                handY - 1 },
                        9);

                // Fingers
                g2d.setColor(characterPalate.getSuitPrimaryColor());
                g2d.fillRoundRect(handX + 3, handY + 8, 3, 9, 2, 3);
                g2d.fillRoundRect(handX, handY + 9, 3, 10, 2, 3);
                g2d.fillRoundRect(handX - 3, handY + 8, 3, 10, 2, 3);
                g2d.fillRoundRect(handX - 6, handY + 7, 3, 9, 2, 3);
                g2d.setColor(characterPalate.getSuitOutlineColor());
                g2d.drawRoundRect(handX + 3, handY + 8, 3, 9, 1, 1);
                g2d.drawRoundRect(handX, handY + 9, 3, 10, 2, 3);
                g2d.drawRoundRect(handX - 3, handY + 8, 3, 10, 2, 3);
                g2d.drawRoundRect(handX - 6, handY + 7, 3, 9, 2, 3);

                // Thumb
                g2d.setColor(characterPalate.getSuitPrimaryColor());
                g2d.fillPolygon(
                        new int[] { handX + 4, handX + 7, handX + 11, handX + 14, handX + 14, handX + 12, handX + 10,
                                handX + 8, handX + 6, handX + 4, handX + 2, handX + 2 },
                        new int[] { handY - 1, handY, handY + 2, handY + 3, handY + 4, handY + 5, handY + 4, handY + 4,
                                handY + 5, handY + 5, handY + 3, handY - 1 },
                        12);
                g2d.setColor(characterPalate.getSuitOutlineColor());
                g2d.drawPolygon(
                        new int[] { handX + 4, handX + 7, handX + 11, handX + 14, handX + 14, handX + 12, handX + 10,
                                handX + 8, handX + 6, handX + 4, handX + 2, handX + 2 },
                        new int[] { handY - 1, handY, handY + 2, handY + 3, handY + 4, handY + 5, handY + 4, handY + 4,
                                handY + 5, handY + 5, handY + 3, handY - 1 },
                        12);

            } else {
                // Palm
                g2d.setColor(characterPalate.getSuitPrimaryColor());
                g2d.fillPolygon(
                        new int[] { handX - 3, handX - 6, handX - 6, handX - 4, handX + 4, handX + 6, handX + 6,
                                handX + 5 },
                        new int[] { handY - 1, handY + 2, handY + 7, handY + 9, handY + 9, handY + 7, handY + 1,
                                handY - 1 },
                        8);

                g2d.setColor(characterPalate.getSuitOutlineColor());
                g2d.drawPolygon(
                        new int[] { handX - 3, handX - 6, handX - 6, handX - 4, handX + 4, handX + 6, handX + 6,
                                handX + 5 },
                        new int[] { handY - 1, handY + 2, handY + 7, handY + 9, handY + 9, handY + 7, handY + 1,
                                handY - 1 },
                        8);
                g2d.setColor(characterPalate.getSuitPrimaryColor());

                // Fingers
                g2d.fillRoundRect(handX + 3, handY + 5, 3, 6, 2, 3);
                g2d.fillRoundRect(handX, handY + 5, 3, 7, 2, 3);
                g2d.fillRoundRect(handX - 3, handY + 5, 3, 7, 2, 3);
                g2d.fillRoundRect(handX - 6, handY + 5, 3, 6, 2, 3);
                g2d.setColor(characterPalate.getSuitOutlineColor());
                g2d.drawRoundRect(handX + 3, handY + 5, 3, 6, 1, 1);
                g2d.drawRoundRect(handX, handY + 5, 3, 7, 2, 3);
                g2d.drawRoundRect(handX - 3, handY + 5, 3, 7, 2, 3);
                g2d.drawRoundRect(handX - 6, handY + 5, 3, 6, 2, 3);

                // Thumb
                g2d.setColor(characterPalate.getSuitPrimaryColor());
                g2d.fillPolygon(
                        new int[] { handX - 4, handX - 6, handX - 5, handX + 1, handX + 1, handX - 1, handX - 2,
                                handX - 2, handX + 2, handX + 1 },
                        new int[] { handY - 2, handY + 2, handY + 9, handY + 10, handY + 8, handY + 6, handY + 6,
                                handY + 4, handY + 1, handY - 2 },
                        10);
                g2d.setColor(characterPalate.getSuitOutlineColor());
                g2d.drawPolygon(
                        new int[] { handX - 4, handX - 6, handX - 5, handX + 1, handX + 1, handX - 1, handX - 2,
                                handX - 2, handX + 2, handX + 1 },
                        new int[] { handY - 2, handY + 2, handY + 9, handY + 10, handY + 8, handY + 6, handY + 6,
                                handY + 4, handY + 1, handY - 2 },
                        10);
            }

        }
        g2d.setTransform(base);
    }
}