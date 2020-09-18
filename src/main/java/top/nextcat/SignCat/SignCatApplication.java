package top.nextcat.SignCat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"top.nextcat.SignCat.controller","top.nextcat.SignCat.serviceImpl","top.nextcat.SignCat.runner"})
@MapperScan("top.nextcat.SignCat.mapper")
@SpringBootApplication
public class SignCatApplication {

	public static void main(String[] args) {
		SpringApplication.run(SignCatApplication.class, args);
	}

}
