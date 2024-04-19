package service;

import java.util.List;

import domain.MemberVo;

public interface MemberService {

	int register(MemberVo mvo);

	MemberVo login(MemberVo mvo);

	int lastLogin(String id);

	List<MemberVo> getlist();

	int update(MemberVo mvo);

	int delete(String id);

}
