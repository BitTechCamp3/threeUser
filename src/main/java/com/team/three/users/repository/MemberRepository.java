package com.team.three.users.repository;

import com.team.three.users.domain.Member;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends ReactiveCrudRepository<Member, Integer> {
}
