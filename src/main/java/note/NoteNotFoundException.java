package note;

class NoteNotFoundException extends RuntimeException {

    NoteNotFoundException(Long id) {
        super("Could not find the note: " + id);
    }

}
