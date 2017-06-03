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
	
/*	â�� ������ �ϴ� SQL ���� ���丮 ������ DB ����
	try �κп� sqlmapConfig�� ��Ʈ��Ʈ��*/
	
	private static SqlSessionFactory sqlMapper;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("/sqlmapConfig.xml");		// reader�� mybatis ������ sqlmapConfig.xml ���� �б�
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);								// ���丮 ������ ����ִ� sqlMapper�� build(reader)�� ����
		} catch (IOException err) {
			throw new RuntimeException("SQL�������丮 �ν��Ͻ� ���� ����" + err, err);
		}
	}
	
	public static List<BoardDto> boardList(String keyfield, String keyword) {
		List<BoardDto> list = null;														// list �ʱ�ȭ
		SqlSession session = sqlMapper.openSession();									// SQL���� �����ϴ� �޼ҵ� ���� (connection.close����)
		if (keyfield != null && keyword != null && keyfield != "" && keyword != "") {	// null ���̳� ������ ���ٸ� (��, �����Ͱ� �ִٸ�)
			Map<String, String> map = new HashMap<String, String>();	
			map.put("keyfield", keyfield);												// map�� key�� value ���� ��ü�� ��¡
			map.put("keyword", keyword);												// map�� ����ϴ� ������ Ư�� ������ �ٸ� ���� ã�� �� ����ϸ� �����ϱ� ����
			list = session.selectList("boardSearch", map);								// �˻��� �ϱ� ���� list�� select 
			session.close();															// session close
			return list;																// ������ ��� list�� ����
		}else {
			list = session.selectList("boardList");										// null ���̳� ������ ������ "boardList"�� �׳� ����ϴ� ������ list�� ����
			session.close();
			return list;
		}
	}
	
	public static BoardDto findBySeq(int seq) {
		SqlSession session = sqlMapper.openSession();					// SQL���� �����ϴ� �޼ҵ带 ����
		BoardDto board = session.selectOne("findBySeq", seq);			// BoardDto�� ������ findBySeq�� seq�� ���� ������ ���� �ϳ��� ��� board�� ����
		session.close();												// session close
		return board;													// ������ ��� board�� ����
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
		session.commit();										// session�� �⺻�� �ڵ����� commit�� ���� �ʱ� ������ commit�� �Ѵ�
		session.close();										// (select���� commit�� �ʿ� ���� ������ select������ commit�� ������� �ʴ´�
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















