package com.sparta.homework1.controller;

import com.sparta.homework1.domain.Memo;
import com.sparta.homework1.domain.MemoRepository;
import com.sparta.homework1.domain.MemoRequestDto;
import com.sparta.homework1.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.sql.Update;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor//
@RestController         //
public class MemoController {

    private final MemoRepository memoRepository;    //나머지는 리포지토리가 필요하다. 필수적인녀석 final
    private final MemoService memoService;          //업데이트를 위해선 서비스가 필요. 필수적인녀석 final

    @PostMapping("/api/memos")    //
    public Memo createMemo(@RequestBody MemoRequestDto requestDto){//메모라는 녀석 안에 있는 createMemo 메서드를 사용하고
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);  //저장은 레포지토리에서 함

    }

    @GetMapping("/api/memos")
    public List<Memo> readMemo(){//조회하기 부분
        LocalDateTime now = LocalDateTime.now();//지금
        LocalDateTime yesterday = LocalDateTime.now().minusDays(1);//하루 전
        return memoRepository.findAllByModifiedAtBetweenOrderByModifiedAtDesc(yesterday, now);    //찾을 때는 repository쓰고 find머시기 써줘라.
        //findAllByModifiedAt Between OrderByModifiedAtDesc
    }

    //update
    @PutMapping("/api/memos/{id}")
    public Long UpdateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){
        memoService.update(id,requestDto);
        return id;
    }

    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id){//@PathVariable Long id경로에 중괄호로 쌓여있는걸 보면 똑같은걸 넣어줄게~
        memoRepository.deleteById(id);
        return id;
    }
    @GetMapping("/api/memos/{id}/pwd")
    public String dbgetPassword(@PathVariable Long id){
        return memoService.getPasswordService(id);
    }

    //main
//    @RequestMapping("/memo/memoList")
//    public String getList(){
//        return "memoList";
//    }
}