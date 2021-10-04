package com.spring.test.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.test.member.vo.MemberVO;
import com.spring.test.member.dao.MemberDAO;
import com.spring.test.member.hash.Hash;
@Service("memberService")
@Transactional(propagation = Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public List listMembers() throws DataAccessException {
		List membersList = null;
		membersList = memberDAO.selectAllMemberList();
		return membersList;
	}
	
	@Override
	public int addMember(MemberVO member) throws DataAccessException {
		System.out.println("MemberServiceImpl : addMember start");

		try {
			Hash hash = new Hash();
			
			member.setMember_salt(hash.getSALT());
			System.out.println(member.getMember_salt());
			
			String hash_pwd = hash.Hashing(member.getMember_pwd().getBytes(), member.getMember_salt());
			
			System.out.println("hash_pwd : " + hash_pwd);
			member.setMember_pwd(hash_pwd);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("MemberServiceImpl : addMember end");
		return memberDAO.insertMember(member);
	}
	@Override
	public int removeMember(String member_id) throws DataAccessException {
		System.out.println("removeMemberstart");
		return memberDAO.deleteMember(member_id);
	}
	@Override
	public MemberVO login(MemberVO member) throws Exception{
		System.out.println("MemberServiceImpl : login start");
		
		try {
			Hash hash = new Hash();
			
			String salt = memberDAO.selectSaltById(member.getMember_id());
			System.out.println("salt : " + salt);
			
			String hash_pwd = hash.Hashing(member.getMember_pwd().getBytes(), salt);
			
			System.out.println("hash_pwd : " + hash_pwd);
			member.setMember_pwd(hash_pwd);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("MemberServiceImpl : login end");
		return memberDAO.loginById(member);
	}

	@Override
	public int updateMember(MemberVO vo) throws Exception {
		return memberDAO.updateMember(vo);
		
	}

	@Override
	public int selectById(String member_id) throws DataAccessException {
		System.out.println("MemberServiceImpl : selectById start");
		return memberDAO.selectById(member_id);
	}

}
