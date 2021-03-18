package Calculator;

public class Operator extends Token {

    private Operation operation;


    public Operation getOperation(){
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    @Override
    public void accept(CalculatorVisitor visitor) {
        visitor.visit(this);
    }
}
