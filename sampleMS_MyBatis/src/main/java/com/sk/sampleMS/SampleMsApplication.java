package com.sk.sampleMS;

import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;

import com.sk.sampleMS.domain.sample.model.*;
import com.sk.sampleMS.domain.sample.repository.*;

import springfox.documentation.spring.data.rest.configuration.*;
import springfox.documentation.swagger2.annotations.*;

@EnableSwagger2
@Import(SpringDataRestConfiguration.class)
@SpringBootApplication
public class SampleMsApplication implements CommandLineRunner {

	
    @Autowired
    private FreeBoardRepository freeBoardRepository;
	
	public static void main(String[] args) {
//	    AnnotationAutoMapper.apply("com.sk.sampleMS.domain.sample");
		SpringApplication.run(SampleMsApplication.class, args);
	}
	
	@Override
	 public void run(String... args) throws Exception {
	    System.out.println("frebboard run");
	        FreeBoard freeBoardVO = new FreeBoard();
	        freeBoardVO.setUserName("홍길동");
	        freeBoardVO.setCategory("101");
	        freeBoardVO.setContent("자유게시판 첫 글");
	        freeBoardVO.setTitle("안녕");

	        freeBoardRepository.registBoard(freeBoardVO);   
	}
	

}
