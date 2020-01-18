package com.jojoldu.book.springboot.domain.posts;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor @AllArgsConstructor
@Entity
@Getter
@Setter
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
    private LocalDate create_time;

    @Builder
    public TemporageData(String key, String value){
        this.key = key;
        this.value = value;
    }


}
