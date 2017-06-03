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
	
	// HashMap은 Map인터페이스로 Map의 속성과 저장방식이 동일하며 Hasing의 검색방법을 사용하기 때문에 많은 양의 데이터를 검색하는데 있어 뛰어난 성능을 가지고 있음 

	@RequestMapping(value="/boardDelete.action", method=RequestMethod.POST)
	public ModelAndView delete(@RequestParam int seq, @RequestParam String storPass) {
		
		ModelAndView view = new ModelAndView();
		int result = boardService.deleteBoard(seq, storPass);
		System.out.println("삭제 처리의 결과값은 : " + result);
		if(result == 1) {
			System.out.println("삭제 성공");
			view.setViewName("redirect:boardList.action");
		}else {
			System.out.println("삭제 실패");
			view.setViewName("redirect:boardDelete.action?seq=" + seq);
			view.addObject("result", result);
		}
		
		return view;
	}
	
}
