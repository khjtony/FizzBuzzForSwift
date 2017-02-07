package com.khjtony.FizzBuzzForSwift;

import java.util.ArrayList;

public class FizzBuzz {
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
	
	// Constructors
	FizzBuzz(){
		//default constructor
		this.limit=DEFAULT_LIMIT;
		this.remember=DEFAULT_REMEMBER;
	}
	FizzBuzz(int limit){
		// configure the limit
		// when constructed from this constructor,
		// _fb will be filled up to the limit
		this.limit=limit>=this.limit?limit:this.limit;
		this.remember=DEFAULT_REMEMBER;
	}
	FizzBuzz(boolean remember){
		this.limit=DEFAULT_LIMIT;
		this.remember=remember;
	}
	
	// public functions
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
	
	// private help functions
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
	
	private String _generate(int n){
		long temp=0;
		if(this._fb.size()<3){
			this._fb.clear();
			this._fb.add(new Atom(0,"0"));
			this._fb.add(new Atom(1,"1"));
			this._fb.add(new Atom(1,"1"));
		}
		
		try{
			if(n>this.limit){
				//filling first
				_generate(this.limit);
				long first=this._fb.get(this._fb.size()-2).raw_value;
				long second=this._fb.get(this._fb.size()-1).raw_value;
				for (long i=this._fb.size();i<=n;i++){
					temp=first+second;
					first=second;
					second=temp;
				}
				return _valueCheck(temp);
			}else{
				if (this._fb.size()>n){
					if(this._fb.get(n).str_value!=""){
						return this._fb.get(n).str_value;
					}else{
						this._fb.get(n).str_value=_valueCheck(this._fb.get(n).raw_value);
						return this._fb.get(n).str_value;
					}
				}else{
					for (int i=this._fb.size();i<=n;i++){
						temp=this._fb.get(i-2).raw_value+this._fb.get(i-1).raw_value;
						this._fb.add(new Atom(temp, ""));
					}
				}
				this._fb.get(n).str_value = _valueCheck(this._fb.get(n).raw_value);
				return this._fb.get(n).str_value;
			}
			
		}catch(Exception e){
			System.out.println("Unkown error: "+e.getStackTrace());
		}
		return null;
	}
	
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