package com.jojoldu.book.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트(){
        //given
        String email = "area409@naver.com";
        String password = "persona33";

        //when
        TemporageResponseDto dto = new TemporageResponseDto(email, password);

        //then
        assertThat(dto.getEmail()).isEqualTo(email);
        assertThat(dto.getPassword()).isEqualTo(password);
    }
}
