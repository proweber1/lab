package cinema;

import java.util.Objects;

/**
 * Объект сеанса
 */
public class Seance implements Comparable<Seance> {
    private Movie movie;
    private Time startTime;
    private Time endTime;

    /**
     * Конечное время вычисляется автоматически
     *
     * @param movie Объект фильма
     * @param startTime Время с которого начинается сеанс
     */
    Seance(Movie movie, Time startTime) {
        this.movie = movie;
        this.startTime = startTime;
        this.endTime = startTime.plus(movie.getDuration());
    }

    /**
     * @return Фильм этого сеанса
     */
    Movie getMovie() {
        return movie;
    }

    /**
     * @param movie Фильм этого сеанса
     */
    void setMovie(Movie movie) {
        this.movie = movie;
    }

    /**
     * @return Время начала сеанса
     */
    Time getStartTime() {
        return startTime;
    }

    /**
     * @param startTime Время начала сеанса
     */
    void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    /**
     * @return Время конца сеанса
     */
    Time getEndTime() {
        return endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seance seance = (Seance) o;
        return Objects.equals(movie, seance.movie) &&
               Objects.equals(startTime, seance.startTime) &&
               Objects.equals(endTime, seance.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movie, startTime, endTime);
    }

    @Override
    public int compareTo(Seance o) {
        return startTime.compareTo(o.getStartTime());
    }

    @Override
    public String toString() {
        return String.format("Начало сеанса %s, конец сеанса %s, фильм %s", startTime, endTime, movie);
    }
}
