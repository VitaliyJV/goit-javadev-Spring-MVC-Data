package goit.SpringData.service;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import goit.SpringData.entity.Note;
import goit.SpringData.repository.NoteRepository;

@Transactional
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
