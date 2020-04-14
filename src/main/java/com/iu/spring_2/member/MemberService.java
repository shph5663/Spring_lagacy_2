package com.iu.spring_2.member;

public class MemberService {
	
	private MemberDAO memberDAO;
	
	public MemberService() {
		memberDAO = new MemberDAO();
	}
	
	public int memberJoin(MemberVO memberVO)throws Exception{
		return memberDAO.memberJoin(memberVO);
	}
	
	public MemberVO memberLogin(MemberVO memberVO) throws Exception {
		return memberDAO.memberLogin(memberVO);
	}
	
	public int memberDelete(MemberVO memberVO) throws Exception {
		return memberDAO.memberDelete(memberVO);
	}
	
	public int memberUpdate(MemberVO memberVO) throws Exception {
		return memberDAO.memberUpdate(memberVO);
	}

}
