package board.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.dao.BoardDaoImpl;
import board.dto.BoardDto;
import board.dto.PageDto;
import board.service.BoardService;

@Controller
public class ListController {
	
	@Resource(name="BoardService")					// BoardServiceImpl.java����� �� BoardService.java�� �ڵ�����
	private BoardService boardService;
	
	//���� ������ �� �Ǵ��� �׽�Ʈ�ϴ� �ڵ�
	public void setBoardService (BoardService boardService) {
		System.out.println(boardService + " ���� ���� Ȯ��");
		this.boardService = boardService;
	}
	
	@RequestMapping(value="/boardList.action")		// ��Ʈ�ѷ��� ó���� ��û URL (value="/boardList.action") ���
	public ModelAndView list(@RequestParam(required=false) Integer nowPage, @RequestParam(required=false)Integer nowBlock, @RequestParam(required=false) String keyField, @RequestParam(required=false) String keyWord) {
		
		ModelAndView view = new ModelAndView();
		List<BoardDto> list = boardService.boardList(keyField, keyWord);
		PageDto page = null;
		try {
			page = boardService.pagingProc(nowPage, nowBlock, list.size());
		} catch(Exception err) {
			System.out.println("now �������� now ���� �������� �ʾ� 0�� ����");
			System.out.println("���� ���� : " + err);
			page = boardService.pagingProc(0, 0, list.size());
		}
		view.addObject("dao", new BoardDaoImpl());		// ȭ�鿡 ǥ�õ� jsp ���Ͽ��� �Ѱ��� ���� addObject �޼ҵ�� ����
		view.addObject("list", list);
		view.addObject("page", page);
		view.addObject("keyWord", keyWord);
		view.addObject("keyField", keyField);
		view.setViewName("Board_List");					// jsp ������ ����
		
		return view;
	}
}
