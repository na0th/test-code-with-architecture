package com.example.demo.repository;

import com.example.demo.model.UserStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest(showSql = true)
@Sql("/sql/user-repository-test-data.sql")
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    void findByIdAndStatus_로_유저_데이터를_찾아올_수_있다() {
        //given
        //when
        Optional<UserEntity> result = userRepository.findByIdAndStatus(1, UserStatus.ACTIVE);
        //then
        Assertions.assertThat(result.isPresent()).isTrue();
    }

    @Test
    @DisplayName("설명")
    void findByIdAndStatus_는_데이터가_없으면_Optional_empty_를_내려준다() {
        // given
        //when
        Optional<UserEntity> result = userRepository.findByIdAndStatus(1, UserStatus.ACTIVE);
        // then
        Assertions.assertThat(result.isEmpty()).isFalse();
    }
    


}