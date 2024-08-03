package com.blog.nta.web.controller;

import java.time.LocalDateTime;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.nta.api.domain.member.MemberSvc;
import com.blog.nta.api.domain.member.MemberVO;
import com.blog.nta.common.Result;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

	final MemberSvc memberSvc;
	
	/**
	 * 회원가입 화면 진입
	 * @param model
	 * @return 
	 */
	@RequestMapping(value = "/joinView")
	public String joinView(Model model) {
		
		System.out.println(":::: [회원 서비스] 회원가입 화면 진입 ::::");
		
		return "/member/join";
	}
	
	/**
	 * 로그인 화면 진입
	 * @param model
	 * @return 
	 */
	@RequestMapping(value = "/loginView")
	public String loginView(Model model) {
		
		System.out.println(":::: [회원 서비스] 로그인 화면 진입 ::::");
		
		return "/member/login";
	}

	@ResponseBody
	@RequestMapping(value = "/v1/selectMemberInfo", method = { RequestMethod.GET })
	public Result<MemberVO> selectMemberInfo(HttpServletRequest request, HttpServletResponse response, MemberVO memberVO) {
		
		System.out.println(":::: [회원 서비스] 회원 정보 조회 CTR 진입 ::::");

		return Result.<MemberVO>builder().data(memberSvc.selectMemberInfo(memberVO)).build();
	}
	
	/**
	 * 로그인한 회원 정보 조회 
	 * @param email
	 * @param password
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/login", method = { RequestMethod.POST })
    public Result login(@RequestParam String email, 
    								        @RequestParam String password,
    								        HttpSession session) {
		
		long startTime = System.currentTimeMillis(); // 시작 시간 측정
		
		MemberVO memberReqVo = new MemberVO();
		memberReqVo.setEmail(email);
		memberReqVo.setPassword(password);
		
		System.out.println(":::: memberReqVo : "+memberReqVo+" ::::");
		
        MemberVO memberResVo = memberSvc.selectLoginMemberInfo(memberReqVo);
        
        System.out.println(":::: memberResVo : "+memberResVo+" ::::");
        
        try {
        	long elapsedTime = System.currentTimeMillis() - startTime; 
	        if (memberResVo != null && memberResVo.getPassword().equals(password)) {
	        	session.setAttribute("member", memberResVo);
	        	return Result.<MemberVO>builder().status(200)
		        																		 .message("Success 통신 성공")
		        																		 .elapsedTime(elapsedTime)
		        																		 .timestamp(LocalDateTime.now())
		        																		 .data(memberSvc.selectLoginMemberInfo(memberReqVo))
		        																		 .build();											
	        } 
	        
	        else {
	        	return Result.<MemberVO>builder().status(401)
						 .message("FAIL : 해당하는 사용자 이메일이 존재하지 않거나, 패스워드가 일치하지 않습니다.")
						 .elapsedTime(elapsedTime)
						 .timestamp(LocalDateTime.now())
						 .build();		
	        }
        }

        catch (NullPointerException ne) {
        	
        	long elapsedTime = System.currentTimeMillis() - startTime;
	        
        	ne.printStackTrace(System.out); // 스택 트레이스 출력
        	
        	 return Result.<Map<String, Map<String, Integer>>>builder().status(501)
					  .message("FAIL : 로그인 정보가 없습니다.")
		              .elapsedTime(elapsedTime)
		              .timestamp(LocalDateTime.now())
		              .build();
        } 
        
        catch (Exception e) {
        	long elapsedTime = System.currentTimeMillis() - startTime;
        	e.printStackTrace(System.out); 
        	return Result.<Map<String, Map<String, Integer>>>builder().status(500)
																																	  .message("FAIL : 무슨 에러인지 모르겠당")
																														              .elapsedTime(elapsedTime)
																														              .timestamp(LocalDateTime.now())
																														              .build();
        }
    }
	
	
	@RequestMapping(value = "/logout", method = { RequestMethod.GET })
    public String logout(HttpSession session) {
		System.out.println("로그아웃 진입");
		System.out.println("기존 session : "+session);
        session.invalidate(); // 세션 무효화
        
        System.out.println("이후 session : "+session);
        return "redirect:/"; // 로그아웃 후 메인 페이지로 리다이렉트
    }
    
}
