package com.root2z.aspect;

import com.root2z.utils.IPUtils;
import eu.bitwalker.useragentutils.UserAgent;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;

/** 请求日志处理 */
@Aspect
@Component
public class WebLogAspect {

  private static final Logger LOGGER = LoggerFactory.getLogger(WebLogAspect.class);

  /** 设置请求时间 */
  private ThreadLocal<Long> startTime = new ThreadLocal<>();

  /** 在控制器包创建切入点 */
  @Pointcut("execution(public * com.root2z.controller..*.*(..))")
  public void webLogPointcut() {}

  /**
   * 在切点之前织入
   *
   * @param joinPoint
   * @throws Throwable
   */
  @Before("webLogPointcut()")
  public void doBefore(JoinPoint joinPoint) throws Throwable {
    startTime.set(System.currentTimeMillis());
    // 开始打印请求日志
    ServletRequestAttributes attributes =
        (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = attributes.getRequest();

    // 获取请求头中的User-Agent
    UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));

    // 打印请求相关参数
    LOGGER.info(
        "========================================== Start ==========================================");
    // 打印请求 url
    LOGGER.info("URL              : {}", request.getRequestURL().toString());
    // 打印 Http method
    LOGGER.info("HTTP Method      : {}", request.getMethod());
    LOGGER.info("Request IP       : {}", IPUtils.getIpAddr(request));
    LOGGER.info(
        "Class Method     : {}.{}",
        joinPoint.getSignature().getDeclaringTypeName(),
        joinPoint.getSignature().getName());
    LOGGER.info("Request Args     : {}", Arrays.toString(joinPoint.getArgs()));
    LOGGER.info("Browser          : {}", userAgent.getBrowser());
    LOGGER.info("Browser version  : {}", userAgent.getBrowserVersion());
    LOGGER.info("Operation System : {}", userAgent.getOperatingSystem());
  }

  @AfterReturning(returning = "result", pointcut = "webLogPointcut()")
  public void doAfterReturning(Object result) throws Throwable {
    // 共计花费时间
    LOGGER.info("Spend Time       : {}", (System.currentTimeMillis() - startTime.get()) + "ms");
    LOGGER.info(
        "=========================================== End ===========================================");
    LOGGER.info("");
  }

  /**
   * 捕获控制器发生的异常
   *
   * @param throwable
   */
  @AfterThrowing(value = "webLogPointcut()", throwing = "throwable")
  public void doAfterThrowing(Throwable throwable) {
    // 保存异常日志记录
    LOGGER.error("发生异常时间：{}" + LocalDateTime.now());
    LOGGER.error("抛出异常：{}" + throwable.getMessage());
  }
}
