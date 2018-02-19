package ModSock;

import static java.lang.Math.*;

public class ModSock
{

    private String strSockName;
    private double dSockLength;
    private double dSockCirc;
    private double dGaugeSPI;         // stitches per inch
    private double dGaugeRPI;         // rows per inch
    private int    iMaxStitches;      // total number of stitches around sock
    private int    iCastOn;
    private int    iToeIncreaseStitches;
    private int    iToeIncreaseRows;
        private int    iKnitStraightRows     = 0; // calculated
    private double dKnitStraightLength   = 0; // calculated
    private int    iGussetIncrStitches   = 0;
    private int    iGussetIncrRows       = 0;
    private int    iSoleStitches         = 0;
    private String strYarnWeight         = "";
    private double dNeedles              = 0;
    
    @Override
    public String toString()
    {
        String strOutputString = "";
        strOutputString = "Sock Name: " + this.strSockName + "\n"
                          + "Sock Length: " + this.dSockLength + "\n"
                          + "Sock Width: " + this.dSockCirc + "\n"
                          + "Gauge (stitches per inch): " + this.dGaugeSPI + "\n"
                          + "Gauge (rows per inch): " + this.dGaugeRPI + "\n"
                          + "Cast-on: " + this.iCastOn + "\n"
                          + "Toe Increase Stitches: " + this.iToeIncreaseStitches + "\n"
                          +" Toe Increase Rows: " + this.iToeIncreaseRows  + "\n"
                          + "Total Stitches: " + this.iMaxStitches + "\n"
                          + "Sole Stitches: " + this.iSoleStitches + "\n"
                          + "Knit straight length: " + this.dKnitStraightLength + "\n"
                          + "Knit straight rows: " + this.iKnitStraightRows + "\n"
                          + "Gusset Increase Stitches: " + this.iGussetIncrStitches + "\n"
                          + "Gusset Increase Rows: " + this.iGussetIncrRows + "\n"
                          + "Knit straight formula: sock Length x (2/3)" + " = \n"
                          + "    " + this.dSockLength  * 2/3 ;
                          
        return strOutputString;
    }
    
    
    ModSock(double sockLength, double sockCirc, double SPI, double RPI, String sockName, String strYarn, double needles)
    {
        this.dSockLength = sockLength;
        this.dSockCirc   = sockCirc;
        this.dGaugeSPI   = SPI; // stitches per inch
        this.dGaugeRPI   = RPI; // rows per inch
        this.strSockName = sockName;
        this.dNeedles    = needles;
        this.strYarnWeight = strYarn;


        // calculates max stitches for entire sock
        double M = 0;
        M = dSockCirc * dGaugeSPI;
        // round the number up if it isn't a whole number
        if(M % 1 != 0)
        {
            M = ceil(M);
        }
        
        // now set the double to an int value
        this.iMaxStitches = (int) M;
        
        //since we're using two circulars, get an even number for stitch count
        if(this.iMaxStitches % 2 != 0)
        {
            this.iMaxStitches = this.iMaxStitches + 1;
        }
        
        // get cast-on stitches
        double C = 0;
        C = this.iMaxStitches / 3;
        // round the number up if it isn't a whole number
        if(C % 1 != 0)
        {
            C = ceil(C);
        }
        
        // get an even cast-on number
        this.iCastOn = (int) C;
        if(this.iCastOn % 2 != 0)
        {
            this.iCastOn = this.iCastOn + 1;
        }
        
        //now get an even number for each needle
        if((this.iCastOn / 2) % 2 != 0)
        {
            this.iCastOn = this.iCastOn + 2;
        }

        // get number of toe stitches to increase
        // get toe length
        this.iToeIncreaseStitches = this.iMaxStitches - this.iCastOn;
        this.iToeIncreaseRows = this.iToeIncreaseStitches / 2;
        
        //get sole stitches
        //get gusset increase stitches
        this.iSoleStitches = this.iMaxStitches / 2;
        this.iGussetIncrRows = iSoleStitches;
                this.iGussetIncrStitches = this.iSoleStitches - 2;
        
        this.dKnitStraightLength = this.dSockLength * (0.6666666666666667);
        double dKnitStraightRows = this.dKnitStraightLength * dGaugeRPI;
        if (dKnitStraightRows % 1 != 0)
            dKnitStraightRows = ceil(dKnitStraightRows);
        this.iKnitStraightRows = (int) dKnitStraightRows;

    }
    
    public String getYarnWeight()
    {
        return this.strYarnWeight;
    }
    
    public double getNeedles()
    {
        return this.dNeedles;
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

    
// formula for figuring out how long to knit from toe before gusset inc's
//               total sock length  * 2/3
// M  = totalStitches for sock circumference (stitches) (after toe-increase) 
// R  = rows per inch
// S  = 1/2 * M (stitches in the sole and nbr of rows to increase for gusset)
// G  = 1/2 * S (stitches increased on each side of sole for gusset) (stitches)
    // calculate cast-on (1/3 of max stitches)
    // calculate toe rows
    // calculate sole stitches (1/2 iMaxStitches)
    // calculate number of rows needed to increase for gusset (1/2 iMaxStitches)
    // calculate number of stitches to increase on each side of the sole for the gusset (1/4 iMaxStitches)
    // calculate length to knit plain from toe to beginning of gusset shaping
    //   

  
}
