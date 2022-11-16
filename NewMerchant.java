import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class NewMerchant {

    // String generator of length 10, made up of 1's and 0's
    public static String stringGen() {
        String result = "";
        int num;
        for(int i = 0; i < 10; i++) {
            num = (int)Math.round(Math.random());
            result += Integer.toString(num);
        }
        return result;
    }

    /* Need to determine what we are getting from the customer
     * We are getting either: 
     * 0 --> I ⊕ ai, di, and xi, OR
     * 1 --> ai, ci, and yi
     */
    // Hashfunction for x and y
    public static String f(BigInteger x, BigInteger y) throws NoSuchAlgorithmException {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
        } catch (Exception e) {
            throw new NoSuchAlgorithmException();
        }
        String result = x.toString() + y.toString();
        return result;
    }

    // Hashfunction for g
    public static String g(BigInteger x, BigInteger y) throws NoSuchAlgorithmException {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
        } catch (Exception e) {
            throw new NoSuchAlgorithmException();
        }
        String result = x.toString() + y.toString();
        return result;
    }

    public static void main(String args[]) throws NoSuchAlgorithmException {
        BigInteger bank1 = new BigInteger("45102246070852877005834805071565697303530753565236670573550117115010865770545266090895421231898028549377566326963374616157756280120181748932018677751293313293523827859377666639166849915682609959979131340115018334098535898721356842525455183760413239157639236971732220612271453478131788159610221783610160493541");
        BigInteger bank1Account = new BigInteger("3553584");
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        // final byte[] encodeHash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));
        System.out.println(stringGen());
    }
}
