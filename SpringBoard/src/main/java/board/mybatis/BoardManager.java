package board.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.dto.BoardDto;

public class BoardManager {
	
/*	창구 역할을 하는 SQL 세션 팩토리 빌더로 DB 연결
	try 부분에 sqlmapConfig은 부트스트랩*/
	
	private static SqlSessionFactory sqlMapper;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("/sqlmapConfig.xml");		// reader로 mybatis 폴더의 sqlmapConfig.xml 파일 읽기
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);								// 팩토리 내용이 들어있는 sqlMapper를 build(reader)로 저장
		} catch (IOException err) {
			throw new RuntimeException("SQL세션팩토리 인스턴스 생성 실패" + err, err);
		}
	}
	
	public static List<BoardDto> boardList(String keyfield, String keyword) {
		List<BoardDto> list = null;														// list 초기화
		SqlSession session = sqlMapper.openSession();									// SQL문을 실행하는 메소드 제공 (connection.close까지)
		if (keyfield != null && keyword != null && keyfield != "" && keyword != "") {	// null 값이나 공백이 없다면 (즉, 데이터가 있다면)
			Map<String, String> map = new HashMap<String, String>();	
			map.put("keyfield", keyfield);												// map에 key와 value 값을 객체로 저징
			map.put("keyword", keyword);												// map을 사용하는 이유는 특정 값으로 다른 값을 찾을 때 사용하면 유용하기 때문
			list = session.selectList("boardSearch", map);								// 검색을 하기 위해 list를 select 
			session.close();															// session close
			return list;																// 정보가 담긴 list를 리턴
		}else {
			list = session.selectList("boardList");										// null 값이나 공백이 있으면 "boardList"를 그냥 출력하는 정보를 list로 리턴
			session.close();
			return list;
		}
	}
	
	public static BoardDto findBySeq(int seq) {
		SqlSession session = sqlMapper.openSession();					// SQL문을 실행하는 메소드를 제공
		BoardDto board = session.selectOne("findBySeq", seq);			// BoardDto의 정보중 findBySeq를 seq의 값에 저장한 것을 하나만 골라 board에 저장
		session.close();												// session close
		return board;													// 정보가 담긴 board를 리턴
	}
	
	public static String preView(int seq) {
		SqlSession session = sqlMapper.openSession();
		String content = session.selectOne("preView", seq);
		System.out.println(content);
		session.close();
		return content;
	}
	
	public static void readCount(int seq) {
		SqlSession session = sqlMapper.openSession();
		session.update("readCount", seq);
		session.commit();
		session.close();
	}
	
	public static void upPos() {
		SqlSession session = sqlMapper.openSession();
		session.update("upPos");
		session.commit();
		session.close();
	}
	
	public static void insertBoard(BoardDto board) {
		SqlSession session = sqlMapper.openSession();
		session.insert("insertBoard", board);
		session.commit();										// session의 기본은 자동으로 commit이 되지 않기 때문에 commit을 한다
		session.close();										// (select절은 commit이 필요 없기 때문에 select절에는 commit을 사용하지 않는다
	}
	
	public static int updateBoard(BoardDto board, String pass) {
		SqlSession session = sqlMapper.openSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("board", board);
		map.put("password", pass);
		int result = session.update("updateBoard", map);
		session.commit();
		session.close();
		return result;
	}
	
	public static int deleteBoard(int seq, String storPass) {
		SqlSession session = sqlMapper.openSession();
		Map map = new HashMap();
		System.out.println("seq : storPass = " + seq + ":" + storPass);
		map.put("seq", seq);
		map.put("storPass", storPass);
		int result = session.delete("deleteBoard", map);
		session.commit();
		session.close();
		return result;
	}
	
	public static String deleteView(int seq) {
		SqlSession session = sqlMapper.openSession();
		String storPass = session.selectOne("deleteView", seq);
		session.close();
		return storPass;
	}
	
	public static void replyBoard(BoardDto board) {
		SqlSession session = sqlMapper.openSession();
		session.insert("replyBoard", board);
		session.commit();
		session.close();
	}
	
	public static void replyUpPos(BoardDto board) {
		SqlSession session = sqlMapper.openSession();
		session.update("replyUpPos", board);
		session.commit();
		session.close();
	}
	
}















