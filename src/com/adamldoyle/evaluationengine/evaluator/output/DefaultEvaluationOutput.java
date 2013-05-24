package com.adamldoyle.evaluationengine.evaluator.output;

import com.adamldoyle.evaluationengine.evaluator.input.EvaluationInput;

/**
 * Special evaluation output for handling unmapped evaluation input.
 * @author adoyle
 *
 * @param <InputType> Type of input to handle
 * @param <OutputType> Type of output to return
 */
public interface DefaultEvaluationOutput<InputType, OutputType> extends EvaluationOutput<OutputType>
{

    /**
     * Resolve the unmapped input into the output
     * @param input Unmapped input
     */
    public void resolveInput(EvaluationInput<InputType> input);

}
