package com.sparta.homework1.domain;
//클래스에서 메소드에서 멤버 변수만 없는 녀석들 = interface
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
//Query는 sql을 변형시킨것
//갖다 쓸거 다 JPA의 레포지토리를. 메모클래스이고 Long형태로 가져올것
public interface MemoRepository extends JpaRepository<com.sparta.homework1.domain.Memo, Long> {
    List<com.sparta.homework1.domain.Memo> findAllByModifiedAtBetweenOrderByModifiedAtDesc(LocalDateTime start, LocalDateTime end);
    //findAll By Modified At /Between/ Order By ModifiedAtDesc
}
