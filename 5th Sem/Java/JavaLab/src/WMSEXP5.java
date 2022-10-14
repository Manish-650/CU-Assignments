import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class WMSEXP5 {
	public static String encryptThisString(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");

			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger no = new BigInteger(1, messageDigest);
			String hashtext = no.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String args[]) throws NoSuchAlgorithmException {
		System.out.println("HashCode Generated by SHA-1 for: ");
		Scanner in = new Scanner(System.in);
		String s1 = in.next();
		System.out.println("\n" + s1 + " : " + encryptThisString(s1));
		String s2 = in.next();
		System.out.println("\n" + s2 + " : " + encryptThisString(s2));
		in.close();
	}
}
