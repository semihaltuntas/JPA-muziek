package be.vdab.muziek.albums;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ArtistNietGevonden extends RuntimeException {
    public ArtistNietGevonden() {
        super("Artist niet gevonden");
    }
}
