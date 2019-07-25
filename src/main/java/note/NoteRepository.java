package note;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

interface NoteRepository extends JpaRepository<Note, Long> {

    @Query(value ="SELECT * FROM Note WHERE body LIKE %?1%", nativeQuery = true)
    List<Note> findNoteByBody(String body);

}
