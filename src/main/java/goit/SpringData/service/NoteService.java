package goit.SpringData.service;

import goit.SpringData.entity.Note;
import goit.SpringData.repository.NoteRepository;
import lombok.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.*;

//@Service
//@Getter
//@Setter
//@Data
//@RequiredArgsConstructor
//@NoArgsConstructor

public class NoteService implements INoteService {

    private NoteRepository repository;

    @Override
    public List<Note> listAll() {
        return repository.findAll();
    }

    @Override
    public void add(Note note) {
        repository.save(note);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Note note) {
        repository.save(note);
    }

    @Override
    public Optional<Note> getById(long id) {
        return repository.findById(id);
    }

    public NoteRepository getRepository() {
        return repository;
    }

    public void setRepository(NoteRepository noteRepository) {
        this.repository=noteRepository;
    }

}
