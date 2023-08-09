package duong.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class MyRedisApp {

  public static void main(String[] args) {
    SpringApplication.run(MyRedisApp.class);
  }
}
