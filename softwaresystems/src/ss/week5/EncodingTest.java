package ss.week5;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.Base64;

/**
 * A simple class that experiments with the Hex encoding
 * of the Apache Commons Codec library.
 *
 */
public class EncodingTest {
    public static void main(String[] args) throws DecoderException {
        String input = "Hello World";
        String input2 = "Hello Big World";
        
        String hex = "4d6f64756c652032";
        
        String base64 = "010203040506";
        
        String base64_2 = "U29mdHdhcmUgU31zdGVtcw==";

        // bytes to hex
        System.out.println(":Hello World: in hex: " + Hex.encodeHexString(input.getBytes()));
        System.out.println(":Hello Big World: in hex " + Hex.encodeHexString(input2.getBytes()));
        
        byte[] hexToByte = Hex.decodeHex(hex.toCharArray());
        String byteToString = new String(hexToByte);
        // hex to bytes
        System.out.println("Hexstring :4d6f64756c652032: decoded: " + byteToString);
        
        // string to base64
        System.out.println(":010203040506: in base64: " + Base64.encodeBase64String(input.getBytes()));
        
        // hex to byte to base64
        byte[] toByte = Hex.decodeHex(base64.toCharArray());
        byte[] toBase64 = Base64.encodeBase64(toByte);
        String byte64ToString = new String(toBase64);
        System.out.println("Hexstring :010203040506: encoded to base64: " + byte64ToString);
        
        // decode base64
        byte[] base64ToByte = Base64.decodeBase64(base64_2);
        String byteToString64 = new String(base64ToByte);
        System.out.println(":U29mdHdhcmUgU31zdGVtcw==: decoded from base 64: " + byteToString64);
        
        // encode "a", "aa", "aaa", ect. with base64
        String one = "a";
        String two = "aa";
        String three = "aaa";
        String four = "aaaa";
        String five = "aaaaa";
        String fifteen = "aaaaaaaaaaaaaaa";
        
        String one64 = new String(Base64.encodeBase64(one.getBytes()));
        System.out.println("\na: " + one64);
        String two64 = new String(Base64.encodeBase64(two.getBytes()));
        System.out.println("aa: " + two64);
        String three64 = new String(Base64.encodeBase64(three.getBytes()));
        System.out.println("aaa: " + three64);
        String four64 = new String(Base64.encodeBase64(four.getBytes()));
        System.out.println("aaaa: " + four64);
        String five64 = new String(Base64.encodeBase64(five.getBytes()));
        System.out.println("aaaaa: " + five64);
        String fifteen64 = new String(Base64.encodeBase64(fifteen.getBytes()));
        System.out.println("aaaaaaaaaaaaaaa: " + fifteen64);
    }
}