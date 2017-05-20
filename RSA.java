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
		this.n = p*q;
		this.theta = (p-1)*(q-1)
	}
	
	private void createPQ() {
		this.p = findPrimeNumber();
		this.q = findPrimeNumber();
	}
	
	private int findPrimeNumber() {
		Random r = new Random();
		int rand = r.nextInt(400)+1;
		int prime = 1;
		int temp = (r.nextInt(rand)+rand) + (r.nextInt(rand)+rand);
		int primeCount = 3;
		for(int i = 0; i < temp/r.nextInt(rand/4); i++){
			if(isPrime(primeCount))
				prime *= primeCount;
			primeCount++;
		}
		return prime++;
	}
	
	public boolean isPrime(int prime) {
		if(n%2 == 0) return false;
		//looping through odd values
		for(int i = 3; i*i <= prime; i +=2)
			if(n%i == 0) return false;
		return true;
	}
	
}

class RSAMain {
	
	public static void main(String [] args) {
		RSA r = new RSA();
	}
}