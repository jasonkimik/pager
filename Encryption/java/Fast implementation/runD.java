public class runD
{

    public static void main(String[] args) throws Exception
    {

        long startTime = System.currentTimeMillis();

        //String password = "Make America Great Again";
        String passwordEnc = args[0]; 
        String passwordDec = dec.decrypt(passwordEnc);

        //System.out.println("Plain Text     : " + password);
        System.out.println("Encrypted Text : " + passwordEnc);
        System.out.println("Decrypted Text : " + passwordDec);

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime);

    }
}
