package board.dao;

import java.util.ArrayList;
import java.util.List;

import board.dto.BoardDto;
import board.mybatis.BoardManager;

public class BoardDaoImpl implements BoardDao {

	// 상속 받은 것을 오버라이드
	@Override
	public List<BoardDto> boardList(String keyfield, String keyword) {
		List<BoardDto> result = new ArrayList<BoardDto>();
		System.out.println("2) BoardDaoImpl.java : 정상적으로 값이 들어옴");
		System.out.println("3) BoardDaoImpl.java : " + keyfield + "//" + keyword);
		result = BoardManager.boardList(keyfield, keyword);
		System.out.println(result.size());
		return result;
	}

	@Override
	public String preView(int seq) {
		String preContent = BoardManager.preView(seq);
		return preContent;
	}

	@Override
	public BoardDto findBySeq(int seq) {
		BoardDto result = BoardManager.findBySeq(seq);
		return result;
	}

	@Override
	public BoardDto viewContent(int seq) {
		BoardManager.readCount(seq);		// 글 보면 카운트 수 증가 (조회수)
		BoardDto result = BoardManager.findBySeq(seq);		// 실질적인 글 읽기
		return result;
	}

	// 글쓰기는 upPos와 insertBoard 2개
	public void upPos() {
		BoardManager.upPos();
		System.out.println("글을 쓰면 pos 1 UP");
	}
	
	public void insertBoard(BoardDto board) {
		upPos();
		BoardManager.insertBoard(board);
	}
	// ----------------------------------------- 여기까지

	// 게시글 수정, 삭제는 바로 리턴 ...... 글쓰기는 void 처리
	public int updateBoard(BoardDto board, String pass) {
		return BoardManager.updateBoard(board, pass);
	}

	@Override
	public String deleteView(int seq) {
		String storPass = BoardManager.deleteView(seq);
		return storPass;
	}

	// 게시글 수정, 삭제는 바로 리턴
	public int deleteBoard(int seq, String storPass) {
		return BoardManager.deleteBoard(seq, storPass);
	}

	@Override
	public void replyBoard(BoardDto board) {
		BoardManager.replyBoard(board);
	}

	@Override
	public void replyUpPos(BoardDto board) {
		BoardManager.replyUpPos(board);
	}

}
