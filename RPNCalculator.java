package ca.bcit.comp2522.lab04;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.util.Scanner;

/**
 * RPNCalculator.
 *
 * @author Jihoon Yoon
 * @version 2023-02-11
 */
public class RPNCalculator {
    // Minimum size constant.
    static final int MIN_SIZE = 2;
    // Stack used for this calculation.
    private final Stack stack;

    /**
     * RPNCalculator constructor.
     *
     * @param stackSize size of the stack
     * @throws IllegalArgumentException if the size of the stack is less than the minimum size
     */
    public RPNCalculator(int stackSize) {
        if (stackSize < MIN_SIZE) {
            throw new IllegalArgumentException();
        } else {
            this.stack = new Stack(stackSize);
        }
    }

    /**
     * Reads the values in the stack.
     *
     * @param formula calculator inputs
     * @return result of the calculation
     * @throws IllegalArgumentException if the formula is null or empty
     */
    public int processFormula(final String formula) {
        if (formula == null || formula.length() == 0) {
            throw new IllegalArgumentException();
        } else {
            Scanner sc = new Scanner(formula);
            while (sc.hasNext()) {
                if (sc.hasNextInt()) {
                    this.stack.push(sc.nextInt());
                } else {
                    // Gets the next character
                    Operation op = getOperation(sc.next().charAt(0));
                    this.perform(op);
                }
            }
        }
        return this.getResult();
    }

    /**
     * Selects the operation the symbol uses.
     *
     * @param symbol operation symbol
     * @return operation that the symbol uses
     * @throws IllegalArgumentException if the symbol given is not +, -, *, /
     */
    private Operation getOperation(final char symbol) {
        return switch (symbol) {
            case '+' -> new AdditionOperation();
            case '-' -> new SubtractionOperation();
            case '*' -> new MultiplicationOperation();
            case '/' -> new DivisionOperation();
            default -> throw new IllegalArgumentException(Character.toString('c'));
        };
    }

    /**
     * Performs an operation.
     *
     * @param operation specified operation
     */
    private void perform(final Operation operation) {
        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null!");
        } else {
            int operandRight = stack.pop();
            int operandLeft = stack.pop();
            int result = operation.perform(operandLeft, operandRight);
            stack.push(result);
        }
    }

    /**
     * Gets the result of the calculation.
     *
     * @return result of the calculation
     */
    public int getResult() {
        return stack.peek();
    }

    /**
     * Drives the program by evaluating the RPN calculation provided as
     * a command line argument.
     *
     * Example usage: RPNCalculator 10 "1 2 +"
     *
     * Note that the formula MUST be placed inside of double quotes.
     *
     * @param argv - the command line arguments are the size of the Stack
     * to be created followed by the expression to evaluate.
     */
    public static void main(final String[] argv) {
        // Checks for correct number of command line arguments.
        if (argv.length != 2) {
            System.err.println("Usage: Main <stack size> <formula>");
            System.exit(1);
        }
        // Initializes stack and RPNCalculator.
        final int stackSize = Integer.parseInt(argv[0]);
        final RPNCalculator calculator = new RPNCalculator(stackSize);
        try {
            System.out.println("[" + argv[1] + "] = "
                    + calculator.processFormula(argv[1]));
        } catch (final IllegalArgumentException ex) {
            System.err.println("formula can only contain integers, +, -, *, and /");
        } catch (final BufferOverflowException ex) {
            System.err.println("too many operands in the formula, increase the stack size");
        } catch (final BufferUnderflowException ex) {
            System.err.println("too few operands in the formula");
        }
    }
}
