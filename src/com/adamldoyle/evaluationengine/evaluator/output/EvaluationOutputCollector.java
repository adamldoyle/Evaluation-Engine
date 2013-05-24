package com.adamldoyle.evaluationengine.evaluator.output;

/**
 * Collect output from the engine.
 * @author adoyle
 *
 * @param <OutputType> The type of data to collect
 */
public interface EvaluationOutputCollector<OutputType>
{

    /**
     * Collect a single output.
     * @param output The data to collect
     */
    public void collect(EvaluationOutput<OutputType> output);

    /**
     * Return all collected output.
     * @return Collected output
     */
    public Iterable<OutputType> getOutput();
}
