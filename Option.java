import java.util.Arrays;

public class Option 
{
    //indicates what mode[] is selected
    private static int whatMode = 0;

    //Easy, Medium, Hard, Costem.
    private static Boolean[] mode = new Boolean[] {true, false, false};

    //chances value of mode[] and returns it
    public Boolean[] chanceMode(int arrowHit)
    {
        mode[whatMode] = false;
        whatMode = whatMode + arrowHit;
        
        if(whatMode < 0)
        {
            whatMode = mode.length-1;
        }
        else if(whatMode > mode.length-1)
        {
            whatMode = 0;
        }
        mode[whatMode] = true;
        return mode;
    }

    //checks what mode[] is true and returns it as an int.
    public int modeSelected()
    {
        int sendBool = 0;

        //find what i is true
        for(int i = 0; i < mode.length; i++)
        {
            if(mode[i])
            {
                sendBool = i;
            }
        }
        return sendBool;
    }

   

}
