package com.mycompany.trafficlight;
public class Threading 
{
    public static void main(String[] args)
    {
        // TODO code application logic here
        RedLightThread redLightThread = new RedLightThread();
        GreenLightThread greenLightThread = new GreenLightThread();
        YellowLightThread yellowLightThread = new YellowLightThread();
        
        redLightThread.start();
        greenLightThread.start();
        yellowLightThread.start();
    }
}
