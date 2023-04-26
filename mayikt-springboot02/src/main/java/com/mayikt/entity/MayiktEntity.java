package com.mayikt.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@Data
@Component
@ConfigurationProperties(prefix = "luo")
public class MayiktEntity {
    private String name;
    private String age;

}
