package com.example.todolist.service;

import com.example.todolist.model.Note;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoteService {
    private final Map<Long, Note> notes = new HashMap<>();
    private long nextId = 1;

    public List<Note> listAll() {
        return new ArrayList<>(notes.values());
    }

    public Note add(Note note) {
        note.setId(nextId++);
        notes.put(note.getId(), note);
        return note;
    }

    public void deleteById(long id) {
        if (!notes.containsKey(id)) {
            throw new NoSuchElementException("Note not found with id: " + id);
        }
        notes.remove(id);
    }

    public void update(Note note) {
        if (!notes.containsKey(note.getId())) {
            throw new NoSuchElementException("Note not found with id: " + note.getId());
        }
        notes.put(note.getId(), note);
    }

    public Note getById(long id) {
        if (!notes.containsKey(id)) {
            throw new NoSuchElementException("Note not found with id: " + id);
        }
        return notes.get(id);
    }
}
