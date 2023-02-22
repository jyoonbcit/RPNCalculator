package ca.bcit.comp2522.lab04;

/**
 * Operation interface.
 *
 * @author Jihoon Yoon
 * @version 2023-02-11
 */
public interface Operation {
    /**
     * Gets the symbol the operation uses.
     *
     * @return operation symbol
     */
    char getSymbol();

    /**
     * Performs an operation on two operands.
     *
     * @param operandA Left operand
     * @param operandB Right operand
     * @return Result of operation performed
     */
    int perform(int operandA, int operandB);
}
