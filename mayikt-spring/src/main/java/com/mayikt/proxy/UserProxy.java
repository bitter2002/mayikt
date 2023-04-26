package com.mayikt.proxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect//定义切面
public class UserProxy {

    @Pointcut("execution(* com.mayikt.service.MayiktService.*(..));")
    private void pointcut() {

    }

    /*
     *  @Before(value = "定义切入点")
     * aop通知
     * 前置通知
     * 后置通知
     * 异常通知
     * 环绕通知
     * */
    //拦截我们MayiktService类中的所有方法
    @Before(value = "execution(* com.mayikt.service.MayiktService.*(..));")
    public void before(JoinPoint joinPoint) {
        //获取到目标方法传递的参数
        Object[] args = joinPoint.getArgs();
        for (int i =0;i<args.length;i++){
            System.out.println("@Before:使用前置通知输出调用目标方法的参数值args:" + args[i]);
        }
        System.out.println("@Before在目标方法之前执行..");

    }

    @After(value = "execution(* com.mayikt.service.MayiktService.*(..));")
    public void after() {
        System.out.println("@After在目标方法之后执行..");
    }

    /*
     *
     * */
    @Around(value = "execution(* com.mayikt.service.MayiktService.*(..));")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知调用目标方法前..");
        Object result = proceedingJoinPoint.proceed();//调用到目标方法
        System.out.println("环绕通知调用目标方法后..");
        return result;
    }

    //@AfterReturning 表达后置通知/返回通知,表达方法返回结果后执行
    @AfterReturning(value = "execution(* com.mayikt.service.MayiktService.*(..));")
    public void afterReturning() {
        System.out.println("afterReturning");
    }

    /*
     * 异常通知 方法有异常就抛出该通知
     * */
    @AfterThrowing(value = "execution(* com.mayikt.service.MayiktService.*(..));")
    public void afterThrowing() {
        System.out.println("afterThrowing 异常通知拦截");
    }
}
