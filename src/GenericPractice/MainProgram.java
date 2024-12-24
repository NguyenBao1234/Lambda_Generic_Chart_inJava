package GenericPractice;

public class MainProgram
{
    public static void main(String[] args)
    {
        PrintThing(5*3);
        PrintThing(true);
        PrintThing("Con day la print kieu String");

        GenericPrinter<Integer> intPrinterInst = new GenericPrinter<>();
        intPrinterInst.Print(100);

        GenericPrinter<String> strPrinterInst = new GenericPrinter<>("Room I.702");
        strPrinterInst.Print("String for strPrinterInst");
        strPrinterInst.PrintThing();
    }
    static <KieuTuDong> void PrintThing(KieuTuDong ThingToPrint)
    {
        System.out.println(ThingToPrint);
    }
}

class GenericPrinter <T>
{
    //Can co instance truoc de co T
    public GenericPrinter(){};
    public GenericPrinter(T Thing){ ThingToPrint = Thing;}
    T ThingToPrint;
    public void PrintThing()
    {
        System.out.println(ThingToPrint);
    }
    public void Print(T ContentToPrint)
    {
        System.out.println(ContentToPrint);
    }
}
