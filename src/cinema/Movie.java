package cinema;

public class Movie {
    private String title;
    private Time duration;

    Movie() {

    }

    Movie(String title, Time duration) {
        this.title = title;
        this.duration = duration;
    }

    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    Time getDuration() {
        return duration;
    }

    void setDuration(Time duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return String.format("%s, Продолжительность: %s", title, duration);
    }
}
