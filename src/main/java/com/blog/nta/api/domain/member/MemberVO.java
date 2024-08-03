package com.blog.nta.api.domain.member;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Alias("memberVO")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberVO {
	
	/* 페이징 */
	// 나중에 공통 VO 생성
	private int pageNo;
	private int pageSize;
	
	/* 회원번호 */
	private int memberId;
	/* 패스워드 */
	private String password;
	/* 회원구분 */
	private String memberCd;
	/* 가입구분 */
	private String joinCd;
	/* SNS ID */
	private String snsId;
	/* 회원 ID(E-Mail) */
	private String email;
	/* 회원 명 */
	private String nm;
	/* 생년월일 */
	private String birth;
	/* 연결정보 */
	private String ci;
	/* 중복정보 */
	private String di;
	/* 개인정보 수집 동의 여부 */
	private String psnlYn;
	/* 개인정보 3자 위탁 동의 여부  */
	private String psnlConsignYn;
	/* 개인정보 입력 풀 저장 동의 여부 */
	private String pnslFullAgrYn;

}
