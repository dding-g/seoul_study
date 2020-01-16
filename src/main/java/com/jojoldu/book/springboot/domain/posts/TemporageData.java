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
public class TemporageData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 65536, nullable = false)
    private String key;

    @Column(length = 65536, nullable = false)
    private String value;

    @Column
    @CreationTimestamp
    private LocalDateTime create_time;


    @Builder
    public TemporageData(String key, String value){
        this.key = key;
        this.value = value;
    }
}
