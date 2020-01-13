package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class AppData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 65536, nullable = false)
    private String key;

    @Column(length = 65536, nullable = false)
    private String value;

    @Builder
    public AppData(String key, String value){
        this.key = key;
        this.value = value;
    }
}
