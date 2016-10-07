/*
 * Name: Florian Kieninger
 * ID: S1510455013
 */
package at.fhhagenberg.sqe.exercise1.ui;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Represents the view of the triangle calculator.
 */
class TriangleCalculatorView implements TriangleCalculatorContract.View {

    private final TriangleCalculatorContract.Logic logic;

    private ResourceBundle stringResources;

    private JFrame frame;

    private JTextField sideATextField;
    private JTextField sideBTextField;
    private JTextField sideCTextField;

    private JLabel perimeterLabel;
    private JLabel areaLabel;

    /**
     * Creates the triangle calculator view.
     *
     * @param logic {@link at.fhhagenberg.sqe.exercise1.ui.TriangleCalculatorContract.Logic}: The logic of the triangle calculator.
     * @return {@link TriangleCalculatorView}: The created view.
     */
    static TriangleCalculatorView create(TriangleCalculatorContract.Logic logic) {
        TriangleCalculatorView triangleCalculatorView = new TriangleCalculatorView(logic);
        triangleCalculatorView.createUserInterface();
        return triangleCalculatorView;
    }

    private TriangleCalculatorView(TriangleCalculatorContract.Logic logic) {
        this.logic = logic;
        stringResources = ResourceBundle.getBundle("StringBundle", Locale.getDefault());
    }

    @Override
    public void displayResult(double perimeter, double area) {
        perimeterLabel.setText(String.valueOf(perimeter));
        areaLabel.setText(String.valueOf(area));
    }

    @Override
    public void displayError(ErrorType errorType) {
        if(errorType != null) {
            switch (errorType) {
                case NO_NUMBER_VALUES:
                    JOptionPane.showMessageDialog(frame, stringResources.getString("TriangleCalculatorView_NoNumbersError"));
                    break;
                case INVALID_NUMBERS:
                    JOptionPane.showMessageDialog(frame, stringResources.getString("TriangleCalculatorView_InvalidNumbersError"));
                    break;
                default:
                    JOptionPane.showMessageDialog(frame, stringResources.getString("TriangleCalculatorView_UnknownError"));
                    break;
            }
        } // else ignore.
    }

    private void createUserInterface() {
        frame = new JFrame(stringResources.getString("TriangleCalculatorView_Title"));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        panel.add(new JLabel(stringResources.getString("TriangleCalculatorView_SideALabel")), createLabelConstraints(0, 0));
        sideATextField = new JTextField();
        panel.add(sideATextField, createTextFieldConstraints(1, 0));

        panel.add(new JLabel(stringResources.getString("TriangleCalculatorView_SideBLabel")), createLabelConstraints(0, 1));
        sideBTextField = new JTextField();
        panel.add(sideBTextField, createTextFieldConstraints(1, 1));

        panel.add(new JLabel(stringResources.getString("TriangleCalculatorView_SideCLabel")), createLabelConstraints(0, 2));
        sideCTextField = new JTextField();
        panel.add(sideCTextField, createTextFieldConstraints(1, 2));

        JButton button = new JButton(stringResources.getString("TriangleCalculatorView_CalculateButton"));
        button.addActionListener(e -> logic.requestCalculation(sideATextField.getText(), sideBTextField.getText(), sideCTextField.getText()));
        panel.add(button, createButtonConstraints(0, 3, 2));

        panel.add(new JLabel(stringResources.getString("TriangleCalculatorView_PerimeterLabel")), createLabelConstraints(0, 4));
        perimeterLabel = new JLabel();
        panel.add(perimeterLabel, createLabelConstraints(1, 4));

        panel.add(new JLabel(stringResources.getString("TriangleCalculatorView_AreaLabel")), createLabelConstraints(0, 5));
        areaLabel = new JLabel();
        panel.add(areaLabel, createLabelConstraints(1, 5));

        frame.getContentPane().add(panel);
        frame.setMinimumSize(new Dimension(200, 120));
        frame.pack();
        frame.setVisible(true);
    }

    private GridBagConstraints createLabelConstraints(int gridX, int gridY) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = 0.5;
        constraints.weighty = 1;
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        return constraints;
    }

    private GridBagConstraints createTextFieldConstraints(int gridX, int gridY) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        return constraints;
    }

    private GridBagConstraints createButtonConstraints(int gridX, int gridY, int gridWidth) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridwidth = gridWidth;
        constraints.weighty = 1;
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        return constraints;
    }

}
