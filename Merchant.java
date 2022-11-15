import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.*;

public class Merchant {
    public static String challenge_toSendBank;
    public static String decrypting_temp1;
    private static ArrayList<byte[]> temp_toBank = new ArrayList<byte[]>();

    // Might need a constructor, for now it just prints 'Merchant'
    public Merchant() {
         System.out.println("Merchant");
    }

    // Creating a unique ID
    public static String UniqueID1() {
        String s = "";
        Random r = new Random();
        while(s.length() < 10) {
            int r1 = r.nextInt(2);
            s += Integer.toString(r1);
        }
        return s;
    }

    // Creating challenge bit string
    public String challenge() {
        String to_challenge = UniqueID1();
        challenge_toSendBank = to_challenge;
        return to_challenge;
    }

    public void toSendm_bank() {
        System.out.println("To send to the bank.");
    }

    public boolean toCheckHash(ArrayList<byte[]> temp_2) throws IOException {
        boolean c_temp = true;
        temp_toBank = temp_2;
        String array1[] = decrypting_temp1.split("::");
        ArrayList<String> temp_inMerch = new ArrayList<String>();
        int j = 2;
        int k = 3;
        for(int i = 0; i < challenge_toSendBank.length(); i++) {
            char i1 = challenge_toSendBank.charAt(i);
            int index_challenge = i1 - '0';
            if(index_challenge == 0) {
                temp_inMerch.add(array1[j]);
            } else {
                temp_inMerch.add(array1[k]);
            }
            j += 2;
            k += 2;
        }
        for(int i=0;i<temp_inMerch.size();i++) {
            String hash_test = new String(temp_2.get(i));
            String hash_test1=Integer.toString(hash_test.hashCode());
            if(hash_test1.equals(temp_inMerch.get(i))) {
                c_temp = c_temp;
            } else {
                return false;
            }
        }
    return c_temp;
    }

    public String send_chalb() {
        return challenge_toSendBank;
    }

    // Check for bank signature
    public String received_orderFromCustomer(byte[] received, BigInteger public_key1, BigInteger Mod) {
        String confirmation = "";
        byte[] decrypted1_c = ((((new BigInteger(received)).modPow(public_key1, Mod))).toByteArray());
        String to_checkHash = (new String(decrypted1_c));
        decrypting_temp1 = to_checkHash;
        return to_checkHash;
    }

    public static void main(String args[]) {
        
    }
}