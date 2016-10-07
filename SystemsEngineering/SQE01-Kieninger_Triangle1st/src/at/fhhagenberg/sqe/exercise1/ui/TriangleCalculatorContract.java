/*
 * @author: Florian Kieninger - S1510455013
 */
package at.fhhagenberg.sqe.exercise1.ui;

/**
 * The contract of the triangle calculator.
 */
interface TriangleCalculatorContract {

    /**
     * The view contract of the triangle calculator.
     */
    interface View {

        /**
         * Shows the result.
         *
         * @param perimeter {@link double}: The perimeter of the triangle.
         * @param area {@link double}: The area of the triangle.
         */
        void displayResult(double perimeter, double area);

        /**
         * Display an error.
         *
         * @param errorType {@link ErrorType}: Describe the type of error.
         */
        void displayError(ErrorType errorType);

        /**
         * Represents all possible errors.
         */
        enum ErrorType {

            /**
             * The entered values were not be able to be parsed as numbers.
             */
            NO_NUMBER_VALUES,

            /**
             * The entered values didn't fit with the triangle specification.
             */
            INVALID_NUMBERS

        }
    }

    /**
     * Represents the logic of the triangle calculator.
     */
    interface Logic {

        /**
         * Requests a calculation of the entered values.
         *
         * @param sideA {@link String}: Side a of the triangle.
         * @param sideB {@link String}: Side b of the triangle.
         * @param sideC {@link String}: Side c of the triangle.
         */
        void requestCalculation(String sideA, String sideB, String sideC);

    }

}
