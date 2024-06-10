package be.vdab.muziek.albums;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "labels")
public class Label {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String naam;
    @OneToMany (mappedBy = "label")
    private Set<Album> albums;

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public Set<Album> getAlbums() {
        return albums;
    }
}
