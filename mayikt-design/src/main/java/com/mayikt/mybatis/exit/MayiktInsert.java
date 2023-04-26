package com.mayikt.mybatis.exit;

import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Indexed
public @interface MayiktInsert {
    String value();
}