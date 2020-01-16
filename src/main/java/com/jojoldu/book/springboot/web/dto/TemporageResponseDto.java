package com.jojoldu.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter //선언된 모든 필드에 Getter 메서드를 생성해준다.
@RequiredArgsConstructor // 선언된 모든 final 필드가 포함된 생성자를 생성해준다. final이 없는 필드는 생성자에 포함 X
public class TemporageResponseDto {
    private final String key;
    private final String value;
}
