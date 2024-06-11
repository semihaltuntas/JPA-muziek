package be.vdab.muziek.albums;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.time.LocalTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "albums")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String naam;
    private int jaar;
    @Column(unique = true)
    private long barcode;
    private int score;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "artiestId")
    private Artiest artiest;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "labelId")
    private Label label;

    @ElementCollection // Bu anotasyon, bu alanın bir koleksiyon value object'ler içerdiğini belirtir.
    @CollectionTable(name = "tracks",
            joinColumns = @JoinColumn(name = "albumId"))
    private Set<Track> tracks = new LinkedHashSet<>();

    protected Album() {
    }

    public Album(String naam, int jaar, long barcode, int score, Artiest artiest, Label label) {
        this.naam = naam;
        this.jaar = jaar;
        this.barcode = barcode;
        this.score = score;
        this.artiest = artiest;
        this.label = label;
    }

    public LocalTime getTijd() {
        return tracks.stream()
                .map(track -> track.getTijd())
                .reduce(LocalTime.MIN, (albumTijd, trackTijd)
                        -> albumTijd
                        .plusHours(trackTijd.getHour())
                        .plusMinutes(trackTijd.getMinute())
                        .plusSeconds(trackTijd.getSecond()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return barcode == album.barcode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(barcode);
    }

    public void setScore(int score) {
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public int getJaar() {
        return jaar;
    }

    public long getBarcode() {
        return barcode;
    }

    public int getScore() {
        return score;
    }

    public Artiest getArtiest() {
        return artiest;
    }

    public Label getLabel() {
        return label;
    }

    public Set<Track> getTracks() {
        return tracks;
    }
}

