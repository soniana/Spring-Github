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
	
	@RequestMapping(value="/boardWrite.action", method=RequestMethod.GET)		// GET�� ���� �ۼ��� ��
	public String writeView() {													// GET ����� ������ ������ �����ִ� �뵵��, ���� �� �� ���
		return "Board_Write";
	}
	
	@RequestMapping(value="/boardWrite.action", method=RequestMethod.POST)		// POST�� ���� �ۼ��ϰ� ����Ʈ�� �Ѿ ��
	public String insert(@ModelAttribute BoardDto dto) {						// POST ����� ������ ó���� �� ����ϴ� �뵵��, ���� ���� ���� �����͸� list.action���� ������ ���� ������� ���
		String content = dto.getContent();
		String content2 = content.replaceAll("\n", "<br/>");
		dto.setContent(content2);
		boardService.insertBoard(dto);
		
		return "redirect:boardList.action";
	}
	
}
