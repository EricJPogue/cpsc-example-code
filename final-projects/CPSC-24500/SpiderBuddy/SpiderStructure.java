import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.Color;

class SpiderStructure extends JPanel {
    private SpiderFaces head;
    private SpiderBody body;
    private Shoulder leftShoulder, rightShoulder;
    private UpperArm leftUpperArm, rightUpperArm;
    private Forearm leftForearm, rightForearm;
    public Hand leftHand, rightHand;
    private Quad leftQuad, rightQuad;
    private Calf leftCalf, rightCalf;
    private Foot leftFoot, rightFoot;
    private Boolean hangingWeb;
    private int character, centerHeadX, centerHeadY, centerChestX, centerChestY, centerAbsX, centerAbsY, centerHipsX,
            centerHipsY, rightQuadX, rightQuadY, rightCalfX, rightCalfY, rightFootX, rightFootY, rightShoulderX,
            rightShoulderY, rightArmX, rightArmY, rightForearmX, rightForearmY, rightHandX, rightHandY, leftQuadX,
            leftQuadY, leftCalfX, leftCalfY, leftFootX, leftFootY, leftShoulderX, leftShoulderY, leftArmX, leftArmY,
            leftForearmX, leftForearmY, leftHandX, leftHandY;
    private double neck, rightDelt, rightElbow, rightWrist, rightHip, rightKnee, rightAnkle, leftDelt, leftElbow,
            leftWrist, leftHip, leftKnee, leftAnkle, bodyAngle;

    public void setCharacter(int characterIn) {
        character = characterIn;
    }

    public int getCharacter() {
        return character;
    }

    public void setCenterHeadX(int headX) {
        centerHeadX = headX;
    }

    public int getCenterHeadX() {
        return centerHeadX;
    }

    public void setCenterHeadY(int headY) {
        centerHeadY = headY;
    }

    public int getCenterHeadY() {
        return centerHeadY;
    }

    public void setCenterChestX(int chestX) {
        centerChestX = chestX;
    }

    public int getCenterChestX() {
        return centerChestX;
    }

    public void setCenterChestY(int chestY) {
        centerChestY = chestY;
    }

    public int getCenterChestY() {
        return centerChestY;
    }

    public void setCenterAbsX(int absX) {
        centerAbsX = absX;
    }

    public int getCenterAbsX() {
        return centerAbsX;
    }

    public void setCenterAbsY(int absY) {
        centerAbsY = absY;
    }

    public int getCenterAbsY() {
        return centerAbsY;
    }

    public void setCenterHipsX(int hipsX) {
        centerHipsX = hipsX;
    }

    public int getCenterHipsX() {
        return centerHipsX;
    }

    public void setCenterHipsY(int hipsY) {
        centerHipsY = hipsY;
    }

    public int getCenterHipsY() {
        return centerHipsY;
    }

    public void setRightQuadX(int rQuadX) {
        rightQuadX = rQuadX;
    }

    public int getRightQuadX() {
        return rightQuadX;
    }

    public void setRightQuadY(int rQuadY) {
        rightQuadY = rQuadY;
    }

    public int getRightQuadY() {
        return rightQuadY;
    }

    public void setRightCalfX(int rCalfX) {
        rightCalfX = rCalfX;
    }

    public int getRightCalfX() {
        return rightCalfX;
    }

    public void setRightCalfY(int rCalfY) {
        rightCalfY = rCalfY;
    }

    public int getRightCalfY() {
        return rightCalfY;
    }

    public void setRightFootX(int rFootX) {
        rightFootX = rFootX;
    }

    public int getRightFootX() {
        return rightFootX;
    }

    public void setRightFootY(int rFootY) {
        rightFootY = rFootY;
    }

    public int getRightFootY() {
        return rightFootY;
    }

    public void setRightShoulderX(int rShoulderX) {
        rightShoulderX = rShoulderX;
    }

    public int getRightShoulderX() {
        return rightShoulderX;
    }

    public void setRightShoulderY(int rShoulderY) {
        rightShoulderY = rShoulderY;
    }

    public int getRightShoulderY() {
        return rightShoulderY;
    }

    public void setRightArmX(int rArmX) {
        rightArmX = rArmX;
    }

    public int getRightArmX() {
        return rightArmX;
    }

    public void setRightArmY(int rArmY) {
        rightArmY = rArmY;
    }

    public int getRightArmY() {
        return rightArmY;
    }

    public void setRightForearmX(int rForearmX) {
        rightForearmX = rForearmX;
    }

