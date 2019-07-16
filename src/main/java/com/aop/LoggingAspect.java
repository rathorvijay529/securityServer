package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
//Note:The two dots in the argument list match any number of arguments.
//syntax 1.  @Before("execution(* pkgName.className.methodName(..))")
//2.  @Before("execution(* pkgName.className.*(..))")  // in class  all method
//3.  @Before("execution(* pkgName.*.*(..))")  // in pkg all classess all method

//@AfterReturning annotated methods run after the method (matching with pointcut expression) is executed normally and do no throw any error/exception.
//@AfterThrowing annotated methods run after the method (matching with pointcut expression) exits by throwing an exception.
//@Around annotated methods run before and after the all methods matching with pointcut expression.
@Aspect
@Component
public class LoggingAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// @Before is used to identify something before the execution the particular
	// method that will match by regrex
	// getSignature() ::name of method
	// getArgs()::argument
	// getStaticPart():: give the expression of Advise
	@Before("execution(* com.service.UserServiceImpl.*(..)) ")
	public void loggingAspectBefore(JoinPoint joinPoint) {
		logger.info("Inside class ::" + joinPoint.getTarget().getClass().getName());
		logger.info("Method name::" + joinPoint.getSignature().getName() + " Starting..");
		logger.info("RunnTime argument::" + joinPoint.getArgs().length);
		Object[] signatureArgs = joinPoint.getArgs();
		for (Object signatureArg : signatureArgs) {
			int count = 0;
			logger.info("Arg:" + (++count) + "::" + signatureArg);
		}
	}

	@After("execution(* com.service.UserServiceImpl.*(..)) ")
	public void loggingAspectAfter(JoinPoint joinPoint) {
		logger.info("Inside class ::" + joinPoint.getTarget().getClass().getName());
		logger.info("Method name::" + joinPoint.getSignature().getName() + " ending..");
	}

	

	@AfterReturning(pointcut = "execution(* com.service.UserServiceImpl.*(..))", returning = "returnValue")
	public void loggingAspectAfterReturning(JoinPoint joinPoint, Object returnValue) throws Throwable {
		logger.info("Method " + joinPoint.getSignature().getName() + " return " + returnValue.toString());
		logger.info("Method run successfully No error no Exception");
	}

	@AfterThrowing(pointcut = "execution(* com.service.UserServiceImpl.*(..))", throwing = "ex")
	public void loggingAspectAfterThrowingException(JoinPoint joinPoint, Exception ex) throws Throwable {
		logger.info("Method " + joinPoint.getSignature().getName() + " throw exception " + ex.getMessage());
	}
	
	
	/*@Around("execution(* com.service.UserServiceImpl.*(..))")
	public void loggingAspectAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		//logger.info("Around the method " + joinPoint.getSignature().getName() + " is starting");
		//logger.info("Around the method " + joinPoint.getSignature().getName() + " is ended");
		System.out.println("*********************");
	}*/
}
