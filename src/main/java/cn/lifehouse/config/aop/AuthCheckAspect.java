package cn.lifehouse.config.aop;

import cn.lifehouse.config.constants.RedisConstant;
import cn.lifehouse.config.exception.AuthCheckException;
import cn.lifehouse.config.models.json.AuthUserJson;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

@Aspect
@Order(1)
@Component
public class AuthCheckAspect {

    @Autowired
    protected RedisTemplate<Object, Object> redisTemplate;

    @Pointcut("execution(* cn.lifehouse.config.controller.ConfigController.*(..)) || " +
            "execution(* cn.lifehouse.config.controller.UserController.*User(..))")
    public void authCheck(){}

    @Before("authCheck()")
    public void doBefore(JoinPoint joinPoint) throws Exception{
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)){
            throw new AuthCheckException();
        }
        AuthUserJson user = (AuthUserJson) redisTemplate.opsForValue().get(RedisConstant.CONFIG_AUTH_USER_KEY + token);
        if (user == null){
            throw new AuthCheckException();
        }
        redisTemplate.opsForValue().set(RedisConstant.CONFIG_AUTH_USER_KEY + token, user, 60, TimeUnit.MINUTES);
    }
}
