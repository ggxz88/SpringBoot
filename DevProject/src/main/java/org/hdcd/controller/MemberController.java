package org.hdcd.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hdcd.domain.Address;
import org.hdcd.domain.Card;
import org.hdcd.domain.CodeLabelValue;
import org.hdcd.domain.FileMember;
import org.hdcd.domain.Member;
import org.hdcd.domain.MultiFileMember;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@Controller
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	//5. 컨트롤러 요청 처리
	//요청 처리
	/*
	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public String registerForm() {
		logger.info("registerForm");
		
		return "registerForm";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerByParameter(String userId, String password) {
		logger.info("registerByParameter");
		
		logger.info("userId = " + userId);
		// > userId = hongkd
		
		logger.info("password = " + password);
		// > password = 1234
		
		return "success";
	}
	
	@RequestMapping(value = "/register/{userId}", method = RequestMethod.GET)
	public String registerByPath(String userId) {
		logger.info("registerByPath");
		
		logger.info("userId = " + userId);
		// > userId = hongkd
		
		return "success";
	}
	
	@RequestMapping(value = "/register01", method = RequestMethod.POST)
	public String register01(String userId) {
		logger.info("register01");
		
		logger.info("userId = " + userId);
		// > userId = hongkd
		
		return "success";
	}
	
	@RequestMapping(value = "/register02", method = RequestMethod.POST)
	public String register02(String userId, String password) {
		logger.info("register02");
		
		logger.info("userId = " + userId);
		// > userId = hongkd
		
		logger.info("password = " + password);
		// > password = 1234
		
		return "success";
	}
	
	@RequestMapping(value = "/register03", method = RequestMethod.POST)
	public String register03(String password, String userId) {
		logger.info("register03");
		
		logger.info("userId = " + userId);
		// > userId = hongkd
		
		logger.info("password = " + password);
		// > password = 1234
		
		return "success";
	}
	
	@RequestMapping(value = "/register04", method = RequestMethod.POST)
	public String register04(String userId, String password, String coin) {
		logger.info("register04");
		
		logger.info("userId = " + userId);
		// > userId = hongkd
		
		logger.info("password = " + password);
		// > password = 1234
		
		logger.info("coin = " + coin);
		// > coin = 100
		
		return "success";
	}
	
	@RequestMapping(value = "/register05", method = RequestMethod.POST)
	public String register05(String userId, String password, int coin) {
		logger.info("register05");
		
		logger.info("userId = " + userId);
		// > userId = hongkd
		
		logger.info("password = " + password);
		// > password = 1234
		
		logger.info("coin = " + coin);
		// > coin = 100
		
		return "success";
	}
	*/
	
	//요청 처리 데이터 애너테이션
	/*
	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public String registerForm() {
		logger.info("registerForm");
		
		return "registerForm";
	}
	
	@RequestMapping(value = "/register/{userId}", method = RequestMethod.GET)
	public String registerByPath(String userId) {
		logger.info("registerByPath");
		
		logger.info("userId = " + userId);
		// > userId = hongkd
		
		return "success";
	}
	
	@RequestMapping(value = "/register/{userId}/{coin}", method = RequestMethod.GET)
	public String registerByPath(@PathVariable("userId") String userId, @PathVariable("coin") int coin) {
		logger.info("registerByPath");
		
		logger.info("userId = " + userId);
		// > userId = hongkd

		logger.info("coin = " + coin);
		// > coin = 100
		
		return "success";
	}
	
	@RequestMapping(value = "/register01", method = RequestMethod.POST)
	public String register01(String userId) {
		logger.info("register01");
		
		logger.info("userId = " + userId);
		// > userId = hongkd
		
		return "success";
	}
	
	@RequestMapping(value = "/register0201", method = RequestMethod.POST)
	public String register0201(String username) {
		logger.info("register0201");
		
		logger.info("userId = " + username);
		// > userId = null
		
		return "success";
	}
	
	@RequestMapping(value = "/register0202", method = RequestMethod.POST)
	public String register0202(@RequestParam("userId") String username) {
		logger.info("register0202");
		
		logger.info("userId = " + username);
		// > userId = null
		
		return "success";
	}
	
	@RequestMapping(value = "/register0301", method = RequestMethod.POST)
	public String register0301(String memberId) {
		logger.info("register0301");
		
		logger.info("userId = " + memberId);
		// > userId = null
		
		return "success";
	}
	
	@RequestMapping(value = "/register0302", method = RequestMethod.POST)
	public String register0302(@RequestParam("userId") String memberId) {
		logger.info("register0302");
		
		logger.info("userId = " + memberId);
		// > userId = null
		
		return "success";
	}
	*/
	
	//요청 처리 자바빈즈
	/*
	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public String registerForm() {
		logger.info("registerForm");
		
		return "registerForm";
	}
	
	@RequestMapping(value = "/register01", method = RequestMethod.POST)
	public String register01(Member member) {
		logger.info("register01");
		
		logger.info("member.getUserId() = " + member.getUserId());
		// > member.getUserId() = hongkd
		
		logger.info("member.getPassword() = " + member.getPassword());
		// > member.getPassword() = 1234
		
		logger.info("member.getCoin() = " + member.getCoin());
		// > member.getCoin() = 100
		
		return "success";
	}
	
	@RequestMapping(value = "/register02", method = RequestMethod.POST)
	public String register02(Member member, int coin) {
		logger.info("register02");
		
		logger.info("member.getUserId() = " + member.getUserId());
		// > member.getUserId() = hongkd
		
		logger.info("member.getPassword() = " + member.getPassword());
		// > member.getPassword() = 1234
		
		logger.info("member.getCoin() = " + member.getCoin());
		// > member.getCoin() = 100
		
		logger.info("coin = " + coin);
		// > coin = 100
		
		return "success";
	}
	
	@RequestMapping(value = "/register03", method = RequestMethod.POST)
	public String register03(int uid, Member member) {
		logger.info("register03");
		
		logger.info("uid = " + uid);
		// > uid = 50
		
		logger.info("member.getUserId() = " + member.getUserId());
		// > member.getUserId() = hongkd
		
		logger.info("member.getPassword() = " + member.getPassword());
		// > member.getPassword() = 1234
		
		logger.info("member.getCoin() = " + member.getCoin());
		// > member.getCoin() = 100
		
		return "success";
	}
	*/
	
	//Date 타입 처리
	/*
	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public String registerForm() {
		logger.info("registerForm");
		
		return "registerForm";
	}
	
	@RequestMapping(value = "/registerByGet01", method = RequestMethod.GET)
	public String registerByGet01(String userId, Date dateOfBirth) {
		logger.info("registerByGet01");
		
		logger.info("userId = " + userId);
		// > userId = hongkd
		
		logger.info("dateOfBirth = " + dateOfBirth);
		// > dateOfBirth = Sat Sep 08 00:00:00 KST 2018
		
		return "success";
	}
	
	@RequestMapping(value = "/registerByGet02", method = RequestMethod.GET)
	public String registerByGet02(Member member) {
		logger.info("registerByGet02");
		
		logger.info("member.getUserId() = " + member.getUserId());
		// > member.getUserId() = hongkd
		
		logger.info("member.getDateOfBirth() = " + member.getDateOfBirth());
		// > member.getDateOfBirth() = Sat Sep 08 00:00:00 KST 2018
		
		return "success";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Member member) {
		logger.info("register");
		
		logger.info("member.getUserId() = " + member.getUserId());
		// > member.getUserId() = hongkd
		
		logger.info("member.getPassword() = " + member.getPassword());
		// > member.getPassword() = 1234
		
		logger.info("member.getDateOfBirth() = " + member.getDateOfBirth());
		// > member.getDateOfBirth() = Sat Sep 08 00:00:00 KST 2018
		
		return "success";
	}
	*/
	
	//@DateTimeFormat 애너테이션
	/*
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Member member) {
		logger.info("register");
		
		logger.info("member.getUserId() = " + member.getUserId());
		// > member.getUserId() = hongkd
		
		logger.info("member.getPassword() = " + member.getPassword());
		// > member.getPassword() = 1234
		
		logger.info("member.getDateOfBirth() = " + member.getDateOfBirth());
		// > member.getDateOfBirth() = Sat Sep 08 00:00:00 KST 2018
		
		return "success";
	}
	
	@RequestMapping(value = "/registerByGet01", method = RequestMethod.GET)
	public String registerByGet01(String userId, @DateTimeFormat(pattern="yyyMMdd") Date dateOfBirth) {
		logger.info("registerByGet01");
		
		logger.info("userId = " + userId);
		// > userId = hongkd
		
		logger.info("dateOfBirth = " + dateOfBirth);
		// > dateOfBirth = Sat Sep 08 00:00:00 KST 2018
		
		return "success";
	}
	
	@RequestMapping(value = "/registerByGet02", method = RequestMethod.GET)
	public String registerByGet02(Member member) {
		logger.info("registerByGet02");
		
		logger.info("member.getUserId() = " + member.getUserId());
		// > member.getUserId() = hongkd
		
		logger.info("member.getDateOfBirth() = " + member.getDateOfBirth());
		// > member.getDateOfBirth() = Sat Sep 08 00:00:00 KST 2018
		
		return "success";
	}
	
	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public String registerForm() {
		logger.info("registerForm");
		
		return "registerForm";
	}
	*/
	
	//폼 방식 요청 처리
	/*
	@RequestMapping(value = "/registerAllForm", method = RequestMethod.GET)
	public String registerAllForm() {
		logger.info("registerAllForm");
		
		return "registerAllForm";
	}
	
	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public String registerForm() {
		logger.info("registerForm");
		
		return "registerForm";
	}
	
	@RequestMapping(value = "/registerMemberUserId", method = RequestMethod.POST)
	public String registerMemberUserId(Member member) {
		logger.info("registerUserId");
		
		logger.info("member.getUserId() = " + member.getUserId());
		
		return "registerForm";
	}
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String registerUser(Member member) {
		logger.info("registerUser");
		
		logger.info("member.getUserId() = " + member.getUserId());
		logger.info("member.getGender() = " + member.getGender());
		logger.info("member.getHobby() = " + member.getHobby());
		logger.info("member.getForeigner() = " + member.getForeigner());
		logger.info("member.getDeveloper() = " + member.getDeveloper());
		logger.info("member.getDateOfBirth() = " + member.getDateOfBirth());
		logger.info("member.getCars() = " + member.getCars());
		logger.info("member.getIntroduction() = " + member.getIntroduction());
		
		String[] hobbyArray = member.getHobbyArray();
		
		if(hobbyArray != null) {
			logger.info("hobbyArray.length = " + hobbyArray.length);
			
			for(int i = 0; i< hobbyArray.length; i++) {
				logger.info("hobbyArray[" + i +"] = " + hobbyArray[i]);
			}
		}
		else {
			logger.info("hobbyArray == null");
		}
		
		List<String> hobbyList = member.getHobbyList();
		
		if(hobbyList != null) {
			logger.info("hobbyList.size() = " + hobbyList.size());
			
			for(int i = 0; i< hobbyList.size(); i++) {
				logger.info("hobbyList(" + i +") = " + hobbyList.get(i));
			}
		}
		else {
			logger.info("hobbyList == null");
		}
		
		Address address = member.getAddress();
		
		if(address != null) {
			logger.info("address.getPostCode() = " + address.getPostCode());
			logger.info("address.getLocation() = " + address.getLocation());
		}
		else {
			logger.info("address == null");
		}
		
		List<Card> cardList = member.getCardList();
		
		if(cardList != null) {
			logger.info("cardList.size() = " + cardList.size());
			
			for(int i = 0; i< cardList.size(); i++) {
				Card card = cardList.get(i);
				logger.info("card.getNo() = " + card.getNo());
				logger.info("card.getValidMonth() = " + card.getValidMonth());
			}
		}
		else {
			logger.info("cardList == null");
		}
		
		String[] carArray = member.getCarArray();
		
		if(carArray != null) {
			logger.info("carArray.length = " + carArray.length);
			
			for(int i = 0; i< carArray.length; i++) {
				logger.info("carArray[" + i +"] = " + carArray[i]);
			}
		}
		else {
			logger.info("carArray == null");
		}
		
		List<String> carList = member.getCarList();
		
		if(carList != null) {
			logger.info("carList.size() = " + carList.size());
			
			for(int i = 0; i< carList.size(); i++) {
				logger.info("carList(" + i +") = " + carList.get(i));
			}
		}
		else {
			logger.info("carList == null");
		}
		
		return "success";
	}
	
	@RequestMapping(value= "/registerUserId", method = RequestMethod.POST)
	public String registerUserId(String userId) {
		logger.info("registerUserId");
		logger.info("userId = " + userId);
		
		return "success";
	}
	
	@RequestMapping(value= "/registerPassword", method = RequestMethod.POST)
	public String registerPassword(String password) {
		logger.info("registerPassword");
		logger.info("password = " + password);
		
		return "success";
	}
	
	@RequestMapping(value= "/registerTextArea", method = RequestMethod.POST)
	public String registerTextArea(String introduction) {
		logger.info("registerTextArea");
		logger.info("introduction = " + introduction);
		
		return "success";
	}
	
	@RequestMapping(value= "/registerRadio", method = RequestMethod.POST)
	public String registerRadio(String gender) {
		logger.info("registerRadio");
		logger.info("gender = " + gender);
		
		return "success";
	}
	
	@RequestMapping(value= "/registerCheckbox01", method = RequestMethod.POST)
	public String registerCheckbox01(String hobby) {
		logger.info("registerCheckbox01");
		logger.info("hobby = " + hobby);
		
		return "success";
	}
	
	@RequestMapping(value= "/registerCheckbox02", method = RequestMethod.POST)
	public String registerCheckbox02(String[] hobbyArray) {
		logger.info("registerCheckbox02");

		if(hobbyArray != null) {
			logger.info("hobbyArray.length = " + hobbyArray.length);
			
			for(int i = 0; i< hobbyArray.length; i++) {
				logger.info("hobbyArray[" + i +"] = " + hobbyArray[i]);
			}
		}
		else {
			logger.info("hobbyArray == null");
		}
		
		return "success";
	}
	
	@RequestMapping(value= "/registerCheckbox03", method = RequestMethod.POST)
	public String registerCheckbox03(List<String> hobbyList) {
		logger.info("registerCheckbox03");
		
		if(hobbyList != null) {
			logger.info("hobbyList.size() = " + hobbyList.size());
			
			for(int i = 0; i< hobbyList.size(); i++) {
				logger.info("hobbyList(" + i +") = " + hobbyList.get(i));
			}
		}
		else {
			logger.info("hobbyList == null");
		}
		
		return "success";
	}
	
	@RequestMapping(value= "/registerCheckbox04", method = RequestMethod.POST)
	public String registerCheckbox04(String developer) {
		logger.info("registerCheckbox04");
		logger.info("developer = " + developer);
		
		return "success";
	}
	
	@RequestMapping(value= "/registerCheckbox05", method = RequestMethod.POST)
	public String registerCheckbox05(String foreigner) {
		logger.info("registerCheckbox05");
		logger.info("foreigner = " + foreigner);
		
		return "success";
	}
	
	@RequestMapping(value= "/registerSelect", method = RequestMethod.POST)
	public String registerSelect(String nationality) {
		logger.info("registerSelect");
		logger.info("nationality = " + nationality);
		
		return "success";
	}
	
	@RequestMapping(value= "/registerMultipleSelect01", method = RequestMethod.POST)
	public String registerMultipleSelect01(String cars) {
		logger.info("registerMultipleSelect01");
		logger.info("cars = " + cars);
		
		return "success";
	}
	
	@RequestMapping(value= "/registerMultipleSelect02", method = RequestMethod.POST)
	public String registerMultipleSelect02(String[] carArray) {
		logger.info("registerMultipleSelect02");

		if(carArray != null) {
			logger.info("carArray.length = " + carArray.length);
			
			for(int i = 0; i< carArray.length; i++) {
				logger.info("carArray[" + i +"] = " + carArray[i]);
			}
		}
		else {
			logger.info("carArray == null");
		}
		
		return "success";
	}
	
	@RequestMapping(value= "/registerMultipleSelect03", method = RequestMethod.POST)
	public String registerMultipleSelect03(ArrayList<String> carList) {
		logger.info("registerMultipleSelect03");

		if(carList != null) {
			logger.info("carList.size() = " + carList.size());
			
			for(int i = 0; i< carList.size(); i++) {
				logger.info("carList(" + i +") = " + carList.get(i));
			}
		}
		else {
			logger.info("carList == null");
		}
		
		return "success";
	}
	
	@RequestMapping(value= "/registerAddress", method = RequestMethod.POST)
	public String registerAddress(Address address) {
		logger.info("registerAddress");
		
		if(address != null) {
			logger.info("address.getPostCode() = " + address.getPostCode());
			logger.info("address.getLocation() = " + address.getLocation());
		}
		else {
			logger.info("address == null");
		}
		
		return "success";
	}
	
	@RequestMapping(value= "/registerUserAddress", method = RequestMethod.POST)
	public String registerUserAddress(Member member) {
		logger.info("registerUserAddress");

		Address address = member.getAddress();
		
		if(address != null) {
			logger.info("address.getPostCode() = " + address.getPostCode());
			logger.info("address.getLocation() = " + address.getLocation());
		}
		else {
			logger.info("address == null");
		}
		
		return "success";
	}
	
	@RequestMapping(value= "/registerUserCardList", method = RequestMethod.POST)
	public String registerUserCardList(Member member) {
		logger.info("registerUserCardList");
		
		List<Card> cardList = member.getCardList();
		
		if(cardList != null) {
			logger.info("cardList.size() = " + cardList.size());
			
			for(int i = 0; i< cardList.size(); i++) {
				Card card = cardList.get(i);
				logger.info("card.getNo() = " + card.getNo());
				logger.info("card.getValidMonth() = " + card.getValidMonth());
			}
		}
		else {
			logger.info("cardList == null");
		}
		
		return "success";
	}
	
	@RequestMapping(value= "/registerDate01", method = RequestMethod.POST)
	public String registerDate01(Date dateOfBirth) {
		logger.info("registerDate01");
		
		if(dateOfBirth != null) {
			logger.info("dateOfBirth = " + dateOfBirth);
		}
		else {
			logger.info("dateOfBirth == null");
		}
		
		return "success";
	}
	
	@RequestMapping(value= "/registerDate02", method = RequestMethod.POST)
	public String registerDate02(@DateTimeFormat(pattern="yyyyMMdd") Date dateOfBirth) {
		logger.info("registerDate02");
		
		if(dateOfBirth != null) {
			logger.info("dateOfBirth = " + dateOfBirth);
		}
		else {
			logger.info("dateOfBirth == null");
		}
		
		return "success";
	}
	*/
	
	//파일업로드 폼 방식 요청 처리
	/*
	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public String registerForm() {
		logger.info("registerForm");
		
		return "registerForm";
	}
	
	@RequestMapping(value = "/registerFile01", method = RequestMethod.POST)
	public String registerFile01(MultipartFile picture) throws Exception {
		logger.info("registerFile01");
		
		logger.info("originalName: " + picture.getOriginalFilename());
		logger.info("size: " + picture.getSize());
		logger.info("contentTye: " + picture.getContentType());
		
		return "success";
	}
	
	@RequestMapping(value = "/registerFile02", method = RequestMethod.POST)
	public String registerFile02(String userId, String password, MultipartFile picture) throws Exception {
		logger.info("registerFile02");
		
		logger.info("userId = " + userId);
		logger.info("password = " + password);
		
		logger.info("originalName: " + picture.getOriginalFilename());
		logger.info("size: " + picture.getSize());
		logger.info("contentTye: " + picture.getContentType());
		
		return "success";
	}
	
	@RequestMapping(value = "/registerFile03", method = RequestMethod.POST)
	public String registerFile03(Member member, MultipartFile picture) throws Exception {
		logger.info("registerFile03");
		
		logger.info("userId = " + member.getUserId());
		logger.info("password = " + member.getPassword());
		
		logger.info("originalName: " + picture.getOriginalFilename());
		logger.info("size: " + picture.getSize());
		logger.info("contentTye: " + picture.getContentType());
		
		return "success";
	}
	
	@RequestMapping(value = "/registerFile04", method = RequestMethod.POST)
	public String registerFile04(FileMember fileMember) throws Exception {
		logger.info("registerFile04");
		
		logger.info("userId = " + fileMember.getUserId());
		logger.info("password = " + fileMember.getPassword());
		
		MultipartFile picture = fileMember.getPicture();
		
		logger.info("originalName: " + picture.getOriginalFilename());
		logger.info("size: " + picture.getSize());
		logger.info("contentTye: " + picture.getContentType());
		
		return "success";
	}
	
	@RequestMapping(value = "/registerFile05", method = RequestMethod.POST)
	public String registerFile05(MultipartFile picture, MultipartFile picture2) throws Exception {
		logger.info("registerFile05");
		
		logger.info("originalName: " + picture.getOriginalFilename());
		logger.info("size: " + picture.getSize());
		logger.info("contentTye: " + picture.getContentType());
		
		logger.info("originalName: " + picture2.getOriginalFilename());
		logger.info("size: " + picture2.getSize());
		logger.info("contentTye: " + picture2.getContentType());
		
		
		return "success";
	}
	
	@RequestMapping(value = "/registerFile06", method = RequestMethod.POST)
	public String registerFile06(List<MultipartFile> pictureList) throws Exception {
		logger.info("registerFile06");
		
		logger.info("registerFile06 pictureList.size() = " + pictureList.size());
		
		for(MultipartFile picture : pictureList) {
			logger.info("picture originalName: " + picture.getOriginalFilename());
			logger.info("picture size: " + picture.getSize());
			logger.info("picture contentTye: " + picture.getContentType());
		}
		
		return "success";
	}
	
	@RequestMapping(value = "/registerFile07", method = RequestMethod.POST)
	public String registerFile07(MultiFileMember multiFileMember) throws Exception {
		logger.info("registerFile07");
		
		List<MultipartFile> pictureList = multiFileMember.getPictureList();
		
		logger.info("registerFile07 pictureList.size() = " + pictureList.size());
		
		for(MultipartFile picture : pictureList) {
			logger.info("picture originalName: " + picture.getOriginalFilename());
			logger.info("picture size: " + picture.getSize());
			logger.info("picture contentTye: " + picture.getContentType());
		}
		
		return "success";
	}
	
	@RequestMapping(value = "/registerFile08", method = RequestMethod.POST)
	public String registerFile08(MultipartFile[] pictureList) throws Exception {
		logger.info("registerFile08");
				
		logger.info("registerFile08 pictureList.length = " + pictureList.length);
		
		for(MultipartFile picture : pictureList) {
			logger.info("picture originalName: " + picture.getOriginalFilename());
			logger.info("picture size: " + picture.getSize());
			logger.info("picture contentTye: " + picture.getContentType());
		}
		
		return "success";
	}
	*/
	
	//Ajax 방식 요청 처리
	/*
	@RequestMapping(value = "/register/{userId}", method = RequestMethod.GET)
	public ResponseEntity<String> register01(@PathVariable("userId") String userId) {
		logger.info("register01");
		
		logger.info("userId = " + userId);
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		return entity;
	}
	
	@RequestMapping(value = "/register/{userId}/{password}", method = RequestMethod.POST)
	public ResponseEntity<String> register02(@PathVariable("userId") String userId, @PathVariable("password") String password) {
		logger.info("register02");
		
		logger.info("userId = " + userId);
		logger.info("password = " + password);
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		return entity;
	}
	
	@RequestMapping(value = "/register03", method = RequestMethod.POST)
	public ResponseEntity<String> register03(@RequestBody Member member) {
		logger.info("register03");
		
		logger.info("userId = " + member.getUserId());
		logger.info("password = " + member.getPassword());
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		return entity;
	}
	
	@RequestMapping(value = "/register04", method = RequestMethod.POST)
	public ResponseEntity<String> register04(String userId) {
		logger.info("register03");
		
		logger.info("userId = " + userId);
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		return entity;
	}
	
	@RequestMapping(value = "/register05", method = RequestMethod.POST)
	public ResponseEntity<String> register05(String userId, String password) {
		logger.info("register05");
		
		logger.info("userId = " + userId);
		logger.info("password = " + password);
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		return entity;
	}
	
	@RequestMapping(value = "/register/{userId}", method = RequestMethod.POST)
	public ResponseEntity<String> register06(@PathVariable("userId") String userId, @RequestBody Member member) {
		logger.info("register06");
		
		logger.info("userId = " + userId);
		
		logger.info("member.getUserId() = " + member.getUserId());
		logger.info("member.getPassword() = " + member.getPassword());
		
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		return entity;
	}
	
	@RequestMapping(value = "/register07", method = RequestMethod.POST)
	public ResponseEntity<String> register07(@RequestBody List<Member> memberList) {
		logger.info("register07");
		
		for(Member member : memberList) {
			logger.info("userId = " + member.getUserId());
			logger.info("password = " + member.getPassword());
		}
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		return entity;
	}
	
	@RequestMapping(value= "/register08", method = RequestMethod.POST)
	public ResponseEntity<String> register08(@RequestBody Member member) {
		logger.info("register08");
		
		logger.info("userId = " + member.getUserId());
		logger.info("password = " + member.getPassword());

		Address address = member.getAddress();
		
		if(address != null) {
			logger.info("address.getPostCode() = " + address.getPostCode());
			logger.info("address.getLocation() = " + address.getLocation());
		}
		else {
			logger.info("address == null");
		}
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		return entity;
	}
	
	@RequestMapping(value= "/register09", method = RequestMethod.POST)
	public ResponseEntity<String> register09(@RequestBody Member member) {
		logger.info("register09");
		
		logger.info("userId = " + member.getUserId());
		logger.info("password = " + member.getPassword());

		List<Card> cardList = member.getCardList();
		
		if(cardList != null) {
			logger.info("cardList.size() = " + cardList.size());
			
			for(int i = 0; i< cardList.size(); i++) {
				Card card = cardList.get(i);
				logger.info("card.getNo() = " + card.getNo());
				logger.info("card.getValidMonth() = " + card.getValidMonth());
			}
		}
		else {
			logger.info("cardList == null");
		}
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		return entity;
	}
	*/
	
	//파일업로드 Ajax 방식 요청 처리
	/*
	@RequestMapping(value = "/uploadAjax", method = RequestMethod.POST, produces = "text/plain; charset=UTF-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception {
		String originalFilename = file.getOriginalFilename();
		
		logger.info("originalName: " + originalFilename);
		
		ResponseEntity<String> entity = new ResponseEntity<String>("UPLOAD SUCCESS" + originalFilename, HttpStatus.OK);
		
		return entity;	
	}
	*/
	
	//6. 데이터 전달자 모델
	//모델을 통한 데이터 전달
	/*
	@RequestMapping(value = "/read01", method = RequestMethod.GET)
	public String read01(Model model) {
		logger.info("read01");
		
		model.addAttribute("userId", "hongkd");
		model.addAttribute("password", "1234");
		model.addAttribute("email", "aaa@ccc.com");
		model.addAttribute("userName", "홍길동");
		model.addAttribute("birthDay", "1989-09-07");
		
		return "read01";
	}
	
	@RequestMapping(value = "/read02", method = RequestMethod.GET)
	public String read02(Model model) {
		logger.info("read02");
		
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

		return "read02";
	}
	
	@RequestMapping(value = "/read03", method = RequestMethod.GET)
	public String read03(Model model) {
		logger.info("read03");
		
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
		
		model.addAttribute("user", member);

		return "read03";
	}
	
	@RequestMapping(value = "/read04", method = RequestMethod.GET)
	public String read04(Model model) {
		logger.info("read04");
		
		String[] carArray = {"saab", "audi"};
		
		List<String> carList = new ArrayList<String>();
		carList.add("saab");
		carList.add("audi");
		
		String[] hobbyArray = {"Music", "Movie"};
		
		List<String> hobbyList = new ArrayList<String>();
		hobbyList.add("Music");
		hobbyList.add("Movie");
		
		model.addAttribute("carArray", carArray);
		model.addAttribute("carList", carList);

		model.addAttribute("hobbyArray", hobbyArray);
		model.addAttribute("hobbyList", hobbyList);

		return "read04";
	}
	
	@RequestMapping(value = "/read05", method = RequestMethod.GET)
	public String read05(Model model) {
		logger.info("read05");
		
		Member member = new Member();
		
		Address address = new Address();
		address.setPostCode("080908");
		address.setLocation("seoul");
		
		member.setAddress(address);
		
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
	
	@RequestMapping(value = "/read06", method = RequestMethod.GET)
	public String read06(Model model) {
		logger.info("read06");
		
		Member member = new Member();
		
		member.setUserId("hongkd");
		member.setPassword("1234");
		member.setEmail("aaa@ccc.com");
		member.setUserName("홍길동");
		member.setBirthDay("1989-09-07");
		
		member.setGender("female");
		
		member.setDeveloper("Y");
		member.setForeigner(true);
		
		member.setNationality("Austraila");
		
		//user.setCars("saab, audi");
		member.setCars("saab");
		
		String[] carArray = {"saab", "audi"};
		
		member.setCarArray(carArray);
		
		List<String> carList = new ArrayList<String>();
		carList.add("saab");
		carList.add("audi");
		
		member.setCarList(carList);
		
		member.setHobby("Movie");
		
		String[] hobbyArray = {"Music", "Movie"};
		
		member.setHobbyArray(hobbyArray);
				
		List<String> hobbyList = new ArrayList<String>();
		hobbyList.add("Music");
		hobbyList.add("Movie");
		
		member.setHobbyList(hobbyList);

		Address address = new Address();
		address.setPostCode("080908");
		address.setLocation("seoul");
		
		member.setAddress(address);
		
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
		
		cal.set(Calendar.YEAR, 1988);
		cal.set(Calendar.MONTH, 10);
		cal.set(Calendar.DAY_OF_MONTH, 7);
		
		member.setDateOfBirth(cal.getTime());
		
		String introduction = "안녕하세요.\n반갑습니다.";
		
		member.setIntroduction(introduction);
		
		model.addAttribute("user", member);

		return "read06";
	}
	*/
	
	//@ModelAttribute 애너테이션
	/*
	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public String registerForm() {
		logger.info("registerForm");
		
		return "registerForm";
	}
	
	@RequestMapping(value = "/register01", method = RequestMethod.POST)
	public String register01(String userId) {
		logger.info("register01");
		
		logger.info("userId = " + userId);
		// > userId = hongkd
		
		return "result01";
	}
	
	@RequestMapping(value = "/register02", method = RequestMethod.POST)
	public String register02(@ModelAttribute("userId") String userId) {
		logger.info("register02");
		
		logger.info("userId = " + userId);
		// > userId = hongkd
		
		return "result02";
	}
	
	@RequestMapping(value = "/register03", method = RequestMethod.POST)
	public String register03(@ModelAttribute("userId") String userId, @ModelAttribute("password") String password) {
		logger.info("register03");
		
		logger.info("userId = " + userId);
		// > userId = hongkd
		
		logger.info("password = " + password);
		// > password = 1234
		
		return "result03";
	}
	
	@RequestMapping(value = "/register04", method = RequestMethod.POST)
	public String register04(Member member) {
		logger.info("register04");
		
		logger.info("userId = " + member.getUserId());
		// > userId = hongkd
		
		logger.info("password = " + member.getPassword());
		// > password = 1234
		
		return "result04";
	}
	*/
	
	//RedirectAttributes 타입
	/*
	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public String registerForm() {
		logger.info("registerForm");
		
		return "registerForm";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Member member, RedirectAttributes rttr) throws Exception {
		logger.info("register");
		
		rttr.addFlashAttribute("msg", "success");
		
		return "registerForm";
	}
	
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public String result() {
		logger.info("result");
		
		return "result";
	}
	*/
	
	//8. 스프링 폼
	//폼 요소
	/*
	@RequestMapping(value = "/registerForm01", method = RequestMethod.GET)
	public String registerForm01() {
		logger.info("registerForm01");
		
		return "registerForm";
	}
	
	@RequestMapping(value = "/registerForm02", method = RequestMethod.GET)
	//화면에 전달할 데이터를 위해 모델을 매개변수로 지정한다.
	public String registerForm02(Model model) {
		logger.info("registerForm02");
		
		//속성명에 'member'를 지정하고 폼 객체를 모델에 추가한다.
		model.addAttribute("member", new Member());
		
		return "registerForm";
	}
	
	@RequestMapping(value = "/registerForm03", method = RequestMethod.GET)
	//화면에 전달할 데이터를 위해 모델을 매개변수로 지정한다.
	public String registerForm03(Model model) {
		logger.info("registerForm03");
		
		//속성명에 'user'를 지정하고 폼 객체를 모델에 추가한다.
		model.addAttribute("user", new Member());
		
		return "registerForm";
	}
	
	@RequestMapping(value = "/registerForm04", method = RequestMethod.GET)
	//화면에 전달할 데이터를 위해 모델을 매개변수로 지정한다.
	public String registerForm04(Model model) {
		logger.info("registerForm04");
		
		//속성명에 'user'를 지정하고 폼 객체를 모델에 추가한다.
		model.addAttribute("user", new Member());
		
		return "registerForm2";
	}
	
	@RequestMapping(value = "/registerForm05", method = RequestMethod.GET)
	//컨트롤러는 기본적으로 자바빈즈 규칙에 맞는 객체는 다시 화면으로 폼 객체를 전달한다.
	public String registerForm05(Member member) {
		logger.info("registerForm05");
		
		return "registerForm";
	}
	
	@RequestMapping(value = "/registerForm06", method = RequestMethod.GET)
	//폼 객체의 속성명은 매개변수로 전달된 자바빈즈 클래스의 타입명을 이용하여 만든다.
	public String registerForm06(Member user) {
		logger.info("registerForm06");
		
		return "registerForm";
	}
	
	@RequestMapping(value = "/registerForm07", method = RequestMethod.GET)
	//폼 객체의 속성명은 매개변수로 전달된 자바빈즈 클래스의 타입명을 이용하여 만든다.
	public String registerForm07(@ModelAttribute("user") Member member) {
		logger.info("registerForm07");
		
		return "registerForm";
	}
	
	@RequestMapping(value = "/registerForm08", method = RequestMethod.GET)
	//폼 객체의 속성명은 매개변수로 전달된 자바빈즈 클래스의 타입명을 이용하여 만든다.
	public String registerForm08(@ModelAttribute("user") Member member) {
		logger.info("registerForm08");
		
		return "registerForm2";
	}
	
	@RequestMapping(value = "/registerForm09", method = RequestMethod.GET)
	//화면에 전달할 데이터를 위해 모델을 매개변수로 지정한다.
	public String registerForm09(Model model) {
		logger.info("registerForm09");
		
		Member member = new Member();
		
		//폼 객체의 프로퍼티에 값을 지정한다.
		member.setUserId("hongkd");
		member.setUserName("홍길동");
		
		model.addAttribute("member", member);
		
		return "registerForm";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Member member) {
		logger.info("register");
		
		logger.info("member.getUserId() = " + member.getUserId());
		
		logger.info("member.getUserName() = " + member.getUserName());
	
		return "result";
	}
	*/
	
	//텍스트 필드 요소
	/*
	@RequestMapping(value = "/registerForm01", method = RequestMethod.GET)
	public String registerForm01(Model model) {
		logger.info("registerForm01");
		
		model.addAttribute("member", new Member());
		
		return "registerForm";
	}
	
	@RequestMapping(value = "/registerForm02", method = RequestMethod.GET)
	public String registerForm02(Model model) {
		logger.info("registerForm02");
		
		Member member = new Member();
		
		member.setEmail("aaa@ccc.com");
		member.setUserName("홍길동");
		
		model.addAttribute("member", member);
		
		return "registerForm";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Member member) {
		logger.info("register");
		
		logger.info("member.getUserId() = " + member.getUserId());
		logger.info("member.getUserName() = " + member.getUserName());
		logger.info("member.getEmail() = " + member.getEmail());
		
		return "result";
	}
	*/
	
	//패스워드 필드 요소
	/*
	@RequestMapping(value = "/registerForm01", method = RequestMethod.GET)
	public String registerForm01(Model model) {
		logger.info("registerForm01");
		
		model.addAttribute("member", new Member());
		
		return "registerForm";
	}
	
	@RequestMapping(value = "/registerForm02", method = RequestMethod.GET)
	public String registerForm02(Model model) {
		logger.info("registerForm02");
		
		Member member = new Member();
		
		member.setPassword("1234");
		
		model.addAttribute("member", member);
		
		return "registerForm";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Member member) {
		logger.info("register");
		
		logger.info("member.getPassword() = " + member.getPassword());
		
		return "result";
	}
	*/
	
	//텍스트 영역 요소
	/*
	@RequestMapping(value = "/registerForm01", method = RequestMethod.GET)
	public String registerForm01(Model model) {
		logger.info("registerForm01");
		
		model.addAttribute("member", new Member());
		
		return "registerForm";
	}
	
	@RequestMapping(value = "/registerForm02", method = RequestMethod.GET)
	public String registerForm02(Model model) {
		logger.info("registerForm02");
		
		Member member = new Member();
		
		String introduction = "안녕하세요.\n반갑습니다.";
		
		member.setIntroduction(introduction);
		
		model.addAttribute("member", member);
		
		return "registerForm";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Member member) {
		logger.info("register");
		
		logger.info("member.getIntroduction() = " + member.getIntroduction());

		return "result";
	}
	*/
	
	//여러 개의 체크박스 요소
	/*
	@RequestMapping(value = "/registerForm01", method = RequestMethod.GET)
	public String registerForm01(Model model) {
		logger.info("registerForm01");
		
		Map<String, String> hobbyMap = new HashMap<String, String>();
		hobbyMap.put("01", "Sports");
		hobbyMap.put("02", "Music");
		hobbyMap.put("03", "Movie");
		
		model.addAttribute("hobbyMap", hobbyMap);
		
		model.addAttribute("member", new Member());
		
		return "registerForm01";
	}
	
	@RequestMapping(value = "/registerForm02", method = RequestMethod.GET)
	public String registerForm02(Model model) {
		logger.info("registerForm02");
		
		List<CodeLabelValue> hobbyCodeList = new ArrayList<CodeLabelValue>();
		hobbyCodeList.add(new CodeLabelValue("01", "Sports"));
		hobbyCodeList.add(new CodeLabelValue("02", "Music"));
		hobbyCodeList.add(new CodeLabelValue("03", "Movie"));
		
		model.addAttribute("hobbyCodeList", hobbyCodeList);
		
		model.addAttribute("member", new Member());
		
		return "registerForm02";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Member member) {
		logger.info("register");
		
		List<String> hobbyList = member.getHobbyList();
		
		if(hobbyList != null) {
			logger.info("hobbyList != null = " + hobbyList.size());
			
			for(int i = 0; i< hobbyList.size(); i++) {
				logger.info("hobbyList(" + i + ") = " + hobbyList.get(i));
			}
		}
		else {
			logger.info("hobbyList == null");
		}

		return "result";
	}
	*/
	
	//체크박스 요소
	/*
	@RequestMapping(value = "/registerForm01", method = RequestMethod.GET)
	public String registerForm01(Model model) {
		logger.info("registerForm01");
		
		model.addAttribute("member", new Member());
		
		return "registerForm";
	}
	
	@RequestMapping(value = "/registerForm02", method = RequestMethod.GET)
	public String registerForm02(Model model) {
		logger.info("registerForm02");
		
		Member member = new Member();
		
		member.setDeveloper("Y");
		member.setForeigner(true);
		
		member.setHobby("Movie");
		
		String[] hobbyArray = {"Music", "Movie"};
		
		member.setHobbyArray(hobbyArray);
		
		List<String> hobbyList = new ArrayList<String>();
		hobbyList.add("Music");
		hobbyList.add("Movie");
		
		member.setHobbyList(hobbyList);
		
		model.addAttribute("member", member);
		
		return "registerForm";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Member member) {
		logger.info("register");
		
		logger.info("member.isForeigner() = " + member.isForeigner());
		logger.info("member.getDeveloper() = " + member.getDeveloper());
		logger.info("member.getHobby() = " + member.getHobby());
		
		String[] hobbyArray = member.getHobbyArray();
		
		if(hobbyArray != null) {
			logger.info("hobbyArray != null = " + hobbyArray.length);
			
			for(int i = 0; i< hobbyArray.length; i++) {
				logger.info("hobbyArray[" + i + "] = " + hobbyArray[i]);
			}
		}
		else {
			logger.info("hobbyArray == null");
		}
		
		List<String> hobbyList = member.getHobbyList();
		
		if(hobbyList != null) {
			logger.info("hobbyList != null = " + hobbyList.size());
			
			for(int i = 0; i< hobbyList.size(); i++) {
				logger.info("hobbyList(" + i + ") = " + hobbyList.get(i));
			}
		}
		else {
			logger.info("hobbyList == null");
		}

		return "result";
	}
	*/
	
	//여러 개의 라디오 버튼 요소
	/*
	@RequestMapping(value = "/registerForm01", method = RequestMethod.GET)
	public String registerForm01(Model model) {
		logger.info("registerForm01");
		
		Map<String, String> genderCodeMap = new HashMap<String, String>();
		genderCodeMap.put("01", "Male");
		genderCodeMap.put("02", "Female");
		genderCodeMap.put("03", "Other");
		
		model.addAttribute("genderCodeMap", genderCodeMap);
		
		model.addAttribute("member", new Member());
		
		return "registerForm01";
	}
	
	@RequestMapping(value = "/registerForm02", method = RequestMethod.GET)
	public String registerForm02(Model model) {
		logger.info("registerForm02");
		
		List<CodeLabelValue> genderCodeList = new ArrayList<CodeLabelValue>();
		genderCodeList.add(new CodeLabelValue("01", "Male"));
		genderCodeList.add(new CodeLabelValue("02", "Female"));
		genderCodeList.add(new CodeLabelValue("03", "Other"));
		
		model.addAttribute("genderCodeList", genderCodeList);
		
		model.addAttribute("member", new Member());
		
		return "registerForm02";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Member member, Model model) {
		logger.info("register");
		
		logger.info("member.getGender() = " + member.getGender());
		
		model.addAttribute("gender", member.getGender());

		return "result";
	}
	*/
	
	//라디오 버튼 요소
	/*
	@RequestMapping(value = "/registerForm01", method = RequestMethod.GET)
	public String registerForm01(Model model) {
		logger.info("registerForm01");
		
		model.addAttribute("member", new Member());
		
		return "registerForm";
	}
	
	@RequestMapping(value = "/registerForm02", method = RequestMethod.GET)
	public String registerForm02(Model model) {
		logger.info("registerForm02");
		
		Member member = new Member();
		
		member.setGender("female");
		
		model.addAttribute("member", member);
		
		return "registerForm";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Member member, Model model) {
		logger.info("register");
		
		logger.info("member.getGender() = " + member.getGender());
		
		model.addAttribute("member", member);
		
		return "result";
	}
	*/
	
	//셀렉트 박스 요소
	/*
	@RequestMapping(value = "/registerForm01", method = RequestMethod.GET)
	public String registerForm01(Model model) {
		logger.info("registerForm01");
		
		Map<String, String> nationalityCodeMap = new HashMap<String, String>();
		nationalityCodeMap.put("01", "Korea");
		nationalityCodeMap.put("02", "Germany");
		nationalityCodeMap.put("03", "Australia");
		
		model.addAttribute("nationalityCodeMap", nationalityCodeMap);
		
		model.addAttribute("member", new Member());
		
		return "registerForm01";
	}
	
	@RequestMapping(value = "/registerForm02", method = RequestMethod.GET)
	public String registerForm02(Model model) {
		logger.info("registerForm02");
		
		List<CodeLabelValue> nationalityCodeList = new ArrayList<CodeLabelValue>();
		nationalityCodeList.add(new CodeLabelValue("01", "Korea"));
		nationalityCodeList.add(new CodeLabelValue("02", "Germany"));
		nationalityCodeList.add(new CodeLabelValue("03", "Australia"));
		
		model.addAttribute("nationalityCodeList", nationalityCodeList);
		
		model.addAttribute("member", new Member());
		
		return "registerForm02";
	}
	
	@RequestMapping(value = "/registerForm03", method = RequestMethod.GET)
	public String registerForm03(Model model) {
		logger.info("registerForm01");
		
		Map<String, String> carCodeMap = new HashMap<String, String>();
		carCodeMap.put("01", "Volvo");
		carCodeMap.put("02", "Saab");
		carCodeMap.put("03", "Opel");
		
		model.addAttribute("carCodeMap", carCodeMap);
		
		model.addAttribute("member", new Member());
		
		return "registerForm03";
	}
	
	@RequestMapping(value = "/registerForm04", method = RequestMethod.GET)
	public String registerForm04(Model model) {
		logger.info("registerForm04");
		
		List<CodeLabelValue> carCodeList = new ArrayList<CodeLabelValue>();
		carCodeList.add(new CodeLabelValue("01", "Volvo"));
		carCodeList.add(new CodeLabelValue("02", "Saab"));
		carCodeList.add(new CodeLabelValue("03", "Opel"));
		
		model.addAttribute("carCodeList", carCodeList);
		
		model.addAttribute("member", new Member());
		
		return "registerForm04";
	}
	
	@RequestMapping(value = "/registerForm05", method = RequestMethod.GET)
	public String registerForm05(Model model) {
		logger.info("registerForm05");
		
		List<CodeLabelValue> carCodeList = new ArrayList<CodeLabelValue>();
		carCodeList.add(new CodeLabelValue("01", "Volvo"));
		carCodeList.add(new CodeLabelValue("02", "Saab"));
		carCodeList.add(new CodeLabelValue("03", "Opel"));
		
		model.addAttribute("carCodeList", carCodeList);
		
		model.addAttribute("member", new Member());
		
		return "registerForm05";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Member member, Model model) {
		logger.info("register");
		
		logger.info("member.getNationality() = " + member.getNationality());
		
		model.addAttribute("nationality", member.getNationality());

		return "result";
	}
	*/
	
	//숨겨진 필드 요소
	/*
	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public String registerForm(Model model) {
		logger.info("registerForm");
		
		Member member = new Member();
		
		member.setUserId("hongkd");
		member.setUserName("홍길동");
		
		model.addAttribute("member", member);
		
		return "registerForm";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Member member) {
		logger.info("register");
		
		logger.info("member.getUserId() = " + member.getUserId());
		
		logger.info("member.getUserName() = " + member.getUserName());
	
		return "result";
	}
	*/
	
	//입력값 검증 에러
	/*
	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public String registerForm(Model model) {
		logger.info("registerForm");
		
		Member member = new Member();
		
		member.setEmail("aaa@ccc.com");
		member.setUserName("홍길동");
		
		model.addAttribute("member", member);
		
		return "registerForm";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Member member) {
		logger.info("register");
		
		logger.info("member.getUserId() = " + member.getUserId());
		logger.info("member.getUserName() = " + member.getUserName());
		logger.info("member.getEmail() = " + member.getEmail());
		
		return "result";
	}
	*/
	
	//9. 입력 유효성 검증
	//입력값 검증
	//입력값 검증 결과
	/*
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	//입력값 검증을 할 도메인 클래스에 @Validated를 지정한다.
	public String register(@Validated Member member, BindingResult result) {
		logger.info("register");
		
		//입력값 검증 에러가 발생한 경우 true를 반환한다.
		logger.info("result.hasErrors() = " + result.hasErrors());
		
		//입력갑 검증 후 BindingResult가 제공하는 메서드를 이용하여 검사 결과를 확인
		if(result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			List<ObjectError> globalErrors = result.getGlobalErrors();
			List<FieldError> fieldErrors = result.getFieldErrors();
			
			logger.info("allError.size() = " + allErrors.size());
			logger.info("allError.size() = " + globalErrors.size());
			logger.info("allError.size() = " + fieldErrors.size());
			
			for(int i = 0; i < allErrors.size(); i++) {
				ObjectError objectError = allErrors.get(i);
				logger.info("allError = " + objectError);
			}
			
			for(int i = 0; i < allErrors.size(); i++) {
				ObjectError objectError = allErrors.get(i);
				logger.info("allError = " + objectError);
			}
			
			for(int i = 0; i < globalErrors.size(); i++) {
				ObjectError objectError = globalErrors.get(i);
				logger.info("globalErrors = " + globalErrors);
			}
			
			for(int i = 0; i < fieldErrors.size(); i++) {
				FieldError fieldError = fieldErrors.get(i);
				
				logger.info("fieldErrors = " + fieldErrors);
				logger.info("fieldError.getDefaultMessage() = " + fieldError.getDefaultMessage());
			}
			
			return "registerForm";
		}
		
		logger.info("member.getUserId() = " + member.getUserId());
		logger.info("member.getGender() = #" + member.getGender() + "#");
		
		return "success";
	}
	*/
	
	//입력값 검증 규픽
	/*
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	//입력값 검증을 할 도메인 클래스에 @Validated를 지정한다.
	public String register(@Validated Member member, BindingResult result) {
		logger.info("register");
		
		//입력값 검증 에러가 발생한 경우 true를 반환한다.
		logger.info("result.hasErrors() = " + result.hasErrors());
		
		//입력갑 검증 후 BindingResult가 제공하는 메서드를 이용하여 검사 결과를 확인
		if(result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			List<ObjectError> globalErrors = result.getGlobalErrors();
			List<FieldError> fieldErrors = result.getFieldErrors();
			
			logger.info("allError.size() = " + allErrors.size());
			logger.info("allError.size() = " + globalErrors.size());
			logger.info("allError.size() = " + fieldErrors.size());
			
			for(int i = 0; i < allErrors.size(); i++) {
				ObjectError objectError = allErrors.get(i);
				logger.info("allError = " + objectError);
			}
			
			for(int i = 0; i < allErrors.size(); i++) {
				ObjectError objectError = allErrors.get(i);
				logger.info("allError = " + objectError);
			}
			
			for(int i = 0; i < globalErrors.size(); i++) {
				ObjectError objectError = globalErrors.get(i);
				logger.info("globalErrors = " + globalErrors);
			}
			
			for(int i = 0; i < fieldErrors.size(); i++) {
				FieldError fieldError = fieldErrors.get(i);
				
				logger.info("fieldErrors = " + fieldErrors);
				logger.info("fieldError.getDefaultMessage() = " + fieldError.getDefaultMessage());
			}
			
			return "registerForm";
		}
		
		logger.info("member.getUserId() = " + member.getUserId());
		logger.info("member.getGender() = #" + member.getGender() + "#");
		
		return "success";
	}

	@RequestMapping(value = "registerForm01", method = RequestMethod.GET)
	public String registerForm01(Model model) {
		logger.info("registerForm01");
		
		model.addAttribute("member", new Member());
		
		return "registerForm";
	}
	
	@RequestMapping(value = "/registerForm02", method = RequestMethod.GET)
	public String registerForm02(Model model) {
		logger.info("registerForm02");
		
		Member member = new Member();
		
		member.setPassword("1234");
		member.setEmail("aaa@ccc.com");
		member.setUserName("홍길동");
		
		member.setGender("female");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1988);
		cal.set(Calendar.MONTH, 10);
		cal.set(Calendar.DAY_OF_MONTH, 7);
		
		member.setDateOfBirth(cal.getTime());
		
		model.addAttribute("member", member);

		return "registerForm";
	}
	*/
	
	//중첩된 자바빈즈 입력값 검증
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@Validated Member member, BindingResult result) {
		logger.info("register");
		
		if(result.hasErrors()) {
			return "registerForm";
		}
		
		logger.info("member.getUserId() = " + member.getUserId());
		logger.info("member.getDateOfBirth() = " + member.getDateOfBirth());
		
		Address address = member.getAddress();
		
		if(address != null) {
			logger.info("address != null address.getPostCode() = " + address.getPostCode());
			logger.info("address != null address.getLocation() = " + address.getLocation());
		}
		else {
			logger.info("address == null");
		}
		
		List<Card> cardList = member.getCardList();
		
		if(cardList != null) {
			logger.info("cardList != null = " + cardList.size());
			
			for(int i = 0; i <cardList.size(); i++) {
				Card card = cardList.get(i);
				logger.info("card.getNo() = " + card.getNo());
				logger.info("card.getValidMonth() = " + card.getValidMonth());
			}
		}
		
		return "success";
	}

	@RequestMapping(value = "registerForm01", method = RequestMethod.GET)
	public String registerForm01(Model model) {
		logger.info("registerForm01");
		
		model.addAttribute("member", new Member());
		
		return "registerForm";
	}
	
	@RequestMapping(value = "/registerForm02", method = RequestMethod.GET)
	public String registerForm02(Model model) {
		logger.info("registerForm02");
		
		Member member = new Member();
		
		member.setPassword("1234");
		member.setEmail("aaa@ccc.com");
		member.setUserName("홍길동");
		
		Address address = new Address();
		address.setPostCode("080908");
		address.setLocation("seoul");
		
		member.setAddress(address);
		
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
		
		cal.set(Calendar.YEAR, 1988);
		cal.set(Calendar.MONTH, 10);
		cal.set(Calendar.DAY_OF_MONTH, 7);
		
		member.setDateOfBirth(cal.getTime());		
		
		model.addAttribute("member", member);
		
		return "registerForm";
	}
}
