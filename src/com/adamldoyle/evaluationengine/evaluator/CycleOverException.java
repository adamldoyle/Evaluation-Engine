package com.adamldoyle.evaluationengine.evaluator;

/**
 * Represents a failed request for more input data
 * @author adoyle
 */
public class CycleOverException extends RuntimeException
{

    public CycleOverException()
    {
        super();
    }

}
