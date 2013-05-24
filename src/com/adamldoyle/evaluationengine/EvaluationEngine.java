package com.adamldoyle.evaluationengine;

import com.adamldoyle.evaluationengine.evaluator.CycleOverException;
import com.adamldoyle.evaluationengine.evaluator.EvaluationCycle;
import com.adamldoyle.evaluationengine.evaluator.Evaluator;
import com.adamldoyle.evaluationengine.evaluator.NoEvaluationException;
import com.adamldoyle.evaluationengine.evaluator.input.EvaluationInput;
import com.adamldoyle.evaluationengine.evaluator.input.EvaluationInputFactory;
import com.adamldoyle.evaluationengine.evaluator.output.EvaluationOutput;
import com.adamldoyle.evaluationengine.evaluator.output.EvaluationOutputCollector;

/**
 * Evaluation engine that requests input data from the inputFactory and cycle and evaluates
 * it according to the evaluator. All results stored in the outputCollector.
 * @author adoyle
 * @param <InputType> Type of input data this engine can process
 * @param <OutputType> Type of output data this engine can produce
 */
public class EvaluationEngine<InputType, OutputType> extends Thread
{

    private Evaluator<InputType, OutputType> evaluator;
    private EvaluationInputFactory<InputType> inputFactory;
    private EvaluationOutputCollector<OutputType> outputCollector;
    private EvaluationCycle<InputType> cycle;

    /**
     * Set the evaluator to be used for all evaluations.
     * @param evaluator Evaluator
     */
    public void setEvaluator(Evaluator<InputType, OutputType> evaluator)
    {
        this.evaluator = evaluator;
    }

    /**
     * Set the input factory to be used for producing input data.
     * @param inputFactory Input factory
     */
    public void setInputFactory(EvaluationInputFactory<InputType> inputFactory)
    {
        this.inputFactory = inputFactory;
    }

    /**
     * Set the output collector to be used for collecting all output data.
     * @param outputCollector Output collector
     */
    public void setOutputCollector(EvaluationOutputCollector<OutputType> outputCollector)
    {
        this.outputCollector = outputCollector;
    }

    /**
     * Set the cycle to be used for getting raw input data.
     * @param cycle Cycle
     */
    public void setCycle(EvaluationCycle<InputType> cycle)
    {
        this.cycle = cycle;
    }

    /**
     * Run the evaluation until the cycle is empty.
     */
    @Override
    public void run() throws NoEvaluationException, CycleOverException
    {
        while (!isInterrupted() && cycle.hasNext())
        {
            InputType data = cycle.getNext();
            EvaluationInput<InputType> input = inputFactory.getEvaluationInput(data);
            EvaluationOutput<OutputType> output = evaluator.evaluate(input);
            outputCollector.collect(output);
        }
    }

}
