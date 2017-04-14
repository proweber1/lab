package cinema;

import java.util.Set;
import java.util.TreeSet;

public class Schedule {
    private final Set<Seance> seances;

    Schedule() {
        seances = new TreeSet<>();
    }

    void addSeance(Seance seance) {
        seances.add(seance);
    }

    void removeSeance(Seance seance) {
        seances.remove(seance);
    }

    void removeMovie(Movie movie) {
        seances.removeIf(seance -> seance.getMovie().equals(movie));
    }

    @Override
    public String toString() {
        return seances.toString();
    }
}
