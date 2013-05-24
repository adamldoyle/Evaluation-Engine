package com.adamldoyle.evaluationengine.evaluator;

import java.util.HashMap;
import java.util.Map;

import com.adamldoyle.evaluationengine.evaluator.input.EvaluationInput;
import com.adamldoyle.evaluationengine.evaluator.output.DefaultEvaluationOutput;
import com.adamldoyle.evaluationengine.evaluator.output.EvaluationOutput;

/**
 * Performs an evaluation on input and provides an output.
 * @author adoyle
 *
 * @param <InputType> Type of input to handle
 * @param <OutputType> Type of output to return
 */
public class Evaluator<InputType, OutputType>
{

    private DefaultEvaluationOutput<InputType, OutputType> defaultEvaluationOutput = null;
    private Map<EvaluationInput<InputType>, EvaluationOutput<OutputType>> mapping = new HashMap<EvaluationInput<InputType>, EvaluationOutput<OutputType>>();

    /**
     * Register evaluation to be used if no matching evaluation is found.
     * @param defaultOutput Evaluation output to use by default
     */
    public void registerDefaultEvaluation(DefaultEvaluationOutput<InputType, OutputType> defaultOutput)
    {
        defaultEvaluationOutput = defaultOutput;
    }

    /**
     * Registers an output for a provided input.
     * @param input Evaluation input
     * @param output Evaluation output
     */
    public void registerEvaluation(EvaluationInput<InputType> input, EvaluationOutput<OutputType> output)
    {
        mapping.put(input, output);
    }

    /**
     * Perform an evaluation given an input
     * @param input Evaluation input
     * @return Evaluation output
     * @throws NoEvaluationException No matching evaluation and no default evaluation
     */
    public EvaluationOutput<OutputType> evaluate(EvaluationInput<InputType> input) throws NoEvaluationException
    {
        if (mapping.containsKey(input))
        {
            return mapping.get(input);
        }
        if (defaultEvaluationOutput != null)
        {
            defaultEvaluationOutput.resolveInput(input);
            return defaultEvaluationOutput;
        }
        throw new NoEvaluationException();
    }

}
