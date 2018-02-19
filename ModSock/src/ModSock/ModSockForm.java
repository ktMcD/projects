/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ModSock;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class ModSockForm extends javax.swing.JDialog
{

/**
 * Creates new form ModSockForm
 */
public ModSockForm(java.awt.Frame parent, boolean modal)
{
    super(parent, modal);
    initComponents();
    sockNameTextField.requestFocus();
}

public void setFieldError(String theField)
{
    if(theField == "footLength")
    {
        footLengthTextField.setBackground(Color.yellow);
        footLengthLabel.setForeground(Color.red);
    }
    if(theField == "footCirc")
    {
        footCircTextField.setBackground(Color.yellow);
        footCircLabel.setForeground(Color.red);
    }
    if(theField == "lengthEase")
    {
        lengthEaseTextField.setBackground(Color.yellow);
        sockLengthEaseLabel.setForeground(Color.red);
    }
    if(theField == "circEase")
    {
        circEaseTextField.setBackground(Color.yellow);
        sockCircEaseLabel.setForeground(Color.red);
    }
    if(theField == "sockName")
    {
        sockNameTextField.setBackground(Color.yellow);
        sockNameLabel.setForeground(Color.red);
    }
    if(theField == "yarn")
    {
       yarnWeightLabel.setForeground(Color.red);
    }

    if(theField == "needles")
    {
        needleSizeTextField.setBackground(Color.yellow);
        needleSizeTextField.setForeground(Color.red);
    }

    if(theField == "gaugeSPI")
    {
        gaugeSPITextField.setBackground(Color.yellow);
        gaugeSPITextField.setForeground(Color.red);
    }

    if(theField == "gaugeRPI")
    {
        gaugeRPITextField.setBackground(Color.yellow);
        gaugeRPITextField.setForeground(Color.red);
    }
    
}

public void resetFieldColors(String theField)
{

    if(theField == "footLength")
    {
        footLengthTextField.setBackground(Color.white);
        footLengthLabel.setForeground(Color.black);
    }
    if(theField == "footCirc")
    {
        footCircTextField.setBackground(Color.white);
        footCircLabel.setForeground(Color.black);
    }
    if(theField == "lengthEase")
    {
        lengthEaseTextField.setBackground(Color.white);
        sockLengthEaseLabel.setForeground(Color.black);
    }
    if(theField == "circEase")
    {
        circEaseTextField.setBackground(Color.white);
        sockCircEaseLabel.setForeground(Color.black);
    }
    if(theField == "sockName")
    {
        sockNameTextField.setBackground(Color.white);
        sockNameLabel.setForeground(Color.black);
    }
    if(theField == "yarn")
    {
       yarnWeightLabel.setForeground(Color.black);
    }

    if(theField == "needles")
    {
        needleSizeTextField.setBackground(Color.white);
        needleSizeTextField.setForeground(Color.black);
    }

    if(theField == "gaugeSPI")
    {
        gaugeSPITextField.setBackground(Color.white);
        gaugeSPITextField.setForeground(Color.black);
    }

    if(theField == "gaugeRPI")
    {
        gaugeRPITextField.setBackground(Color.white);
        gaugeRPITextField.setForeground(Color.black);
    }
    
}

public boolean valIsNotEmpty(String theField)
{
    boolean isValid = true;
    if(theField.length() == 0)
    {
        isValid = false;
        return isValid;
    }
    return isValid;
}

public boolean validateDouble(String theNumber)
{
    boolean lNumValid = true;
    
    try
    {
        Double.parseDouble(theNumber);
    }
    catch(NumberFormatException badDE)
    {
        lNumValid = false;
        return lNumValid;
    }
    return lNumValid;
}

public boolean valSpecialChars(String theText)
{
    boolean lIsValid         = true;
    // carat tells regex to match any char that is *not* in the compile set
    // so m.find() will return true if there is a character in the string not in the compile set 
    Pattern goodChars        = Pattern.compile("[^a-z0-9_-]", Pattern.CASE_INSENSITIVE);
    Matcher m                = goodChars.matcher(theText);
    boolean lFoundSpecChars  = m.find();
    if (lFoundSpecChars)
    {
        lIsValid = false;
        return lIsValid;
    }

    return lIsValid;
}

public void findFocus(String theField)
{
    if(theField == "footLength")
    {
        footLengthTextField.requestFocus();
    }
    else if(theField == "footCirc")
    {
        footCircTextField.requestFocus();
    }
    else if(theField == "lengthEase")
    {
        lengthEaseTextField.requestFocus();
    }
    else if(theField == "circEase")
    {
        circEaseTextField.requestFocus();
    }
    else if(theField == "sockName")
    {
        sockNameTextField.requestFocus();
    }
    else if(theField == "needles")
    {
        needleSizeTextField.requestFocus();
    }
    else if(theField == "gaugeSPI")
    {
        gaugeSPITextField.requestFocus();
    }
    else if(theField == "gaugeRPI")
    {
        gaugeRPITextField.requestFocus();
    }
}

public void resetAllFields()
{
    sockNameTextField.setText("");
    footLengthTextField.setText("");
    footCircTextField.setText("");
    circEaseTextField.setText("");
    lengthEaseTextField.setText("");
    yarnWeightComboBox.setSelectedIndex(-1);
    sockLengthLabel.setText("Sock Length:");
    sockCircLabel.setText("Sock Width:");
    gaugeSPITextField.setText("");
    gaugeRPITextField.setText("");
    needleSizeTextField.setText("");
    resetFieldColors("footLength");
    resetFieldColors("footCirc");
    resetFieldColors("lengthEase");
    resetFieldColors("circEase");
    resetFieldColors("sockName");
    resetFieldColors("yarn");
    resetFieldColors("needles");
    resetFieldColors("gaugeSPI");
    resetFieldColors("gaugeRPI");

}

public String buildPattern(ModSock theSock)
{
    
    String thePattern = "";
    thePattern =  "Toe: \n"
                  + "Cast on " + theSock.getCastOn() + " stitches using Judy's magic cast-on or Turkish cast-on \n"
                  + "    (that's " + (theSock.getCastOn() / 2) + " stitches per needle) \n"
                  + "Row 1: Knit around; \n"
                  + "Row 2 both needles: Knit 1, backwards yarn over (BYO), knit to last stitch, yarn over (YO), knit last stitch. \n"
                  + "                    You have increased the number of stitches on each needle by 2 \n"
                  + "Row 3 both needles: Knit 1, knit into the BYO you made in the previous row through the back loop (it should knit twisted) \n"
                  + "                    Knit to second-to-last stitch (the last YO you made in the previous row), \n"
                  + "                         knit into the BYO (it should knit twisted), knit last stitch \n"
                  + "Repeat rows 2 and 3 until you have increased to " + theSock.getMaxStitches() + " stitches \n"
                  + "    You should have added " + theSock.getToeIncreaseStitches() + " stitches (" + (theSock.getToeIncreaseStitches() / 2) + " stitches each end).\n"
                  + "over " + theSock.getToeIncreaseRows() + " rows. End on a row-3 row. \n\n"
                  + "Knit straight until your sock tube and toe measure " + theSock.getKnitStraighLength() + " inches (approx. " + theSock.getKnitStraightRows() + " rows)"
                  + "\n\n"
                  + "GUSSET:\n"
                  + "Now it's time to increase for the gusset of our sock. \n"
                  + "Over the next  " + theSock.getGussetRows() + " rows, you will increase only on the sole needle (needle 1 \"N1\").\n"
                  + "Row 1 Needle 1: knit 1, PLACE MARKER, YO, knit to second-to-last stitch, BYO, PLACE MARKER, knit last stitch;\n"
                  + "Row 1 Needle 2: knit across; \n"
                  + "Row 2 Needle 1: knit 1, knit into the back of the YO you made in the previous row, \n"
                  + "                knit across to second-to-last stitch (the BYO you made in the previous row), \n"
                  +    "knit into the BYO (it should knit twisted);\n"
                  + "Row 2 Needle 2: knit across; \n"
                  + "Repeat rows 1 and 2 until you have added " + theSock.getGussetStitches() + " stitches to Needle 1, for a total of " + (theSock.getSoleStitches() + theSock.getGussetStitches()) + " stitches on Needle 1."
                  + "\n\n"
                  + "TURNING THE HEEL \n"
                  + "For the next few rows, we will only be working on the sole needle (Needle 1), leaving the instep needle (Needle 2) unworked for now. \n"
                  + "You should have placed markers inside the new gusset stitches on the two ends of N1, leaving the original sole stitches in the center.\n"
                  + "Row 1 (right side - RS): Knit to 1 stitch before second marker, Wrap & Turn (W&T);\n"
                  + "Row 2: (wrong side - WS): Purl to 1 stitch before the first marker, W&T;\n"
                  + "Row 3: Knit to 2 stitches before the last wrap, W&T \n"
                  + "Row 4: Purl to 2 stitches before the last wrap, W&T \n"
                  + "Repeat rows 3 and 4 until you have " + (theSock.getCastOn() / 2) + " stitches remaining between the wraps closest to the center, ending with a PURL row\n"
                  + "Next two rows:\n"
                  + "    Row 1: Knit across the sole stitches, working each wrap together with the stitch it wraps, W&T.\n"
                  + "    Row 2: Purl across the sole stitches, purling the stitches you just knit together and working each wrap together with the stitch it wraps, W&T. \n"
                  + "You have just completed turning the heel!!\n\n"
                  + "HEEL FLAP\n"
                  + "Row 1 (RS): Knit to second marker, slip wrap, slip wrapped stitch, slip next stitch (total of 3), knit all 3 together, turn \n"
                  + "Row 2 (WS): Slip 1, purl to first marker, slip wrap, slip wrapped stitch, slip next stitch (total of 3), purl all 3 together, turn \n"
                  + "Row 3 (RS): *(Slip 1, knit 1) repeating from * all the way across to 1 stitch before marker, ssk, turn (slip as if to knit)\n"
                  + "Row 4 (WS): Slip 1, purl to 1 stitch before marker, purl next two together, turn \n"
                  + "Repeat fows 3 and 4 until all side stitches have been worked on the Right Side, end on a knit row.\n\n"
                  + "At this point, you still have some stitches to consume. You can consume those on your way back around next time. \n"
                  + "We're stopping early here to avoid gaping holes at the intersection of the gusset and foot tube. \n"
                  + "Return to working in the round. \n"
                  + "\n"
                  + "Switch to one size smaller needles for cuff" ;
    
        
    return thePattern;
}

/**
 * This method is called from within the constructor to
 * initialize the form.
 * WARNING: Do NOT modify this code. The content of this method is
 * always regenerated by the Form Editor.
 */
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        formLabel = new javax.swing.JLabel();
        sockNameLabel = new javax.swing.JLabel();
        sockNameTextField = new javax.swing.JTextField();
        gaugeAndYarnPanel = new javax.swing.JPanel();
        gaugeSPILabel = new javax.swing.JLabel();
        gaugeSPITextField = new javax.swing.JTextField();
        needleSizeLabel = new javax.swing.JLabel();
        needleSizeTextField = new javax.swing.JTextField();
        gaugeRPILabel = new javax.swing.JLabel();
        gaugeRPITextField = new javax.swing.JTextField();
        yarnWeightLabel = new javax.swing.JLabel();
        yarnWeightComboBox = new javax.swing.JComboBox<>();
        footMeasurementPanel = new javax.swing.JPanel();
        footLengthTextField = new javax.swing.JTextField();
        footLengthLabel = new javax.swing.JLabel();
        footCircLabel = new javax.swing.JLabel();
        footCircTextField = new javax.swing.JTextField();
        sockLengthEaseLabel = new javax.swing.JLabel();
        lengthEaseTextField = new javax.swing.JTextField();
        sockCircEaseLabel = new javax.swing.JLabel();
        circEaseTextField = new javax.swing.JTextField();
        sockMeasurementPanel = new javax.swing.JPanel();
        sockLengthLabel = new javax.swing.JLabel();
        sockCircLabel = new javax.swing.JLabel();
        writePatternButton = new javax.swing.JButton();
        quickieCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        formLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        formLabel.setText("All Measurements are in Inches - assuming two circs");
        formLabel.setFocusable(false);

        sockNameLabel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        sockNameLabel.setText("Sock Name:");
        sockNameLabel.setFocusable(false);

        gaugeSPILabel.setText("Gauge (sts per inch):");
        gaugeSPILabel.setFocusable(false);

        needleSizeLabel.setText("Needle Size:");
        needleSizeLabel.setFocusable(false);

        gaugeRPILabel.setText("Gauge (rows per inch):");
        gaugeRPILabel.setFocusable(false);

        yarnWeightLabel.setText("Yarn Weight:");
        yarnWeightLabel.setFocusable(false);

        yarnWeightComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "lace or fingering", "thread", "super fine", "sock weight", "sport weight", "baby weight", "sport weight", "light worsted", "double knitting or dk weight", "worsted or afghan or Aran", "rug", "bulky or chunky", "super bulky", "roving" }));

        javax.swing.GroupLayout gaugeAndYarnPanelLayout = new javax.swing.GroupLayout(gaugeAndYarnPanel);
        gaugeAndYarnPanel.setLayout(gaugeAndYarnPanelLayout);
        gaugeAndYarnPanelLayout.setHorizontalGroup(
            gaugeAndYarnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gaugeAndYarnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gaugeAndYarnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, gaugeAndYarnPanelLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(gaugeSPILabel)
                        .addGap(18, 18, 18)
                        .addComponent(gaugeSPITextField, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(needleSizeLabel)
                        .addGap(18, 18, 18)
                        .addComponent(needleSizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, gaugeAndYarnPanelLayout.createSequentialGroup()
                        .addComponent(gaugeRPILabel)
                        .addGap(18, 18, 18)
                        .addComponent(gaugeRPITextField, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(yarnWeightLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(yarnWeightComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gaugeAndYarnPanelLayout.setVerticalGroup(
            gaugeAndYarnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gaugeAndYarnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gaugeAndYarnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(gaugeAndYarnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(gaugeSPITextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(gaugeSPILabel))
                    .addGroup(gaugeAndYarnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(needleSizeLabel)
                        .addComponent(needleSizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gaugeAndYarnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gaugeAndYarnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(yarnWeightLabel)
                        .addComponent(yarnWeightComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gaugeAndYarnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(gaugeRPITextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(gaugeRPILabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        footLengthLabel.setText("Foot Length:");
        footLengthLabel.setFocusable(false);

        footCircLabel.setText("Foot Circumference:");
        footCircLabel.setFocusable(false);

        sockLengthEaseLabel.setText("Sock Length Ease:");
        sockLengthEaseLabel.setFocusable(false);

        sockCircEaseLabel.setText("Sock Circumference Ease:");
        sockCircEaseLabel.setFocusable(false);

        javax.swing.GroupLayout footMeasurementPanelLayout = new javax.swing.GroupLayout(footMeasurementPanel);
        footMeasurementPanel.setLayout(footMeasurementPanelLayout);
        footMeasurementPanelLayout.setHorizontalGroup(
            footMeasurementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footMeasurementPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(footMeasurementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sockCircEaseLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sockLengthEaseLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(footCircLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(footLengthLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(19, 19, 19)
                .addGroup(footMeasurementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lengthEaseTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                    .addComponent(footCircTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(footLengthTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(circEaseTextField, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        footMeasurementPanelLayout.setVerticalGroup(
            footMeasurementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footMeasurementPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(footMeasurementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(footLengthLabel)
                    .addComponent(footLengthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(footMeasurementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(footCircLabel)
                    .addComponent(footCircTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(footMeasurementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lengthEaseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sockLengthEaseLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(footMeasurementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(sockCircEaseLabel)
                    .addComponent(circEaseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        sockLengthLabel.setText("Sock Length:");
        sockLengthLabel.setFocusable(false);

        sockCircLabel.setText("Sock Width:");
        sockCircLabel.setFocusable(false);

        javax.swing.GroupLayout sockMeasurementPanelLayout = new javax.swing.GroupLayout(sockMeasurementPanel);
        sockMeasurementPanel.setLayout(sockMeasurementPanelLayout);
        sockMeasurementPanelLayout.setHorizontalGroup(
            sockMeasurementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sockMeasurementPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sockMeasurementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sockLengthLabel)
                    .addComponent(sockCircLabel))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        sockMeasurementPanelLayout.setVerticalGroup(
            sockMeasurementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sockMeasurementPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sockLengthLabel)
                .addGap(18, 18, 18)
                .addComponent(sockCircLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        writePatternButton.setText("Write Pattern");
        writePatternButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                writePatternButtonActionPerformed(evt);
            }
        });

        quickieCheckBox.setText("Quickie?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(gaugeAndYarnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(footMeasurementPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(sockMeasurementPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(quickieCheckBox)
                                        .addGap(18, 18, 18)
                                        .addComponent(writePatternButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(23, 23, 23))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(sockNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sockNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(formLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(formLabel)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sockNameLabel)
                    .addComponent(sockNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(gaugeAndYarnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sockMeasurementPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(writePatternButton)
                            .addComponent(quickieCheckBox)))
                    .addComponent(footMeasurementPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void writePatternButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_writePatternButtonActionPerformed
    {//GEN-HEADEREND:event_writePatternButtonActionPerformed
        double  dFootLength          = 0;
        double  dFootCirc            = 0;
        double  dSockLengthEase      = 0;
        double  dSockCircEase        = 0;
        double  dSockCirc            = 0; // calculated
        double  dSockLength          = 0; // calculated
        double  dGaugeSPI            = 0;
        double  dGaugeRPI            = 0;
        double  dNeedleSize          = 0;
        boolean allFieldsOK          = true;
        boolean lFLengthNotNull      = valIsNotEmpty(footLengthTextField.getText());
        boolean lFLengthVal          = validateDouble(footLengthTextField.getText());
        boolean lFCircNotNull        = valIsNotEmpty(footCircTextField.getText());
        boolean lFCircVal            = validateDouble(footCircTextField.getText());
        boolean lSLengthEaseNotNull  = valIsNotEmpty(lengthEaseTextField.getText());
        boolean lSLengthEaseVal      = validateDouble(lengthEaseTextField.getText());
        boolean lSCircEaseNotNull    = valIsNotEmpty(circEaseTextField.getText());
        boolean lSCircEaseVal        = validateDouble(circEaseTextField.getText());
        boolean lSockNameNotNull     = valIsNotEmpty(sockNameTextField.getText());
        boolean lSockNameVal         = valSpecialChars(sockNameTextField.getText());
        boolean lYarnWeightNotNull   = valIsNotEmpty(String.valueOf(yarnWeightComboBox.getSelectedItem()));        
        boolean lNeedlesNotNull      = valIsNotEmpty(needleSizeTextField.getText());
        boolean lNeedlesVal          = validateDouble(needleSizeTextField.getText());
        boolean lGaugeSPINotNull     = valIsNotEmpty(gaugeSPITextField.getText());
        boolean lGaugeSPIVal         = validateDouble(gaugeSPITextField.getText());
        boolean lGaugeRPINotNull     = valIsNotEmpty(gaugeRPITextField.getText());
        boolean lGaugeRPIVal         = validateDouble(gaugeRPITextField.getText());
        
        String  strErrorText         = "";
        String  strFocusField        = "";
        String  strSockName          = "";
        String  strYarnWeight        = "";

        if(lFLengthNotNull && lFLengthVal)
        {
            dFootLength = Double.parseDouble(footLengthTextField.getText());
        }
        else
        {
            strErrorText = strErrorText + "-Please enter foot length in inches (decimals)" + "\n"+
                                          "   Decimal numbers only, please" + "\n";
            setFieldError("footLength");
            if(strFocusField == "")
            {
                strFocusField = "footLength";
            }
            allFieldsOK = false;
        }

        if(lFCircNotNull && lFCircVal)
        {
            dFootCirc = Double.parseDouble(footCircTextField.getText());
        }
        else
        {
            strErrorText = strErrorText + "-Please enter foot circumference in inches (decimals)" + "\n" +
                                          "   Decimal numbers only, please" + "\n";
            setFieldError("footCirc");
            if(strFocusField == "")
            {
                strFocusField = "footCirc";
            }
            allFieldsOK = false;
        }

        if(lSLengthEaseNotNull && lSLengthEaseVal)
        {
            dSockLengthEase = Double.parseDouble(lengthEaseTextField.getText());
        }
        else
        {
            strErrorText = strErrorText + "-Please enter sock length ease in inches (decimals)" + "\n" +
                                          "   Decimal numbers only, please" + "\n";
            setFieldError("lengthEase");
            if(strFocusField == "")
            {
                strFocusField = "lengthEase";
            }
            allFieldsOK = false;
        }

        if(lSCircEaseNotNull && lSCircEaseVal)
        {
            dSockCircEase = Double.parseDouble(circEaseTextField.getText());
            dSockLength = dFootLength - dSockLengthEase;
            dSockCirc   = dFootCirc - dSockCircEase;
            sockLengthLabel.setText("Sock Length: " + dSockLength);
            sockCircLabel.setText("Sock Width: " + dSockCirc);
        }
        else
        {
            strErrorText = strErrorText + "-Please enter sock circumference ease in inches (decimals)" + "\n" +
                                          "   Decimal numbers only, please" + "\n";
            setFieldError("circEase");
            if(strFocusField == "")
            {
                strFocusField = "circEase";
            }
            allFieldsOK = false;
        }

        if(lSockNameNotNull && lSockNameVal)
        {
            strSockName = sockNameTextField.getText();
        }
        else
        {
            strErrorText = strErrorText + "-Please enter a name for this sock" + "\n" +
                                          "   Letters, numbers, dashes and underscores only" + "\n" +
                                          "   (no spaces or other special characters)";
            setFieldError("sockName");
            if(strFocusField == "")
            {
                strFocusField = "sockName";
            }
            allFieldsOK = false;
        }
        
        if(lYarnWeightNotNull)
        {
            strYarnWeight = String.valueOf(yarnWeightComboBox.getSelectedItem());
        }
        else
        {
           strErrorText = strErrorText + "-Please select the weight of yarn you're using for these socks" ;
            setFieldError("yarn");
            allFieldsOK = false;
        }

        if(lNeedlesNotNull && lNeedlesVal)
        {
            dNeedleSize = Double.parseDouble(needleSizeTextField.getText());
        }
        else
        {
           strErrorText = strErrorText + "-Please enter your US needle size (decimals)" + "\n" +
                                          "   Decimal numbers only, please" + "\n";
            setFieldError("needles");
            if(strFocusField == "")
            {
                strFocusField = "needles";
            }
            allFieldsOK = false;
        }        

        if(lGaugeSPINotNull && lGaugeSPIVal)
        {
            dGaugeSPI = Double.parseDouble(gaugeSPITextField.getText());
        }
        else
        {
            strErrorText = strErrorText + "-Please your stitches per inch (decimals)" + "\n"+
                                          "   Decimal numbers only, please" + "\n";
            setFieldError("gaugeSPI");
            if(strFocusField == "")
            {
                strFocusField = "gaugeSPI";
            }
            allFieldsOK = false;
        }

        if(lGaugeRPINotNull && lGaugeRPIVal)
        {
            dGaugeRPI = Double.parseDouble(gaugeRPITextField.getText());
        }
        else
        {
            strErrorText = strErrorText + "-Please your rows per inch (decimals)" + "\n"+
                                          "   Decimal numbers only, please" + "\n";
            setFieldError("gaugeRPI");
            if(strFocusField == "")
            {
                strFocusField = "gaugeRPI";
            }
            allFieldsOK = false;
        }
        
        if(!allFieldsOK)
        {
            JOptionPane.showMessageDialog(this, strErrorText);
            findFocus(strFocusField);
        }
        
        else
        {
            resetAllFields();
            PatternDoc thePattern = new PatternDoc();
            ModSock newSock       = new ModSock(dSockLength, dSockCirc, dGaugeSPI, dGaugeRPI, strSockName, strYarnWeight, dNeedleSize);
            if(quickieCheckBox.isSelected())
            {
            thePattern.setThePattern(newSock.toString());            
            thePattern.writePattern(strSockName + "_quickPrint.txt");
            JOptionPane.showMessageDialog(this, "Your pattern is complete.");
            System.exit(0);
 
            }
            else
            {
            String patternString = "Instructions:" + "\n\n"
                                    + "Wrap & Turn: \n"
                                    + "    Knitwise:" + "\n"
                                    + "        slip next stitch purlwise onto right needle \n"
                                    + "        bring yarn to front \n"
                                    + "        put the slipped stitch back onto left needle \n"
                                    + "        turn \n"
                                    + "        bring yarn to front (because your new row will be a purl row) \n"
                                    + "        Place Marker \n\n"
                                    + "    Purlwise: \n"
                                    + "        slip next stitch purlwise onto right needle \n"
                                    + "        bring yarn to back \n"
                                    + "        put the slipped stitch back ontoleft needle \n"
                                    + "        turn \n"
                                    + "        bring yarn to back (because your new row will be a knit row) \n"
                                    + "        Place Marker \n\n"
                                    + "============================================= \n"
                                    + "\n\n"
                                    + "How to work wrapped stitches:\n"
                                    + "    Knit Row:\n"
                                    + "        Pick up front bar of wrap as if to knit and place it on left needle\n"
                                    + "        Slip wrap and wrapped stitch to right needle as if to knit\n"
                                    + "        Insert left needle into front of two slipped stitches on right needle (as in an SSK)\n"
                                    + "        Knit the two stitches together\n"
                                    + "    Purl Row:\n"
                                    + "        Pick up back bar of wrap and place iton left needle with the stitch it wrapped \n"
                                    + "        Purl both stitches together\n\n"
                                    + "==============================================\n"
                                    + "\n\n"
                                    + "Backward Yarn Over (BYO) \n"
                                    + "    Bring the yarn over your right needle from BACK to FRONT \n"
                                    + "    knitting into the front of this stitch on the next row will create an invisible increase\n"
                                    + "Yarn Over (YO) \n"
                                    + "    Bring the yarn over your right needle FRONT to BACK \n"
                                    + "    knitting into the back of this stitch on next row will create an invisible increase\n\n"
                                    + "==============================================\n"
                                    + "\n\n";
            thePattern.setThePattern(patternString);
            thePattern.setThePattern(buildPattern(newSock));
            thePattern.writePattern(strSockName + "_pattern.txt");
            JOptionPane.showMessageDialog(this, "Your pattern is complete.");
            System.exit(0);
            }
            
        }
        
    }//GEN-LAST:event_writePatternButtonActionPerformed
/**
 * @param args the command line arguments
 */
public static void main(String args[])
{
    /*
     * Set the Nimbus look and feel
     */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /*
     * If Nimbus (introduced in Java SE 6) is not available, stay with the
     * default look and feel.
     * For details see
     * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
     */
    try
    {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
        {
            if ("Nimbus".equals(info.getName()))
            {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    }
    catch (ClassNotFoundException ex)
    {
        java.util.logging.Logger.getLogger(ModSockForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (InstantiationException ex)
    {
        java.util.logging.Logger.getLogger(ModSockForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (IllegalAccessException ex)
    {
        java.util.logging.Logger.getLogger(ModSockForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (javax.swing.UnsupportedLookAndFeelException ex)
    {
        java.util.logging.Logger.getLogger(ModSockForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /*
     * Create and display the dialog
     */
    java.awt.EventQueue.invokeLater(new Runnable()
    {

    public void run()
    {
        ModSockForm dialog = new ModSockForm(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter()
        {

        @Override
        public void windowClosing(java.awt.event.WindowEvent e)
        {
            System.exit(0);
        }

        });
        dialog.setVisible(true);
    }

    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField circEaseTextField;
    private javax.swing.JLabel footCircLabel;
    private javax.swing.JTextField footCircTextField;
    private javax.swing.JLabel footLengthLabel;
    private javax.swing.JTextField footLengthTextField;
    private javax.swing.JPanel footMeasurementPanel;
    private javax.swing.JLabel formLabel;
    private javax.swing.JPanel gaugeAndYarnPanel;
    private javax.swing.JLabel gaugeRPILabel;
    private javax.swing.JTextField gaugeRPITextField;
    private javax.swing.JLabel gaugeSPILabel;
    private javax.swing.JTextField gaugeSPITextField;
    private javax.swing.JTextField lengthEaseTextField;
    private javax.swing.JLabel needleSizeLabel;
    private javax.swing.JTextField needleSizeTextField;
    private javax.swing.JCheckBox quickieCheckBox;
    private javax.swing.JLabel sockCircEaseLabel;
    private javax.swing.JLabel sockCircLabel;
    private javax.swing.JLabel sockLengthEaseLabel;
    private javax.swing.JLabel sockLengthLabel;
    private javax.swing.JPanel sockMeasurementPanel;
    private javax.swing.JLabel sockNameLabel;
    private javax.swing.JTextField sockNameTextField;
    private javax.swing.JButton writePatternButton;
    private javax.swing.JComboBox<String> yarnWeightComboBox;
    private javax.swing.JLabel yarnWeightLabel;
    // End of variables declaration//GEN-END:variables
}
