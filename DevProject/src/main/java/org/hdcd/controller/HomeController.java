package org.hdcd.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.hdcd.domain.Address;
import org.hdcd.domain.Card;
import org.hdcd.domain.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//@RestController //@RestController : Spring MVC Controller에 @ResponseBody가 추가된 것. 당연하게도 RestController의 주 용도는 Json 형태로 객체 데이터를 반환하는 것
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/*
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
				
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate);
		
		return "home";
	}
	
	@RequestMapping(value = "/formHome", method = RequestMethod.GET)
	public String formHome() {
		return "formHome";
	}
	*/
	
	//3. 컨트롤러 요청 매핑
	//Headers 매핑
	//Content Type 매핑
	//Accept 매핑
	/*
	@RequestMapping(value = "/ajaxHome", method = RequestMethod.GET)
	public String ajaxHome() {
		return "ajaxHome";
	}
	*/
	
	//4. 컨트롤러 응답
	/*
	//void 타입
	@RequestMapping(value = "/goHome0101", method = RequestMethod.GET)
	public void home0101() {
		logger.info("home0101");
	}
	
	@RequestMapping(value = "/sub/goHome0102", method = RequestMethod.GET)
	public void home0102() {
		logger.info("home0102");
	}
	
	//String 타입
	@RequestMapping(value = "/goHome0201", method = RequestMethod.GET)
	public String home0201() {
		logger.info("home0201");
		
		return "home0201";
	}
	
	@RequestMapping(value = "/sub/goHome0202", method = RequestMethod.GET)
	public String home0202() {
		logger.info("home0202");
		
		return "home0202";
	}
	
	@RequestMapping(value = "/sub/goHome0203", method = RequestMethod.GET)
	public String home0203() {
		logger.info("home0203");
		
		return "home0203";
	}
	
	@RequestMapping(value = "/goHome0204", method = RequestMethod.GET)
	public String home0204() {
		logger.info("home0204");
		
		return "redirect:/sub/gohome0204";
	}
	
	@RequestMapping(value = "/sub/goHome0205", method = RequestMethod.GET)
	public String home0205() {
		logger.info("home0205");
		
		return "home0205";
	}
	
	//자바빈즈 클래스 타입
	@ResponseBody //@ResponseBody나 @RestController를 지정하지 않으면 에러 발생
	@RequestMapping(value = "/goHome0301", method = RequestMethod.GET)
	public Member home0301() {
		logger.info("home0301");
		
		Member member = new Member(); 
		
		return member;
	}
	
	//컬렉션 List 타입
	@ResponseBody 
	@RequestMapping(value = "/goHome04", method = RequestMethod.GET)
	public List<Member> home04() {
		logger.info("home04");
		
		List<Member> list = new ArrayList<Member>();
		
		Member member = new Member(); 
		list.add(member);
		
		Member member2 = new Member(); 
		list.add(member2);
		
		return list;
	}
	
	//컬렉션 Map 타입
	@ResponseBody 
	@RequestMapping(value = "/goHome05", method = RequestMethod.GET)
	public Map<String, Member> home05() {
		logger.info("home05");
		
		Map<String, Member> map = new HashMap<String, Member>();
		
		Member member = new Member(); 
		map.put("key1", member);
		
		Member member2 = new Member(); 
		map.put("key2", member2);
		
		return map;
	}
	
	//ResponseEntity<Void> 타입
	//ResponseEntity는 @ResponseBody 어노테이션과 같은 의미로, ResponseEntity를 return Type으로 지정하면 JSON (default) 또는 Xml Format으로 결과를 내려준다.
	@ResponseBody 
	@RequestMapping(value = "/goHome06", method = RequestMethod.GET)
	public ResponseEntity<Void> home06() {
		logger.info("home06");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	//ResponseEntity<String> 타입
	@ResponseBody 
	@RequestMapping(value = "/goHome07", method = RequestMethod.GET)
	public ResponseEntity<String> home07() {
		logger.info("home07");
		
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}
	
	//ResponseEntity<자바빈즈 클래스> 타입
	@ResponseBody 
	@RequestMapping(value = "/goHome08", method = RequestMethod.GET)
	public ResponseEntity<Member> home08() {
		logger.info("home08");
		
		Member member = new Member();
		
		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}
		
	//ResponseEntity<List> 타입
	@ResponseBody 
	@RequestMapping(value = "/goHome09", method = RequestMethod.GET)
	public ResponseEntity<List<Member>> home09() {
		logger.info("home09");
		
		List<Member> list = new ArrayList<Member>();
		
		Member member = new Member(); 
		list.add(member);
		
		Member member2 = new Member(); 
		list.add(member2);
		
		return new ResponseEntity<List<Member>>(list, HttpStatus.OK);
	}
	
	//ResponseEntity<Map> 타입
	@ResponseBody 
	@RequestMapping(value = "/goHome10", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Member>> home10() {
		logger.info("home10");
		
		Map<String, Member> map = new HashMap<String, Member>();
		
		Member member = new Member(); 
		map.put("key1", member);
		
		Member member2 = new Member(); 
		map.put("key2", member2);
		
		return new ResponseEntity<Map<String, Member>>(map, HttpStatus.OK);
	}
	
	//ResponseEntity<byte[]> 타입
	@ResponseBody 
	@RequestMapping(value = "/goHome1101", method = RequestMethod.GET)
	public ResponseEntity<byte[]> home1101() throws Exception{
		logger.info("home1101");
				
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		try {
			HttpHeaders headers = new HttpHeaders();
			
			in = new FileInputStream("C:\\TEMP\\sample.jpg");
			
			headers.setContentType(MediaType.IMAGE_PNG);
			
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		return entity;
	}
	
	@ResponseBody 
	@RequestMapping(value = "/goHome1101", method = RequestMethod.GET)
	public ResponseEntity<byte[]> home1102() throws Exception{
		logger.info("home1102");
		
		String fileName = "aa.zip";
		
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		try {
			HttpHeaders headers = new HttpHeaders();
			
			in = new FileInputStream("C:\\TEMP\\" + fileName);
			
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.add("Content-Disposition", "attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
			
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		return entity;
	}
	*/
	
	//5. 컨트롤러 요청 처리
	//Ajax 방식 요청 처리
	//파일업로드 Ajax 방식 요청 처리
	/*
	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public String registerForm() {
		logger.info("registerForm");
		
		return "registerForm";
	}
	*/
	
	//7. 타임리프
	//타임리프 소개
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		model.addAttribute("msg", "Hello world!");
		
		return "home";
	}
	
	//텍스트 사용
	/*
	@RequestMapping(value = "/home0101", method = RequestMethod.GET)
	public String home0101(Model model) {
		
		model.addAttribute("msg", "<b>Hello world!<b>");
		
		return "home0101";
	}
	
	@RequestMapping(value = "/home0102", method = RequestMethod.GET)
	public String home0102(Model model) {
		
		model.addAttribute("msg", "<b>Hello world!<b>");
		
		return "home0102";
	}
	*/
	
	//표현식
	/*
	@RequestMapping(value = "/home0101", method = RequestMethod.GET)
	public String home0101() {
		logger.info("home0101");

		return "home0101";
	}
	
	@RequestMapping(value = "/home0201", method = RequestMethod.GET)
	public String home0201(Model model) {
		logger.info("home0201");

		model.addAttribute("msg", "Hello world!");
		
		return "home0201";
	}
	
	@RequestMapping(value = "/home0202", method = RequestMethod.GET)
	public String home0202(Model model) {
		logger.info("home0202");
		
		Member member = new Member();
		
		member.setUserId("hongkd");
		member.setPassword("1234");
		member.setEmail("aaa@ccc.com");
		member.setUserName("홍길동");
		member.setBirthDay("1989-09-07");
			
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1988);
		cal.set(Calendar.MONTH, 10);
		cal.set(Calendar.DAY_OF_MONTH, 7);
		
		member.setDateOfBirth(cal.getTime());
		
		model.addAttribute(member);

		return "home0202";
	}
	
	@RequestMapping(value = "/home0203", method = RequestMethod.GET)
	public String home0203(Model model) {
		logger.info("home0203");
		
		Member member = new Member();
		
		Address address = new Address();
		address.setPostCode("080908");
		address.setLocation("seoul");
		
		member.setAddress(address);
		
		model.addAttribute(member);

		return "home0203";
	}
	
	@RequestMapping(value = "/home0301", method = RequestMethod.GET)
	public String home0301(Model model) {
		logger.info("home0301");
		
		Member member = new Member();
		
		member.setUserId("hongkd");
		member.setPassword("1234");
		member.setEmail("aaa@ccc.com");
		member.setUserName("홍길동");
		member.setBirthDay("1989-09-07");
			
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1988);
		cal.set(Calendar.MONTH, 10);
		cal.set(Calendar.DAY_OF_MONTH, 7);
		
		member.setDateOfBirth(cal.getTime());
		
		model.addAttribute(member);

		return "home0301";
	}
	
	@RequestMapping(value = "/home0302", method = RequestMethod.GET)
	public String home0302(Model model) {
		logger.info("home0302");
		
		Member member = new Member();
		
		member.setUserId("hongkd");
		member.setPassword("1234");
		member.setEmail("aaa@ccc.com");
		member.setUserName("홍길동");
		member.setBirthDay("1989-09-07");
			
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1988);
		cal.set(Calendar.MONTH, 10);
		cal.set(Calendar.DAY_OF_MONTH, 7);
		
		member.setDateOfBirth(cal.getTime());
		
		model.addAttribute(member);

		return "home0302";
	}
	
	@RequestMapping(value = "/home0401", method = RequestMethod.GET)
	public String home0401() {
		logger.info("home0401");

		return "home0401";
	}
	
	@RequestMapping(value = "/home0402", method = RequestMethod.GET)
	public String home0402() {
		logger.info("home0402");

		return "home0402";
	}
	
	
	@RequestMapping(value = "/home0403", method = RequestMethod.GET)
	public String home0403() {
		logger.info("home0403");

		return "home0403";
	}
	
	@RequestMapping(value = "/home0501", method = RequestMethod.GET)
	public String home0501() {
		logger.info("home0501");

		return "home0501";
	}
	
	@RequestMapping(value = "/home0601", method = RequestMethod.GET)
	public String home0601(Locale locale, Model model) {
		logger.info("home0601");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
				
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate);
		
		return "home0601";
	}
	
	@RequestMapping(value = "/home0701", method = RequestMethod.GET)
	public String home0701(Locale locale, Model model) {
		logger.info("home0701");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
				
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate);
		
		return "home0701";
	}
	*/
	
	//속성 값 설정
	/*
	@RequestMapping(value = "/home0101", method = RequestMethod.GET)
	public String home0101() {
		logger.info("home0101");

		return "home0101";
	}
	
	@RequestMapping(value = "/home0201", method = RequestMethod.GET)
	public String home0201() {
		logger.info("home0201");

		return "home0201";
	}
	
	@RequestMapping(value = "/home0301", method = RequestMethod.GET)
	public String home0301() {
		logger.info("home0301");

		return "home0301";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Model model) throws Exception {
		logger.info("msg", "등록이 완료되었습니다.");

		return "success";
	}
	*/
	
	//제어 속성
	/*
	@RequestMapping(value = "/home0101", method = RequestMethod.GET)
	public String home0101(Model model) {
		logger.info("home0101");
		
		Member member = new Member();

		model.addAttribute(member);
		
		return "home0101";
	}
	
	@RequestMapping(value = "/home0102", method = RequestMethod.GET)
	public String home0102(Model model) {
		logger.info("home0102");
		
		Member member = new Member();
		member.setForeigner(true);

		model.addAttribute(member);
		
		return "home0102";
	}
	
	@RequestMapping(value = "/home0103", method = RequestMethod.GET)
	public String home0103(Model model) {
		logger.info("home0103");
		
		Member member = new Member();
		member.setForeigner(false);

		model.addAttribute(member);
		
		return "home0103";
	}
	
	@RequestMapping(value = "/home0201", method = RequestMethod.GET)
	public String home0201(Model model) {
		logger.info("home0201");
		
		Member member = new Member();

		model.addAttribute(member);
		
		return "home0201";
	}
	
	@RequestMapping(value = "/home0202", method = RequestMethod.GET)
	public String home0202(Model model) {
		logger.info("home0202");
		
		Member member = new Member();
		member.setGender("F");

		model.addAttribute(member);
		
		return "home0201";
	}
	
	@RequestMapping(value = "/home0203", method = RequestMethod.GET)
	public String home0203(Model model) {
		logger.info("home0203");
		
		Member member = new Member();
		member.setGender("M");

		model.addAttribute(member);
		
		return "home0201";
	}
	
	@RequestMapping(value = "/home0301", method = RequestMethod.GET)
	public String home0301(Model model) {
		logger.info("home0301");
		
		Member member = new Member();
		
		String[] hobbyArray = {"Music", "Movie"};
		
		member.setHobbyArray(hobbyArray);

		model.addAttribute(member);
		
		return "home0301";
	}
	
	@RequestMapping(value = "/home0302", method = RequestMethod.GET)
	public String home0302(Model model) {
		logger.info("home0302");
		
		Member member = new Member();
		
		List<String> hobbyList = new ArrayList<String>();
		hobbyList.add("Music");
		hobbyList.add("Movie");
		
		member.setHobbyList(hobbyList);

		model.addAttribute(member);
		
		return "home0302";
	}
	
	@RequestMapping(value = "/home0303", method = RequestMethod.GET)
	public String home0303(Model model) {
		logger.info("home0303");
		
		Member member = new Member();
		
		List<Card> cardList = new ArrayList<Card>();
		
		Card card1 = new Card();
		card1.setNo("123456");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2020);
		cal.set(Calendar.MONTH, 9);
		cal.set(Calendar.DAY_OF_MONTH, 8);
		
		card1.setValidMonth(cal.getTime());
		
		cardList.add(card1);
		
		Card card2 = new Card();
		card2.setNo("456789");
		
		cal.set(Calendar.YEAR, 2022);
		cal.set(Calendar.MONTH, 11);
		cal.set(Calendar.DAY_OF_MONTH, 7);
		
		card2.setValidMonth(cal.getTime());
		
		cardList.add(card2);
		
		member.setCardList(cardList);
		
		model.addAttribute("user", member);
		
		return "read05";
	}
	
	@RequestMapping(value = "/home0401", method = RequestMethod.GET)
	public String home0401(Model model) {
		logger.info("home0401");
		
		Member member = new Member();
		
		member.setUserId("hongkd");

		model.addAttribute(member);
		
		return "home0401";
	}
	
	@RequestMapping(value = "/home0402", method = RequestMethod.GET)
	public String home0402(Model model) {
		logger.info("home0402");
		
		Member member = new Member();
		
		member.setUserId("hongkd");

		model.addAttribute(member);
		
		return "home0402";
	}
	*/
	
	//인라인
	/*
	@RequestMapping(value = "/home0101", method = RequestMethod.GET)
	public String home0101(Model model) {
		logger.info("home0101");
		
		model.addAttribute("username", "Sebastian");
		
		return "home0101";
	}
	
	@RequestMapping(value = "/home0102", method = RequestMethod.GET)
	public String home0102(Model model) {
		logger.info("home0102");
		
		model.addAttribute("username", "<b>Sebastian<b>");
		
		return "home0102";
	}
	
	@RequestMapping(value = "/home0201", method = RequestMethod.GET)
	public String home0201(Model model) {
		logger.info("home0201");
		
		model.addAttribute("username", "<b>Sebastian<b>");
		
		return "home0201";
	}
	
	@RequestMapping(value = "/home0301", method = RequestMethod.GET)
	public String home0301(Model model) {
		logger.info("home0301");
		
		model.addAttribute("username", "Sebastian");
		
		return "home0301";
	}
	
	@RequestMapping(value = "/home0401", method = RequestMethod.GET)
	public String home0401(Model model) {
		logger.info("home0401");
		
		model.addAttribute("username", "Sebastian");
		
		return "home0401";
	}
	*/
	
	//주석
	//템플릿 프래그먼트
	//레이아웃 재사용
	/*
	@RequestMapping(value = "/home0101", method = RequestMethod.GET)
	public String home0101(Model model) {
		logger.info("home0101");
		
		model.addAttribute("msg", "Hello world!");
		
		return "home0101";
	}
	
	
	@RequestMapping(value = "/home0201", method = RequestMethod.GET)
	public String home0201(Model model) {
		logger.info("home0201");
		
		model.addAttribute("msg", "Hello world!");
		
		return "home0201";
	}
	*/
	
	//유틸리티 객체
	/*
	@RequestMapping(value = "/home0101", method = RequestMethod.GET)
	public String home0101(Model model) {
		logger.info("home0101");
		
		int coin = 1000;
		
		model.addAttribute("coin", coin);
		
		return "home0101";
	}
	
	@RequestMapping(value = "/home0201", method = RequestMethod.GET)
	public String home0201(Model model) {
		logger.info("home0201");
		
		Date date = new Date();
		
		model.addAttribute("now", date);
		
		return "home0201";
	}
	
	@RequestMapping(value = "/home0301", method = RequestMethod.GET)
	public String home0301(Model model) {
		logger.info("home0301");
		
		String str ="Hello, World";

		model.addAttribute("str", str);
		
		return "home0301";
	}
	*/
	//10. 메시지 처리
	//메시지 소스 정의
	//국제화
	/*
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
				
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate);
		
		return "home";
	}
	*/
	
	//컨트롤러에서 메시지 소스 사용
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
				
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate);
		
		return "home";
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome() {
		
		//미리 정의된 메시지에 값을 넘겨준다.
		String[] args = {"홍길동"};
		
		//스프링 프레임워크로 부터 MessageSource를 주입받은 다음 getMessage 메서드를 호출한다.
		String message = messageSource.getMessage("welcome.message", args, Locale.KOREAN);
		
		logger.info("Welcome message : " + message);
		
		return "home";
	}
	
}
