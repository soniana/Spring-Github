package board.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.service.BoardService;

@Controller
public class DeleteController {
	
	@Resource(name="BoardService")
	private BoardService boardService;
	
	@RequestMapping(value="/boardDelete.action", method=RequestMethod.GET)
	public ModelAndView deleteView(@RequestParam int seq) {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("Board_Delete");
		
		String storPass = boardService.deleteView(seq);
		Map map = new HashMap();
		map.put("seq", seq);
		map.put("storPass", storPass);
		view.addAllObjects(map);
		
		return view;
	}
	
	// HashMap�� Map�������̽��� Map�� �Ӽ��� �������� �����ϸ� Hasing�� �˻������ ����ϱ� ������ ���� ���� �����͸� �˻��ϴµ� �־� �پ ������ ������ ���� 

	@RequestMapping(value="/boardDelete.action", method=RequestMethod.POST)
	public ModelAndView delete(@RequestParam int seq, @RequestParam String storPass) {
		
		ModelAndView view = new ModelAndView();
		int result = boardService.deleteBoard(seq, storPass);
		System.out.println("���� ó���� ������� : " + result);
		if(result == 1) {
			System.out.println("���� ����");
			view.setViewName("redirect:boardList.action");
		}else {
			System.out.println("���� ����");
			view.setViewName("redirect:boardDelete.action?seq=" + seq);
			view.addObject("result", result);
		}
		
		return view;
	}
	
}
