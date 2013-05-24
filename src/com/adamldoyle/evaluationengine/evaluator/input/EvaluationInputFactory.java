package com.adamldoyle.evaluationengine.evaluator.input;

/**
 * Generate an {@link EvaluationInput} object given input data.
 * @author adoyle
 *
 * @param <InputType> Type of input to handle
 */
public interface EvaluationInputFactory<InputType>
{

    /**
     * Returns an input object given input data.
     * @param data Input data
     * @return Evaluation input based on the data
     */
    public EvaluationInput<InputType> getEvaluationInput(InputType data);

}
