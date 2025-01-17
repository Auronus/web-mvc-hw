package org.example.config;

import org.example.controller.PostController;
import org.example.repository.PostRepositoryImpl;
import org.example.service.PostService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@Configuration
public class JavaConfig {
  @Bean
  // аргумент метода и есть DI
  // название метода - название бина
  public PostController postController(PostService service) {
    return new PostController(service);
  }

  @Bean
  public PostService postService(PostRepositoryImpl repository) {
    return new PostService(repository);
  }

  @Bean
  public PostRepositoryImpl postRepository() {
    return new PostRepositoryImpl();
  }

  @Bean
  public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
    final var bean = new RequestMappingHandlerAdapter();
    bean.getMessageConverters().add(new GsonHttpMessageConverter());
    return bean;
  }
}
