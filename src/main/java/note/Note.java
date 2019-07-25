package note;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
class Note {

    private @Id @GeneratedValue Long id;
    private String body;

    Note(){}

    Note(String body) {
        this.body = body;
    }

}
