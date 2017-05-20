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
	public int n;	// n value for both public and private keys
	public int e;	// e value for the public key
	private int d;	// d value for the private key
	private int p;	// p prime number
	private int q;	// q prime number
	private int theta;	//(p-1)*(q-1)
	private int x;	// 1 = x * e + y * theta
	private int y;	
	
	//implements the public and private keys
	//by calling on a series of methods
	public RSA() {
		createPQ();	//create prime numbers p and q
		this.n = p*q;	// use p and q to make n
		this.theta = (p-1)*(q-1);	// use p and q to make theta
		findE();	//find an e where 1 < e < theta
		pulverizer();	// used to find the x and y values
		this.d = y%theta;
	}
	
	// sets the p and q value to a prime number
	// found by the method findPrimeNumber()
	private void createPQ() {
		this.p = findPrimeNumber();
		this.q = findPrimeNumber();
	}
	
	// chooses a number e where 1 < e < theta
	// makes sure that gcd(theta, e) == 1
	public void findE() {
		// for all numbers less than theta
		for(int i = 3; i < this.theta; i++) {
			//System.out.println(i);
			// if their gcd is 1 set e = i and break
			if(gcd(this.theta, i) == 1) {
				e = i;
				break;
			}
		}
		System.out.println(e);
	}
	
	// finds our x and y values by using the
	// pulverizer algorithm
	public void pulverizer() {
		int [] pulv = new int[8];
		pulv[0] = this.theta;	//temp theta value
		pulv[1] = this.e;	// temp e value
		pulv[2] = pulv[0]/pulv[1];	// quotient
		pulv[3] = pulv[0]%pulv[1];	// remainder
		pulv[4] = 1;	// x1
		pulv[5] = 0;	// y1
		pulv[6] = 0;	// x2
		pulv[7] = 1;	// y2
		while (pulv[3] != 0) {
			pulv[0] = pulv[1];
			pulv[1] = pulv[3];
			int qTemp = pulv[2];
			pulv[2] = pulv[0]/pulv[1];
			pulv[3] = pulv[0]%pulv[1];
			int x1Temp = pulv[4];
			int y1Temp = pulv[5];
			pulv[4] = pulv[6];	// x1
			pulv[5] = pulv[7];	// y1
			pulv[6] = x1Temp - qTemp*(pulv[4]);
			pulv[7] = y1Temp - qTemp*(pulv[5]);
		}
		this.x = pulv[6];
		this.y = pulv[7];
	}
	
	//finds as random a number i can think of
	//returns int
	private int findPrimeNumber() {
		Random r = new Random(1);	//create random object
		int rand = r.nextInt(20)+5;	// create a random number
		int prime = 1;	//keep track of our prime number
		int primeCount = 3;
		//from 0 to the temp number divided by a different random
		for(int i = 1; i < rand; i++){
			//System.out.println("Am i getting here ?");
			//if the prime count value is prime then multiply it
			if(isPrime(primeCount)) {
				prime *= primeCount;
			}
			primeCount++;	//or else just add one to prime count
		}
		//return the number plus one, because then it is prime
		return prime++;
	}
	
	// method to check if something is prime
	//takes a prime value and returns a boolean
	public boolean isPrime(int prime) {
		if(prime%2 == 0) return false;
		//looping through odd values until i^2
		//is greater than the "prime" value
		int i = 3;
		while(i*i <= prime && prime%i != 0){i+=2;}
		return prime%i != 0; // else return true that it is prime
	}
	
	// checking for the gcd recursively
	public int gcd(int t, int i) {
		if(t == 0 || i == 0) return t+i; //returning an assumed to be >0 value
		return gcd(i, t%i); //returns gcd(smaller int, bigger int mod smaller)
	}
	
	public int encrypt(int m) {
		return ((int)Math.pow(m, e))%n;
	}
	
	public int decrypt(int c) {
		return ((int)Math.pow(c, d))%n;
	}
	
}

// runs and tests RSA for functionality
class RSAMain {
	
	public static void main(String [] args) {
		RSA r = new RSA();
		int m = 2;
		int c = r.encrypt(2);
		if(r.decrypt(c) == m) System.out.println("You Rock");
		else System.out.println("You suck");
	}
}