package com.example.ItCubeNumbers.user_number;

import com.example.ItCubeNumbers.users.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserNumberService {

    private final UserNumberRepository userNumberRepository;

    public UserNumberService(UserNumberRepository userNumberRepository) {
        this.userNumberRepository = userNumberRepository;
    }

    public List<UserNumber> findAllByUser(User user) {
        return userNumberRepository.findAllByUser(user);
    }

    public void deleteUserNumber(Long id) {
        userNumberRepository.delete(userNumberRepository.findById(id).get());
    }

    public UserNumber findUserNumberById(Long id) {
        return userNumberRepository.findById(id).get();
    }

    public void addUserNumber(UserNumber userNumber) {
        userNumberRepository.save(userNumber);
    }

    public List<UserNumber> findUserNumbersSort(User user, UserNumber userNumber) {
        if (!userNumber.getNumber().equals("") && !userNumber.getName().equals("")) {
            return userNumberRepository.findAllByUserAndNumberAndName(user, userNumber.getNumber(), userNumber.getName());
        } else if (!userNumber.getNumber().equals("")) {
            return userNumberRepository.findAllByUserAndNumber(user, userNumber.getNumber());
        } else if (!userNumber.getName().equals("")) {
            return userNumberRepository.findAllByUserAndName(user, userNumber.getName());
        }
        return userNumberRepository.findAllByUser(user);
    }
}
