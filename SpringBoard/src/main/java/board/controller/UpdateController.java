package board.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.dto.BoardDto;
import board.service.BoardService;

@Controller
public class UpdateController {
	
	@Resource(name="BoardService")
	private BoardService boardService;
	
	@RequestMapping(value="/boardUpdate.action", method=RequestMethod.GET)
	public ModelAndView updateView(@RequestParam int seq) {
		
		ModelAndView view = new ModelAndView();
		System.out.println(seq);
		BoardDto dto = boardService.findBySeq(seq);
		view.addObject("dto", dto);
		view.setViewName("Board_Update");
		
		return view;
	}
																		// @ModelAttribute�� ������Ʈ�� dto�� ������Ƽ�� ��� �Ķ���͸� �� ���� �ޱ� ���� ���
																		// @RequestParam�� ��û �Ķ���͸� �޼ҵ� �Ķ���Ϳ��� �ϴ��Ϸ� �ޱ� ���� ���
	@RequestMapping(value="/boardUpdate.action", method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute BoardDto board, @RequestParam String pass) {
																		// @ModelAttibute�� key���� value���� ��ü �������� ���� ���� ������̼�
		ModelAndView view = new ModelAndView();
		int result = boardService.updateBoard(board, pass);
		if (result == 1) {
			System.out.println("���� �Ϸ�");
			view.setViewName("redirect:boardList.action");	
		}
		
		
		
/*		if(result == 1) {
			System.out.println("���� �Ϸ�");
			view.setViewName("redirect:boardList.action");
		}else {
			System.out.println("���� ���� ���� : " + result);
			view.addObject("result", result);
			view.setViewName("redirect:boardUpdate.action?seq="+board.getSeq());
		} */
		
		return view;
	}
}
