package person;

import generators.*;
import person.appearance.Appearance;

public final class Person {

    private String id;
    private Fio fio;
    private Physical phys;
    private Appearance appearance;
    private Phone phone;

    private Person() {
    }

    private static Person instance;

    public static Person getInstance() {
        if (instance == null) {
            instance = new Person();
        }
        return instance;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder()
                .append(id).append("\n")
                .append(fio).append("\n")
                .append(phys).append("\n")
                .append(appearance).append("\n");
        if (phone != null) {
            sb.append(phone);
        } else {
            sb.append("Телефона нет");
        }
        return sb.toString();
    }

    public static final class Builder {
        private final String input;
        private final int intCode;
        private Appearance appearance;
        private Physical physical;
        private Fio fio;
        private Phone phone = null;


        public Builder(final String input) {
            this.input = input;
            this.intCode = Integer.parseInt(input);

        }


        public Builder withInitials() {

            this.fio = new FioGenerator().getParam(intCode, new FioGenerator());

            return this;
        }


        public Builder withAppearance() {
            this.appearance = new AppearanceGenerator().getParam(intCode, new AppearanceGenerator());
            return this;
        }

        public Builder withPhysical() {
            this.physical = new PhysGenerator().getParam(intCode, new PhysGenerator());
            return this;
        }

        public Builder withPhone() {
            if (!input.equals(new StringBuilder(input).reverse().toString())) {
                this.phone = new PhoneGenerator().getParam(intCode, new PhoneGenerator());
            }
            return this;
        }

        public Person build() {
            Person person = Person.getInstance();
            person.id = this.input;
            person.fio = this.fio;
            person.appearance = this.appearance;
            person.phys = this.physical;
            person.phone = this.phone;
            return person;
        }
    }
}