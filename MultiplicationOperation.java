package ca.bcit.comp2522.lab04;

/**
 * MultiplicationOperation.
 *
 * @author Jihoon Yoon
 * @version 2023-02-11
 */
public class MultiplicationOperation extends AbstractOperation {
    // Star symbol for multiplication
    static final char MULTIPLICATION_SYMBOL = '*';

    /**
     * MultiplicationOperation constructor.
     */
    public MultiplicationOperation() {
        super(MULTIPLICATION_SYMBOL);
    }

    /**
     * Multiplies the left operand by the right operand.
     *
     * @param operandA Left operand
     * @param operandB Right operand
     * @return Result of multiplication of the left operand with the right operand
     */
    public int perform(int operandA, int operandB) {
        return operandA * operandB;
    }
}
