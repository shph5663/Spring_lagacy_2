package com.iu.spring_2.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/member/**")
public class MemberController {
	
	private MemberService memberService;
	
	public  MemberController() {
		memberService = new MemberService();
	}
	
	
	@RequestMapping(value= "memberJoin")
	public void memberJoin(Model model) {
		String id = "test";
		//model.addAttribute("id", id);
		model.addAttribute(id);
	}
	
	@RequestMapping(value= "memberJoin", method = RequestMethod.POST)
	public void memberJoin2(MemberVO memberVO, HttpServletRequest request) {
		//memberVO의 멤버변수의 값으로 파라미터 값 넣기
		//출력
	}
	
	@RequestMapping(value= "memberLogin")
	public void memberLogin() {
		
	}
	
	@RequestMapping(value= "memberLogin", method = RequestMethod.POST)
	public MemberVO memberLogin2(HttpSession session, MemberVO memberVO) throws Exception{
		
		System.out.println("Member Login Post");
	    memberVO = memberService.memberLogin(memberVO);

		//로그인 성공시 인덱스페이지
		//실패시 로그인 실패  alert에 띄우고 다시 로그인창
		if (memberVO != null) {
			session.setAttribute("member", memberVO);
			return "redirect:../";
		}else {
			session.setAttribute("result", "로그인실패");
			
			return memberVO;
		}
	}
	
	@RequestMapping(value= "memberPage")
	public void memberPage() {
		
	}
	
	@RequestMapping(value= "memberUpdate")
	public void memberUpdate() {
		
	}
	
	@RequestMapping(value= "memberUpdate", method = RequestMethod.POST)
	public void memberUpdate2() {
		System.out.println("Member Update Post");
	}
	
	@RequestMapping(value= "memberDelete")
	public void memberDelete() {
		System.out.println("Member Delete");
	}
	
}
