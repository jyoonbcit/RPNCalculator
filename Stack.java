package ca.bcit.comp2522.lab04;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;

/**
 * Stack.
 *
 * @author Jihoon Yoon
 * @version 2023-02-11
 */
public class Stack {
    // Integers in the stack.
    private final int[] stackValues;
    // Number of integers in the stack.
    private int count;

    /**
     * Stack constructor.
     *
     * @param stackSize size of the stack
     * @throws IllegalArgumentException if stackSize is less than or equal to 1
     */
    public Stack(int stackSize) {
        if (stackSize <= 1) {
            throw new IllegalArgumentException();
        } else {
            this.stackValues = new int[stackSize - 1];
        }
    }

    /**
     * Gets the capacity of the stack.
     *
     * @return capacity of the stack
     */
    public int capacity() {
        return this.stackValues.length;
    }

    /**
     * Gets the size of the stack.
     *
     * @return size of the stack
     */
    public int size() {
        return this.count;
    }

    /**
     * Gets the number of unused spots in the stack.
     *
     * @return number of unused spots in the stack
     */
    public int unused() {
        return this.capacity() - this.size();
    }

    /**
     * Pushes a number onto the stack.
     *
     * @param value number input
     * @throws BufferOverflowException if the number of unused spaces is equal to 0
     */
    public void push(int value) {
        if (this.unused() != 0) {
            this.count++;
            this.stackValues[this.size() - 1] = value;
        } else {
            throw new BufferOverflowException();
        }
    }

    /**
     * Pops the integer off the top of the stack.
     *
     * @return integer on top of the stack
     * @throws BufferUnderflowException if size is equal to 0
     */
    public int pop() {
        if (this.size() != 0) {
            int toPop = this.stackValues[this.size() - 1];
            this.stackValues[this.size() - 1] = 0;
            count--;
            return toPop;
        } else {
            throw new BufferUnderflowException();
        }
    }

    /**
     * Peeks at the top of the stack.
     *
     * @return number on top of the stack
     * @throws BufferUnderflowException if size is equal to 0
     */
    public int peek() {
        if (this.size() != 0) {
            return this.stackValues[this.size() - 1];
        } else {
            throw new BufferUnderflowException();
        }
    }
}
