package pack.model;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.BoardBean;

@Repository
public class BoardDaoImpl extends SqlSessionDaoSupport implements BoardDaoInter {
	@Autowired
	public void setFactory(SqlSessionFactory factory) {
		setSqlSessionFactory(factory);
	}
	
	@Override
	public ArrayList<BoardDto> getList() {
		return (ArrayList)getSqlSession().selectList("selectList");
	}
	
	@Override
	public int totalCnt() {
		return getSqlSession().selectOne("selectCnt");
	}
	
	@Override
	public boolean insert(BoardBean bean) {
		int re = getSqlSession().insert("insertData", bean);
		
		if(re > 0) return true;
		else return false;
	}
	
	@Override
	public int currentNum() {
		if(getSqlSession().selectOne("currentNum") == null) return 0;
		return getSqlSession().selectOne("currentNum");
	}
	
	@Override
	public ArrayList<BoardDto> getSearch(BoardBean bean) {
		// 검색용
		return (ArrayList)getSqlSession().selectList("searchList", bean);
	}
	
	@Override
	public boolean updateReadCnt(String num) {
		// 상세보기 시 조회 수 증가
		int re = getSqlSession().update("updateReadCnt", num);
		
		if(re > 0) return true;
		else return false;
	}
	
	@Override
	public BoardDto getDetail(String num) {
		return getSqlSession().selectOne("selectOne", num);
	}
	
	@Override
	public String selectPass(String num) {
		// 수정 시 비밀번호 비교
		return getSqlSession().selectOne("selectPass", num);
	}
	
	@Override
	public boolean update(BoardBean bean) {
		int re = getSqlSession().update("updateData", bean);
		
		if(re > 0) return true;
		else return false;
	}
	
	@Override
	public boolean delete(String num) {
	int re = getSqlSession().update("deleteData", num);
		
		if(re > 0) return true;
		else return false;
	}
	
	@Override
	public boolean updateOnum(BoardBean bean) {
		// 댓글용
		int re = getSqlSession().update("updateOnum", bean);

		if(re > 0) return true;
		else return false;
	}
	
	@Override
	public boolean insertReply(BoardBean bean) {
		int re = getSqlSession().insert("insertRedata", bean);

		if(re > 0) return true;
		else return false;
	}
}