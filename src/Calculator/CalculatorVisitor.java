package Calculator;


import DataStructures.LinkedStack;

public class CalculatorVisitor implements Visitor, Calculator {

    private LinkedStack<Token> tokenStack;

    public CalculatorVisitor() {
        tokenStack = new LinkedStack<Token>();
    }


    @Override
    public int getResult() throws MalformedExpressionException {
        Token pop = tokenStack.pop();
        if (!tokenStack.isEmpty()){
            throw new MalformedExpressionException();
        }
        Operand operand = (Operand) pop;
        return operand.getValue();
    }

    @Override
    public void visit(Operand operand) {
        pushOperand(operand);
    }

    @Override
    public void visit(Operator operator) {
        try {
            performOperation(operator);
        } catch (MalformedExpressionException e) {
            e.printStackTrace();
        }
    }

    private void pushOperand(Operand operand) {
        tokenStack.push(operand);
    }

    private void performOperation(Operator operator) throws MalformedExpressionException {
        Token tempA; //First one
        Token tempB;

        tempB = tokenStack.pop();
        tempA = tokenStack.pop();

        Operand A = (Operand) tempA;
        int valueA = A.getValue();

        Operand B = (Operand) tempB;
        int valueB = B.getValue();

        int sum = 0;

        switch (operator.getOperation()) {

            case PLUS: {
                sum = valueA + valueB;
                break;
            }

            case MINUS: {
                sum = valueA - valueB;
                break;
            }

            case GANGE: {
                sum = valueA * valueB;
                break;
            }

            case DIVIDERE: {
                sum = valueA / valueB;
                break;
            }
        }

        Operand operand = new Operand();
        operand.setValue(sum);
        pushOperand(operand);

    }

}