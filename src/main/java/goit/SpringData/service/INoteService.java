package goit.SpringData.service;

import goit.SpringData.entity.Note;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface INoteService {
    List<Note> listAll();
    void add(Note note);
    void deleteById(long id);
    void update(Note note);
    Optional<Note> getById(long id);
}
