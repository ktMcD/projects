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

        if(lSLengthEaseNotNull && lSLengthEaseVal)
        {
            dSockLengthEase = Double.parseDouble(lengthEaseTextField.getText());
            JOptionPane.showMessageDialog(this, dSockLength);
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