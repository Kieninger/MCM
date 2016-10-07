/*
 * @author: Florian Kieninger - S1510455013
 */
package at.fhhagenberg.sqe.exercise1.ui;

import at.fhhagenberg.sqe.exercise1.business.TriangleModel;

/**
 * Represents the logic of the triangle calculator.
 */
class TriangleCalculator implements TriangleCalculatorContract.Logic {

    /**
     * Shows the triangle calculator.
     */
    static void show() {
        new TriangleCalculator();
    }

    private final TriangleCalculatorContract.View view;

    private TriangleCalculator() {
        view = TriangleCalculatorView.create(this);
    }

    @Override
    public void requestCalculation(String sideA, String sideB, String sideC) {
        try {
            double a = Double.valueOf(sideA);
            double b = Double.valueOf(sideB);
            double c = Double.valueOf(sideC);

            TriangleModel triangleModel = TriangleModel.create(a, b, c);
            if (triangleModel != null) {
                view.displayResult(triangleModel.getPerimeter(), triangleModel.getArea());
            } else {
                view.displayError(TriangleCalculatorContract.View.ErrorType.INVALID_NUMBERS);
            }

        } catch (NumberFormatException exception) {
            view.displayError(TriangleCalculatorContract.View.ErrorType.NO_NUMBER_VALUES);
        }
    }
}
