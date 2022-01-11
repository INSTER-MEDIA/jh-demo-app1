package com.inster.media.java.jh.demo;

import com.inster.media.java.jh.demo.JhDemo1App;
import com.inster.media.java.jh.demo.config.TestSecurityConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { JhDemo1App.class, TestSecurityConfiguration.class })
public @interface IntegrationTest {
}
