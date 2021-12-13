import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class DES {
    //Key for DES encryption b=must be 64 bits
    static ArrayList<Integer> key = new ArrayList<>(Arrays.asList(0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1));
    //represents the 56 bit permuted key
    static ArrayList<Integer> keyplus;
    //represents the subkeys for DES
    static ArrayList<Integer> k1;
    static ArrayList<Integer> k2;
    static ArrayList<Integer> k3;
    static ArrayList<Integer> k4;
    static ArrayList<Integer> k5;
    static ArrayList<Integer> k6;
    static ArrayList<Integer> k7;
    static ArrayList<Integer> k8;
    static ArrayList<Integer> k9;
    static ArrayList<Integer> k10;
    static ArrayList<Integer> k11;
    static ArrayList<Integer> k12;
    static ArrayList<Integer> k13;
    static ArrayList<Integer> k14;
    static ArrayList<Integer> k15;
    static ArrayList<Integer> k16;

    //method to be called from the homepage to return the encrypted byte array
    //converts byte input into 64 bit blocks
    public static ArrayList<Integer> encryptByteArray(byte[] in) {
        byte[] encrypted;
        ArrayList<Integer> encryptedBits = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        String bitsStr;
        for (int i = 0; i < in.length; i++) {
            if (i + 1 % 8 == 0) {
                bitsStr = toBits(in[i]);
                for (int j = 0; j < bitsStr.length(); i++) {
                    temp.add((int) bitsStr.charAt(j));
                }
                encryptedBits.addAll(encrypt64(temp));
                temp = new ArrayList<>();
            } else {
                bitsStr = toBits(in[i]);
                for (int j = 0; j < bitsStr.length(); i++) {
                    temp.add((int) bitsStr.charAt(j));
                }
            }
        }
        return encryptedBits;
    }

    //converts byte messages from the homepage into bits for DES encryption
    public static String toBits(final byte val) {
        final StringBuilder result = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            result.append((int) (val >> (8 - (i + 1)) & 0x0001));
        }

        return result.toString();
    }

    //encrypts 64 bit blocks using DES subkeys
    public static ArrayList<Integer> encrypt64(ArrayList<Integer> block) {
        keyplus = permuteKey(key);
        generateSubkeys(keyplus);
        //encode block would happen here with keys generated
        return block;
    }

    //generates subkeys for DES encryption
    public static void generateSubkeys(ArrayList<Integer> kplus) {
        ArrayList<Integer> C = new ArrayList<>();
        ArrayList<Integer> D = new ArrayList<>();
        ArrayList<Integer> CD = new ArrayList<>();

        for (int i = 0; i < 28; i++) {
            C.add(kplus.get(i));
        }
        for (int i = 28; i < 56; i++) {
            D.add(kplus.get(i));
        }
        Collections.rotate(C, 1);
        Collections.rotate(D, 1);
        CD = C;
        CD.addAll(D);
        k1 = permuteKey(CD);
        Collections.rotate(C, 1);
        Collections.rotate(D, 1);
        CD = C;
        CD.addAll(D);
        k2 = permuteKey(CD);
        Collections.rotate(C, 2);
        Collections.rotate(D, 2);
        CD = C;
        CD.addAll(D);
        k3 = permuteKey(CD);
        Collections.rotate(C, 2);
        Collections.rotate(D, 2);
        CD = C;
        CD.addAll(D);
        k4 = permuteKey(CD);
        Collections.rotate(C, 2);
        Collections.rotate(D, 2);
        CD = C;
        CD.addAll(D);
        k5 = permuteKey(CD);
        Collections.rotate(C, 2);
        Collections.rotate(D, 2);
        CD = C;
        CD.addAll(D);
        k6 = permuteKey(CD);
        Collections.rotate(C, 2);
        Collections.rotate(D, 2);
        CD = C;
        CD.addAll(D);
        k7 = permuteKey(CD);
        Collections.rotate(C, 2);
        Collections.rotate(D, 2);
        CD = C;
        CD.addAll(D);
        k8 = permuteKey(CD);
        Collections.rotate(C, 1);
        Collections.rotate(D, 1);
        CD = C;
        CD.addAll(D);
        k9 = permuteKey(CD);
        Collections.rotate(C, 2);
        Collections.rotate(D, 2);
        CD = C;
        CD.addAll(D);
        k10 = permuteKey(CD);
        Collections.rotate(C, 2);
        Collections.rotate(D, 2);
        CD = C;
        CD.addAll(D);
        k11 = permuteKey(CD);
        Collections.rotate(C, 2);
        Collections.rotate(D, 2);
        CD = C;
        CD.addAll(D);
        k12 = permuteKey(CD);
        Collections.rotate(C, 2);
        Collections.rotate(D, 2);
        CD = C;
        CD.addAll(D);
        k13 = permuteKey(CD);
        Collections.rotate(C, 2);
        Collections.rotate(D, 2);
        CD = C;
        CD.addAll(D);
        k14 = permuteKey(CD);
        Collections.rotate(C, 2);
        Collections.rotate(D, 2);
        CD = C;
        CD.addAll(D);
        k15 = permuteKey(CD);
        Collections.rotate(C, 1);
        Collections.rotate(D, 1);
        CD = C;
        CD.addAll(D);
        k16 = permuteKey(CD);
    }

    //permutes the key for DES encryption and subkey generation
    public static ArrayList<Integer> permuteKey(ArrayList<Integer> in) {
        ArrayList<Integer> retList = new ArrayList<>();
        for (int i = 0; i < in.size(); i++) {
            if (i + 1 % 8 != 0) {
                retList.add(in.get(i));
            }
        }
        Collections.shuffle(retList);
        return retList;
    }
}
