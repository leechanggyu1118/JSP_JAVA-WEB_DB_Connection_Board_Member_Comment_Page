package repository;

import java.util.List;

import domain.MemberVo;

public interface MemberDAO {

	int register(MemberVo mvo);

	MemberVo login(MemberVo mvo);

	int lastLogin(String id);

	List<MemberVo> list();

	int update(MemberVo mvo);

	int delete(String id);

}
