package demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {

    @Before("execution(* demo.ShoppingCart.checkout(..))")
    public void loggerBefore(JoinPoint joinPoint){

        System.out.println("############\nLoggers before\n");

        System.out.println("Kind : "+joinPoint.getKind());
        System.out.println("Signature : "+joinPoint.getSignature());
        System.out.println("Location : "+joinPoint.getSourceLocation());
        System.out.println("Args : "+joinPoint.getArgs()[0]);
        System.out.println("Target : "+joinPoint.getTarget() );
        System.out.println("Static Part : "+joinPoint.getStaticPart());

        System.out.println("\n############\nLoggers before");
    }

    @After("execution(* *.*.checkout(..))") // * for any return type, * for any package , * for any class. with checkout method
    public void loggerAfter(){
        System.out.println("Loggers after");
    }
    @Pointcut("execution(* demo.ShoppingCart.quantity(..))")
    public void  afterReturningPointCut(){

    }
    @AfterReturning(pointcut = "afterReturningPointCut()",returning = "retVal")
    public void  afterReturning(String retVal){
        System.out.println("After returning => "+retVal);
    }
}
