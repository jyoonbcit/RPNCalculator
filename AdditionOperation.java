package ca.bcit.comp2522.lab04;

/**
 * AdditionOperation.
 *
 * @author Jihoon Yoon
 * @version 2023-02-11
 */
public class AdditionOperation extends AbstractOperation {
    // Plus symbol for addition
    static final char ADDITION_SYMBOL = '+';

    /**
     * AdditionOperation constructor.
     */
    public AdditionOperation() {
        super(ADDITION_SYMBOL);
    }

    /**
     * Adds both operands.
     *
     * @param operandA Left operand
     * @param operandB Right operand
     * @return Result of addition of both operands
     */
    public int perform(int operandA, int operandB) {
        return operandA + operandB;
    }
}
