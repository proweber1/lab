package cinema;

public class Time implements Comparable<Time> {

    private final static int MINUTES_MIN = 0;
    private final static int MINUTES_MAX = 59;
    private final static int HOUR_MIN = 0;
    private final static int HOUR_MAX = 24;

    private int min;
    private int hour;

    int getMin() {
        return min;
    }

    void setMin(int min) {
        testRange(min, MINUTES_MAX, MINUTES_MIN, "Минуты должны быть в периоде от 0 до 59");

        this.min = min;
    }

    int getHour() {
        return hour;
    }

    void setHour(int hour) {
        testRange(hour, HOUR_MAX, HOUR_MIN, "Часы должны быть в периоде между 0 и 24");

        this.hour = hour;
    }

    /**
     * Прибавляет к объекту времени еще один объект времени
     *
     * @param time Время которое надо прибавить
     * @return Новое время
     */
    Time plus(Time time) {
        int hours = getHour() + time.getHour();
        int minutes = getMin() + time.getMin();

        return from(hours, minutes);
    }

    /**
     * Проверяет значение на вход в определенный диапазон чисел
     *
     * @param value   Значение которое нужно проверить
     * @param max     Максимально допустимое
     * @param min     Минимально допустимое
     * @param message Сообщение об ошибке
     */
    private void testRange(int value, int max, int min, String message) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Возвращает время в виде 00:00, формат меняться не будет
     *
     * @return Строка времени
     */
    @Override
    public String toString() {
        return String.format("%02d:%02d:00", hour, min);
    }

    /**
     * Создает новый объект времени основываясь на значениях часов и минут
     *
     * @param hour Количество часов
     * @param minutes Количество минут
     * @return Объект времени
     */
    static Time from(int hour, int minutes) {
        final Time result = new Time();
        result.setHour(hour);
        result.setMin(minutes);

        return result;
    }

    /**
     * @param o Объект времени с которым нужно сравнить текущий
     * @return результат сравнения
     */
    @Override
    public int compareTo(Time o) {
        return hour != o.hour ? hour - o.hour : min - o.min;
    }
}
