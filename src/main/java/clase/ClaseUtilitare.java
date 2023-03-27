package clase;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 *
 * @author Ana
 */
public class ClaseUtilitare {
   
    public static String hashParola(String parola) {
        
        String hashGenerat = null;
        try {
            byte[] salt = new byte[128 / 4];
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] bytesParola = md.digest(parola.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytesParola.length; i++) {
                sb.append(Integer.toString((bytesParola[i] & 0xff) + 0x100, 16).substring(1));
            }
            hashGenerat = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashGenerat;
    }
    
  
  
   
    public static String genereazaParola(String cnp) {
        StringBuilder str = new StringBuilder();

        String zz = "" + cnp.charAt(5) + cnp.charAt(6);

        String ll = "" + cnp.charAt(3) + cnp.charAt(4);

        String aa = "";
        if (cnp.charAt(0) == '1' || cnp.charAt(0) == '2') {
            aa = "19" + cnp.charAt(1) + cnp.charAt(2);
        } else if (cnp.charAt(0) == '5' || cnp.charAt(0) == '6') {
            aa = "20" + cnp.charAt(1) + cnp.charAt(2);
        }
        System.out.println(aa);

        String p = "" + zz + "-" + ll + "-" + aa;

        str.append(p);

        return str.toString();
    }

}
