package be.vdab.muziek.albums;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

@RestController
@RequestMapping("albums")
public class AlbumController {
    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    private record AlbumBeKnopt(String naam, String artiestNaam, int jaar) {
        AlbumBeKnopt(Album album) {
            this(album.getNaam(), album.getArtiest().getNaam(), album.getJaar());
        }
    }

    @GetMapping
    Stream<AlbumBeKnopt> findAllAlbumsMetArtistNaam() {
        return albumService.findAllAlbums()
                .stream()
                .map(AlbumBeKnopt::new);
    }

    private record Detail(String naam, String artiestNaam, int jaar,
                          String labelNaam, LocalTime tijd, Set<Track> tracks) {
        Detail(Album album) {
            this(album.getNaam(), album.getArtiest().getNaam(), album.getJaar(),
                    album.getLabel().getNaam(), album.getTijd(), album.getTracks());
        }
    }

    @GetMapping("{id}")
    Detail findById(@PathVariable long id) {
        return albumService.findById(id)
                .map(Detail::new)
                .orElseThrow(AlbumNietGevondenException::new);
    }
}
