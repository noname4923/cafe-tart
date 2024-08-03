package com.blog.nta.api.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.blog.nta.api.domain.member.MemberVO;

@Mapper
@Repository
public interface MemberMapper {

	/* 회원정보 조회 */
	MemberVO selectMemberInfo();
	/* 로그인 회원정보 조회 */
	MemberVO selectLoginMemberInfo(MemberVO memberVO);
}
