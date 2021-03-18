package Calculator;

public interface Calculator {
    int getResult() throws MalformedExpressionException; // TODO: Make the exception

    class MalformedExpressionException extends Exception {
    }
}