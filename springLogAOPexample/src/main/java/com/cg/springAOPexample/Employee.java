package com.cg.springAOPexample;

/**
 * Hello world!
 *
 */
public class Employee 
{
    public int run()
    {
    	int number=10;
 
    	System.out.println("run method called");
    	return number;
    }
    
 
    public void check(int num) throws Exception
    {
    	if(num>0)
    	{
    		System.out.println("it is positive");
    	}
    	else
    	{
    		throw new Exception("exception called");
    	}
    }
}
