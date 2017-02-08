package com.khjtony.FizzBuzzForSwift;

import java.util.ArrayList;

public class FizzBuzz {
	//	single node class. This class holes the raw value of fibonacci 
	//	values and its string result.
	class Atom{
		Atom(long raw_value, String str_value){
			this.raw_value=raw_value;
			this.str_value=str_value;
		}
		public long raw_value;
		public String str_value;
	}
	
	private final int DEFAULT_LIMIT=100;
	private final boolean DEFAULT_REMEMBER = true;
	private ArrayList<Atom> _fb = new ArrayList<Atom>();
	private int limit=0;
	private boolean remember=true;
	
	//********************Constructor********************
	// Constructors. Will set limit and remember option to default value.
	FizzBuzz(){
		//default constructor
		this.limit=DEFAULT_LIMIT;
		this.remember=DEFAULT_REMEMBER;
	}
	
	// Optional constructor that change the limit value. 
	// Attention: when call this function, the program will generate 
	// fibonacci values immediately.
	FizzBuzz(int limit){
		// configure the limit
		// when constructed from this constructor,
		// _fb will be filled up to the limit
		this.limit=limit>=this.limit?limit:this.limit;
		this.remember=DEFAULT_REMEMBER;
		_generate(this.limit);
	}
	
	// Optional constructor that change the remember option. 
	FizzBuzz(boolean remember){
		this.limit=DEFAULT_LIMIT;
		this.remember=remember;
	}
	
	// ********************public functions********************
	// Wrapper function serves as public function. 
	// accept n as input parameter
	// return the final result in String, "Fizz", "Buzz", etc
	// throw ArithmeticException when n<0
	public String doFizzBuzz(int n) throws ArithmeticException{
		if(n<0){
			throw new ArithmeticException("Input value less than 0!");
		}
		if(this.remember){
			return _generate(n);
		}else{
			return _quickFizzBuzz(n);
		}
	}
	
	// ********************private help functions********************
	// When remember option is disabled, this function will be call
	// to directly calcluate the final result.
	// Accept n as input parameter
	// return the final result in String, "Fizz", "Buzz", etc
	private String _quickFizzBuzz(int n){
		if(n<1){
			throw new ArithmeticException("Input value less than 0!"); 
		}
		if(n<3){
			return _valueCheck(1);
		}
		long first=1;
		long second=1;
		long temp=0;
		for (int i=this._fb.size();i<n;i++){
			temp=first+second;
			first=second;
			second=temp;
		}
		return _valueCheck(temp);
	}
	
	// This function will generate and store the first nth fibonacci
	// numbers in the ArrayList
	// Accept n as input parameter
	// return the final result in String, "Fizz", "Buzz", etc
	private String _generate(int n){
		long temp=0;
		// if _fb<3, initialize the _fb first.
		if(this._fb.size()<3){
			this._fb.clear();
			this._fb.add(new Atom(0,"0"));
			this._fb.add(new Atom(1,"1"));
			this._fb.add(new Atom(1,"1"));
		}
		
		try{
			// if request nth number is larger than limit, fill in the
			// _fb ArrayList first, and calculate the result on the fly.
			if(n>this.limit){
				//filling ArrayList first
				_generate(this.limit);
				long first=this._fb.get(this._fb.size()-2).raw_value;
				long second=this._fb.get(this._fb.size()-1).raw_value;
				//calculate requested number on the fly
				for (long i=this._fb.size();i<=n;i++){
					temp=first+second;
					first=second;
					second=temp;
				}
				return _valueCheck(temp);
			}else{
				// if request nth number is in the ArrayList,
				// just return the result.
				if (this._fb.size()>n){
					if(this._fb.get(n).str_value!=""){
						return this._fb.get(n).str_value;
					}else{
						this._fb.get(n).str_value=_valueCheck(this._fb.get(n).raw_value);
						return this._fb.get(n).str_value;
					}
				}else{
					// if request nth number is not in the ArrayList, generate
					// the number and return the result.
					for (int i=this._fb.size();i<=n;i++){
						temp=this._fb.get(i-2).raw_value+this._fb.get(i-1).raw_value;
						this._fb.add(new Atom(temp, ""));
					}
				}
				// Only check the number when needed.
				this._fb.get(n).str_value = _valueCheck(this._fb.get(n).raw_value);
				return this._fb.get(n).str_value;
			}
			
		}catch(Exception e){
			// Throw the unkown error
			System.out.println("Unkown error: "+e.getStackTrace());
		}
		return null;
	}
	
	
	// This function check the value, and return the string result.
	// Accept a fibonacci number
	// Return result in String, "Fizz", "Buzz", etc
	private String _valueCheck(long value){
		if(value%2==0){
			return String.valueOf(value);
		}
		
		if(value%15==0){
			return "FizzBuzz";
		}
		
		if(value%3==0){
			return "Buzz";
		}
		
		if(value%5==0){
			return "Fizz";
		}
		
		if(_isPrime(value)){
			return "BuzzFizz";
		}
		
		return String.valueOf(value);
	}
	
	
	// This function will check if a number is prime number.
	// Accept a value
	// Return true or false in boolean
	private boolean _isPrime(long value){
		// though value%2==0 has been tested previously in the _valueCheck
		// for better readability, we will check again.
		if (value<=1){
			return false;
		}
		if(value<=3){
			return true;
		}
		if(value%2==0 || value%3==0){
			return false;
		}
		int i=5;
		while(i*i<value){
			if (value%i==0 || value%(i+2)==0){
				return false;
			}
			i+=6;	
		}	
		return true;
	}
	
	
}
