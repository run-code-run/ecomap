package api.logging;


import api.entity.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LggingAspect {

    @Around("@annotation(LogUserRegistration)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

        Object proceed = joinPoint.proceed();

        Object[] args = joinPoint.getArgs();

        for (Object o : args) {
            if (o instanceof User) {
                User u = (User) o;
                System.out.println(joinPoint.getSignature() + u.toString() + " has tried to register.");
            }
        }

        return proceed;
    }

}
