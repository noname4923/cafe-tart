package com.cafe.tart.api.domain.member;

import org.springframework.stereotype.Service;

import com.cafe.tart.api.repository.MemberMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberSvc {

	/*
	 * @Autowired를 사용하지 않고 의존성을 주입하는 방법으로 final 키워드와 @RequiredArgsConstructor를 사용하는
	 * 것은 매우 일반적이고 권장되는 방식입니다. 이 방법은 생성자 주입(Constructor Injection)을 통해 의존성을 주입
	 */
	private final MemberMapper memberMapper;
	// private final RedisService redisService;

	/**
	 * TEST
	 * @param memberVO
	 * @return
	 */
	public MemberVO selectMemberInfo(MemberVO memberVO) {
		System.out.println(":::: 회원 정보 조회 SVC 진입 ::::");
		MemberVO selectMemberInfo = memberMapper.selectMemberInfo();

		return selectMemberInfo;
	}
	
	/**
	 * 로그인한 회원 정보를 조회하는 기능
	 * @param memberVO
	 * @return
	 */
	public MemberVO selectLoginMemberInfo(MemberVO memberVO) {
		System.out.println(":::: 로그인 회원 정보 조회 SVC 진입 ::::");
		MemberVO selectLoginMemberInfo = memberMapper.selectLoginMemberInfo(memberVO);

		return selectLoginMemberInfo;
	}

}
