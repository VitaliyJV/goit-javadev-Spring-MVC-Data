package goit.SpringData.service;

import goit.SpringData.entity.User;
import goit.SpringData.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{
    private final UserRepo uRepository;

    public UserService(UserRepo uRepository) {
        this.uRepository = uRepository;
    }

    public List<User> listAll() {
        return uRepository.findAll();
    }

    public void add(User user) {
        uRepository.save(user);
    }

    public void deleteById(long id) {
        uRepository.deleteById(id);
    }

    public void update(User user) {
        uRepository.save(user);
    }

    public Optional<User> getUser(long id) {
        return uRepository.findById(id);
    }

    public UserRepo getURepository() {
        return uRepository;
    }
}
