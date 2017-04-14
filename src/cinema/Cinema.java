package cinema;

import java.util.Map;
import java.util.TreeMap;

public class Cinema {
    private final Map<Days, Schedule> weekSchedule = new TreeMap<Days, Schedule>(){{
        for (Days day: Days.values()) {
            put(day, new Schedule());
        }
    }};

    private final Time open;
    private final Time close;

    /**
     * @param open Начало рабочего дня
     * @param close Конец рабочего дня
     */
    Cinema(Time open, Time close) {
        this.open = open;
        this.close = close;
    }

    /**
     * Добавляет фильм в раписание на каждый день
     *
     * @param movie Фильм который надо добавить
     * @param times Время на которое нужно его добавить
     */
    void addMovie(Movie movie, Time... times) {
        weekSchedule.forEach((k, v) -> {
            for (Time time: times) {
                final Seance seance = new Seance(movie, time);

                checkWorkTime(seance);
                v.addSeance(seance);
            }
        });
    }

    /**
     * Добавляет объект сеанса в расписание на каждый день, может
     * кинуть исключение когда время сеанса выходит за пределы времени
     * работы кинотеатра
     *
     * @param seance Объект сеанса
     */
    void addSeance(Seance seance) {
        checkWorkTime(seance);

        weekSchedule.forEach((k, v) -> v.addSeance(seance));
    }

    /**
     * Проходит по раписанию на каждый день, ищет в расписании фильм и удаляет
     * если он там есть
     *
     * @param movie Фильм который надо удалить
     */
    void removeMovie(Movie movie) {
        weekSchedule.forEach((k, v) -> v.removeMovie(movie));
    }

    /**
     * @param seance Сеанс который надо удалить
     * @param dayName Название дня
     */
    void removeSeance(Seance seance, String dayName) {
        weekSchedule.forEach((k, v) -> {
            if (k.getName().equalsIgnoreCase(dayName)) {
                v.removeSeance(seance);
            }
        });
    }

    /**
     * Проверяет что сеанс входит в рабочее время кинотеатра, если не входит, то ошибка
     *
     * @param seance Сеанс фильма
     */
    private void checkWorkTime(Seance seance) {
        if (seance.getStartTime().compareTo(open) < 0 || seance.getEndTime().compareTo(close) > 0) {
            throw new IllegalArgumentException("Время сеанса должно быть в рабочее время кинотеатра");
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        weekSchedule.forEach((k, v) -> {
            stringBuilder.append(k.getName())
                    .append(" {\n")
                    .append(v)
                    .append("}\n");
        });

        return stringBuilder.toString();
    }
}
