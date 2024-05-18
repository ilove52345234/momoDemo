package com.momo.demo.jpa;

import com.momo.demo.http.MemberCondition;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


/**
 * 會員Repository
 */
@Transactional(rollbackFor = Exception.class)
@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long>, JpaSpecificationExecutor<MemberEntity> {

    default List<MemberEntity> findMembers(MemberCondition condition) {
        Specification<MemberEntity> spec = (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (condition.getAccount() != null && !condition.getAccount().isEmpty()) {
                predicates.add(builder.equal(root.get("account"), condition.getAccount()));
            }
            if (condition.getName() != null && !condition.getName().isEmpty()) {
                predicates.add(builder.like(root.get("name"), "%" + condition.getName() + "%"));
            }
            if (condition.getStartDate() != null && condition.getEndDate() != null) {
                LocalDateTime startDate = condition.getStartDate().atStartOfDay();
                LocalDateTime endDate = condition.getEndDate().atTime(LocalTime.MAX);
                predicates.add(builder.between(root.get("createdDate"), startDate, endDate));
            } else if (condition.getStartDate() != null) {
                predicates.add(builder.lessThanOrEqualTo(root.get("createdDate"), LocalDateTime.of(condition.getStartDate(), LocalTime.MAX)));
            } else if (condition.getEndDate() != null) {
                predicates.add(builder.greaterThanOrEqualTo(root.get("createdDate"), LocalDateTime.of(condition.getEndDate(), LocalTime.MIN)));
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        };
        return findAll(spec);
    }
}
