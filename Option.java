import java.util.Arrays;


public class Option 
{
    
    private static int whatMode = 0;

    //Easy, Medium, Hard, Costem.
    private static Boolean[] mode = new Boolean[] {true, false, false};

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
        System.out.println(whatMode);
        mode[whatMode] = true;
        System.out.println(Arrays.toString(mode));
        return mode;
    }

    public int modeSelected()
    {
        int sendBool = 0;

        //find what i is true
        for(int i = 0; i < mode.length; i++)
        {
            if(mode[i])
            {
                System.out.println(i + "  " + mode[i]);
                sendBool = i;
            }
        }
        return sendBool;
    }

   

}
