package generators;

import person.Physical;

public class PhysGenerator implements Generator<Physical> {

    private int age;
    private int weight;
    private double height;

    /**
     * Физические параметры генерируются по второй цифре кода:
     * Возраст: 10..100
     * Вес: 30..120 кг
     * Рост: 1..1,9 м.
     */
    @Override
    public final void generateParams(final int code) {
        final int i = code % 1000 / 100;
        age = (i + 1) * 10;
        weight = 30 + i * 10;
        height = (100 + i * 10) / 100.00;
    }

    @Override
    public final Physical buildResponse() {
        return new Physical(age, weight, height);
    }


}
