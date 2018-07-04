package com.cg.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AccountAspect {

	@Pointcut("execution(* com.cg.aop.*.withdraw(..))")
	public void k() {
	}

	
	 /*@Before("k()") public void myBeforeAdvice(JoinPoint jp) {
	 System.out.println("before advice is called"); }
	 
	 @After("k()") public void myAdviceAfter(JoinPoint jp) {
	 System.out.println("after advice is called");
	 System.out.println("Method Signature: " + jp.getSignature()); }
	 */

	@AfterReturning(pointcut = "execution(* com.cg.aop.*.withdraw(..))", returning = "result")
	public void myadvice(JoinPoint jp, Object result) {
		System.out.println("Method Signature: " + jp.getSignature());
		System.out.println("Result in advice: " + result);
		System.out.println("end of after returning advice...");
	}

	@Around("k()")
	public Object myadvice(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("Additional Concern Before calling actual method");
		Object obj = pjp.proceed();
		System.out.println("Additional Concern After calling actual method");
		return obj;
	}

	@AfterThrowing(pointcut = "execution(* com.cg.aop.*.withdraw(..))", throwing = "error")
	public void myadvice(JoinPoint jp,Throwable error) 
    {  
        System.out.println("Method Signature: "  + jp.getSignature());  
        System.out.println("Exception is: "+error);  
        System.out.println("end of after throwing advice...");  
    }

}
