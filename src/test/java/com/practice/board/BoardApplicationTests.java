package com.practice.board;

import com.practice.board.entity.Board;
import com.practice.board.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureWebMvc
class BoardApplicationTests {

	@Autowired
	private BoardService boardService;

	@Test
	public void test(Board board) {
		for (int i = 1; i <= 100; i++) {
			board.setContent("테스트" + i);
			board.setTitle("테스트" + i);
			board.setId(i);
			boardService.write(board);
		}

	}

}
