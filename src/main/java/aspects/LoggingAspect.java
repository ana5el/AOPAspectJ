package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;







@Aspect
public class LoggingAspect {
	
	public Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Pointcut("execution(* metier.MetierImpl.*(..))")
	public void pc1() {}
	
//	@Before("pc1()")
//	public void avant(JoinPoint joinPoint) {
//		t1 = System.currentTimeMillis();
//		logger.info("Avant l'execution de la methode " + joinPoint.getSignature());
//	}
//	
//	@After("pc1()")
//	public void apres(JoinPoint joinPoint) {
//		logger.info("Apres l'execution de la methode " + joinPoint.getSignature());
//		t2 = System.currentTimeMillis();
//		logger.info("Duree de l'exucution de la methode : " + (t2-t1));
//	}
	
//	@Around("pc1()")
//	public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//		logger.info("{}","Avant l'execution de la methode ");
//		proceedingJoinPoint.proceed();
//		logger.info("{}","Apres l'execution de la methode ");
//	}
	
	@Around("pc1()")
	public Object autour(ProceedingJoinPoint proceedingJoinPoint, JoinPoint joinPoint) throws Throwable {
		long t1 = System.currentTimeMillis();
		logger.info("Avant l'execution de la methode " + joinPoint.getSignature());
		Object o = proceedingJoinPoint.proceed();
		logger.info("Apres l'execution de la methode " + joinPoint.getSignature());
		long t2 = System.currentTimeMillis();
		logger.info("Duree de l'exucution de la methode : " + (t2-t1));
		return o;
	}

}
