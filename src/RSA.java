import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.SecureRandom;
	

public class RSA {
	
	private final static BigInteger one = new BigInteger("1");
	private final static SecureRandom random = new SecureRandom();
	
	private int e;
	private int d = 0;
	private BigInteger mod;

    public static void main (String [] arguments) throws IOException {
    }
 
    // Encrypting the message
    public byte[] encryptByteArray(byte[] file) {
    	BigInteger p = BigInteger.probablePrime(2, random);
    	BigInteger q = BigInteger.probablePrime(2, random);
    	mod = p.multiply(q);
    	BigInteger T = (p.subtract(one)).multiply(q.subtract(one));
    	for (e = 2; e < T.intValue(); e++) {
    		 
            // e is for public key exponent
            if (gcd(e, T.intValue()) == 1) {
                break;
            }
        }
    	System.out.println("the value of e = " + e);
        for (int i = 0; i <= 9; i++) {
            int x = 1 + (i * T.intValue());
 
            // d is for private key exponent
            if (x % e == 0) {
                d = x / e;
                break;
            }
        }
        System.out.println("the value of d = " + d);
        byte[] cipher = file;
        for (byte c : cipher) {
        	c = (byte) ((Math.pow(c, e)) % mod.intValue());
        }
        return cipher;
    }
 
    // Decrypting the message
    public byte[] decryptByteArray(byte[] file) {
    	
    	byte[] decrypted = file;
        for (byte c : decrypted) {
        	BigInteger C = BigDecimal.valueOf(c).toBigInteger();
        	c = (byte) ((C.pow(d)).mod(mod)).intValue();
        }
        return decrypted;
    }
    
    static int gcd(int e, int z)
    {
        if (e == 0)
            return z;
        else
            return gcd(z % e, e);
    }
    
    
}
