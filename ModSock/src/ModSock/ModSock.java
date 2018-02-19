package ModSock;

import static java.lang.Math.*;
import javax.swing.JOptionPane;

public class ModSock
{

    private double dSockLength;
    private double dGaugeRPI;         // rows per inch
    private int    iMaxStitches;      // total number of stitches around sock
    private int    iCastOn;
    private int    iToeIncreaseStitches;
    private int    iToeIncreaseRows;
    private double dToeLength            = 0; // calculated
    private int    iKnitStraightRows     = 0; // calculated
    private double dKnitStraightLength   = 0; // calculated
    private double dHeelLength           = 0; // calculated
    private double dHeelTurnLength       = 0;
    private int    iHeelTurnRows         = 0;
    private double dGussetLength         = 0; // calculated
    private int    iGussetRows           = 0;
    private int    iGussetIncrStitches   = 0;
    private int    iGussetIncrRows       = 0;
    private int    iSoleStitches         = 0;
    private double dToeToAnkleInches     = 0;
    private int    iToeToAnkleRows       = 0;
    private double dFootLengthInches     = 0;
    private int    iFootLengthRows       = 0;
    private int    iStopHeelTurn         = 0;
    private int    iToeRows              = 0;
    
    @Override
    public String toString()
    {
        String strOutputString = "";
        strOutputString = "Total Stitches: " + this.iMaxStitches + "\n"
                          + "Foot length: " + this.dFootLengthInches + "\n"
                          + "Toe-to-Ankle: " + this.dToeToAnkleInches + "\n"
                          + "Gauge - rows per inch: " + this.dGaugeRPI + "\n"
                          + "Sock Length: " + this.dSockLength + "\n"
                          + "Toe Length: " + this.dToeLength + "\n"
                          + "Total toe rows: " + this.iToeRows + "\n"
                          + "Cast-on: " + this.iCastOn + "\n"
                          + "Toe Increase Stitches: " + this.iToeIncreaseStitches + "\n"
                          + "     Toe Increase Rows: " + this.iToeIncreaseRows  + "\n"
                          + "Total toe rows / Increase Rows: " + (this.iToeRows / this.iToeIncreaseRows) + "\n"
                          + "   Which means you'll increase by 4 every " + (this.iToeRows / this.iToeIncreaseRows) + " rows \n" 
                          + "Sole Stitches: " + this.iSoleStitches + "\n"
                          + "Knit straight length: " + this.dKnitStraightLength + "\n"
                          + "Knit straight rows: " + this.iKnitStraightRows + "\n"
                          + "Stop wrapping at: " + this.iStopHeelTurn + "\n"
                          + "Heel Turn length: " + this.dHeelTurnLength + "\n"
                          + "Heel Turn Rows: " + this.iHeelTurnRows + "\n"
                          + "Start Gusset at: " + (this.dSockLength - this.dGussetLength - (this.dHeelTurnLength / 2)) + "\n"
                          + "Gusset should be " + (this.dSockLength - this.dToeToAnkleInches ) + " inches long " + "\n"
                          + "    (which is the sock length - toe-to-angle length)" + "\n"
                          + "Gusset Increase Stitches: " + this.iGussetIncrStitches + "\n"
                          + "Gusset Increase Rows: " + this.iGussetIncrRows + "\n"
                          + "Gusset Length: " + this.dGussetLength + "\n"
                          + "It should take " + this.iHeelTurnRows + " rows to turn the heel " + "\n"
                          + "Most of which will be the back of the sock rather than on the heel " +"\n"
                          + "Knit straight formula: sock Length - (toe length + gusset length + (heel turn length / 2))" + "\n"
                          + "    " + this.dSockLength  + " - (" + this.dToeLength + "  +  " + this.dGussetLength + "  +  " + (this.dHeelTurnLength)  + " / 2 (" + (this.dHeelTurnLength / 2) + "))\n\n";
                          
        return strOutputString;
    }
    
    
    ModSock(double footLength, double lengthEase, int maxStitches, double RPI, double toeToAnkle)
    {
        this.dFootLengthInches = footLength;
        // lengthEase is actually a percentage of the foot
        this.dSockLength = footLength - lengthEase;
        this.iMaxStitches = maxStitches;
        this.dGaugeRPI   = RPI; // rows per inch
        this.dToeLength = this.dFootLengthInches / 4;
        double dToeRows = this.dToeLength * this.dGaugeRPI;
        if (dToeRows % 1 != 0)
            dToeRows = ceil(dToeRows);
        this.iToeRows = (int) dToeRows;
        if (this.iToeRows % 2 != 0)
        {
            this.iToeRows = this.iToeRows + 1;
        }
        
        // calculate cast-on
        // 1/3 of max stitches
        this.iCastOn = this.iMaxStitches / 3;
        if(this.iCastOn % 2 != 0)
        {
            this.iCastOn = this.iCastOn + 1;
        }
        
        // cast-on - iMaxStitches
        
        

        if(toeToAnkle == 0)
        {
            // the ankle hits the foot at around 2/3 of the total foot length
            this.dToeToAnkleInches = (this.dFootLengthInches / 3) * 2;
        }
        else
        {
            this.dToeToAnkleInches = toeToAnkle;
        }
        
        // get number of toe stitches to increase
        // get toe length
        this.iToeIncreaseStitches = this.iMaxStitches - this.iCastOn;
        this.iToeIncreaseRows = this.iToeIncreaseStitches / 4;
       
        
        //get sole stitches
        //get gusset increase stitches
        this.iSoleStitches = this.iMaxStitches / 2;
        this.dGussetLength = this.dSockLength - this.dToeToAnkleInches;
        this.iGussetIncrRows = (int)(this.dGussetLength * this.dGaugeRPI);
        if(this.iGussetIncrRows % 2 != 0)
        {
            this.iGussetIncrRows = this.iGussetIncrRows + 1;
        }
        this.iGussetIncrStitches = this.iGussetIncrRows;
        
        this.iStopHeelTurn = (iMaxStitches / 3) / 2;        
        iHeelTurnRows = ((iMaxStitches - 2) - iStopHeelTurn ) / 4 + 1;
        this.dHeelTurnLength = iHeelTurnRows / this.dGaugeRPI;
        
        // gusset increase ends at end of heel
        double dGussetToeHeelIn = dGussetLength + dToeLength + (this.dHeelTurnLength / 2);
        double dGussetToeHeelRows = iGussetIncrRows + iToeIncreaseRows + (this.iHeelTurnRows / 2);
        
        this.dKnitStraightLength = this.dSockLength - dGussetToeHeelIn;
        double dKnitStraightRows = this.dKnitStraightLength * this.dGaugeRPI;
        if (dKnitStraightRows % 1 != 0)
            dKnitStraightRows = ceil(dKnitStraightRows);
        this.iKnitStraightRows = (int) dKnitStraightRows;

    }
    
