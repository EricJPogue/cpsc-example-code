import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

class OvalDrawPanel extends JPanel {
    private boolean ovalArrayListNeedsInitializing; 
    private OvalDraw OD2;
    private ArrayList<OvalDraw> ovalDrawList;

    OvalDrawPanel() {
        super();
        ovalArrayListNeedsInitializing = true; 
        OD2 = null; 
        ovalDrawList = null;
    }

    public void intializeOvalArrayList() {
        assert OD2==null:"initialOvalArrayList should only be called once"; 
        assert ovalDrawList==null:"initialOvalArrayList should only be called once";     

        Rectangle r = getBounds();
        OD2 = new OvalDraw((int)r.getWidth(), (int)r.getHeight()); 

        ovalDrawList = new ArrayList<OvalDraw>();
        for (int i=0; i<3; i++) {
            ovalDrawList.add(new OvalDraw((int)r.getWidth(), (int)r.getHeight()));
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); 

        if (ovalArrayListNeedsInitializing) {
            // We should only initialize the array list once. Note that it was not possible utilize "getBounds()" from the
            //     constructor.  
            intializeOvalArrayList();
            ovalArrayListNeedsInitializing = false; 
        }

        Rectangle r = getBounds();
        OvalDraw OD = new OvalDraw(r);
        OD.Draw(g); 

        OD2.Draw(g);

        for (OvalDraw oD : ovalDrawList) {
            oD.Draw(g); 
        }
    }
}