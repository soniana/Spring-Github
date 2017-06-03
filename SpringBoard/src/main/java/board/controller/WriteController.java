package board.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import board.dto.BoardDto;
import board.service.BoardService;

@Controller
public class WriteController {
	
	@Resource(name="BoardService")
	private BoardService boardService;
	
	@RequestMapping(value="/boardWrite.action", method=RequestMethod.GET)		// GET은 글을 작성할 때
	public String writeView() {													// GET 방식은 정보를 가져와 보여주는 용도로, 글을 쓸 때 사용
		return "Board_Write";
	}
	
	@RequestMapping(value="/boardWrite.action", method=RequestMethod.POST)		// POST는 글을 작성하고 리스트를 넘어갈 때
	public String insert(@ModelAttribute BoardDto dto) {						// POST 방식은 정보를 처리할 때 사용하는 용도로, 글을 쓰고 나서 데이터를 list.action으로 보내기 위한 방식으로 사용
		String content = dto.getContent();
		String content2 = content.replaceAll("\n", "<br/>");
		dto.setContent(content2);
		boardService.insertBoard(dto);
		
		return "redirect:boardList.action";
	}
	
}
