package duong.demo.controller;

import duong.demo.model.PutRequest;
import duong.demo.model.User;
import duong.demo.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("redis")
public class RedisController {

  private final RedisService service;

  @GetMapping("/{userId}")
  public User cacheableTest(@PathVariable String userId) {
    return service.test(userId);
  }

  @PutMapping("/{userId}")
  public User cachePutTest(@PathVariable String userId, @RequestBody PutRequest request) {
    return service.cachePutTest(userId, request.getUsername());
  }

  @CacheEvict(value = "user", key = "#userId")
  @DeleteMapping("/{userId}")
  public String cacheEvictTest(@PathVariable String userId) {
    return "Deleted";
  }

  @CacheEvict(value = "user", allEntries = true)
  @DeleteMapping("/all")
  public String cacheDeleteAll () {
    return "Deleted All";
  }
}
