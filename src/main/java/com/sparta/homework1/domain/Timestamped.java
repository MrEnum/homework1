package com.sparta.homework1.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter             //세개 중에 하나도 빠지면 안된다.
@MappedSuperclass // Entity가 자동으로 컬럼으로 인식합니다.
@EntityListeners(AuditingEntityListener.class) // 생성/변경 시간을 자동으로 업데이트합니다./ 변화가 일어나면 자동으로 업데이트 해준다.
public abstract class Timestamped {

    @CreatedDate//생성시간
    private LocalDateTime createdAt;

    @LastModifiedDate//수정시간
    private LocalDateTime modifiedAt;
}