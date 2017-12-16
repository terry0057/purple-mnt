package purple.mnt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


import org.springframework.scheduling.annotation.EnableScheduling;
import purple.mnt.mapper.MssHealthMapper;
import purple.mnt.service.ActionJob;



@ServletComponentScan
@SpringBootApplication
@MapperScan("purple.mnt.mapper")
@EnableScheduling
public class MntApplication {


	public static void main(String[] args) {
		SpringApplication.run(MntApplication.class, args);
	}
}
