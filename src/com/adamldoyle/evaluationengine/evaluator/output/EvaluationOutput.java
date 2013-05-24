package com.adamldoyle.evaluationengine.evaluator.output;

import com.adamldoyle.evaluationengine.evaluator.Evaluator;

/**
 * Output from an {@link Evaluator}
 * @author adoyle
 *
 * @param <OutputType> Type of output to return
 */
public interface EvaluationOutput<OutputType>
{

    /**
     * Retrieve the data from the output
     * @return The data
     */
    public OutputType getData();

}
