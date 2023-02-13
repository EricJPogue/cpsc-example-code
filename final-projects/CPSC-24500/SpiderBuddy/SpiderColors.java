import java.awt.Color;

class SpiderColors {
    // Color Constants
    public final Color BLACK = new Color(0, 0, 0);
    public final Color RED = new Color(255, 0, 0);
    public final Color WHITE = new Color(255, 255, 255);
    public final Color TAN = new Color(223, 195, 174);
    public final Color BROWN = new Color(132, 98, 64);
    public final Color PINK = new Color(232, 70, 226);
    public final Color BLUE = new Color(0, 0, 255);
    public final Color DARK_BLUE = new Color(0, 0, 170);
    public final Color OFF_WHITE = new Color(245, 245, 245);
    public final Color OFF_BLACK = new Color(50, 50, 50);
    public final Color YELLOW = new Color(220, 210, 10);
    public final Color GOLD = new Color(180, 170, 80);
    public final Color OFF_GOLD = new Color(170, 170, 80);
    public final Color IRON_RED = new Color(190, 0, 0);
    public final Color NEON_GREEN = new Color(50, 230, 90);
    public final Color BRIGHT_NEON_GREEN = new Color(60, 240, 100);
    public final Color SILVER = new Color(210, 210, 210);
    public final Color BRIGHT_SILVER = new Color(220, 220, 220);
    public final Color BRIGHT_BLUE = new Color(75, 175, 225);
    public final Color TEAL = new Color(0, 240, 255);

    // Constructors
    public SpiderColors() {
        this(1);
    }

    public SpiderColors(int character) {
        CharacterSelect(character);
    }

    /*
     * Mask Color
     */
    private Color maskColor;

    public void setMaskColor(Color color) {
        maskColor = color;
    }

    public Color getMaskColor() {
        return maskColor;
    }

    /*
     * Webbing Outline Color
     */
    private Color webbingOutlineColor;

    public void setWebbingOutlineColor(Color color) {
        webbingOutlineColor = color;
    }

    public Color getWebbingOutlineColor() {
        return webbingOutlineColor;
    }

    /*
     * Webbing Color
     */
    private Color webbingColor;

    public void setWebbingColor(Color color) {
        webbingColor = color;
    }

    public Color getWebbingColor() {
        return webbingColor;
    }

    /*
     * Eye Outline Color
     */
    private Color eyeOutlineColor;

    public void setEyeOutlineColor(Color color) {
        eyeOutlineColor = color;
    }

    public Color getEyeOutlineColor() {
        return eyeOutlineColor;
    }

    /*
     * Eye Center Color
     */
    private Color eyeCenterColor;

    public void setEyeCenterColor(Color color) {
        eyeCenterColor = color;
    }

    public Color getEyeCenterColor() {
        return eyeCenterColor;
    }

    /*
     * Face Color
     */
    private Color faceColor;

    public void setFaceColor(Color color) {
        faceColor = color;
    }

    public Color getFaceColor() {
        return faceColor;
    }

    /*
     * Mouth Color
     */
    private Color mouthColor;

    public void setmouthColor(Color color) {
        mouthColor = color;
    }

    public Color getMouthColor() {
        return mouthColor;
    }

    /*
     * Teeth Color
     */
    private Color teethColor;

    public void setTeethColor(Color color) {
        teethColor = color;
    }

    public Color getTeethColor() {
        return teethColor;
    }

    private Color suitPrimaryColor;

    public void setSuitPrimaryColor(Color color) {
        suitPrimaryColor = color;
    }

    public Color getSuitPrimaryColor() {
        return suitPrimaryColor;
    }

    private Color suitSecondaryColor;

    public void setSuitSecondaryColor(Color color) {
        suitSecondaryColor = color;
    }

    public Color getSuitSecondaryColor() {
        return suitSecondaryColor;
    }

    private Color suitAlternateColor;

    public void setSuitAlternateColor(Color color) {
        suitAlternateColor = color;
    }

    public Color getSuitAlternateColor() {
        return suitAlternateColor;
    }

    private Color suitOutlineColor;

    public void setSuitOutlineColor(Color color) {
        suitOutlineColor = color;
    }

    public Color getSuitOutlineColor() {
        return suitOutlineColor;
    }

    private Color suitWebbingColor;

    public void setSuitWebbingColor(Color color) {
        suitWebbingColor = color;
    }

    public Color getSuitWebbingColor() {
        return suitWebbingColor;
    }

