package be.vdab.muziek.albums;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "artiesten")
public class Artiest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String naam;
    @OneToMany (mappedBy = "artiest")
    @OrderBy("naam")
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
