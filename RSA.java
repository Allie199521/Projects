/* Name: Alexandra Miranda
   File: RSA.java
*/

//this file encrypts and decrypts a message using the
// public key encryption algorithm RSA
// RSA uses a public key, (n, e) to encrypt message m
// to send to a private key, (n, d) to decrypt the encrypted message

import java.util.*;
import java.io.*;

public class RSA {
	public int n;
	public int e;
	private int d;
	private int p;
	private int q;
	private int theta;
	private int e;
	private int x;
	private int y;
	
	//implements the public and private keys
	//by calling on a series of methods
	public RSA() {
		createPQ();
	}
	
	 void createPQ() {
		p = findPrimeNumber();
	}
	
	public int findPrimeNumber() {
		Random r = new Random();
		int temp = r.nextInt(100) +10;
		int firstPrime = 3;
		for(int i = 0; i < temp; i++);
			
	}
	
}

class RSAMain {
	
	public static void main(String [] args) {
		RSA r = new RSA();
	}
}