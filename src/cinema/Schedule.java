package cinema;

import java.util.Set;
import java.util.TreeSet;

public class Schedule {

    /**
     * Множество сеансов в расписании на день
     */
    private final Set<Seance> seances;

    Schedule() {
        seances = new TreeSet<>();
    }

    /**
     * @param seance Модель сеанса
     */
    void addSeance(Seance seance) {
        seances.add(seance);
    }

    /**
     * @param seance Модель сеанса
     */
    void removeSeance(Seance seance) {
        seances.remove(seance);
    }

    /**
     * Удаляет фильм из всех сеансов
     *
     * @param movie Модель фильма
     */
    void removeMovie(Movie movie) {
        seances.removeIf(seance -> seance.getMovie().equals(movie));
    }

    @Override
    public String toString() {
        return seances.toString();
    }
}
