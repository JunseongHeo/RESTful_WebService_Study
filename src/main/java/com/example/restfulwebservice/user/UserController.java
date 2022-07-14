package com.example.restfulwebservice.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    private UserDaoService service;

    // 생성자 통해서 의존성 주입
    public UserController(UserDaoService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retreveUsers() {
        return service.findAll();
    }

    // Get /user/1 or /user/10 -> String
    @GetMapping("/users/{id}")
    // 인자 데이터타입을 int로 지정해야 주소값을 int로 자동변환해서 받음
    public User retrieveUser(@PathVariable int id) {
        User user = service.findOne(id);
        if( user == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }
        return user;
    }

    // 포스트요청이 들어오면 앞에 있는 URI값이 일치되면 createUser 메서드 실행
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = service.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        User user = service.deleteById(id);
        if ( user == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }
    }
}
