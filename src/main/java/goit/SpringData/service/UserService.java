package goit.SpringData.service;

import goit.SpringData.entity.User;
import goit.SpringData.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepo uRepository;

    public UserService(UserRepo uRepository) {
        this.uRepository = uRepository;
    }


    public List<User> listAllUsers() {
        return uRepository.findAll();
    }


    public void addUser(User user) {
        uRepository.save(user);
    }


    public void deleteUserById(long id) {
        uRepository.deleteById(id);
    }


    public void updateUser(User user) {
        uRepository.save(user);
    }


    public Optional<User> getUserById(long id) {
        return uRepository.findById(id);
    }

    public UserRepo getURepository() {
        return uRepository;
    }
}
