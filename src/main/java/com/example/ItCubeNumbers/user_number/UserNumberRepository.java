package com.example.ItCubeNumbers.user_number;

import com.example.ItCubeNumbers.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserNumberRepository extends JpaRepository<UserNumber, Long> {
    List<UserNumber> findAllByUserAndNumberAndName(User user, String number, String name);
    List<UserNumber> findAllByUserAndNumber(User user, String number);
    List<UserNumber> findAllByUserAndName(User user, String name);
    List<UserNumber> findAllByUser(User user);
}
