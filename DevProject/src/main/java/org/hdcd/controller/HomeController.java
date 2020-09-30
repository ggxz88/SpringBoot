package org.hdcd.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.hdcd.domain.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	//3. 컨트롤러 요청 매핑
	//Headers 매핑
	//Content Type 매핑
	//Accept 매핑
	@RequestMapping(value = "/ajaxHome", method = RequestMethod.GET)
	public String ajaxHome() {
		return "ajaxHome";
	}
	
	//4. 컨트롤러 응답
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
	
	//5. 컨트롤러 요청 처리
	//Ajax 방식 요청 처리
	//파일업로드 Ajax 방식 요청 처리
	
	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public String registerForm() {
		logger.info("registerForm");
		
		return "registerForm";
	}
}
