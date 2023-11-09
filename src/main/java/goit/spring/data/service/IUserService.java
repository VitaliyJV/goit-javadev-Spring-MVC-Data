package goit.spring.data.service;

import goit.spring.data.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IUserService {
    List<User> listAll();
    void add(User user);
    void deleteById(long id);
    void update(User user);
    Optional<User> getUser(long id);

}




