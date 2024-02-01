package com.project.mall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration//스프링의 환경설정 파일임을 의미, 여기선 스프링 시큐리티의 설정을 위해  사용됨
@EnableWebSecurity//모든 요청 URL이 스프링 시큐리티의 제어를 받도록 함
				  //내부적으로 SpringSecurityFilterChain이 동작하여 URL 필더가 적용됨

public class SecurityConfig{
	
	
	
	
		//특정http 요청에 대한 웹 기반 보안 구성
	 	@Bean
	    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//       authorizeHttpRequests 메서드는 HTTP 요청에 대한 권한 설정을 지정하는 부분
//	     requestMatchers 는 특정 요청 매처(RequestMatcher)를 지정할 때 사용된다. 
//	     여기서는 'new AntPathRequestMatcher("/**")` 를 사용하여 모든 경로('/**') 에 대한 설정을 지정하고 있다.
//		 permitAll() 은 해당 요청에 대한 모든 사용자에게 접근 권한을 부여한다는 것을 의미한다. 즉 로그인 여부와 상관없이 누구나 해당 URL 에 접근할 수 있다. 
//		 *이 코드는 인증을 필요로 하지 않는 모든 요청에 대한 권한을 부여하는데 사용된다.
//
//		 만약 authorizeHttpRequests 블록을 추가하지 않으면 모든 URL 에 대한 접근이 허용되며, 따라서 로그인 없이도 모든 URL 에 접근할 수 있게 된다.
//
//		 정리(URL 접근에 한함)
//		 1) SecurityFilterChain 빈 등록 X
//		 -> 로그인 없이도 모든 URL에 대한 접근 권한 허용
//		 2) SecurityFilterChain 빈 등록 O, authorizeHttpRequests 블록 추가 X
//		 -> 로그인 없이도 모든 URL에 대한 접근 권한 허용
//		 3) SecurityFilterChain 빈 등록 O, authorizeHttpRequests 블록 추가 O
//		 -> 특정 URL 에 대해 접근 권한을 설정할 수 있게 됨
		 
//		 formLogin 메서드는 스프링 시큐리티의 로그인 설정을 구성하는 부분이다. 
//		 .loginpPage 는 로그인 페이지의 URL 을 지정하는 부분이다.
//		 사용자가 로그인을 시도할때 redirection 되는 로그인 페이지의 URL을 '/user/login' 으로 지정하고 있다. 
//		 (MVC 패턴 사용 시) 해당 URL 을 Controller 에서 아래와 같이 로그인 폼 html 파일과 매핑시켜주면 된다.
//
//		 defaultSuccessUrl 메서드는 로그인 성공 후 이동할 페이지의 URL 을 지정하는 부분이다.
		 
		 
		 
	        http
	                .authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
	                        .requestMatchers(new AntPathRequestMatcher("/**")).permitAll()) 
	                .formLogin((formLogin)-> formLogin //form기반의 로그인 설정
	                        .loginPage("/user/login") //로그인페이지 url을 넣을것
	                        .defaultSuccessUrl("/"))// 로그인 성공 후 리다이렉트할 주소
	                .logout((logout) -> logout
	                        .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
	                        .logoutSuccessUrl("/")
	                        .invalidateHttpSession(true)) 
	        ;
	        return http.build();
	    }
	 
	 @Bean
	    PasswordEncoder passwordEncoder() {//PasswordEncoder는 BCryptPasswordEncoder 의 인터페이스임
	        return new BCryptPasswordEncoder();
	    }
	
	   @Bean
	    //스프링 시큐리티의 인증을 담당, 사용자 인증시 앞에서 작성한 UserSecurityService 와 PasswordEncoder 를 사용
	    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
	        return authenticationConfiguration.getAuthenticationManager();
	    }

}
