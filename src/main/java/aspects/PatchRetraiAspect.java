package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import metier.Compte;
import metier.MetierImpl;

@Aspect
public class PatchRetraiAspect {
	
	@Pointcut("execution(* metier.MetierImpl.retirer(..))")
	public void pc1() {}
	
	@Around("pc1() && args(code, montant)")
	public Object autourRetirer(Long code, double montant, ProceedingJoinPoint proceedingJoinPoint, JoinPoint joinPoint) throws Throwable {
		MetierImpl metierImpl = (MetierImpl) joinPoint.getTarget();
		Compte c = metierImpl.consulter(code);
		if(c.getSolde() < montant) throw new RuntimeException("Solde insuffisant");
		return proceedingJoinPoint.proceed();
	}

}
