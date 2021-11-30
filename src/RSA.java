import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;	

public class RSA {
	
	private final static BigInteger one = new BigInteger("1");
	private final static SecureRandom random = new SecureRandom();

	private BigInteger privateKey;
	
	private BigInteger phi;
	private BigInteger p;
	private BigInteger q;
 
    public RSA() {
    	p = BigInteger.probablePrime(1024/2, random);
        q = BigInteger.probablePrime(1024/2, random);
        phi = (p.subtract(one)).multiply(q.subtract(one));                                  
    }

 
    public static void main (String [] arguments) throws IOException {
    	RSA rsa = new RSA();
        DataInputStream input = new DataInputStream(System.in);
        String inputString;
        System.out.println("Enter message you wish to send.");
        inputString = input.readLine();
        System.out.println("Encrypting the message: " + inputString);
        System.out.println("The message in bytes is:: "
                + bToS(inputString.getBytes()));
        // encryption
        byte[] cipher = rsa.encryptByteArray(inputString.getBytes(), new BigInteger("65537"), rsa.getP().multiply(rsa.getQ()));
        // decryption
        byte[] plain = rsa.decryptByteArray(cipher, rsa.getPrivateKey(), rsa.getP(), rsa.getQ());
        System.out.println("Decrypting Bytes: " + bToS(plain));
        System.out.println("Plain message is: " + new String(plain));
    }
 
    // Encrypting the message
    public byte[] encryptByteArray(byte[] file, BigInteger publicKey, BigInteger modulus) {
    	privateKey = publicKey.modInverse(phi);
        return (new BigInteger(file)).modPow(publicKey, modulus).toByteArray();
    }
 
    // Decrypting the message
    public byte[] decryptByteArray(byte[] file, BigInteger privateKey, BigInteger p, BigInteger q) {
        return (new BigInteger(file)).modPow(privateKey, p.multiply(q)).toByteArray();
    }
    
    private static String bToS(byte[] cipher) {
        String temp = "";
        for (byte b : cipher)
        {
            temp += Byte.toString(b);
        }
        return temp;
    }
    
    public BigInteger getPrivateKey() {
    	return privateKey;
    }
    
    public BigInteger getP() {
    	return p;
    }
    
    public BigInteger getQ() {
    	return q;
    }
}
