package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//<Entity 클래스, PK 타입>
public interface TemporageDataRepository extends JpaRepository<TemporageData, Long> {
    List<TemporageData> findByKey(String key);
}
