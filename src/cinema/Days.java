package cinema;

/**
 * Перечисление дней недели, чтобы можно было
 * их использовать для управления расписаниями
 */
public enum Days {
    MONDAY("Понедельник"),
    TUESDAY("Вторник"),
    WEDNESDAY("Среда"),
    THURSDAY("Четверг"),
    FRIDAY("Пятница"),
    SATURDAY("Суббота"),
    SUNDAY("Воскресенье");

    private String name;

    /**
     * @param name Человекупонятное имя дня недели
     */
    Days(String name) {
        this.name = name;
    }

    /**
     * @return Имя для недели для отображения
     */
    public String getName() {
        return name;
    }
}
