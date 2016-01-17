package com.multithreading;

public class Calculator {


	/**
	 * Class level lock
	 * object level lock
	 * reentrant lock
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public  String shagunsLock=new String("lock");
	public  String gvLock=new String("lock");;
	public  String rdLock=new String("lock");;
	public  String pkLock=new String("lock");;
	
	
	public   int add(int a,int b){
		System.out.println("a+b");
		synchronized(this){
		    return a + b;
		}
	}
	
	public   int reentrantAdd(int a,int b){
		System.out.println("a+b");
		synchronized(this){
			subtract(a,b);
		    return a + b;
		}
	}
	
	
	public   int addAndSubtract(int a,int b){
		synchronized(shagunsLock){
			System.out.println("a+b");
			synchronized (gvLock) {
				System.out.println("Never In");
			}
		    return a + b;
		}
	}
	
	public   int subtractAndAdd(int a,int b){
		synchronized(gvLock){
			System.out.println("a-b");
			synchronized (shagunsLock) {
				System.out.println("IN Never");
			}
		    return a + b;
		}
	}
	
    public   int subtract(int a,int b){
    	System.out.println("a-b");
    	synchronized(this){
    	   return a - b;
    	}
	}
    
    public   int divide(int a,int b){
    	System.out.println("a/b");
    	synchronized(this){
    	   return a/b;
    	}
	}
    
    public   int multiply(int a,int b){
    	System.out.println("a*b");
    	synchronized(this){
    	  return a * b;
    	}
	}

}