    public int getRightForearmX() {
        return rightForearmX;
    }

    public void setRightForearmY(int rForearmY) {
        rightForearmY = rForearmY;
    }

    public int getRightForearmY() {
        return rightForearmY;
    }

    public void setRightHandX(int rHandX) {
        rightHandX = rHandX;
    }

    public int getRightHandX() {
        return rightHandX;
    }

    public void setRightHandY(int rHandY) {
        rightHandY = rHandY;
    }

    public int getRightHandY() {
        return rightHandY;
    }

    public void setLeftQuadX(int lQuadX) {
        leftQuadX = lQuadX;
    }

    public int getLeftQuadX() {
        return leftQuadX;
    }

    public void setLeftQuadY(int lQuadY) {
        leftQuadY = lQuadY;
    }

    public int getLeftQuadY() {
        return leftQuadY;
    }

    public void setLeftCalfX(int lCalfX) {
        leftCalfX = lCalfX;
    }

    public int getLeftCalfX() {
        return leftCalfX;
    }

    public void setLeftCalfY(int lCalfY) {
        leftCalfY = lCalfY;
    }

    public int getLeftCalfY() {
        return leftCalfY;
    }

    public void setLeftFootX(int lFootX) {
        leftFootX = lFootX;
    }

    public int getLeftFootX() {
        return leftFootX;
    }

    public void setLeftFootY(int lFootY) {
        leftFootY = lFootY;
    }

    public int getLeftFootY() {
        return leftFootY;
    }

    public void setLeftShoulderX(int lShoulderX) {
        leftShoulderX = lShoulderX;
    }

    public int getLeftShoulderX() {
        return leftShoulderX;
    }

    public void setLeftShoulderY(int lShoulderY) {
        leftShoulderY = lShoulderY;
    }

    public int getLeftShoulderY() {
        return leftShoulderY;
    }

    public void setLeftArmX(int lArmX) {
        leftArmX = lArmX;
    }

    public int getLeftArmX() {
        return leftArmX;
    }

    public void setLeftArmY(int lArmY) {
        leftArmY = lArmY;
    }

    public int getLeftArmY() {
        return leftArmY;
    }

    public void setLeftForearmX(int lForearmX) {
        leftForearmX = lForearmX;
    }

    public int getLeftForearmX() {
        return leftForearmX;
    }

    public void setLeftForearmY(int lForearmY) {
        leftForearmY = lForearmY;
    }

    public int getLeftForearmY() {
        return leftForearmY;
    }

    public void setLeftHandX(int lHandX) {
        leftHandX = lHandX;
    }

    public int getLeftHandX() {
        return leftHandX;
    }

    public void setLeftHandY(int lHandY) {
        leftHandY = lHandY;
    }

    public int getLeftHandY() {
        return leftHandY;
    }

    public void setNeck(double neckAng) {
        neck = neckAng;
    }

    public double getNeck() {
        return neck;
    }

    public void setRightDelt(double deltAng) {
        rightDelt = deltAng;
    }

    public double getRightDelt() {
        return rightDelt;
    }

    public void setRightElbow(double elbowAng) {
        rightElbow = elbowAng;
    }

    public double getRightElbow() {
        return rightElbow;
    }

    public void setRightWrist(double wristAng) {
        rightWrist = wristAng;
    }

    public double getRightWrist() {
        return rightWrist;
    }

    public void setRightHip(double hipAng) {
        rightHip = hipAng;
    }

    public double getRightHip() {
        return rightHip;
    }

    public void setRightKnee(double kneeAng) {
        rightKnee = kneeAng;
    }

    public double getRightKnee() {
        return rightKnee;
    }

    public void setRightAnkle(double ankleAng) {
        rightAnkle = ankleAng;
    }

    public double getRightAnkle() {
        return rightAnkle;
    }

    public void setLeftDelt(double deltAng) {
        leftDelt = deltAng;
    }

    public double getLeftDelt() {
        return leftDelt;
    }

    public void setLeftElbow(double elbowAng) {
        leftElbow = elbowAng;
    }

    public double getLeftElbow() {
        return leftElbow;
    }

    public void setLeftWrist(double wristAng) {
        leftWrist = wristAng;
    }

    public double getLeftWrist() {
        return leftWrist;
    }

    public void setLeftHip(double hipAng) {
        leftHip = hipAng;
    }

    public double getLeftHip() {
        return leftHip;
    }

    public void setLeftKnee(double kneeAng) {
        leftKnee = kneeAng;
    }

