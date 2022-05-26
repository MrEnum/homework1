package com.sparta.homework1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing          //생성시간이 바꼈을 때, 수정사항이 바꼈을 떄, 자동으로 업데이트가 됩니다.
@SpringBootApplication
public class homework1Application {

    public static void main(String[] args) {
        SpringApplication.run(homework1Application.class, args);
    }

}