    // Character Selection
    public void CharacterSelect(int character) {
        /*
         * Peter Parker
         */
        if (character == 1) {
            setMaskColor(RED);
            setWebbingOutlineColor(BLACK);
            setWebbingColor(BLACK);
            setEyeOutlineColor(BLACK);
            setEyeCenterColor(WHITE);
            setFaceColor(TAN);
            setmouthColor(BLACK);
            setTeethColor(WHITE);
            setSuitPrimaryColor(RED);
            setSuitSecondaryColor(BLUE);
            setSuitAlternateColor(WHITE);
            setSuitWebbingColor(BLACK);
            setSuitOutlineColor(BLACK);
        }

        /*
         * Miles Morales
         */
        if (character == 2) {
            setMaskColor(BLACK);
            setWebbingOutlineColor(RED);
            setWebbingColor(RED);
            setEyeOutlineColor(RED);
            setEyeCenterColor(WHITE);
            setFaceColor(BROWN);
            setmouthColor(BLACK);
            setTeethColor(WHITE);
            setSuitPrimaryColor(BLACK);
            setSuitSecondaryColor(RED);
            setSuitAlternateColor(RED);
            setSuitWebbingColor(RED);
            setSuitOutlineColor(RED);
        }

        /*
         * Spider-Gwen
         */
        if (character == 3) {
            setMaskColor(WHITE);
            setWebbingOutlineColor(PINK);
            setWebbingColor(WHITE);
            setEyeOutlineColor(PINK);
            setEyeCenterColor(WHITE);
            setFaceColor(TAN);
            setmouthColor(BLACK);
            setTeethColor(WHITE);
            setSuitPrimaryColor(BLACK);
            setSuitSecondaryColor(PINK);
            setSuitAlternateColor(TEAL);
            setSuitWebbingColor(WHITE);
            setSuitOutlineColor(WHITE);
        }

        /*
         * Ben Reilly
         */
        if (character == 4) {
            setMaskColor(RED);
            setWebbingOutlineColor(BLUE);
            setWebbingColor(RED);
            setEyeOutlineColor(OFF_WHITE);
            setEyeCenterColor(WHITE);
            setFaceColor(TAN);
            setmouthColor(BLACK);
            setTeethColor(WHITE);
            setSuitPrimaryColor(RED);
            setSuitSecondaryColor(BLUE);
            setSuitAlternateColor(SILVER);
            setSuitWebbingColor(BLACK);
            setSuitOutlineColor(BLUE);
        }

        /*
         * Kaine Parker
         */
        if (character == 5) {
            setMaskColor(BLACK);
            setWebbingOutlineColor(RED);
            setWebbingColor(BLACK);
            setEyeOutlineColor(IRON_RED);
            setEyeCenterColor(IRON_RED);
            setFaceColor(TAN);
            setmouthColor(BLACK);
            setTeethColor(WHITE);
            setSuitPrimaryColor(RED);
            setSuitSecondaryColor(BLACK);
            setSuitAlternateColor(IRON_RED);
            setSuitWebbingColor(IRON_RED);
            setSuitOutlineColor(RED);
        }

        /*
         * Otto Octavius
         */
        if (character == 6) {

            setMaskColor(RED);
            setWebbingOutlineColor(BLACK);
            setWebbingColor(BLACK);
            setEyeOutlineColor(BLACK);
            setEyeCenterColor(OFF_BLACK);
            setFaceColor(TAN);
            setmouthColor(BLACK);
            setTeethColor(WHITE);
            setSuitPrimaryColor(RED);
            setSuitSecondaryColor(BLACK);
            setSuitAlternateColor(SILVER);
            setSuitWebbingColor(BLACK);
            setSuitOutlineColor(BLACK);
        }

        /*
         * Miguel O'Hara
         */
        if (character == 7) {
            setMaskColor(DARK_BLUE);
            setWebbingOutlineColor(RED);
            setWebbingColor(DARK_BLUE);
            setEyeOutlineColor(RED);
            setEyeCenterColor(DARK_BLUE);
            setFaceColor(TAN);
            setmouthColor(BLACK);
            setTeethColor(WHITE);
            setSuitPrimaryColor(DARK_BLUE);
            setSuitSecondaryColor(RED);
            setSuitAlternateColor(DARK_BLUE);
            setSuitWebbingColor(RED);
            setSuitOutlineColor(BLUE);
        }

        /*
         * Symbiote
         */
        if (character == 8) {
            setMaskColor(BLACK);
            setWebbingOutlineColor(BLACK);
            setWebbingColor(BLACK);
            setEyeOutlineColor(OFF_WHITE);
            setEyeCenterColor(WHITE);
            setFaceColor(TAN);
            setmouthColor(BLACK);
            setTeethColor(WHITE);

            setSuitPrimaryColor(BLACK);
            setSuitSecondaryColor(BLACK);
            setSuitAlternateColor(WHITE);
            setSuitWebbingColor(BLACK);
            setSuitOutlineColor(OFF_BLACK);
        }

        /*
         * Secret Wars
         */
        if (character == 9) {
            setMaskColor(OFF_BLACK);
            setWebbingOutlineColor(BLUE);
            setWebbingColor(RED);
            setEyeOutlineColor(BLACK);
            setEyeCenterColor(WHITE);
            setFaceColor(TAN);
            setmouthColor(BLACK);
            setTeethColor(WHITE);
            setSuitPrimaryColor(OFF_BLACK);
            setSuitSecondaryColor(BLUE);
            setSuitAlternateColor(BLACK);
            setSuitWebbingColor(RED);
            setSuitOutlineColor(BLACK);

        }

        /*
         * Iron Spider
         */
        if (character == 10) {
            setMaskColor(IRON_RED);
            setWebbingOutlineColor(GOLD);
            setWebbingColor(IRON_RED);
            setEyeOutlineColor(GOLD);
            setEyeCenterColor(GOLD);
            setFaceColor(TAN);
            setmouthColor(BLACK);
            setTeethColor(WHITE);
            setSuitPrimaryColor(IRON_RED);
            setSuitSecondaryColor(GOLD);
            setSuitAlternateColor(SILVER);
            setSuitWebbingColor(IRON_RED);
            setSuitOutlineColor(GOLD);
        }

        /*
         * Big Time Stealth
         */
        if (character == 11) {
            setMaskColor(BLACK);
            setWebbingOutlineColor(BLACK);
            setWebbingColor(BLACK);
            setEyeOutlineColor(NEON_GREEN);
            setEyeCenterColor(BRIGHT_NEON_GREEN);
            setFaceColor(TAN);
            setmouthColor(BLACK);
            setTeethColor(WHITE);
            setSuitPrimaryColor(BLACK);
            setSuitSecondaryColor(NEON_GREEN);
            setSuitAlternateColor(OFF_BLACK);
            setSuitWebbingColor(NEON_GREEN);
            setSuitOutlineColor(BLACK);
        }

        /*
         * Spider Armor MK I
         */
        if (character == 12) {
            setMaskColor(SILVER);
            setWebbingOutlineColor(BLACK);
            setWebbingColor(BLACK);
            setEyeOutlineColor(BRIGHT_SILVER);
            setEyeCenterColor(WHITE);
            setFaceColor(TAN);
            setmouthColor(BLACK);
            setTeethColor(WHITE);
            setSuitPrimaryColor(SILVER);
            setSuitSecondaryColor(OFF_BLACK);
            setSuitAlternateColor(BRIGHT_SILVER);
            setSuitWebbingColor(BLACK);
            setSuitOutlineColor(BLACK);
        }

        /*
         * Spider Armor MK II
         */
        if (character == 13) {
            setMaskColor(BLACK);
            setWebbingOutlineColor(BLACK);
            setWebbingColor(BLACK);
            setEyeOutlineColor(GOLD);
            setEyeCenterColor(YELLOW);
            setFaceColor(TAN);
            setmouthColor(BLACK);
            setTeethColor(WHITE);
            setSuitPrimaryColor(BLACK);
            setSuitSecondaryColor(YELLOW);
            setSuitAlternateColor(GOLD);
            setSuitWebbingColor(GOLD);
            setSuitOutlineColor(BLACK);
        }

        /*
         * Spider Armor MK III
         */
        if (character == 14) {
            setMaskColor(IRON_RED);
            setWebbingOutlineColor(BLACK);
            setWebbingColor(IRON_RED);
            setEyeOutlineColor(BLACK);
            setEyeCenterColor(WHITE);
            setFaceColor(TAN);
            setmouthColor(BLACK);
            setTeethColor(WHITE);
            setSuitPrimaryColor(IRON_RED);
            setSuitSecondaryColor(BLACK);
            setSuitAlternateColor(BRIGHT_SILVER);
            setSuitWebbingColor(IRON_RED);
            setSuitOutlineColor(BLACK);
        }

        /*
         * Spider Armor MK IV
         */
        if (character == 15) {
            setMaskColor(IRON_RED);
            setWebbingOutlineColor(BLACK);
            setWebbingColor(BLACK);
            setEyeOutlineColor(BLACK);
            setEyeCenterColor(BRIGHT_NEON_GREEN);
            setFaceColor(TAN);
            setmouthColor(BLACK);
            setTeethColor(WHITE);
            setSuitPrimaryColor(IRON_RED);
            setSuitSecondaryColor(BRIGHT_BLUE);
            setSuitAlternateColor(NEON_GREEN);
            setSuitWebbingColor(BLACK);
            setSuitOutlineColor(BLACK);
        }

        /*
         * Future Foundation
         */
        if (character == 16) {
            setMaskColor(WHITE);
            setWebbingOutlineColor(BLACK);
            setWebbingColor(WHITE);
            setEyeOutlineColor(BLACK);
            setEyeCenterColor(OFF_BLACK);
            setFaceColor(TAN);
            setmouthColor(BLACK);
            setTeethColor(WHITE);
            setSuitPrimaryColor(WHITE);
            setSuitSecondaryColor(BLACK);
            setSuitAlternateColor(SILVER);
            setSuitWebbingColor(WHITE);
            setSuitOutlineColor(BLACK);
        }
    }

}