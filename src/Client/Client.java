package Client;

import Calculator.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Client {

    private Token token;

    public static int evaluateExpression(ArrayList<Token> tokenList) throws Calculator.MalformedExpressionException {
        CalculatorVisitor visitor = new CalculatorVisitor();

        for (int i = 0; i < tokenList.size(); i++) {
            tokenList.get(i).accept(visitor);
        }

            return visitor.getResult();

    }



    public static void main(String[] args) {
        ArrayList<Token> tokenArrayList = new ArrayList<>();


       /* Operand operand1 = new Operand();
        Operand operand2 = new Operand();
        Operand operand3 = new Operand();
        Operand operand4 = new Operand();
        Operand operand5 = new Operand();
        Operand operand6 = new Operand();
        operand1.setValue(0);
        operand2.setValue(-2);
        operand3.setValue(3);
        operand4.setValue(4);
        operand5.setValue(5);
        operand6.setValue(6);
        Operator operator1 = new Operator();
        Operator operator2 = new Operator();
        Operator operator3 = new Operator();
        Operator operator4 = new Operator();
        operator1.setOperation(Operation.GANGE);
        operator2.setOperation(Operation.DIVIDERE);
        operator3.setOperation(Operation.PLUS);
        operator4.setOperation(Operation.MINUS);

        tokenArrayList.add(operand2);
        tokenArrayList.add(operand2);
        tokenArrayList.add(operator3);
        tokenArrayList.add(operand1);
        tokenArrayList.add(operator2);


        System.out.println(evaluateExpression(tokenArrayList));*/
    }



}