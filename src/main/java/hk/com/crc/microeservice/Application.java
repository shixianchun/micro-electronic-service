package hk.com.crc.microeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication//SpringBoot启动核心
@EnableConfigurationProperties
@EnableTransactionManagement
@MapperScan("hk.com.crc.microeservice.mapper")
public class Application {
    //启动文件
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

}
