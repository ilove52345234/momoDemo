package com.momo.demo;


import com.momo.demo.http.MemberCondition;
import com.momo.demo.http.MemberRequest;
import com.momo.demo.jpa.MemberRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;


/**
 * 會員服務
 */
@Service
@Validated
@Slf4j
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;


    /**
     * 取得全部的方法
     */
    public List<Member> getAll() {
        return memberMapper.fromJpa(memberRepository.findAll());
    }

    /**
     * 搜尋的方法
     */
    public List<Member> search(MemberCondition memberCondition) {
        return memberMapper.fromJpa(memberRepository.findMembers(memberCondition));
    }

    /**
     * 新增的方法
     */
    @Transactional(rollbackFor = Exception.class)
    public Member createMember(@Valid @NotNull MemberRequest memberRequest) {
        return memberMapper.fromJpa(memberRepository.save(memberMapper.toJpa(memberRequest)));
    }

    /**
     * 更新的方法
     */
    @Transactional(rollbackFor = Exception.class)
    public Optional<Member> updateMember(MemberRequest memberRequest) {
        Long Id = memberRequest.getId();
        val entity = memberRepository.findById(Id).orElseThrow(() -> new IllegalArgumentException("更新分失敗，查無會員資料"));
        val beforeSave = memberMapper.copy(memberRequest, entity);
        return Optional.ofNullable(memberMapper.fromJpa(memberRepository.save(beforeSave)));
    }


    /**
     * 刪除的方法
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteMember(@Valid @Min(1) Long planInfoId) {
        memberRepository.deleteById(planInfoId);
    }

}
