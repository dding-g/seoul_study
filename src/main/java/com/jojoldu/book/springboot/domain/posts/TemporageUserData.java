package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="temporage_user_data")
public class TemporageUserData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 128, nullable = false)
    private String email;

    @Column(length = 128, nullable = false)
    private String password;

    @Column(length = 32, nullable = false)
    private String name;

    @Column
    @CreationTimestamp
    private LocalDateTime create_time;


    @Builder
    public TemporageUserData(String email, String password, String name){
        this.email = email;
        this.password = password;
        this.name = name;
    }
}
