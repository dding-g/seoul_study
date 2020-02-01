package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

//<Entity 클래스, PK 타입>
public interface TemporageDataRepository extends JpaRepository<TemporageData, Long> {
    @Query(value = "SELECT * FROM temporage_data " +
            "WHERE key = :key and " +
            "create_date between to_timestamp(:current_date - 1, 'YYYY-MM-DD') and" +
            "to_timestamp(:current_date, 'YYYY-MM-DD');"
            , nativeQuery = true)
    List<TemporageData> findByKey(String key, LocalDateTime current_date);
}