    public double getLeftKnee() {
        return leftKnee;
    }

    public void setLeftAnkle(double ankleAng) {
        leftAnkle = ankleAng;
    }

    public double getLeftAnkle() {
        return leftAnkle;
    }

    public void setBodyAngle(double angIn) {
        bodyAngle = angIn;
    }

    public double getBodyAngle() {
        return bodyAngle;
    }

    public void setHangingWeb(Boolean check) {
        hangingWeb = check;
    }

    public Boolean getHangingWeb() {
        return hangingWeb;
    }

    public void switchHangingWeb() {
        if (getHangingWeb()) {
            setHangingWeb(false);
        } else {
            setHangingWeb(true);
        }
    }

    /*
    
    
    
    
    */

    // Defualt Peter w/ Location
    public SpiderStructure(int headX, int headY) {
        setCharacter(1);
        setCenterHeadX(headX);
        setCenterHeadY(headY);
        setValuesByHead();
        setBodyParts();
        setHangingWeb(true);
    }

    // Character w/ Location
    public SpiderStructure(int headX, int headY, int character) {
        setCharacter(character);
        setCenterHeadX(headX);
        setCenterHeadY(headY);
        setValuesByHead();
        setBodyParts();
        setHangingWeb(true);

    }

    public void setValuesByHead() {

        // Neck
        setNeck(Math.toRadians(0));

        // Torso
        setCenterChestX(getCenterHeadX());
        setCenterChestY(getCenterHeadY() + 125);
        setCenterAbsX(getCenterHeadX());
        setCenterAbsY(getCenterHeadY() + 140);
        setCenterHipsX(getCenterHeadX());
        setCenterHipsY(getCenterHeadY() + 153);

        // Arms Bases
        setRightShoulderX(getCenterHeadX() + 37);
        setRightShoulderY(getCenterHeadY() + 100); // Corect Distance 100
        setLeftShoulderX(getCenterHeadX() - 37);
        setLeftShoulderY(getCenterHeadY() + 100); // Corect Distance 100

        // Arms Angles
        setRightDelt(Math.toRadians(10)); // 10
        setLeftDelt(Math.toRadians(5)); // 5
        setRightElbow(Math.toRadians(50)); // 50
        setLeftElbow(Math.toRadians(-65)); // -65
        setRightWrist(Math.toRadians(90)); // 90
        setLeftWrist(Math.toRadians(-90)); // -90

        // Arms
        setArmValues();

        // Legs Bases
        setQuadValues();

        // Legs Angles
        setRightHip(Math.toRadians(-50)); // Hip Bent Angle - 50
        setLeftHip(Math.toRadians(50)); // Hip Straigt Angle - 5
        setRightKnee(Math.toRadians(41));
        setLeftKnee(Math.toRadians(-41));
        setRightAnkle(Math.toRadians(90));
        setLeftAnkle(Math.toRadians(-90));
        // Legs
        setLegValues();

    }

    public void setArmValues() {
        setUpperArmValues();
        setForeArmValues();
        setHandValues();
    }

    public void setLegValues() {
        setCalfValues();
        setFootValues();
    }

    public void setUpperArmValues() {
        setRightArmX(getRightShoulderX() - (int) (15.0 * Math.sin(getRightDelt())));
        setRightArmY(getRightShoulderY() + (int) (15.0 * Math.cos(getRightDelt())));
        setLeftArmX(getLeftShoulderX() - (int) (15.0 * Math.sin(getLeftDelt())));
        setLeftArmY(getLeftShoulderY() + (int) (15.0 * Math.cos(getLeftDelt())));

    }

    public void setForeArmValues() {
        setRightForearmX(getRightArmX() - (int) (18.0 * Math.sin(getRightDelt())));
        setRightForearmY(getRightArmY() + (int) (18.0 * Math.cos(getRightDelt())));
        setLeftForearmX(getLeftArmX() - (int) (18.0 * Math.sin(getLeftDelt())));
        setLeftForearmY(getLeftArmY() + (int) (18.0 * Math.cos(getLeftDelt())));
    }

    public void setHandValues() {
        setRightHandX(getRightForearmX() - (int) (35.0 * Math.sin(getRightElbow())));
        setRightHandY(getRightForearmY() + (int) (35.0 * Math.cos(getRightElbow())));
        setLeftHandX(getLeftForearmX() - (int) (35.0 * Math.sin(getLeftElbow())));
        setLeftHandY(getLeftForearmY() + (int) (35.0 * Math.cos(getLeftElbow())));
    }

