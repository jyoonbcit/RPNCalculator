package ca.bcit.comp2522.lab04;

/**
 * SubtractionOperation.
 *
 * @author Jihoon Yoon
 * @version 2023-02-11
 */
public class SubtractionOperation extends AbstractOperation {
    // Minus symbol for subtraction
    static final char SUBTRACTION_SYMBOL = '-';

    /**
     * SubtractionOperation constructor.
     */
    public SubtractionOperation() {
        super(SUBTRACTION_SYMBOL);
    }

    /**
     * Subtracts the left operand with the right operand.
     *
     * @param operandA Left operand
     * @param operandB Right operand
     * @return Result of subtraction of the left operand with the right operand
     */
    public int perform(int operandA, int operandB) {
        return operandA - operandB;
    }
}
