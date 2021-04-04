package generators;



public interface Generator<T> {

    void generateParams(int code);

    T buildResponse();

    default T getParam(int intCode, Generator<T> generator) {
        generator.generateParams(intCode);
        return generator.buildResponse();
    }


}