    public int getHeelTurnRows()
    {
        return this.iHeelTurnRows;
    }
    
    public int getMaxStitches()
    {
        return this.iMaxStitches;
    }

    public double getKnitStraighLength()
    {
        return this.dKnitStraightLength;
    }
    
    public int getKnitStraightRows()
    {
        return this.iKnitStraightRows;
    }
    
    public double getToeLength()
    {
        return this.dToeLength;
    }
    
    public int getCastOn()
    {        
        return this.iCastOn;
    }
    
    public int getGussetRows()
    {
        return this.iGussetIncrRows;
    }
    
    public int getGussetStitches()
    {
        return this.iGussetIncrStitches;
    }
    
    public double getGussetLength()
    {
        return this.dGussetLength;
    }
    
    public int getToeIncreaseStitches()
    {
        return this.iToeIncreaseStitches;
    }
    
    public int getToeIncreaseRows()
    {
        return this.iToeIncreaseRows;
    }

    public int getSoleStitches()
    {
        return this.iSoleStitches;
    }
    
    public double getRPI()
    {
        return this.dGaugeRPI;
    }
        

    
// formula for figuring out how long to knit after toe before gusset inc's
//               total sock length - (T + HT + GL) (inches)
// M  = totalStitches for sock circumference (stitches) (after toe-increase) 
// R  = rows per inch
// S  = 1/2 * M (stitches in the sole and nbr of rows to increase for gusset)
// G  = 1/2 * S (stitches increased on each side of sole for gusset) (stitches)
// W  = 1/2 * sock circumference (width of heel)
// GL = S / R (inches) (Gusset Length)
// HT = 1/2 * W (heel turn length - inches)
// T = ((maxStitches - cast-on stitches) / 2) / rows per inch (toe length) (inches)
//      for example 72 max stitches - cast-on (24) = 48 / 2 = 24 / 10 (rows / inch)
//                                                            the toe is 2.4"    
    // calculate cast-on (1/3 of max stitches)
    // calculate toe length and toe rows
    // calculate sole stitches (1/2 iMaxStitches)
    // calculate number of rows needed to increase for gusset (1/2 iMaxStitches)
    // calculate numbner of stitches to increase on each side of the sole for the gusset (1/4 iMaxStitches)
    // calculate width of heel (1/2 circumferece)
    // calculate heel turn length (1/2 heel width)
    // calculate length to knit plain after toe increase and before gusset shaping
    //   

  
}
