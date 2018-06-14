package ar.edu.unlp.pasae.pasaetrabajofinalbackend.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggerServicesAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(LoggerServicesAspect.class);

	public LoggerServicesAspect() {
		// TODO Auto-generated constructor stub
	}
	
	@Around(value = "execution(* ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.*.*(..))")
	public Object after(final ProceedingJoinPoint joinPoint) throws Throwable {
		
		logger.info("Se va a ejecutar el servicio {}", joinPoint);

		Object proceed = joinPoint.proceed();

		logger.info("Se ejecutó el servicio {}", joinPoint);
		
		return proceed;
	}


}
