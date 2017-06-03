package board.dao;

import java.util.ArrayList;
import java.util.List;

import board.dto.BoardDto;
import board.mybatis.BoardManager;

public class BoardDaoImpl implements BoardDao {

	// ��� ���� ���� �������̵�
	@Override
	public List<BoardDto> boardList(String keyfield, String keyword) {
		List<BoardDto> result = new ArrayList<BoardDto>();
		System.out.println("2) BoardDaoImpl.java : ���������� ���� ����");
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
		BoardManager.readCount(seq);		// �� ���� ī��Ʈ �� ���� (��ȸ��)
		BoardDto result = BoardManager.findBySeq(seq);		// �������� �� �б�
		return result;
	}

	// �۾���� upPos�� insertBoard 2��
	public void upPos() {
		BoardManager.upPos();
		System.out.println("���� ���� pos 1 UP");
	}
	
	public void insertBoard(BoardDto board) {
		upPos();
		BoardManager.insertBoard(board);
	}
	// ----------------------------------------- �������

	// �Խñ� ����, ������ �ٷ� ���� ...... �۾���� void ó��
	public int updateBoard(BoardDto board, String pass) {
		return BoardManager.updateBoard(board, pass);
	}

	@Override
	public String deleteView(int seq) {
		String storPass = BoardManager.deleteView(seq);
		return storPass;
	}

	// �Խñ� ����, ������ �ٷ� ����
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
