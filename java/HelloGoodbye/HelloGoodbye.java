import java.util.ArrayList;

class HG {
    private String s;

    HG() {
        s = "Hello";
        if (Utils.GetNumberBetweenInclusive(1, 4) == 4) {
            s = "Goodbye";
        }
    }
 
    public String toString() {
        return s;
    }
}

class HelloGoodbye {
    public static void main(String[] args) {
        System.out.println("HelloGoodbye...");

        HG myHG = new HG();
        System.out.println(myHG);

        ArrayList<HG> hgList = new ArrayList<HG>();
        int randHG = Utils.GetNumberBetweenInclusive(3, 10);
        for (int i=0; i<randHG; i++) {
            hgList.add(new HG());
        }

        for(HG hg : hgList) {
            System.out.println(hg);
        }    
    }
}