package goit.spring.data.repository;

import goit.spring.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {
    @Query("select t from User t where t.username = :usrname")
    Optional<User> findByUsername(@Param("usrname") String username);
}
