# FizzBuzzForSwift
## Introduction
This is "answer" code for the application challenge for Swift Navigation.
This code solves the problem at [this](https://github.com/swift-nav/screening_questions/blob/master/questions.md#swift-navigation-application-questions) site.

I chose to use Java, because it is more "Enterprise" taste and has good project management method.

## Program Design
### Language choice
For the best performance, I should choose C or assembly. Java has unexpected garbage collection mechanism which is bad for hard Real-Time application, and it has a lot of program overhead. 

For the fast developing, python could be a better language, but Java has better project management and team collaboration taste, and junit test is just great, I chose Java.

### Design concerns
I assume such an application situation that, the program runs on the embedded system or low profile system that is sensitive to the time and space. For example a field datalogger that responses to the remote requests. It can be idle for long time, but it should response fast enough. Ofcourse, the application envrionment is not related to the actual program content, but I just need a design guideline. 
Algorithm design concerns time complecity and extra space needed. My design will use extra memory space, but excution time will keep low after long time use, because it will remember previous results.

### Mechanism
The program will store all the data in an arraylist of **Atom** class, which consists of **Long** and **String**. When function **doFizzBuzz(int n)** is called, program will first check wether the result is exist in the arraylist. If it is, the program will directly return the result. If the value was generated previously but the property was not, then check the property. If none of them exist, then the program will first calculate **fb(n)**, then check the property.

**ATTENTION** Fibonacci values generation and value check are seperately function, since prime number check costs a lot of time, I only check the value when return the final answer needed.

### Properties and variables
**_fb** : ArrayList<Atom> storage space/look up table to remember the result for future lookup.
**limit** : defines how many elements can be stored in the ArrayList. effects how much memory will be used at most.
**remember** : true when we want program remember generated results, and false that we calculate result on the fly.

### Exception
Input n less or equal to 0 results in "ArithmeticException".

### Interface and construction
FizzBuzz();       // default constructor, will set limit to 100 and enable the remember option. 

FizzBuzz(int limit);      //constructor, will set limit to value input,enable the remember option, and generate n fb values.

FizzBuzz(boolean remember);     // default constructor, will disable the remember option.

String doFizzBuzz(int n);	// public function that do the FizzBuzz calculation.

**More detailed comments and thoughts are in the source code.**
### Sample usage
```java  
package com.khjtony.FizzBuzzForSwift;

public class FizzBuzzMain {
	public static void main(String[] args){
		FizzBuzz fb= new FizzBuzz();
		System.out.println("fb(3)="+fb.doFizzBuzz(3));
		System.out.println("fb(51)="+fb.doFizzBuzz(51));
		
		System.out.println("fb(5)="+fb.doFizzBuzz(5));
		System.out.println("fb(9)="+fb.doFizzBuzz(9));
		System.out.println("fb(11)="+fb.doFizzBuzz(11));
		System.out.println("fb(1)="+fb.doFizzBuzz(1));
	}

}
```  
And expected output would be:
```  
fb(3)=2
fb(51)=20365011074
fb(5)=Fizz
fb(9)=34
fb(11)=BuzzFizz
fb(1)=1
```

##Project Management
This project uses Maven as project manager. No external library needed. This project can be loaded by Eclipse. 
