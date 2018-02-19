using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;


/* "<script language=Javascript>alert('Please only enter decimal values. Width, Length and SPI/RPI cannot be blank');</script>";
*/

namespace sockPattern
{
    public partial class sockForm : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            sockMeasCircLabel.Text = "?";
            sockMeasLengthLabel.Text = "?";
            oneQrtrOfMaxStsLabel.Text = "?";
            maxStitchesLabel.Text = "?";
            twoThirdsSockLengthLabel.Text = "?";
            maxStsLess2Label.Text = "?";
            inputErrorLabel.Text = "";
        }

        protected void calcButton1_Click(object sender, EventArgs e)
        {
            double dFootWidth = 0;
            double dFootLength = 0;
            double dSockWidth = 0;
            double dSockLength = 0;
            double dTwoThirdsSock = 0;
            double dSpi = 0;
            double dRpi = 0;
            double dQuarterOfMax = 0;
            int iQuarterOfMax = 0;
            double dMaxStitches = 0;
            double dSockMultiplier = 2d / 3d;
            int iMaxStitches = 0;
            String sErrorText = "";

            //if footLengthTextBox or footWidthTextBox is blank or contains characters other than numbers and decimal
            // return error
            //if spiTextBox or rpiTextBox is blank or contains chars other than numbers and decimal
            // return error
            // sample code: if (!double.TryParse(footWidthTextbox.Text, out dFootWidth)) then error
            if (footLengthTextBox.Text == "" || (!double.TryParse(footLengthTextBox.Text, out dFootLength)) ||
                footWidthTextBox.Text == "" || (!double.TryParse(footWidthTextBox.Text, out dFootWidth)) ||
                rpiTextBox.Text == "" || (!double.TryParse(rpiTextBox.Text, out dRpi)) ||
                spiTextBox.Text == "" || (!double.TryParse(spiTextBox.Text, out dSpi)))
            {
                sErrorText = "Please only enter decimal values. Width, Length and SPI / RPI cannot be blank";
            }

            // if all data is correct then
            // calculate dMaxStitches
            // calculate iMaxStitches for maxStitchesLabel (if dMaxStitches is a fraction or not divisible by 2)
            // calculate footLengthTextBox value * 2/3 to display on twoThirdsSockLengthLabel
            // calculate iMaxStitches * .25 to display on oneQuarterOfMaxStitchesLabel
            // calculate iMaxStitches - 2 to display on maxStsLess2Label
            // calculate sockMeasLengthLabel = footLengthTextBox.value - (footLengthTextBox.value * .10)
            // calculate sockMeasWidthLabel = footWidthTextBox.value - (footWidthTextBox.value * .10)
            
                dSockLength = Math.Round(dFootLength - (dFootLength * .10), 2);
                dSockWidth = Math.Round(dFootWidth - (dFootWidth * .10), 2);
                dMaxStitches = dSockWidth * dSpi;
                iMaxStitches = (int)Math.Ceiling(dMaxStitches);
                if (iMaxStitches % 2 != 0)
                {
                    iMaxStitches = iMaxStitches + 1;
                }
                dTwoThirdsSock = dSockLength * dSockMultiplier;
                //dTwoThirdsSock = Math.Round(dTwoThirdsSock, 1);
                dQuarterOfMax = dMaxStitches * .25;
                iQuarterOfMax = (int)Math.Ceiling(dQuarterOfMax);
                if (iQuarterOfMax % 2 != 0)
                {
                    iQuarterOfMax = iQuarterOfMax + 1;
                }

            if (!sErrorText.Equals(""))
            {
                inputErrorLabel.Text = "Please only enter decimal values. Width, Length and SPI/RPI cannot be blank";
                sockMeasCircLabel.Text = "?";
                sockMeasLengthLabel.Text = "?";
                oneQrtrOfMaxStsLabel.Text = "?";
                maxStitchesLabel.Text = "?";
                twoThirdsSockLengthLabel.Text = "?";
                maxStsLess2Label.Text = "?";
            }
            else
            {
                footLengthMeasLabel.Text = footLengthTextBox.Text;
                footCircMeasLabel.Text = footWidthTextBox.Text;
                spiLabel.Text = spiTextBox.Text;
                spiLabel0.Text = spiLabel.Text;
                rpiLabel.Text = rpiTextBox.Text;
                sockMeasCircLabel.Text = dSockWidth.ToString();
                sockMeasCircLabel0.Text = sockMeasCircLabel.Text;
                sockMeasLengthLabel.Text = dSockLength.ToString();
                oneQrtrOfMaxStsLabel.Text = iQuarterOfMax.ToString();
                maxStitchesLabel.Text = iMaxStitches.ToString();
                maxStitchesLabel0.Text = dMaxStitches.ToString();
                twoThirdsSockLengthLabel.Text = dTwoThirdsSock.ToString();
                maxStsLess2Label.Text = (iMaxStitches - 2).ToString();
            }
            
        }
    }
}
