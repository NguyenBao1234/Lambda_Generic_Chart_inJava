package LambdaPractice;

public class MainProgram
{
    public static void main(String[] args)
    {
        PrintableFuncRString ShowAndEditMessage = (thamSo)->
        {
            System.out.printf("-Day la giai thuat cua ShowAndEditMessage:\n\tLoi Nhan cua ham la: %s\n", thamSo);
            thamSo = "Edited "+ thamSo;
            return thamSo;
        };
        String KetQuaCuaHamCustom = ShowAndEditMessage.RunFunction("great 22 CDP");
        System.out.println("\tGia tri tra ve cua 'ShowAndEditMessage': " + KetQuaCuaHamCustom);

        PrintableFuncRString OnlyShowMessage = (ThamSo) -> "Message la '" + ThamSo + "'" ;
        System.out.println("-Gia tri tra ve cua ham 'OnlyShowMessage': " + OnlyShowMessage.RunFunction("great 22CDP") );

        Runnable TestFunction = () -> System.out.println("-Void function 'Test Function' was called");
        TestFunction.run();

        FunctionFromClass.run();
        new otherClass().FunctionFromInst.run();
    }
    static Runnable FunctionFromClass = otherClass::PrintHey;
}

class otherClass
{
    Runnable FunctionFromInst = this::PrintHello;

    void PrintHello()
    {
        System.out.println("-Hello from a Instance of otherClass was called");
    }
    static void PrintHey()
    {
        System.out.println("-Hey everyone!Static Function 'PrintHey' From otherClass was called");
    }
}
