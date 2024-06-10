package be.vdab.muziek.albums;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AlbumNietGevondenException extends RuntimeException{
    public AlbumNietGevondenException() {
        super("Albüm niet gevonden");
    }
}