    public void setQuadValues() {
        setRightQuadX(getCenterHipsX() + 15);
        setRightQuadY(getCenterHipsY() + 10);
        setLeftQuadX(getCenterHipsX() - 15);
        setLeftQuadY(getCenterHipsY() + 10);
    }

    public void setCalfValues() {
        setRightCalfX(getRightQuadX() - (int) (30 * Math.sin(getRightHip())));
        setRightCalfY(getRightQuadY() + (int) (30 * Math.cos(getRightHip())));
        setLeftCalfX(getLeftQuadX() - (int) (30 * Math.sin(getLeftHip())));
        setLeftCalfY(getLeftQuadY() + (int) (30 * Math.cos(getLeftHip())));
    }

    public void setFootValues() {
        setRightFootX(getRightCalfX() - (int) (40 * Math.sin(getRightKnee())));
        setRightFootY(getRightCalfY() + (int) (40 * Math.cos(getRightKnee())));
        setLeftFootX(getLeftCalfX() - (int) (40 * Math.sin(getLeftKnee())));
        setLeftFootY(getLeftCalfY() + (int) (40 * Math.cos(getLeftKnee())));

    }

    public void changeCharacter(int i) {
        head.changeCharacter(i);
        body.setColor(i);
        leftShoulder.setColor(i);
        leftUpperArm.setColor(i);
        leftForearm.setColor(i);
        leftHand.setColor(i);
        rightShoulder.setColor(i);
        rightUpperArm.setColor(i);
        rightForearm.setColor(i);
        rightHand.setColor(i);
        leftQuad.setColor(i);
        leftCalf.setColor(i);
        leftFoot.setColor(i);
        rightQuad.setColor(i);
        rightCalf.setColor(i);
        rightFoot.setColor(i);
    }

    public void update() {
        changeBody();
        changeArms();
        changeLegs();
    }

    public void changeFace(int i) {
        head.changeFace(i);
    }

    public void changeBody() {
        body.setCenterChestX(getCenterChestX());
        body.setCenterChestY(getCenterChestY());
        body.setCenterAbsX(getCenterAbsX());
        body.setCenterAbsY(getCenterAbsY());
        body.setCenterHipsX(getCenterHipsX());
        body.setCenterHipsY(getCenterHipsY());
    }

    public void changeArms() {
        leftShoulder.setDelt(getLeftDelt());
        leftShoulder.setShoulderX(getLeftShoulderX());
        leftShoulder.setShoulderY(getLeftShoulderY());
        leftUpperArm.setDelt(getLeftDelt());
        leftUpperArm.setArmX(getLeftArmX());
        leftUpperArm.setArmY(getLeftArmY());
        leftForearm.setElbow(getLeftElbow());
        leftForearm.setForearmX(getLeftForearmX());
        leftForearm.setForearmY(getLeftForearmY());
        leftHand.setWrist(getLeftWrist());
        leftHand.setHandX(getLeftHandX());
        leftHand.setHandY(getLeftHandY());

        rightShoulder.setDelt(getRightDelt());
        rightShoulder.setShoulderX(getRightShoulderX());
        rightShoulder.setShoulderY(getRightShoulderY());
        rightUpperArm.setDelt(getRightDelt());
        rightUpperArm.setArmX(getRightArmX());
        rightUpperArm.setArmY(getRightArmY());
        rightForearm.setElbow(getRightElbow());
        rightForearm.setForearmX(getRightForearmX());
        rightForearm.setForearmY(getRightForearmY());
        rightHand.setWrist(getRightWrist());
        rightHand.setHandX(getRightHandX());
        rightHand.setHandY(getRightHandY());
    }

    public void changeLegs() {
        leftQuad.setHip(getLeftHip());
        leftQuad.setQuadX(getLeftQuadX());
        leftQuad.setQuadY(getLeftQuadY());
        leftCalf.setKnee(getLeftKnee());
        leftCalf.setCalfX(getLeftCalfX());
        leftCalf.setCalfY(getLeftCalfY());
        leftFoot.setAnkle(getLeftAnkle());
        leftFoot.setFootX(getLeftFootX());
        leftFoot.setFootY(getLeftFootY());

        rightQuad.setHip(getRightHip());
        rightQuad.setQuadX(getRightQuadX());
        rightQuad.setQuadY(getRightQuadY());
        rightCalf.setKnee(getRightKnee());
        rightCalf.setCalfX(getRightCalfX());
        rightCalf.setCalfY(getRightCalfY());
        rightFoot.setAnkle(getRightAnkle());
        rightFoot.setFootX(getRightFootX());
        rightFoot.setFootY(getRightFootY());
    }

