package com.momo.demo.http;

import com.momo.demo.Member;
import com.momo.demo.MemberService;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 會員 REST API
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService service;

    @RequestMapping("/member")
    public String home() {
        return "member.html";
    }

    /**
     * 取得列表
     */
    @GetMapping("/member/getAll")
    public ResponseEntity<List<Member>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    /**
     * 新增
     */
    @PostMapping("/member/add")
    public ResponseEntity<Member> create(@Valid @RequestBody MemberRequest request) {
        return ResponseEntity.ok(service.createMember(request));
    }

    /**
     * 查詢
     */
    @PostMapping("/member/search")
    public ResponseEntity<List<Member>> search(
            @Valid @NonNull @RequestBody MemberCondition condition) {
        return ResponseEntity.ok(service.search(condition));
    }

    /**
     * 更新
     */
    @PutMapping("/member/update")
    public ResponseEntity<Member> update(
            @Valid @NonNull @RequestBody MemberRequest request) {
        return service.updateMember(request)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    /**
     * 刪除
     */
    @DeleteMapping("/member/delete/{memberId}")
    public ResponseEntity<Void> delete(@NonNull @PathVariable Long memberId) {
        service.deleteMember(memberId);
        return ResponseEntity.noContent().build();
    }
}
