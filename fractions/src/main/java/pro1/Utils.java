package pro1;

public class Utils
{
    //vypocet nejvetsiho spolecneho delitele
    public static long gcd(long a, long b)
    {
        while(b != 0)
        {
            long temp = b;
            b = a % b;      //zbytek pri deleni
            a = temp;
        }
        return a;          // vraci GCD
    }
}
