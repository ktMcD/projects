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
    totalStitchesTextField.requestFocus();
}

public void setFieldError(String theField)
{
    if(theField == "footLength")
    {
        footLengthTextField.setBackground(Color.yellow);
        footLengthLabel.setForeground(Color.red);
    }
    if(theField == "maxStitches")
    {
        totalStitchesTextField.setBackground(Color.yellow);
        totalStitchesLabel.setForeground(Color.red);
    }
    if(theField == "lengthEase")
    {
        lengthEaseTextField.setBackground(Color.yellow);
        sockLengthEaseLabel.setForeground(Color.red);
    }

    if(theField == "gaugeRPI")
    {
        gaugeRPITextField.setBackground(Color.yellow);
        gaugeRPILabel.setForeground(Color.red);
    }
    
}

public void resetFieldColors(String theField)
{

    if(theField == "footLength")
    {
        footLengthTextField.setBackground(Color.white);
        footLengthLabel.setForeground(Color.black);
    }
    if(theField == "totalStitches")
    {
        totalStitchesTextField.setBackground(Color.white);
        totalStitchesLabel.setForeground(Color.black);
    }
    if(theField == "lengthEase")
    {
        lengthEaseTextField.setBackground(Color.white);
        sockLengthEaseLabel.setForeground(Color.black);
    }

    if(theField == "gaugeSPI")
    {
        totalStitchesTextField.setBackground(Color.white);
        totalStitchesTextField.setForeground(Color.black);
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

public boolean validateInteger(String theNumber)
{
    boolean lNumValid = true;
    
    try
    {
        Integer.parseInt(theNumber);
    }
    catch(NumberFormatException badDE)
    {
        lNumValid = false;
        return lNumValid;
    }
    return lNumValid;
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
    else if(theField == "totalStitches")
    {
        totalStitchesTextField.requestFocus();
    }
    else if(theField == "lengthEase")
    {
        lengthEaseTextField.requestFocus();
    }
    else if(theField == "gaugeSPI")
    {
        totalStitchesTextField.requestFocus();
    }
    else if(theField == "gaugeRPI")
    {
        gaugeRPITextField.requestFocus();
    }
}

public void resetAllFields()
{

    footLengthTextField.setText("");
    totalStitchesTextField.setText("");
    lengthEaseTextField.setText("");
    totalStitchesTextField.setText("");
    gaugeRPITextField.setText("");
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
                  + "Cast on " + theSock.getCastOn() + " stitches using Judy's magic cast-on (that's " + (theSock.getCastOn() / 2) + " stitches per needle) \n"
                  + "Row 1: Knit around; \n"
                  + "Row 2 both needles: Knit 1, backwards yarn over (BYO), knit to last stitch, yarn over (YO), knit last stitch. \n"
                  + "                    You have increased the number of stitches on each needle by 2 \n"
                  + "Row 3 both needles: Knit 1, knit into the BYO you made in the previous row (it should knit twisted) \n"
                  + "                    Knit to second-to-last stitch (the last YO you made in the previous row), \n"
                  + "                         knit into back of the YO (it should knit twisted), knit last stitch \n"
                  + "Repeat rows 2 and 3 until you have increased to " + theSock.getMaxStitches() + " stitches \n"
                  + "    You should have added " + theSock.getToeIncreaseStitches() + " stitches (" + (theSock.getToeIncreaseStitches() / 2) + " stitches each end).\n"
                  + "over " + theSock.getToeIncreaseRows() + " rows. End on a row-3 row. \n\n"
                  + "Knit straight for " + theSock.getKnitStraighLength() + " inches (approx. " + theSock.getKnitStraightRows() + " rows)"
                  + "\n\n"
                  + "GUSSET:\n"
                  + "Now it's time to increase for the gusset of our sock. \n"
                  + "Over the next " + theSock.getGussetLength() + " inches (approximately " + theSock.getGussetRows() + " rows), you will increase only on the sole needle (needle 1).\n"
                  + "Row 1 Needle 1: knit 1, PLACE MARKER, BYO, knit to second-to-last stitch, YO, PLACE MARKER, knit last stitch;\n"
                  + "Row 1 Needle 2: knit across; \n"
                  + "Row 2 Needle 1: knit 1, knit into BYO you made in the previous row, \n"
                  + "                knit across to second-to-last stitch (the YO you made in the previous row), knit into the back of the YO (it should knit twisted);\n"
                  + "Row 2 Needle 2: knit across; \n"
                  + "Repeat rows 1 and 2 until you have added " + theSock.getGussetStitches() + " stitches to Needle 1, for a total of " + (theSock.getSoleStitches() + theSock.getGussetStitches()) + " stitches on Needle 1."
                  + "\n\n"
                  + "TURNING THE HEEL \n"
                  + "For the next few rows, we will only be working on the sole needle (Needle 1), leaving the instep needle (Needle 2) unworked for now. \n"
                  + "You should have placed markers inside the new gusset stitches on the two ends of Needle 1, leaving the original sole stitches in the center.\n"
                  + "Row 1 (right side - RS): Knit to 1 stitch before second marker, Wrap & Turn (W&T);\n"
                  + "Row 2: (wrong side - WS): Purl to 1 stitch before the first marker, W&T;\n"
                  + "Row 3: Knit to 2 stitches before the last wrap, W&T \n"
                  + "Row 4: Purl to 2 stitches before the last wrap, W&T \n"
                  + "Repeat rows 3 and 4 until you have approximately " + (theSock.getMaxStitches() / 3 ) + " stitches left between the wraps closest to the center, \n"
                  + "  end with PURL row\n"
                  + "Next two rows:\n"
                  + "    Row 1: Knit across the sole stitches, working each wrap together with the stitch it wraps, W&T.\n"
                  + "    Row 2: Purl across the sole stitches, purling the stitches you just knit together and working each wrap together with the stitch it wraps, W&T. \n"
                  + "You have just completed turning the heel!!\n\n"
                  + "HEEL FLAP\n"
                  + "Row 1 (RS): Knit to second marker, slip wrap, slip wrapped stitch, slip next stitch (total of 3), knit all 3 together, turn \n"
                  + "Row 2 (WS): Slip 1, purl to first marker, slip wrap, slip wrapped stitch, slip next stitch (total of 3), purl all 3 together, turn \n"
                  + "Row 3 (RS): Slip 1, knit 1, slip 1, knit 1, repeating all the way across to 1 stitch before marker, ssk, turn (slip as if to knit)\n"
                  + "Row 4 (WS): Slip 1, purl to 1 stitch before marker, purl next two together, turn \n"
                  + "Repeat fows 3 and 4 until there is one stitch on each side left to be worked, end on a purl row.\n\n"
                  + "Knit across to last stitch waiting to be integrated into the heel, SSK \n"
                  + "Return to working in the round, knitting across the instep stitches waiting on your other needle. \n"
                  + "Once you have knitted across the last instep stitch, and you're back at the heel, you have one remaining gusset / heel stitch to be worked \n"
                  + "SSK this stitch with next stitch, knit across top complete your heel flap"
                  + "\n"
                  + "Switch to one size smaller needles for cuff\n\n" ;
    
        
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
        footMeasurementPanel = new javax.swing.JPanel();
        footLengthTextField = new javax.swing.JTextField();
        footLengthLabel = new javax.swing.JLabel();
        sockLengthEaseLabel = new javax.swing.JLabel();
        lengthEaseTextField = new javax.swing.JTextField();
        toeToAnkleLabel = new javax.swing.JLabel();
        toeToAnkleTextField = new javax.swing.JTextField();
        writePatternButton = new javax.swing.JButton();
        stitchPanel = new javax.swing.JPanel();
        gaugeRPILabel = new javax.swing.JLabel();
        gaugeRPITextField = new javax.swing.JTextField();
        totalStitchesLabel = new javax.swing.JLabel();
        totalStitchesTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        formLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        formLabel.setText("All Measurements in Inches");
        formLabel.setFocusable(false);

        footLengthLabel.setText("Foot Length:");
        footLengthLabel.setFocusable(false);

        sockLengthEaseLabel.setText("Ease:");
        sockLengthEaseLabel.setFocusable(false);

        toeToAnkleLabel.setText("Toe to Ankle:");

        javax.swing.GroupLayout footMeasurementPanelLayout = new javax.swing.GroupLayout(footMeasurementPanel);
        footMeasurementPanel.setLayout(footMeasurementPanelLayout);
        footMeasurementPanelLayout.setHorizontalGroup(
            footMeasurementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footMeasurementPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(footMeasurementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(toeToAnkleLabel)
                    .addComponent(footLengthLabel)
                    .addComponent(sockLengthEaseLabel))
                .addGap(30, 30, 30)
                .addGroup(footMeasurementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(footLengthTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(lengthEaseTextField)
                    .addComponent(toeToAnkleTextField))
                .addContainerGap())
        );
        footMeasurementPanelLayout.setVerticalGroup(
            footMeasurementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footMeasurementPanelLayout.createSequentialGroup()
                .addGap(0, 9, Short.MAX_VALUE)
                .addGroup(footMeasurementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toeToAnkleLabel)
                    .addComponent(toeToAnkleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(footMeasurementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(footLengthLabel)
                    .addComponent(footLengthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(footMeasurementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lengthEaseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sockLengthEaseLabel)))
        );

        writePatternButton.setText("Write Pattern");
        writePatternButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                writePatternButtonActionPerformed(evt);
            }
        });

        gaugeRPILabel.setText("Gauge (rows per inch):");
        gaugeRPILabel.setFocusable(false);

        totalStitchesLabel.setText("Total Stitches:");
        totalStitchesLabel.setFocusable(false);

        javax.swing.GroupLayout stitchPanelLayout = new javax.swing.GroupLayout(stitchPanel);
        stitchPanel.setLayout(stitchPanelLayout);
        stitchPanelLayout.setHorizontalGroup(
            stitchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stitchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(stitchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(stitchPanelLayout.createSequentialGroup()
                        .addComponent(gaugeRPILabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gaugeRPITextField, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(stitchPanelLayout.createSequentialGroup()
                        .addComponent(totalStitchesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(totalStitchesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        stitchPanelLayout.setVerticalGroup(
            stitchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stitchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(stitchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalStitchesTextField)
                    .addComponent(totalStitchesLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(stitchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gaugeRPILabel)
                    .addComponent(gaugeRPITextField)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(formLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(stitchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(writePatternButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(footMeasurementPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(formLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(stitchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(footMeasurementPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(writePatternButton)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void writePatternButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_writePatternButtonActionPerformed
    {//GEN-HEADEREND:event_writePatternButtonActionPerformed
        double  dFootLength          = 0;
        double  dSockLengthEase      = 0;
        double  dSockLength          = 0; // calculated
        int     iTotalStitches       = 0;
        double  dGaugeRPI            = 0;
        double  dToeToAnkleInches    = 0;
        boolean allFieldsOK          = true;
        boolean lFLengthNotNull      = valIsNotEmpty(footLengthTextField.getText());
        boolean lFLengthVal          = validateDouble(footLengthTextField.getText());
        boolean lSLengthEaseNotNull  = valIsNotEmpty(lengthEaseTextField.getText());
        boolean lSLengthEaseVal      = validateDouble(lengthEaseTextField.getText());
        boolean lGaugeRPINotNull     = valIsNotEmpty(gaugeRPITextField.getText());
        boolean lGaugeRPIVal         = validateDouble(gaugeRPITextField.getText());
        boolean lTotStitchesNotNull  = valIsNotEmpty(totalStitchesTextField.getText());
        boolean lTotStitchesVal      = validateInteger(totalStitchesTextField.getText());
        boolean lToeToAnkleVal       = validateDouble(toeToAnkleTextField.getText());
        boolean lToeToAnkleNotNull   = valIsNotEmpty(toeToAnkleTextField.getText());
        boolean lWriteOK             = false;
        
        String  strErrorText         = "";
        String  strFocusField        = "";

        if(lToeToAnkleNotNull && lToeToAnkleVal)
        {
            dToeToAnkleInches = Double.parseDouble(toeToAnkleTextField.getText());
        }
        else
        {
           dToeToAnkleInches = 0;
        }

        if(lGaugeRPINotNull && lGaugeRPIVal)
        {
            dGaugeRPI = Double.parseDouble(gaugeRPITextField.getText());
        }
        else
        {
            strErrorText = strErrorText + "-Please enter your rows per inch (decimals)" + "\n"+
                                          "   Decimal numbers only, please" + "\n";
            setFieldError("gaugeRPI");
            if(strFocusField == "")
            {
                strFocusField = "gaugeRPI";
            }
            allFieldsOK = false;
        }

       if(lSLengthEaseNotNull && lSLengthEaseVal)
        {
            dSockLengthEase = Double.parseDouble(lengthEaseTextField.getText());
        }
        else
        {
            strErrorText = strErrorText + "-Please enter sock length ease as the real amount by which we will shrink the sock" + "\n"+
                                          "   Decimal numbers only, please" + "\n";
            setFieldError("lengthEase");
            if(strFocusField == "")
            {
                strFocusField = "lengthEase";
            }
            allFieldsOK = false;
        }

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

        if(lTotStitchesNotNull && lTotStitchesVal)
        {
            iTotalStitches = Integer.parseInt(totalStitchesTextField.getText());
        }
        else
        {
            strErrorText = strErrorText + "-Please enter max stitches " + "\n"+
                                          "   Whole numbers only, please" + "\n";
            setFieldError("maxStitches");
            if(strFocusField == "")
            {
                strFocusField = "maxStitches";
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
            ModSock newSock       = new ModSock(dFootLength, dSockLengthEase, iTotalStitches, dGaugeRPI, dToeToAnkleInches);
            
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
            thePattern.setThePattern(newSock.toString());
            thePattern.setThePattern(buildPattern(newSock));
            lWriteOK = thePattern.writePattern("_pattern.txt");
            if(lWriteOK)
            {
                JOptionPane.showMessageDialog(this, "Your pattern is complete.");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Something failed");
            }
            
            System.exit(0);
            
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
    private javax.swing.JLabel footLengthLabel;
    private javax.swing.JTextField footLengthTextField;
    private javax.swing.JPanel footMeasurementPanel;
    private javax.swing.JLabel formLabel;
    private javax.swing.JLabel gaugeRPILabel;
    private javax.swing.JTextField gaugeRPITextField;
    private javax.swing.JTextField lengthEaseTextField;
    private javax.swing.JLabel sockLengthEaseLabel;
    private javax.swing.JPanel stitchPanel;
    private javax.swing.JLabel toeToAnkleLabel;
    private javax.swing.JTextField toeToAnkleTextField;
    private javax.swing.JLabel totalStitchesLabel;
    private javax.swing.JTextField totalStitchesTextField;
    private javax.swing.JButton writePatternButton;
    // End of variables declaration//GEN-END:variables
}
