package com.example.restfulwebservice.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="USER_1")
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    @Size(min=2, message = "Name은 2글자 이상 입력해 주세요.")
    private String name;
    @Past
    private Date join_Date;

    private String password;
    private String ssn;

    // 한명의 사용자가 여러 포스트를 저장할수 있음
    // 데이터간의 관계 정의
    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Post> post;


    public User(int i, String name, Date join_Date, String password, String ssn) {
        this.id = id;
        this.name = name;
        this.join_Date = join_Date;
        this.password = password;
        this.ssn = ssn;
    }
}
