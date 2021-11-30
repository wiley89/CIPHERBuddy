import java.math.*;
import java.util.*;
import java.security.*;
import java.io.*;

public class ElGamal {
	
	private BigInteger p, b, c, secretKey, X, r, EC;
	
	private Random sc = new SecureRandom();

	
	public ElGamal(BigInteger secretKey) {
		this.secretKey = secretKey;
		System.out.println("secretKey = " + secretKey);
        p = BigInteger.probablePrime(64, sc);
        b = new BigInteger("3");
        c = b.modPow(secretKey, p);
        System.out.println("p = " + p);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
	}
	
	
    public byte[] encryptByteArray(byte[] file) {
    	 X = new BigInteger(file);
         r = new BigInteger(64, sc);
         EC = X.multiply(c.modPow(r, p)).mod(p);
        BigInteger brmodp = b.modPow(r, p);
        System.out.println("Plaintext = " + X);
        System.out.println("r = " + r);
        System.out.println("EC = " + EC);
        System.out.println("b^r mod p = " + brmodp);
        return brmodp.toByteArray();
    }
    
 
    public byte[] decryptByteArray(byte[] file, BigInteger secretKey) {
        BigInteger brmodp = b.modPow(r, p);
    	BigInteger crmodp = brmodp.modPow(secretKey, p);
        BigInteger d = crmodp.modInverse(p);
        BigInteger ad = d.multiply(EC).mod(p);
        System.out.println("\n\nc^r mod p = " + crmodp);
        System.out.println("d = " + d);
        System.out.println("Alice decodes: " + ad);
        return ad.toByteArray();
    }
    
	
    public static void main(String[] args) throws IOException {
    	DataInputStream input = new DataInputStream(System.in);
        System.out.println("Enter your private key");
        String key = input.readLine();
    	ElGamal test = new ElGamal(new BigInteger(key));
    	DataInputStream input2 = new DataInputStream(System.in);
        System.out.println("Enter your message");
        String msg = input.readLine();
    	byte[] encrypted = test.encryptByteArray(msg.getBytes());
    	byte[] decrypted = test.decryptByteArray(encrypted, new BigInteger(key));
    }
}