package com.example.redistest.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Movie")
public class Movie implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    private Long id;
    private String name;
}
