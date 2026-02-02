package org.example;

public interface IBillCalculator {
    void printSummary();
    double calculatedPerPerson(double total);
    double calculatedTotal(double admin, double pajak);
}
