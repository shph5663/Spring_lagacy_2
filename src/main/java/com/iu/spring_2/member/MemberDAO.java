package com.iu.spring_2.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.iu.util.DBConnect;

public class MemberDAO {
	
	//update
	//5. Update
		public int memberUpdate(MemberVO memberVO) throws Exception{
			//1. db연결
			Connection con = DBConnect.getConnect();
			//2. sql문 작성
			String sql = "Update member set email=?,phone=?,age=? where id=?";
			//3. 미리전송
			PreparedStatement st = con.prepareStatement(sql);
			//4. ?값 있으면 세팅
			st.setString(1, memberVO.getEmail());
			st.setString(2, memberVO.getPhone());
			st.setInt(3, memberVO.getAge());
			st.setString(4, memberVO.getId());

			//5. 최종 전송후 결과 처리
			int result = st.executeUpdate();
					
			//6. 자원 해제
						
			st.close();
			con.close();
							
			return result;
		}
	
	//delete
	
	public int memberDelete(MemberVO memberVO) throws Exception{
		
		//1. db연결
		Connection con = DBConnect.getConnect();
		//2. sql문 작성
		String sql = "delete member where id = ?";
		//3. 미리전송
		PreparedStatement st = con.prepareStatement(sql);
		//4. ?값 있으면 세팅
		st.setString(1, memberVO.getId());
		//5. 최종 전송후 결과 처리
		int result = st.executeUpdate();
				
		st.close();
		con.close();
				
		return result;
	}
	
	public int memberJoin(MemberVO memberVO)throws Exception{
		int result=0;
		Connection con = DBConnect.getConnect();
		
		String sql ="insert into member values (?,?,?,?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, memberVO.getId());
		st.setString(2, memberVO.getPw());
		st.setString(3, memberVO.getName());
		st.setString(4, memberVO.getEmail());
		st.setString(5, memberVO.getPhone());
		st.setInt(6, memberVO.getAge());
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
		
	}
	
	public MemberVO memberLogin(MemberVO memberVO) throws Exception{
		//1. db연결
		Connection con = DBConnect.getConnect();
		//2. sql문 작성
		String sql = "select * from member where id=? and pw=?";
		//3. 미리전송
		PreparedStatement st = con.prepareStatement(sql);
		//4. ?값 있으면 세팅
		st.setString(1, memberVO.getId());
		st.setString(2, memberVO.getPw());
		//5. 최종 전송후 결과 처리
		ResultSet rs = st.executeQuery();
		
		if (rs.next()) {
			memberVO.setName(rs.getString("name"));
			memberVO.setEmail(rs.getString("email"));
			memberVO.setPhone(rs.getString("phone"));
			memberVO.setAge(rs.getInt("age"));
		}else {
			memberVO = null;
		}
		//6. 자원 해제
		rs.close();
		st.close();
		con.close();
		
		return memberVO;
	}
	
//	public MemberDTO memberPage() throws Exception{
		//1. db연결
//				Connection con = DBConnect.getConnect();
//				//2. sql문 작성
//				String sql = "select * from member where id=? and pw=?";
//				//3. 미리전송
//				PreparedStatement st = con.prepareStatement(sql);
//				//4. ?값 있으면 세팅
//				st.setString(1, memberDTO.getId());
//				st.setString(2, memberDTO.getPw());
//				//5. 최종 전송후 결과 처리
//				ResultSet rs = st.executeQuery();
//		
//	}

}
