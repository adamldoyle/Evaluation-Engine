package com.adamldoyle.evaluationengine.evaluator.input;

import com.adamldoyle.evaluationengine.evaluator.Evaluator;

/**
 * Input to an {@link Evaluator}
 * @author adoyle
 *
 * @param <InputType> Type of input to handle
 */
public interface EvaluationInput<InputType>
{

    /**
     * Retrieve the data from the input
     * @return The data
     */
    public InputType getData();

}
