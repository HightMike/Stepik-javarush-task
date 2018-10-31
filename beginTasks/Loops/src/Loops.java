import java.math.BigInteger;

public class Loops {
    public static void main(String args[]){
        //int N = 4;
        //int sum = 1;
        int value = 4;
        BigInteger c = BigInteger.valueOf(value+1);
        BigInteger a;
        BigInteger result = BigInteger.valueOf(1);
        //BigInteger c = new BigInteger("4");
        BigInteger b = new BigInteger("1");
        for (a=b; !a.equals(c); a=a.add(b)) {
            result = a.multiply(result);

            //sum = sum*i;
        }

        System.out.print("Возвращаемое значение: ");
        System.out.println(result);
    }
}

