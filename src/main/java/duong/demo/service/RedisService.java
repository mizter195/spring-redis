package duong.demo.service;

import duong.demo.model.User;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

  @Cacheable(value = "user", key = "#userId", unless = "#result.username.length < 10")
  public User test(String userId) {
    User user = new User();
    user.setUserId(userId);
    user.setUsername(userId + "name");
    return user;
  }

  @CachePut(value = "user", key = "#userId", unless = "#result.username == \"\"")
  public User cachePutTest(String userId, String username) {
    User user = new User();
    user.setUserId(userId);
    user.setUsername(username);
    return user;
  }
}
