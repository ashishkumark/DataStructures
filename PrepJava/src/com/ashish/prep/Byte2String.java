package com.ashish.prep;

public class Byte2String {

	public static void main(String[] argv) {

		String example = "This is an example";
		byte[] bytes = example.getBytes();

		System.out.println("Text : " + example);
		System.out.println("Text [Byte Format] : " + bytes);
		System.out.println("Text [Byte Format] : " + bytes.toString());

		String s = new String(bytes);
		System.out.println("Text Decryted : " + s);

		System.out.println(getString(bytes));
		System.out.println(false & false);
	}
	
    private static String getString(byte[] bytes) {

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            sb.append((int) (0x00FF & b));
        }
        return sb.toString();
    }
}
