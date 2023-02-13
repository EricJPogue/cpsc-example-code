import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class SpiderBody extends JPanel {
        private SpiderColors characterPalate;
        public int centerChestX, centerChestY, centerAbsX, centerAbsY, centerHipsX, centerHipsY;

        public void setColor(int character) {
                characterPalate = new SpiderColors(character);
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

        // Default Peter
        public SpiderBody(int chestX, int chestY, int absX, int absY, int hipsX, int hipsY) {
                centerChestX = chestX;
                centerChestY = chestY;
                centerAbsX = absX;
                centerAbsY = absY;
                centerHipsX = hipsX;
                centerHipsY = hipsY;
                characterPalate = new SpiderColors(1);
        }

        public SpiderBody(int chestX, int chestY, int absX, int absY, int hipsX, int hipsY, int character) {
                centerChestX = chestX;
                centerChestY = chestY;
                centerAbsX = absX;
                centerAbsY = absY;
                centerHipsX = hipsX;
                centerHipsY = hipsY;
                characterPalate = new SpiderColors(character);
        }

        public void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                AffineTransform base = g2d.getTransform();
                super.paintComponent(g);

                // Abs
                g2d.setColor(characterPalate.getSuitSecondaryColor());
                g2d.fillPolygon(
                                new int[] { centerAbsX - 28, centerAbsX - 19, centerAbsX - 17, centerAbsX + 17,
                                                centerAbsX + 19,
                                                centerAbsX + 28 },
                                new int[] { centerAbsY - 20, centerAbsY, centerAbsY + 10, centerAbsY + 10, centerAbsY,
                                                centerAbsY - 20 },
                                6);

                g2d.setColor(characterPalate.getSuitPrimaryColor());
                g2d.fillPolygon(
                                new int[] { centerAbsX - 17, centerAbsX - 11, centerAbsX - 10, centerAbsX + 10,
                                                centerAbsX + 11,
                                                centerAbsX + 17 },
                                new int[] { centerAbsY - 20, centerAbsY, centerAbsY + 10, centerAbsY + 10, centerAbsY,
                                                centerAbsY - 20 },
                                6);

                g2d.setColor(characterPalate.getSuitWebbingColor());
                g2d.drawPolygon(new int[] { centerAbsX - 28, centerAbsX - 19, centerAbsX - 17, centerAbsX + 17,
                                centerAbsX + 19,
                                centerAbsX + 28 },
                                new int[] { centerAbsY - 20, centerAbsY, centerAbsY + 10, centerAbsY + 10, centerAbsY,
                                                centerAbsY - 20 },
                                6);

                // Chest
                g2d.setColor(characterPalate.getSuitSecondaryColor());
                g2d.fillPolygon(
                                new int[] { centerChestX - 20, centerChestX - 35, centerChestX - 32, centerChestX - 16,
                                                centerChestX,
                                                centerChestX + 16, centerChestX + 32, centerChestX + 35,
                                                centerChestX + 20 },
                                new int[] { centerChestY - 70, centerChestY - 20, centerChestY - 5, centerChestY + 5,
                                                centerChestY,
                                                centerChestY + 5, centerChestY - 5, centerChestY - 20,
                                                centerChestY - 70 },
                                9);
                g2d.setColor(characterPalate.getSuitPrimaryColor());
                g2d.fillPolygon(
                                new int[] { centerChestX - 20, centerChestX - 35, centerChestX - 16, centerChestX,
                                                centerChestX + 16, centerChestX + 35, centerChestX + 20 },
                                new int[] { centerChestY - 70, centerChestY - 20, centerChestY + 5, centerChestY,
                                                centerChestY + 5, centerChestY - 20, centerChestY - 70 },
                                7);
                g2d.setColor(characterPalate.getSuitWebbingColor());
                g2d.drawPolygon(
                                new int[] { centerChestX - 20, centerChestX - 35, centerChestX - 32, centerChestX - 16,
                                                centerChestX,
                                                centerChestX + 16, centerChestX + 32, centerChestX + 35,
                                                centerChestX + 20 },
                                new int[] { centerChestY - 70, centerChestY - 20, centerChestY - 5, centerChestY + 5,
                                                centerChestY,
                                                centerChestY + 5, centerChestY - 5, centerChestY - 20,
                                                centerChestY - 70 },
                                9);

                // Hips
                g2d.setColor(characterPalate.getSuitPrimaryColor());
                g2d.fillPolygon(new int[] { centerHipsX - 17, centerHipsX - 15, centerHipsX - 10, centerHipsX + 10,
                                centerHipsX + 15, centerHipsX + 17, centerHipsX + 20, centerHipsX + 19,
                                centerHipsX + 15,
                                centerHipsX + 10, centerHipsX + 3, centerHipsX - 3, centerHipsX - 10, centerHipsX - 15,
                                centerHipsX - 19, centerHipsX - 20 },
                                new int[] { centerHipsY - 5, centerHipsY - 4, centerHipsY - 3, centerHipsY - 3,
                                                centerHipsY - 4,
                                                centerHipsY - 5, centerHipsY - 1, centerHipsY + 3, centerHipsY + 7,
                                                centerHipsY + 11,
                                                centerHipsY + 17, centerHipsY + 17, centerHipsY + 11, centerHipsY + 7,
                                                centerHipsY + 3,
                                                centerHipsY - 1 },
                                16);
                g2d.setColor(characterPalate.getSuitWebbingColor());
                g2d.drawPolygon(new int[] { centerHipsX - 17, centerHipsX - 15, centerHipsX - 10, centerHipsX + 10,
                                centerHipsX + 15, centerHipsX + 17, centerHipsX + 20, centerHipsX + 19,
                                centerHipsX + 15,
                                centerHipsX + 10, centerHipsX + 3, centerHipsX - 3, centerHipsX - 10, centerHipsX - 15,
                                centerHipsX - 19, centerHipsX - 20 },
                                new int[] { centerHipsY - 5, centerHipsY - 4, centerHipsY - 3, centerHipsY - 3,
                                                centerHipsY - 4,
                                                centerHipsY - 5, centerHipsY - 1, centerHipsY + 3, centerHipsY + 7,
                                                centerHipsY + 11,
                                                centerHipsY + 17, centerHipsY + 17, centerHipsY + 11, centerHipsY + 7,
                                                centerHipsY + 3,
                                                centerHipsY - 1 },
                                16);
        }
}