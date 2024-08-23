package com.example.todolist.service;

import com.example.todolist.model.Note;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NoteController {

    @GetMapping("/note/list")
    public String listNotes(Model model) {
        return "note_list";
    }

    @PostMapping("/note/delete")
    public String deleteNote(@RequestParam Long id) {
        return "redirect:/note/list";
    }

    @GetMapping("/note/edit")
    public String editNoteForm(@RequestParam Long id, Model model) {
        return "note_edit";
    }

    @PostMapping("/note/edit")
    public String editNote(@ModelAttribute Note note) {
        return "redirect:/note/list";
    }
}

