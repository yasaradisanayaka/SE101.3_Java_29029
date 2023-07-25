package com.mycompany.trafficlight;
public class GreenLightThread extends Thread
{
    //@Override
    public void run()
    {
        try
        {
            while(true)
            {
                System.out.println("Green Light");
                Thread.sleep(10000);
            }
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
