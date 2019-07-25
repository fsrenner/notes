package note;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api")
public class NoteController {

    private final NoteRepository repository;

    NoteController(NoteRepository repository) {
        this.repository = repository;
    }

    // Search for note with body matching query word
    @GetMapping(path="notes", params="query")
    List<Note> findNoteByBody(@RequestParam(name = "query", required=false) String body) {
        return repository.findNoteByBody(body);
    }

    // Get all of the notes
    @GetMapping(path="notes")
    List<Note> getAllNotes() {
        return repository.findAll();
    }

    // Post a note
    @PostMapping(path="notes")
    Note addNewNote(@RequestBody Note newNote) {
        return repository.save(newNote);
    }

    // Get a single note by id
    @GetMapping(path="notes/{id}")
    Note getOneNote(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));
    }

    // Update a note
    @PutMapping(path="notes/{id}")
    Note updateNote(@RequestBody Note newNote, @PathVariable Long id) {

        return repository.findById(id)
                .map(note -> {
                    note.setBody(newNote.getBody());
                    return repository.save(note);
                })
                .orElseGet(() -> {
                    newNote.setId(id);
                    return repository.save(newNote);
                });
    }

    // Delete a note
    @DeleteMapping(path="notes/{id}")
    void deleteNote(@PathVariable Long id) {
        repository.deleteById(id);
    }


}
