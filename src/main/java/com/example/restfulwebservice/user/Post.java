package com.example.restfulwebservice.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id // 기본키
    @GeneratedValue // 자동생성
    private Integer id;

    private String description;

    // user : post -> 1: (0~N), Main : sub
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY) // 지연로딩. 포스트데이터가 로딩되는 시점에 필요한 사용자데이터를 가지고옴    @JsonIgnore // 제이슨표현할때 무시됨
    private User user;

}