    public void setBodyParts() {
        head = new SpiderFaces(getCenterHeadX(), getCenterHeadY(), getCharacter());
        body = new SpiderBody(getCenterChestX(), getCenterChestY(), getCenterAbsX(), getCenterAbsY(), getCenterHipsX(),
                getCenterHipsY(), getCharacter());
        leftShoulder = new Shoulder(1, getLeftShoulderX(), getLeftShoulderY(), getLeftArmX(), getLeftArmY(),
                getLeftDelt(), getCharacter());
        rightShoulder = new Shoulder(0, getRightShoulderX(), getRightShoulderY(), getRightArmX(), getRightArmY(),
                getRightDelt(), getCharacter());
        leftUpperArm = new UpperArm(1, getLeftArmX(), getLeftArmY(), getLeftForearmX(), getLeftForearmY(),
                getLeftDelt(), getCharacter());
        rightUpperArm = new UpperArm(0, getRightArmX(), getRightArmY(), getRightForearmX(), getRightForearmY(),
                getRightDelt(), getCharacter());
        leftForearm = new Forearm(1, getLeftForearmX(), getLeftForearmY(), getLeftHandX(), getLeftHandY(),
                getLeftElbow(), getCharacter());
        rightForearm = new Forearm(0, getRightForearmX(), getRightForearmY(), getRightHandX(), getRightHandY(),
                getRightElbow(), getCharacter());
        leftQuad = new Quad(1, getLeftQuadX(), getLeftQuadY(), getLeftCalfX(), getLeftCalfY(), getLeftHip(),
                getCharacter());
        rightQuad = new Quad(0, getRightQuadX(), getRightQuadY(), getRightCalfX(), getRightCalfY(), getRightHip(),
                getCharacter());
        leftCalf = new Calf(1, 0, getLeftCalfX(), getLeftCalfY(), getLeftFootX(), getLeftFootY(), getLeftKnee(),
                getCharacter());
        rightCalf = new Calf(0, 0, getRightCalfX(), getRightCalfY(), getRightFootX(), getRightFootY(), getRightKnee(),
                getCharacter());
        leftFoot = new Foot(1, 0, getLeftFootX(), getLeftFootY(), getLeftAnkle(), getCharacter());
        rightFoot = new Foot(0, 0, getRightFootX(), getRightFootY(), getRightAnkle(), getCharacter());
        leftHand = new Hand(1, 0, getLeftHandX(), getLeftHandY(), getLeftWrist(), getCharacter());
        rightHand = new Hand(0, 0, getRightHandX(), getRightHandY(), getRightWrist(), getCharacter());

    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform base = g2d.getTransform();
        g2d.rotate(Math.PI, getCenterHeadX(), getCenterHeadY());

        // ****************************************************************************
        // Body Scale .75:.5
        // g2d.translate(getCenterHeadX() * 1.0 / 4.0, getCenterHeadY() * 1.0 / 2.0 +
        // 50);
        // g2d.scale(0.75, 0.5);
        // ****************************************************************************

        // Torso

        body.paintComponent(g);

        // Left Leg
        leftQuad.paintComponent(g);
        leftCalf.paintComponent(g);
        leftFoot.paintComponent(g);

        // Right Leg
        rightQuad.paintComponent(g);
        rightCalf.paintComponent(g);
        rightFoot.paintComponent(g);

        if (this.getHangingWeb()) {
            g2d.setColor(new Color(255, 250, 255));
            g2d.fillRect(getCenterHipsX() - 1, getCenterHipsY(), 2, 1000);
            g2d.setColor(new Color(190, 210, 210));
            g2d.drawRect(getCenterHipsX() - 1, getCenterHipsY(), 2, 1000);
        }

        // Right Arm
        rightUpperArm.paintComponent(g);
        rightShoulder.paintComponent(g);
        rightForearm.paintComponent(g);
        rightHand.paintComponent(g);

        // Left Arm
        leftUpperArm.paintComponent(g);
        leftShoulder.paintComponent(g);
        leftForearm.paintComponent(g);
        leftHand.paintComponent(g);

        g2d.setTransform(base);
        g2d.rotate(Math.PI, getCenterHeadX(), getCenterHeadY());

        // Head
        head.paintComponent(g);
        g2d.setTransform(base);
    }
}