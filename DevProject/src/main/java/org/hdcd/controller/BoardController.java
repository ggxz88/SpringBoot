package org.hdcd.controller;

import org.hdcd.domain.Board;
import org.hdcd.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//클래스 레벨 요청 경로 지정
@RequestMapping("/board")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	//3. 컨트롤러 요청 매핑
	//경로 패턴 매핑
	/*
	//@RequestMapping의 value 속성에 요청 경로를 설정한다.
	//@RequestMapping(value = "/board/register")
	//하위 요청 경로 지정
	@RequestMapping("/register")
	public void registerForm() {
		logger.info("registerForm");
	}
	
	//속성이 하나일 때는 속성명을 생략할 수 있다.
	//@RequestMapping("/board/modify")
	//하위 요청 경로 지정
	@RequestMapping("/modify")
	public void modifyForm() {
		logger.info("modifyForm");
	}
	
	//속성이 하나일 때는 속성명을 생략할 수 있다.
	//@RequestMapping("/board/list")
	//하위 요청 경로 지정
	@RequestMapping("/list")	
	public void list() {
		logger.info("list");
	}
	
	@RequestMapping("/read/{boardNo}")	
	//파라미터 변수 : @PathVariable("boardNo") int boardNo
	public String read(@PathVariable("boardNo") int boardNo) {
		logger.info("read boardNo : " + boardNo);
		
		//경로가 변하므로 뷰 이름 지정
		return "board/read";
	}
	*/
	
	//Http 메서드 매핑
	/*
	// /register 경로에 GET 방식
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerForm() {
		logger.info("registerForm");
		
		return "success";
	}
	
	// /register 경로에 POST 방식
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register() {
		logger.info("register");
		
		return "success";
	}
	
	// /modify 경로에 GET 방식
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyForm() {
		logger.info("modifyForm");
		
		return "success";
	}
	
	// /modify 경로에 POST 방식
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify() {
		logger.info("modify");
		
		return "success";
	}
	
	// /remove 경로에 POST 방식
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove() {
		logger.info("remove");
		
		return "success";
	}
	
	// /list 경로에 GET 방식
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list() {
		logger.info("list");
		
		return "success";
	}
	*/
	
	//Params 매핑
	/*
	@RequestMapping(value = "/get", method = RequestMethod.GET, params="register")
	public String registerForm() {
		logger.info("registerForm");
		
		return "success";
	}
	
	@RequestMapping(value = "/post", method = RequestMethod.POST, params="register")
	public String register() {
		logger.info("register");
		
		return "success";
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET, params="modify")
	public String modifyForm() {
		logger.info("modifyForm");
		
		return "success";
	}
	
	@RequestMapping(value = "/post", method = RequestMethod.POST, params="modify")
	public String modify() {
		logger.info("modify");
		
		return "success";
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET, params="remove")
	public String removeForm() {
		logger.info("modifyForm");
		
		return "success";
	}
	
	
	@RequestMapping(value = "/post", method = RequestMethod.POST, params="remove")
	public String remove() {
		logger.info("remove");
		
		return "success";
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET, params="remove")
	public String list() {
		logger.info("list");
		
		return "success";
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET, params="read")
	public String read() {
		logger.info("read");
		
		return "board/read";
	}
	*/
	
	//Headers 매핑
	/*
	@RequestMapping(value = "/{boardNo}", method = RequestMethod.PUT)
	public ResponseEntity<String> modify(@PathVariable("boardNo") int boardNo, @RequestBody Board board) {
		logger.info("modify");
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		return entity;
	}
	
	@RequestMapping(value = "/{boardNo}", method = RequestMethod.PUT, headers = "X-HTTP-Method-Override=PUT")
	public ResponseEntity<String> modifyByHeader(@PathVariable("boardNo") int boardNo, @RequestBody Board board) {
		logger.info("modifyByHeader");
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		return entity;
	}
	*/
	
	//content Type 매핑
	/*
	//consumes 속성값을 지정하지 않으면 기본값인 "application/json" 미디어 타입으로 지정된다.
	@RequestMapping(value = "/{boardNo}", method = RequestMethod.POST)
	public ResponseEntity<String> modify(@PathVariable("boardNo") int boardNo, @RequestBody Board board) {
		logger.info("modify");
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		return entity;
	}
	
	//consumes 속성값에 "application/json" 미디어 타입을 지정한다.
	@RequestMapping(value = "/{boardNo}", method = RequestMethod.PUT, consumes = "application/json")
		public ResponseEntity<String> modifyByJson(@PathVariable("boardNo") int boardNo, @RequestBody Board board) {
		logger.info("modifyByJson");
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		return entity;
	}
	
	//consumes 속성값에 "application/xml" 미디어 타입을 지정한다.
	@RequestMapping(value = "/{boardNo}", method = RequestMethod.PUT, consumes = "application/xml")
		public ResponseEntity<String> modifyByXml(@PathVariable("boardNo") int boardNo, @RequestBody Board board) {
		logger.info("modifyByXml boardNo : " + boardNo);
		
		logger.info("modifyByXml board : " + board);
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		return entity;
	}
	*/
	
	//Accept 매핑
	/*
	//produces 속성값에 "apllication/xml" 미디어 타입을 지정한다.
	@RequestMapping(value = "/{boardNo}", method = RequestMethod.GET, produces = "application/xml")
	public ResponseEntity<Board> readToXml(@PathVariable("boardNo") int boardNo) {
		logger.info("readToXml");
		
		Board board = new Board();
		
		board.setTitle("제목");
		board.setContent("내용입니다.");
		board.setWriter("홍길동");
		board.setRegDate(new Date());
		
		ResponseEntity<Board> entity = new ResponseEntity<Board>(board, HttpStatus.OK);
		
		return entity;
	}
	
	//produces 속성값에 "apllication/json" 미디어 타입을 지정한다.
	@RequestMapping(value = "/{boardNo}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Board> readToJson(@PathVariable("boardNo") int boardNo) {
		logger.info("readToJson");
			
		Board board = new Board();
			
		board.setTitle("제목");
		board.setContent("내용입니다.");
		board.setWriter("홍길동");
		board.setRegDate(new Date());
			
		ResponseEntity<Board> entity = new ResponseEntity<Board>(board, HttpStatus.OK);
		
		return entity;
	}
	
	//produces 속성값을 지정하지 않으면 기본값인 "application/json" 미디어 타입으로 지정된다.
	@RequestMapping(value = "/{boardNo}", method = RequestMethod.GET)
	public ResponseEntity<Board> read(@PathVariable("boardNo") int boardNo) {
		logger.info("readToJson");
			
		Board board = new Board();
			
		board.setTitle("제목");
		board.setContent("내용입니다.");
		board.setWriter("홍길동");
		board.setRegDate(new Date());
				
		ResponseEntity<Board> entity = new ResponseEntity<Board>(board, HttpStatus.OK);
		
		return entity;
	}
	*/
	
	//11. 데이터베이스 연동
	//스프링 JDBC
	//JPA
	//12. Mybatis
	//Mapper 인터페이스
	//별칭 적용
	//_로 구분된 컬럼명 자동 매핑
	//동적 SQL
	
	//14. AOP
	
	//15 .트랜잭션
	
	@Autowired
	private BoardService service;
	/*
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(String title, Model model) throws Exception {
		Board board = new Board();
		board.setTitle(title);
		
		model.addAttribute("board", board);
		
		model.addAttribute("list", service.search(title));
		
		return "board/list";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerForm(Board board, Model model) throws Exception {
		logger.info("registerForm");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Board board, Model model) throws Exception {
		logger.info("register");
		
		service.register(board);
		
		model.addAttribute("msg", "등록이 완료되었습니다.");
		
		return "board/success";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) throws Exception {
		logger.info("list");
		
		model.addAttribute("list", service.list());
	}
	
	@RequestMapping(value = "read", method = RequestMethod.GET)
	public void read(@RequestParam("boardNo") int boardNo, Model model) throws Exception{
		logger.info("read");
		
		model.addAttribute(service.read(boardNo));
	}
	
	@RequestMapping(value = "remove", method = RequestMethod.POST)
	public String remove(@RequestParam("boardNo") int boardNo, Model model) throws Exception {
		logger.info("remove");
		
		service.remove(boardNo);
		
		model.addAttribute("msg", "삭제가 완료되었습니다.");
		
		return "board/success";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyForm(int boardNo, Model model) throws Exception {
		logger.info("modifyForm");
		
		model.addAttribute(service.read(boardNo));
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(Board board, Model model) throws Exception {
		logger.info("modify");
		
		service.modify(board);
		
		model.addAttribute("msg", "수정이 완료되었습니다.");
		
		return "board/success";
	}
	*/
	
	//16. 예외 처리
	//예외 상황
	/*
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(String title, Model model) throws Exception {
		Board board = new Board();
		board.setTitle(title);
		
		model.addAttribute("board", board);
		
		model.addAttribute("list", service.search(title));
		
		return "board/list";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerForm(Board board, Model model) throws Exception {
		logger.info("registerForm");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	//제목에 빈값을 입력하여 유효값 검증 예외 발생
	public String register(@Validated Board board, Model model) throws Exception {
		logger.info("register");
		
		service.register(board);
		
		model.addAttribute("msg", "등록이 완료되었습니다.");
		
		return "board/success";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) throws Exception {
		logger.info("list");
		
		model.addAttribute("list", service.list());
	}
	
	@RequestMapping(value = "read", method = RequestMethod.GET)
	public void read(int boardNo, Model model) throws Exception{
		logger.info("read");
		
		//게시판의 글이 존재하지 않으면 사용자가 정의한 예외를 발생시킨다.
		Board board = service.read(boardNo);
		
		model.addAttribute(board);
	}
	
	@RequestMapping(value = "remove", method = RequestMethod.POST)
	public String remove(@RequestParam("boardNo") int boardNo, Model model) throws Exception {
		logger.info("remove");
		
		//매필 파일에서 예외 발생
		service.remove(boardNo);
		
		model.addAttribute("msg", "삭제가 완료되었습니다.");
		
		return "board/success";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyForm(int boardNo, Model model) throws Exception {
		logger.info("modifyForm");
		
		model.addAttribute(service.read(boardNo));
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(Board board, Model model) throws Exception {
		logger.info("modify");
		
		service.modify(board);
		
		model.addAttribute("msg", "수정이 완료되었습니다.");
		
		return "board/success";
	}
	*/
	
	//입력값 검증 예외 처리
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(String title, Model model) throws Exception {
		Board board = new Board();
		board.setTitle(title);
		
		model.addAttribute("board", board);
		
		model.addAttribute("list", service.search(title));
		
		return "board/list";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerForm(Board board, Model model) throws Exception {
		logger.info("registerForm");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	//BindingResult에는 요청 데이터의 바인딩 에러와 검사 에러 정보가 저장된다.
	public String register(@Validated Board board, BindingResult result,  Model model) throws Exception {
		logger.info("register");
		
		if(result.hasErrors()) {
			return "board/register";
		}
		
		service.register(board);
		
		model.addAttribute("msg", "등록이 완료되었습니다.");
		
		return "board/success";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) throws Exception {
		logger.info("list");
		
		model.addAttribute("list", service.list());
	}
	
	@RequestMapping(value = "read", method = RequestMethod.GET)
	public void read(int boardNo, Model model) throws Exception{
		logger.info("read");
		
		//게시판의 글이 존재하지 않으면 사용자가 정의한 예외를 발생시킨다.
		Board board = service.read(boardNo);
		
		model.addAttribute(board);
	}
	
	@RequestMapping(value = "remove", method = RequestMethod.POST)
	public String remove(@RequestParam("boardNo") int boardNo, Model model) throws Exception {
		logger.info("remove");
		
		//매필 파일에서 예외 발생
		service.remove(boardNo);
		
		model.addAttribute("msg", "삭제가 완료되었습니다.");
		
		return "board/success";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyForm(int boardNo, Model model) throws Exception {
		logger.info("modifyForm");
		
		model.addAttribute(service.read(boardNo));
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(Board board, Model model) throws Exception {
		logger.info("modify");
		
		service.modify(board);
		
		model.addAttribute("msg", "수정이 완료되었습니다.");
		
		return "board/success";
	}
}