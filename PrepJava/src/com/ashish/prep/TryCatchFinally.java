package com.ashish.prep;

public class TryCatchFinally {
	public static void main(String[] args) {
		try {
			final int i;
			
			i =4 ;
			System.out.println(i);
//			i =3;
			if (true) throw new NullPointerException();
			System.out.println(check(i, 64));
			System.out.println(check(44.0f, 44.0f));
//			return;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("This is the end");
		}
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	static <T extends Number> boolean check(T a, T b) {
		return a.equals(b);
	}
}
