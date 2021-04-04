package generators;

import person.Fio;

import static utils.FileReader.getLinesFromFile;
import static utils.MyMath.getDigitsSum;

public class FioGenerator implements Generator<Fio> {

    private String lastName;
    private String firstName;
    private String middleName;

    /**
     * ФИО берутся из соответствующих файлов по индексу в листе:
     * Фамилия - сумма цифр в коде
     * Имя - сумма первых двух цифр
     * Отчество - сумма последних двух цифр.
     *
     * @param code код для генерации
     */
    @Override
    public final void generateParams(final int code) {
        final int lastNameIndex = getDigitsSum(code);
        final String sex = (lastNameIndex % 2 == 0) ? "f" : "m";
        lastName = getLinesFromFile("lastNames_" + sex).get(lastNameIndex);
        firstName = getLinesFromFile("names_" + sex).get(getDigitsSum(code / 100));
        middleName = getLinesFromFile("middleNames_" + sex).get(getDigitsSum(code % 100));
    }

    @Override
    public final Fio buildResponse() {
        return new Fio(lastName, firstName, middleName);
    }

}

