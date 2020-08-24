package cz.zk.springtest2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.ArrayList;

@SpringBootApplication
@EnableScheduling
public class SpringTest2Application {


	public static void main(String[] args) {
		SpringApplication.run(SpringTest2Application.class, args);
	}

}
