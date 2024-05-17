package com.momo.demo;

import com.momo.demo.http.MemberRequest;
import com.momo.demo.jpa.MemberEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

import static org.mapstruct.CollectionMappingStrategy.TARGET_IMMUTABLE;
import static org.mapstruct.NullValueMappingStrategy.RETURN_DEFAULT;

@Mapper(componentModel = "spring", collectionMappingStrategy = TARGET_IMMUTABLE, nullValueMappingStrategy = RETURN_DEFAULT, builder = @Builder)
public interface MemberMapper {

    Member fromJpa(MemberEntity source);

    List<Member> fromJpa(List<MemberEntity> source);

    MemberEntity toJpa(MemberRequest source);

    List<MemberEntity> toJpa(List<MemberRequest> source);

    @Mapping(target = "id", ignore = true)
    MemberEntity copy(MemberRequest source, @MappingTarget MemberEntity target);

}
