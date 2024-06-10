package be.vdab.muziek.albums;

import jakarta.persistence.Embeddable;

import java.time.LocalTime;
import java.util.Objects;

@Embeddable
public class Track {
    private String naam;
    private LocalTime tijd;

    public String getNaam() {
        return naam;
    }

    public LocalTime getTijd() {
        return tijd;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Track track &&
                naam.equalsIgnoreCase(track.naam);
    }

    @Override
    public int hashCode() {
        return naam.toLowerCase().hashCode();
    }
}
