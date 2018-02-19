package ModSock;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PatternDoc
{
    String thePattern = "";

public boolean writePattern(String fileName) 
    {
        File dataFile = new File(fileName);
        boolean dataWriteSuccess = true;
        try
        {
            if(!dataFile.exists())
            {
                dataFile.createNewFile();
            }

            try (BufferedWriter writeData = new BufferedWriter(new FileWriter(dataFile, false)))
            {

                writeData.write(this.thePattern);
                writeData.newLine();
                writeData.write("File Name: " + fileName);
                writeData.close();
            }
            
        }
        catch(IOException badWrite)
        {
            dataWriteSuccess = false;
            return dataWriteSuccess;
        }

        return dataWriteSuccess;
    }

    public void setThePattern(String theText)    
    {
        this.thePattern = this.thePattern + theText;
    }
}
