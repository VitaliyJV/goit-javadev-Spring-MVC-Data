package goit.spring.data.service;

import java.util.List;
import java.util.Optional;

import goit.spring.data.entity.Note;
import goit.spring.data.repository.NoteRepository;
import org.springframework.stereotype.Service;

@Service
public class NoteService implements INoteService {

    private final NoteRepository repository;

    public NoteService(NoteRepository repository) {
        this.repository = repository;
    }

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

}
