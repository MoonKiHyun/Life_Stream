package com.moon.lifestream.domain.member.repository;

import com.moon.lifestream.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
