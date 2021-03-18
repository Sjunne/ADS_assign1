import Calculator.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Client {

    private Token token;

    public static int evaluateExpression(ArrayList<Token> tokenList)
    {
        CalculatorVisitor visitor = new CalculatorVisitor();

        System.out.println("Enter two numbers");

        for (int i = 0; i < tokenList.size(); i++) {
            tokenList.get(i).accept(visitor);
        }
        try {
            return visitor.getResult();
        } catch (Calculator.MalformedExpressionException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        ArrayList<Token> tokenArrayList = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        Operator operator = new Operator();

        for (int i = 0; i <= 1; i++) {
            Operand operand = new Operand();
            operand.setValue(in.nextInt());
            tokenArrayList.add(operand);
        }

        operator.setOperation(Operation.GANGE);
        tokenArrayList.add(operator);


        System.out.println(evaluateExpression(tokenArrayList));
    }

}