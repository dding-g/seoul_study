package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "temporage_data")
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
