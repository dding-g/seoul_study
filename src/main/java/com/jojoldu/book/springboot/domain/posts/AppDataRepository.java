package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//<Entity 클래스, PK 타입>
public interface AppDataRepository extends JpaRepository<AppData, Long> {
    AppData findByKey(String key);
}
