package Calculator;

public class Operand extends Token{

    private int value;

    @Override
    public void accept(CalculatorVisitor visitor) {
        visitor.visit(this);
    }

    public int getValue(){
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}