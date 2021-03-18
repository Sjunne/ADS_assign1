package UnitTesting;

import Calculator.*;
import Client.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CalcutorTests {
    private Calculator calculator;
    private Client client;
    private ArrayList<Token> tokenArrayList;

    @BeforeEach
    void setUp() {
        calculator = new CalculatorVisitor();
        client = new Client();
        tokenArrayList = new ArrayList<>();
    }

    /**
     * Easy calculations, with 1 iteration on the stack
     */
    @Test
    void easyCalculationWithAddition()
    {
        Operand operand1 = new Operand();
        Operand operand2 = new Operand();
        Operator operator1 = new Operator();
        operand1.setValue(2);
        operand2.setValue(2);
        operator1.setOperation(Operation.PLUS);

        tokenArrayList.add(operand1);
        tokenArrayList.add(operand2);
        tokenArrayList.add(operator1);

        try {
            Assertions.assertEquals((operand1.getValue() + operand2.getValue()), client.evaluateExpression(tokenArrayList));
        } catch (Calculator.MalformedExpressionException e) {
            e.printStackTrace();
        }
    }
    @Test
    void easyCalculationWithSubtraction()
    {
        Operand operand1 = new Operand();
        Operand operand2 = new Operand();
        Operator operator1 = new Operator();
        operand1.setValue(2);
        operand2.setValue(2);
        operator1.setOperation(Operation.MINUS);

        tokenArrayList.add(operand1);
        tokenArrayList.add(operand2);
        tokenArrayList.add(operator1);

        try {
            Assertions.assertEquals((operand1.getValue() - operand2.getValue()), client.evaluateExpression(tokenArrayList));
        } catch (Calculator.MalformedExpressionException e) {
            e.printStackTrace();
        }
    }
    @Test
    void easyCalculationWithDivision()
    {
        Operand operand1 = new Operand();
        Operand operand2 = new Operand();
        Operator operator1 = new Operator();
        operand1.setValue(2);
        operand2.setValue(2);
        operator1.setOperation(Operation.DIVIDERE);

        tokenArrayList.add(operand1);
        tokenArrayList.add(operand2);
        tokenArrayList.add(operator1);

        try {
            Assertions.assertEquals((operand1.getValue() / operand2.getValue()), client.evaluateExpression(tokenArrayList));
        } catch (Calculator.MalformedExpressionException e) {
            e.printStackTrace();
        }
    }
    @Test
    void easyCalculationWithMultiply()
    {
        Operand operand1 = new Operand();
        Operand operand2 = new Operand();
        Operator operator1 = new Operator();
        operand1.setValue(2);
        operand2.setValue(2);
        operator1.setOperation(Operation.GANGE);

        tokenArrayList.add(operand1);
        tokenArrayList.add(operand2);
        tokenArrayList.add(operator1);

        try {
            Assertions.assertEquals((operand1.getValue() * operand2.getValue()), client.evaluateExpression(tokenArrayList));
        } catch (Calculator.MalformedExpressionException e) {
            e.printStackTrace();
        }
    }


    /**
     * Easy calculations, with 2 iteration on the stack
     */
    @Test
    void mediumCalculationWithAddition()
    {
        Operand operand1 = new Operand();
        Operand operand2 = new Operand();
        Operator operator1 = new Operator();
        Operand operand3 = new Operand();
        Operator operator2 = new Operator();
        operand1.setValue(2);
        operand2.setValue(2);
        operand3.setValue(4);
        operator2.setOperation(Operation.PLUS);
        operator1.setOperation(Operation.PLUS);

        tokenArrayList.add(operand1);
        tokenArrayList.add(operand2);
        tokenArrayList.add(operator1);
        tokenArrayList.add(operand3);
        tokenArrayList.add(operator2);

        try {
            Assertions.assertEquals(8, client.evaluateExpression(tokenArrayList));
        } catch (Calculator.MalformedExpressionException e) {
            e.printStackTrace();
        }
    }
    @Test
    void mediumCalculationWithSubtraction()
    {
        Operand operand1 = new Operand();
        Operand operand2 = new Operand();
        Operator operator1 = new Operator();
        Operand operand3 = new Operand();
        Operator operator2 = new Operator();
        operand1.setValue(2);
        operand2.setValue(2);
        operand3.setValue(4);
        operator2.setOperation(Operation.MINUS);
        operator1.setOperation(Operation.MINUS);

        tokenArrayList.add(operand1);
        tokenArrayList.add(operand2);
        tokenArrayList.add(operator1);
        tokenArrayList.add(operand3);
        tokenArrayList.add(operator2);

        try {
            Assertions.assertEquals(-4, client.evaluateExpression(tokenArrayList));
        } catch (Calculator.MalformedExpressionException e) {
            e.printStackTrace();
        }
    }
    @Test
    void mediumCalculationWithDivision()
    {
        Operand operand1 = new Operand();
        Operand operand2 = new Operand();
        Operator operator1 = new Operator();
        Operand operand3 = new Operand();
        Operator operator2 = new Operator();
        operand1.setValue(2);
        operand2.setValue(2);
        operand3.setValue(4);
        operator2.setOperation(Operation.DIVIDERE);
        operator1.setOperation(Operation.DIVIDERE);

        tokenArrayList.add(operand1);
        tokenArrayList.add(operand2);
        tokenArrayList.add(operator1);
        tokenArrayList.add(operand3);
        tokenArrayList.add(operator2);

        //svaret er egentlig 0.25, men da vi ikke vil ændre i "getResult" så vil den ikke kunne håndtere det
        try {
            Assertions.assertEquals(0, client.evaluateExpression(tokenArrayList));
        } catch (Calculator.MalformedExpressionException e) {
            e.printStackTrace();
        }
    }
    @Test
    void mediumCalculationWithMultiply()
    {
        Operand operand1 = new Operand();
        Operand operand2 = new Operand();
        Operator operator1 = new Operator();
        Operand operand3 = new Operand();
        Operator operator2 = new Operator();
        operand1.setValue(2);
        operand2.setValue(2);
        operand3.setValue(4);
        operator2.setOperation(Operation.GANGE);
        operator1.setOperation(Operation.GANGE);

        tokenArrayList.add(operand1);
        tokenArrayList.add(operand2);
        tokenArrayList.add(operator1);
        tokenArrayList.add(operand3);
        tokenArrayList.add(operator2);

        try {
            Assertions.assertEquals(16, client.evaluateExpression(tokenArrayList));
        } catch (Calculator.MalformedExpressionException e) {
            e.printStackTrace();
        }
    }

    @Test
    void calculationWithMultipleOperands()
    {
        Operand operand1 = new Operand();
        Operand operand2 = new Operand();
        Operator operator1 = new Operator();
        Operand operand3 = new Operand();
        Operator operator2 = new Operator();
        operand1.setValue(2);
        operand2.setValue(2);
        operand3.setValue(4);
        operator1.setOperation(Operation.DIVIDERE);
        operator2.setOperation(Operation.GANGE);

        tokenArrayList.add(operand1);
        tokenArrayList.add(operand2);
        tokenArrayList.add(operator1);
        tokenArrayList.add(operand3);
        tokenArrayList.add(operator2);

        try {
            Assertions.assertEquals(4, client.evaluateExpression(tokenArrayList));
        } catch (Calculator.MalformedExpressionException e) {
            e.printStackTrace();
        }
    }

    @Test
    void calculationWithMultipleOperands2()
    {
        Operand operand1 = new Operand();
        Operand operand2 = new Operand();
        Operator operator1 = new Operator();
        Operand operand3 = new Operand();
        Operator operator2 = new Operator();
        Operand operand4 = new Operand();
        Operator operator3 = new Operator();
        Operand operand5 = new Operand();
        Operator operator4 = new Operator();
        operand1.setValue(2);
        operand2.setValue(2);
        operand3.setValue(4);
        operand4.setValue(10);
        operand5.setValue(16);

        operator1.setOperation(Operation.DIVIDERE);
        operator2.setOperation(Operation.GANGE);
        operator3.setOperation(Operation.MINUS);
        operator4.setOperation(Operation.PLUS);

        tokenArrayList.add(operand1);
        tokenArrayList.add(operand2);
        tokenArrayList.add(operator1);
        tokenArrayList.add(operand3);
        tokenArrayList.add(operator2);
        tokenArrayList.add(operand4);
        tokenArrayList.add(operator3);
        tokenArrayList.add(operand5);
        tokenArrayList.add(operator4);


        try {
            Assertions.assertEquals(10, client.evaluateExpression(tokenArrayList));
        } catch (Calculator.MalformedExpressionException e) {
            e.printStackTrace();
        }
    }

    @Test
    void MalformedExpression1()
    {
        Operand operand1 = new Operand();
        Operand operand2 = new Operand();
        Operator operator1 = new Operator();
        Operand operand3 = new Operand();
        Operand operand4 = new Operand();
        operand1.setValue(1);
        operand2.setValue(1);
        operator1.setOperation(Operation.MINUS);
        operand3.setValue(1);
        operand4.setValue(1);
        Operator operator2 = new Operator();
        operator2.setOperation(Operation.MINUS);

        tokenArrayList.add(operand1);
        tokenArrayList.add(operand2);
        tokenArrayList.add(operator1);
        tokenArrayList.add(operand3);
        tokenArrayList.add(operand4);
        tokenArrayList.add(operator2);

        Assertions.assertThrows(Calculator.MalformedExpressionException.class, () ->
            client.evaluateExpression(tokenArrayList));
        }

    @Test
    void tokenListIsEmpty()
    {
        Assertions.assertThrows(Calculator.MalformedExpressionException.class, () ->
            client.evaluateExpression(tokenArrayList));
    }

    @Test
    void tokenListHas1Token()
    {
        tokenArrayList.add(new Operator());
        Assertions.assertThrows(Calculator.MalformedExpressionException.class, () ->
            client.evaluateExpression(tokenArrayList));
    }

    @Test
    void tokenListHas2Tokens()
    {
        tokenArrayList.add(new Operator());
        tokenArrayList.add(new Operator());
        Assertions.assertThrows(Calculator.MalformedExpressionException.class, () ->
            client.evaluateExpression(tokenArrayList));
    }

    @Test
    void tokenList2OperatorInARow()
    {
        Operator operator = new Operator();
        Operator operator2 = new Operator();
        operator.setOperation(Operation.GANGE);
        operator2.setOperation(Operation.MINUS);
        tokenArrayList.add(new Operand());
        tokenArrayList.add(new Operand());
        tokenArrayList.add(operator);
        tokenArrayList.add(operator2);
        Assertions.assertThrows(Calculator.MalformedExpressionException.class, () ->
            client.evaluateExpression(tokenArrayList));
    }


    }

