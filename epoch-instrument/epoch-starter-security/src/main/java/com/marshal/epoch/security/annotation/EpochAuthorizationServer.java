package com.marshal.epoch.security.annotation;

import java.lang.annotation.*;

import com.marshal.epoch.security.config.SecurityAutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 * <p>name:EpochAuthorizationServer</p>
 * <pre>
 *      description: an annotation mark application as an authorization server
 * </pre>
 *
 * @author Marshal Yuan
 * @date 2020/8/16
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(SecurityAutoConfiguration.class)
public @interface EpochAuthorizationServer {
}

