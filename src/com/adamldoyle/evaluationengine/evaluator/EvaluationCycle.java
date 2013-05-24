package com.adamldoyle.evaluationengine.evaluator;

/**
 * Represents an evaluation cycle for producing input data.
 * @author adoyle
 * @param <InputType> Type of data to produce
 */
public interface EvaluationCycle<InputType>
{

    /**
     * Returns if another piece of input data can be provided.
     * @return True if another piece of data can be provided, false otherwise
     */
    public boolean hasNext();

    /**
     * Return the next piece of input data.
     * @return Input data
     * @throws CycleOverException If no data can be provided
     */
    public InputType getNext() throws CycleOverException;

}
