package com.sparta.homework1.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.homework1.domain.MemoRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;     //JPA선언

@NoArgsConstructor // 기본생성자를 만듭니다. ㅣimport lombok.NoArgsConstructor에서 가져온듯
@Getter             //import lombok.Getter;에서 가져온듯.
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Memo extends com.sparta.homework1.domain.Timestamped { // 생성,수정 시간을 자동으로 만들어줍니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    //컬럼은 디비에서열
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    @JsonIgnore
//    @JsonIgnore
    private String password;

    @Column(nullable = false)
    private String title;


    public Memo(String username, String contents, String password, String title) {
        this.username = username;
        this.contents = contents;
        this.password = password;
        this.title = title;
    }

    public Memo(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();
        this.title = requestDto.getTitle();
    }

    public void update(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();
    }
}