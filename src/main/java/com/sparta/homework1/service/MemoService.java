package com.sparta.homework1.service;

import com.sparta.homework1.domain.Memo;
import com.sparta.homework1.domain.MemoRepository;
import com.sparta.homework1.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


//빠뜨리지 말아야할 두가지
//memoRepository를 그냥 내버려두면 알아서 넣어주지 못한다. final 해주고 @RequiredArgsConstructor 넣어준다.
//@Transactional 이것도 넣어줘야한다.
@RequiredArgsConstructor//final로 생성된 녀석이 있으면 그거 생성될 때 무조건 넣어줄게.
@Service                //서비스라는거 알려줌
public class MemoService {
    private final MemoRepository memoRepository;
    @Transactional      //
    public Long update(Long id, MemoRequestDto requestDto){
        Memo memo = memoRepository.findById(id).orElseThrow(    //찾았는데 없으면 에러를 발생시켜~
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        memo.update(requestDto);
        return memo.getId();
    }
    @Transactional
    public String getPasswordService(Long id){
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("비밀번호가 존재하지 않습니다.")
        );
        return memo.getPassword();
    }
}