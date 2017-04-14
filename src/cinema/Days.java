package cinema;

public enum Days {
    MONDAY("Понедельник"),
    TUESDAY("Вторник"),
    WEDNESDAY("Среда"),
    THURSDAY("Четверг"),
    FRIDAY("Пятница"),
    SATURDAY("Суббота"),
    SUNDAY("Воскресенье");

    private String name;

    Days(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
