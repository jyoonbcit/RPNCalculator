package ca.bcit.comp2522.lab04;

/**
 * AbstractOperation abstract class.
 *
 * @author Jihoon Yoon
 * @version 2023-02-11
 */
public abstract class AbstractOperation implements Operation {
    // Operation symbol.
    protected char operationType;

    /**
     * AbstractOperation constructor.
     *
     * @param operationType operational symbol
     */
    public AbstractOperation(char operationType) {
        this.operationType = operationType;
    }

    /**
     * Gets the symbol the operation uses.
     *
     * @return operation symbol
     */
    public final char getSymbol() {
        return this.operationType;
    }
}
