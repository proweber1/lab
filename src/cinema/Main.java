package cinema;

public class Main {
    public static void main(String[] args) {
        final Time cinemaOpenTime = Time.from(9, 0);
        final Time cinemaCloseTime = Time.from(22, 0);

        final Movie movie = new Movie("Силиконновая долина", Time.from(1, 40));
        final Seance seance = new Seance(movie, Time.from(10, 0));

        final Cinema cinema = new Cinema(cinemaOpenTime, cinemaCloseTime);
        cinema.addSeance(seance);

        final Movie movie1 = new Movie("Беты", Time.from(1, 20));
        cinema.addMovie(movie1, Time.from(11, 10));

        cinema.removeSeance(seance, "MONDAY");

        System.out.println(cinema);
        cinema.removeMovie(movie);

        System.out.println("-----------------------");
        System.out.println(cinema);
    }
}

