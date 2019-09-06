package kr.or.ddit.user.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.user.vo.UserVO;

public interface IUserDao {
	/**
	* Method : login
	* 작성자 : PC-21
	* 변경이력 :
	* @param sqlSession
	* @param userVo
	* @return
	* Method 설명 : 로그인
	*/
	public UserVO login(SqlSession sqlSession, UserVO userVo); 
}
