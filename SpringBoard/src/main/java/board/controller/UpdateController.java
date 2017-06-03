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
																		// @ModelAttribute는 오브젝트나 dto의 프로퍼티에 담긴 파라미터를 한 번에 받기 위해 사용
																		// @RequestParam은 요청 파라미터를 메소드 파라미터에서 일대일로 받기 위해 사용
	@RequestMapping(value="/boardUpdate.action", method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute BoardDto board, @RequestParam String pass) {
																		// @ModelAttibute는 key값과 value값을 객체 형식으로 쓰기 위한 어노테이션
		ModelAndView view = new ModelAndView();
		int result = boardService.updateBoard(board, pass);
		if (result == 1) {
			System.out.println("수정 완료");
			view.setViewName("redirect:boardList.action");	
		}
		
		
		
/*		if(result == 1) {
			System.out.println("수정 완료");
			view.setViewName("redirect:boardList.action");
		}else {
			System.out.println("수정 실패 이유 : " + result);
			view.addObject("result", result);
			view.setViewName("redirect:boardUpdate.action?seq="+board.getSeq());
		} */
		
		return view;
	}
}
