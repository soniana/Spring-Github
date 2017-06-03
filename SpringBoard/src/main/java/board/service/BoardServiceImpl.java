package board.service;

import java.util.List;

import javax.annotation.Resource;

import board.dao.BoardDao;
import board.dto.BoardDto;
import board.dto.PageDto;

public class BoardServiceImpl implements BoardService{

	@Resource(name="BoardDaoImpl")							// 어플리케이션에서 필요로 하는 자원을 자동연결하는 어노테이션
	private BoardDao boardDao;								// @Resource로 "boardDao"의 자원을 DI기능으로 의존성 주입
	
	@Override
	public List<BoardDto> boardList(String keyfield, String keyword) {
		System.out.println("1) BoardServiceImpl.java : BoardService.BoardList() 접속 성공");
		return boardDao.boardList(keyfield, keyword);
	}

	@Override
	public BoardDto findBySeq(int seq) {
		return boardDao.findBySeq(seq);
	}

	@Override
	public BoardDto viewContent(int seq) {
		return boardDao.viewContent(seq);
	}

	@Override
	public void insertBoard(BoardDto board) {
		boardDao.insertBoard(board);
	}

	@Override
	public int updateBoard(BoardDto board, String pass) {
		return boardDao.updateBoard(board, pass);
	}

	@Override
	public String deleteView(int seq) {
		return boardDao.deleteView(seq);
	}

	@Override
	public int deleteBoard(int seq, String storPass) {
		return boardDao.deleteBoard(seq, storPass);
	}

	@Override
	public void replyBoard(BoardDto board) {
		boardDao.replyBoard(board);
	}

	@Override
	public void replyUpPos(BoardDto board) {
		boardDao.replyUpPos(board);
	}

	@Override
	public PageDto pagingProc(int nowPage, int nowBlock, int totalRecord) {
		int numPerPage = 5;
		int pagePerBlock = 4;
		int totalPage = (int)Math.ceil((double)totalRecord / numPerPage);
		int beginPerPage = nowPage * numPerPage;
		int totalBlock = (int)Math.ceil((double)totalPage / pagePerBlock);
		
		PageDto page = new PageDto();
		
		page.setBeginPerPage(beginPerPage);
		page.setNowBlock(nowBlock);
		page.setNowPage(nowPage);
		page.setNumPerPage(numPerPage);
		page.setPagePerBlock(pagePerBlock);
		page.setTotalBlock(totalBlock);
		page.setTotalPage(totalPage);
		page.setTotalRecord(totalRecord);
		
		return page;
	}

	
}
