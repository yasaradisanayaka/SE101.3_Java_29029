package com.mycompany.trafficlight;
public class RedLightThread extends Thread
{
    //@Override
    public void run()
    {
        try
        {
            while(true)
            {
                System.out.println("Red Light");
                Thread.sleep(5000);
            }
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
