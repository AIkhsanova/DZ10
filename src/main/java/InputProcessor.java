import person.Person;

public class InputProcessor {

    public final String processInput(final String input) {
        String result;

        if (input.trim().matches("\\d{4}")) {
            // Создаём Person

            final Person person = new Person.Builder(input)
                    .withInitials()
                    .withAppearance()
                    .withPhone()
                    .withPhysical()
                    .build();


            result = person.toString();

        } else {
            result = "Неверный ввод.";
        }
        return result;
    }
}
