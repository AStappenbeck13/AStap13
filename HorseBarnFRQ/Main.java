import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args)
    {
        HorseFRQ a = new HorseFRQ("Trigger", 1340);
        HorseFRQ b = new HorseFRQ("Silver", 1210);
        HorseFRQ c = new HorseFRQ("Lady", 1575);
        HorseFRQ d = new HorseFRQ("Patches", 1350);
        HorseFRQ e = new HorseFRQ("Duke", 1410);

        ArrayList<HorseFRQ> HorseFRQs = new ArrayList<HorseFRQ>();

        HorseFRQs.add(a);
        HorseFRQs.add(null);
        HorseFRQs.add(b);
        HorseFRQs.add(c);
        HorseFRQs.add(null);
        HorseFRQs.add(d);
        HorseFRQs.add(e);

        HorseBarnFRQ sweetHome = new HorseBarnFRQ(HorseFRQs);

        //PART A
        System.out.println(sweetHome.findHorseSpace("Trigger"));
        System.out.println(sweetHome.findHorseSpace("Silver"));
        System.out.println(sweetHome.findHorseSpace("Coco"));

        System.out.println();

        //PART B
        System.out.println(sweetHome);
        sweetHome.consolidate();
        System.out.println(sweetHome);
    }

}
