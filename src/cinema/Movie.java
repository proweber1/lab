package cinema;

public class Movie {
    private String title;
    private Time duration;

    Movie() {

    }

    /**
     * @param title Название фильма
     * @param duration Продолжительность {@link Time}
     */
    Movie(String title, Time duration) {
        this.title = title;
        this.duration = duration;
    }

    /**
     * @return Название фильма
     */
    String getTitle() {
        return title;
    }

    /**
     * @param title Название фильма
     */
    void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return Продолжительность фильма {@link Time}
     */
    Time getDuration() {
        return duration;
    }

    /**
     * @param duration Продолжительность фильма {@link Time}
     */
    void setDuration(Time duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return String.format("%s, Продолжительность: %s", title, duration);
    }
}
