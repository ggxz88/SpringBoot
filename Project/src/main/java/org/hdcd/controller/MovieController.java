package org.hdcd.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.hdcd.common.domain.CodeLabelValue;
import org.hdcd.common.domain.PageRequest;
import org.hdcd.common.domain.Pagination;
import org.hdcd.common.security.domain.CustomUser;
import org.hdcd.domain.Member;
import org.hdcd.domain.Movie;
import org.hdcd.domain.Reply;
import org.hdcd.domain.Review;
import org.hdcd.service.MovieService;
import org.hdcd.service.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/movie")
public class MovieController {
	
	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private ReviewService reviewService;
	
	@Value("${upload.path}")
	private String uploadPath;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String registerForm(Model model) throws Exception {
		logger.info("Movie RegisterForm");
		
		Movie movie = new Movie();
		
		model.addAttribute(movie);
		
		return "movie/register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String register(Movie movie, RedirectAttributes rttr) throws Exception {
		logger.info("Movie Register");
		
		MultipartFile posterFile = movie.getPoster();
		MultipartFile still1File = movie.getStill1();
		MultipartFile still2File = movie.getStill2();
		MultipartFile still3File = movie.getStill3();
		MultipartFile still4File = movie.getStill4();
		
		String createdPosterFilename = uploadFile(posterFile.getOriginalFilename(), posterFile.getBytes());
		String createdStill1Filename = uploadFile(still1File.getOriginalFilename(), still1File.getBytes());
		String createdStill2Filename = uploadFile(still2File.getOriginalFilename(), still2File.getBytes());
		String createdStill3Filename = uploadFile(still3File.getOriginalFilename(), still3File.getBytes());
		String createdStill4Filename = uploadFile(still4File.getOriginalFilename(), still4File.getBytes());
		
		movie.setPosterUrl(createdPosterFilename);
		movie.setStill1Url(createdStill1Filename);
		movie.setStill2Url(createdStill2Filename);
		movie.setStill3Url(createdStill3Filename);
		movie.setStill4Url(createdStill4Filename);
		
		movieService.register(movie);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/movie/list";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(@ModelAttribute("pgrq") PageRequest pageRequest, Model model) throws Exception {
		logger.info("Movie List");
		
		List<Movie> movieList = movieService.list(pageRequest);
		
		model.addAttribute("list", movieList);
		
		Pagination pagination = new Pagination();
		pagination.setPageRequest(pageRequest);
		
		pagination.setTotalCount(movieService.count(pageRequest));
		
		model.addAttribute("pagination", pagination);
		
		List<CodeLabelValue> searchTypeCodeValueList = new ArrayList<CodeLabelValue>();
		searchTypeCodeValueList.add(new CodeLabelValue("n", "---"));
		searchTypeCodeValueList.add(new CodeLabelValue("t", "Title"));
		searchTypeCodeValueList.add(new CodeLabelValue("c", "Director"));
		searchTypeCodeValueList.add(new CodeLabelValue("tc", "Title OR Director"));
		
		model.addAttribute("searchTypeCodeValueList", searchTypeCodeValueList);
		
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(Integer movieNo, @ModelAttribute("pgrq") PageRequest pageRequest, Model model) throws Exception {
		logger.info("Movie Read");
		
		Movie movie = movieService.read(movieNo);
				
		model.addAttribute(movie);
		
		//댓글
		logger.info("Movie Reviewlist");
		
		List<Review> reviewList = reviewService.list(movieNo);
		
		model.addAttribute("reviewList", reviewList);
			
		model.addAttribute("review", new Review());
		
		return "movie/read";
		
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String removeForm(Integer movieNo, @ModelAttribute("pgrq") PageRequest pageRequest, Model model) throws Exception {
		logger.info("Movie RemoveForm");
		
		Movie movie = movieService.read(movieNo);
		
		model.addAttribute(movie);
		
		return "movie/remove";
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String remove(Movie movie, PageRequest pageRequest, RedirectAttributes rttr) throws Exception {
		logger.info("Movie Remove");
		
		movieService.remove(movie.getMovieNo());
		
		rttr.addAttribute("page", pageRequest.getPage());
		rttr.addAttribute("sizePerPage", pageRequest.getSizePerPage());
		rttr.addAttribute("searchType", pageRequest.getSearchType());
		rttr.addAttribute("keyword", pageRequest.getKeyword());
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/movie/list";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String modifyForm(Integer movieNo, @ModelAttribute("pgrq") PageRequest pageRequest, Model model) throws Exception {
		logger.info("Movie ModifyForm");
		
		Movie movie = movieService.read(movieNo);
								
		model.addAttribute(movie);
		
		return "movie/modify";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String modify(Movie movie, PageRequest pageRequest, RedirectAttributes rttr) throws Exception {
		logger.info("Movie Modify");
		
		MultipartFile posterFile = movie.getPoster();
		
		if(posterFile != null && posterFile.getSize() > 0) {
			String createFilename = uploadFile(posterFile.getOriginalFilename(), posterFile.getBytes());
			
			movie.setPosterUrl(createFilename);
		}
		
		MultipartFile still1File = movie.getStill1();
		
		if(posterFile != null && posterFile.getSize() > 0) {
			String createFilename = uploadFile(still1File.getOriginalFilename(), still1File.getBytes());
			
			movie.setPosterUrl(createFilename);
		}
		
		MultipartFile still2File = movie.getStill2();
		
		if(posterFile != null && posterFile.getSize() > 0) {
			String createFilename = uploadFile(still2File.getOriginalFilename(), still2File.getBytes());
			
			movie.setPosterUrl(createFilename);
		}
		
		MultipartFile still3File = movie.getStill3();
		
		if(posterFile != null && posterFile.getSize() > 0) {
			String createFilename = uploadFile(still3File.getOriginalFilename(), still3File.getBytes());
			
			movie.setPosterUrl(createFilename);
		}
		
		MultipartFile still4File = movie.getStill4();
		
		if(posterFile != null && posterFile.getSize() > 0) {
			String createFilename = uploadFile(still4File.getOriginalFilename(), still4File.getBytes());
			
			movie.setPosterUrl(createFilename);
		}
		
		movieService.modify(movie);
		
		rttr.addAttribute("page", pageRequest.getPage());
		rttr.addAttribute("sizePerPage", pageRequest.getSizePerPage());
		rttr.addAttribute("searchType", pageRequest.getSearchType());
		rttr.addAttribute("keyword", pageRequest.getKeyword());
				
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/movie/list";
	}
	
	private String uploadFile(String originalName, byte[] fileData) throws Exception {
		logger.info("Movie uploadFile");
		
		UUID uid = UUID.randomUUID();
		
		String createdFileName = uid.toString() + "_" + originalName;
		
		File target = new File(uploadPath, createdFileName);
		
		FileCopyUtils.copy(fileData, target);
		
		return createdFileName;
	}
	
	@ResponseBody
	@RequestMapping("/display1")
	public ResponseEntity<byte[]> display1File(Integer movieNo) throws Exception {
		logger.info("Movie Display1");
		
		InputStream in = null;
		
		ResponseEntity<byte[]> entity = null;
		
		String posterFileName = movieService.getPoster(movieNo);
		
		try {
			String formatName = posterFileName.substring(posterFileName.lastIndexOf(".") + 1);
			
			MediaType mType = getMediaType(formatName);
			
			HttpHeaders headers = new HttpHeaders();
			
			in = new FileInputStream(uploadPath + File.separator + posterFileName);
			
			if (mType != null) {
				headers.setContentType(mType);
			}
			
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
	@RequestMapping("/display2")
	public ResponseEntity<byte[]> display2File(Integer movieNo) throws Exception {
		logger.info("Movie Display2");
		
		InputStream in = null;
		
		ResponseEntity<byte[]> entity = null;
		
		String still1FileName = movieService.getStill1(movieNo);
		
		try {
			String formatName = still1FileName.substring(still1FileName.lastIndexOf(".") + 1);
			
			MediaType mType = getMediaType(formatName);
			
			HttpHeaders headers = new HttpHeaders();
			
			in = new FileInputStream(uploadPath + File.separator + still1FileName);
			
			if (mType != null) {
				headers.setContentType(mType);
			}
			
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
	@RequestMapping("/display3")
	public ResponseEntity<byte[]> display3File(Integer movieNo) throws Exception {
		logger.info("Movie Display3");
		
		InputStream in = null;
		
		ResponseEntity<byte[]> entity = null;
		
		String still2FileName = movieService.getStill2(movieNo);
		
		try {
			String formatName = still2FileName.substring(still2FileName.lastIndexOf(".") + 1);
			
			MediaType mType = getMediaType(formatName);
			
			HttpHeaders headers = new HttpHeaders();
			
			in = new FileInputStream(uploadPath + File.separator + still2FileName);
			
			if (mType != null) {
				headers.setContentType(mType);
			}
			
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
	@RequestMapping("/display4")
	public ResponseEntity<byte[]> display4File(Integer movieNo) throws Exception {
		logger.info("Movie Display4");
		
		InputStream in = null;
		
		ResponseEntity<byte[]> entity = null;
		
		String still3FileName = movieService.getStill3(movieNo);
		
		try {
			String formatName = still3FileName.substring(still3FileName.lastIndexOf(".") + 1);
			
			MediaType mType = getMediaType(formatName);
			
			HttpHeaders headers = new HttpHeaders();
			
			in = new FileInputStream(uploadPath + File.separator + still3FileName);
			
			if (mType != null) {
				headers.setContentType(mType);
			}
			
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
	@RequestMapping("/display5")
	public ResponseEntity<byte[]> display5File(Integer movieNo) throws Exception {
		logger.info("Movie Display5");
		
		InputStream in = null;
		
		ResponseEntity<byte[]> entity = null;
		
		String still4FileName = movieService.getStill4(movieNo);
		
		try {
			String formatName = still4FileName.substring(still4FileName.lastIndexOf(".") + 1);
			
			MediaType mType = getMediaType(formatName);
			
			HttpHeaders headers = new HttpHeaders();
			
			in = new FileInputStream(uploadPath + File.separator + still4FileName);
			
			if (mType != null) {
				headers.setContentType(mType);
			}
			
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		
		} catch (Exception e) {
			e.printStackTrace();
			
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		
		} finally {
			in.close();
		}
		
		return entity;
	}
	
	private MediaType getMediaType(String formatName) {
		
		if(formatName != null) {
			if(formatName.equals("JPG")) {
				return MediaType.IMAGE_JPEG;
			}
			
			if(formatName.equals("GIF")) {
				return MediaType.IMAGE_GIF;
			}
			
			if(formatName.equals("PNG")) {
				return MediaType.IMAGE_PNG;
			}
		}
		
		return null;
	}
	
	//리뷰
	
	@RequestMapping(value = "/reviewregister", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_MEMBER')")
	public String reviewregister(Review review, @RequestParam int movieNo, PageRequest pageRequest, Model model, Authentication authentication, RedirectAttributes rttr) throws Exception {
		logger.info("Movie Reviewregister");
		
		CustomUser customUser = (CustomUser)authentication.getPrincipal();
		Member member = customUser.getMember();
		review.setReviewWriter(member.getUserId());
		
		reviewService.register(review);

		rttr.addAttribute("page", pageRequest.getPage());
		rttr.addAttribute("sizePerPage", pageRequest.getSizePerPage());
		rttr.addAttribute("searchType", pageRequest.getSearchType());
		rttr.addAttribute("keyword", pageRequest.getKeyword());
		rttr.addAttribute("movieNo", movieNo);
		
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/movie/read";
	}
	
	@RequestMapping(value = "/reviewremove", method = RequestMethod.GET)
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MEMBER')")
	public void reviewremoveForm(@RequestParam int reviewNo, @RequestParam int movieNo, @ModelAttribute("pgrq") PageRequest pageRequest, Model model) throws Exception {
		logger.info("Movie ReviewremoveForm");
		
		Review review = reviewService.read(reviewNo);
				
		model.addAttribute(review);
	}
	
	@RequestMapping(value = "/reviewremove", method = RequestMethod.POST)
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MEMBER')")
	public String reviewremove(@RequestParam int reviewNo, int movieNo, PageRequest pageRequest, RedirectAttributes rttr) throws Exception {
		logger.info("Movie Reviewremove");
		
		reviewService.remove(reviewNo);
		
		rttr.addAttribute("page", pageRequest.getPage());
		rttr.addAttribute("sizePerPage", pageRequest.getSizePerPage());
		rttr.addAttribute("searchType", pageRequest.getSearchType());
		rttr.addAttribute("keyword", pageRequest.getKeyword());
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/movie/list";
	}
	
	@RequestMapping(value = "/reviewmodify", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_MEMBER')")
	public void reviewmodifyForm(@RequestParam int reviewNo, @RequestParam int movieNo, @ModelAttribute("pgrq") PageRequest pageRequest, Model model) throws Exception {
		logger.info("Movie ReviewmodifyForm");
		
		Review review = reviewService.read(reviewNo);
				
		model.addAttribute(review);
	}
	
	@RequestMapping(value = "/reviewmodify", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_MEMBER')")
	public String reviewmodify(Review review, @RequestParam int movieNo, PageRequest pageRequest, RedirectAttributes rttr) throws Exception {
		logger.info("Movie Reviewmodify");
		
		reviewService.modify(review);
				
		rttr.addAttribute("page", pageRequest.getPage());
		rttr.addAttribute("sizePerPage", pageRequest.getSizePerPage());
		rttr.addAttribute("searchType", pageRequest.getSearchType());
		rttr.addAttribute("keyword", pageRequest.getKeyword());
				
		rttr.addFlashAttribute("msg", "SUCCESS");
				
		return "redirect:/movie/list";
	}
}
