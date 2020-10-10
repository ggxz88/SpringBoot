package org.hdcd.config;


import javax.sql.DataSource;

import org.hdcd.common.security.CustomAccessDeniedHandler;
import org.hdcd.common.security.CustomLoginSuccessHandler;
import org.hdcd.common.security.CustomNoOpPasswordEncoder;
import org.hdcd.common.security.CustomUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@EnableWebSecurity
//스프링 시큐리티 애너테이션
//시큐리티 애너테이션 활성화를 위한 설정
@EnableGlobalMethodSecurity(prePostEnabled=true, securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);
	
	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.info("security config ...");
		
		//접근 제한 설정
		http.authorizeRequests().antMatchers("/board/list").permitAll();
		
		http.authorizeRequests().antMatchers("/board/register").hasRole("MEMBER");
		
		http.authorizeRequests().antMatchers("/notice/list").permitAll();
		
		http.authorizeRequests().antMatchers("/notice/register").hasRole("ADMIN");
		
		//폼 기반 인증 기능을 사용한다.
		//http.formLogin();
		
		//사용자 정의 로그인 페이지
		//사용자가 정의한 로그인 페이지의 URI를 지정한다.
		//http.formLogin().loginPage("/login");
		
		//로그인 성공 처리
		//로그인 성공 후 처리를 담당하는 처리자로 지정한다.
		http.formLogin().loginPage("/login").successHandler(createAuthenticationSuccessHandler());
		
		//로그아웃 처리
		//로그아웃 처리를 위한 URI를 지정하고, 로그아웃한 후에 세션을 무효화한다.
		//http.logout().logoutUrl("/logout").invalidateHttpSession(true);
		
		//자동로그인
		//로그아웃을 하면 자동 로그인에 사용하는 쿠키도 삭제해 주도록 한다.
		http.logout().logoutUrl("/logout").invalidateHttpSession(true).deleteCookies("remember-me", "JSESSION_ID");
		
		//데이터 소스를 지정하고 테이블을 이용해서 기존 로그인 정보를 기록
		//http.rememberMe()
		//.key("hdcd")
		//.tokenRepository(createJDBCRepository())
		//쿠키의 유효 시간을 지정한다.
		//.tokenValidSeconds(60*60*24);
		
		//접근 거부 처리자
		//접근거부 처리자의 URI를 지정
		//http.exceptionHandling().accessDeniedPage("/accessError");
		
		//사용자 정의 접근 거부 처리자
		//등록한 CustomAccessDeniedHandler를 접근 거부 처리자로 지정한다.
		http.exceptionHandling().accessDeniedHandler(createAccessDeniedHandler());
	}
	
	//로그인 처리
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//지정된 아이디와 패스워드로 로그인이 가능하도록 설정한다.
		//auth.inMemoryAuthentication().withUser("member").password("{noop}1234").roles("MEMBER");
		
		//auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("ADMIN");
		
		//JDBC 이용한 인증/인가 처리
		//JDBC 인증 제공자
		//auth.jdbcAuthentication()
		//데이터 소스를 지정한다.
		//.dataSource(dataSource)
		//시용자가 정의한 비밀번호 암호화 처리기를 지정한다.
		//.passwordEncoder(createPasswordEncoder());
		
		//사용자 테이블 이용한 인증/인가 처리
		//스프링 시큐리티 원하는 결과를 반환하는 쿼리를 작성한다.
		/*
		String query1 = "SELECT user_id, user_pw, enabled FROM member WHERE user_id = ?";
		String query2 = "SELECT b.user_id, a.auth FROM member_auth a, member b WHERE a.user_no = b.user_no AND b.user_id = ?";
		
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		//작성한 쿼리를 지정한다.
		.usersByUsernameQuery(query1)
		.authoritiesByUsernameQuery(query2)
		//BCryptPasswordEncoder 비밀번호 암호화 처리기를 지정한다.
		.passwordEncoder(createPasswordEncoder());
		*/
		
		//UserDetailsService 재정의
		//CustomUserDetailsService 빈을 인증 제공자에 지정한다.
		auth.userDetailsService(createUserDetailsService()).passwordEncoder(createPasswordEncoder());
	}
	
	//사용자 정의 접근 거부 처리자
	//CustomAccessDeniedHandler를 으로 등록한다.
	@Bean
	public AccessDeniedHandler createAccessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
	
	//로그인 성공 처리
	
	@Bean
	public AuthenticationSuccessHandler createAuthenticationSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}
	
	//JDBC 이용한 인증/인가 처리
	//사용자가 정의한 비밀번호 암호화 처리기를 빈으로 등록한다.
	/*
	@Bean
	public PasswordEncoder createPasswordEncoder() {
		return new CustomNoOpPasswordEncoder();
	}
	*/
	
	//사용자 테이블 이용한 인증/인가 처리
	//스프링 시큐리티에서 제공되는 BCryptPasswordEncoder 클래스를 빈으로 등록한다.
	@Bean
	public PasswordEncoder createPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//UserDetailsService 재정의
	//스프링 시큐리티의 UserDetailsService를 구현한 클래스를 빈으로 등록한다.
	@Bean
	public UserDetailsService createUserDetailsService() {
		return new CustomUserDetailsService();
	}
	
	
}
