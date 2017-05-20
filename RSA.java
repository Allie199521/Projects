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
		this.d = e%theta;
		pulverizer();	// used to find the x and y values
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
		for(int i = 3; i < this.theta; i--) {
			// if their gcd is 1 set e = i and break
			if(gcd(this.theta, i) == 1) {
				e = i;
				break;
			}
		}
	}
	
	public void pulverizer() {
		
	}
	
	//finds as random a number i can think of
	//returns int
	private int findPrimeNumber() {
		Random r = new Random();	//create random object
		int rand = r.nextInt(400)+1;	// create a random number
		int prime = 1;	//keep track of our prime number
		// temp is going to be the count for how many prime numbers
		// will be multiplied together
		int temp = ((r.nextInt(rand)+rand) + (r.nextInt(rand)+rand));
		int primeCount = 3;
		//from 0 to the temp number divided by a different random
		//value every time, less than rand (because its /4)
		for(int i = 0; i < temp/r.nextInt(rand/4); i++){
			//if the prime count value is prime then multiply it
			if(isPrime(primeCount))
				prime *= primeCount;
			primeCount++;	//or else just add one to prime count
		}
		//return the number plus one, because then it is prime
		return prime++;
	}
	
	// method to check if something is prime
	//takes a prime value and returns a boolean
	public boolean isPrime(int prime) {
		if(n%2 == 0) return false;
		//looping through odd values until i^2
		//is greater than the "prime" value
		for(int i = 3; i*i <= prime; i +=2)
			if(n%i == 0) return false; //if evenly divisible then return false
		return true; // else return true that it is prime
	}
	
	// checking for the gcd recursively
	public int gcd(int t, int i) {
		if(t == 0 || i == 0) return a+b; //returning an assumed to be >0 value
		return gcd(i, t%i); //returns gcd(smaller int, bigger int mod smaller)
	}
	
}

// runs and tests RSA for functionality
class RSAMain {
	
	public static void main(String [] args) {
		RSA r = new RSA();
	}
}