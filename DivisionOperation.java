package ca.bcit.comp2522.lab04;

/**
 * DivisionOperation.
 *
 * @author Jihoon Yoon
 * @version 2023-02-11
 */
public class DivisionOperation extends AbstractOperation {
    // Slash symbol for division
    static final char DIVISION_SYMBOL = '/';

    /**
     * DivisionOperation constructor.
     */
    public DivisionOperation() {
        super(DIVISION_SYMBOL);
    }

    /**
     * Divides the left operand by the right operand.
     *
     * @param operandA Left operand
     * @param operandB Right operand
     * @return Result of division of the left operand with the right operand
     */
    public int perform(int operandA, int operandB) {
        return operandA / operandB;
    }
}
