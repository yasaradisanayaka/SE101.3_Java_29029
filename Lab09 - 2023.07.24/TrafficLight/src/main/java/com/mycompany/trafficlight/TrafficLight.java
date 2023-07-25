package com.mycompany.trafficlight;

import static com.mycompany.trafficlight.TrafficLightColor.GREEN;
import static com.mycompany.trafficlight.TrafficLightColor.RED;
import static com.mycompany.trafficlight.TrafficLightColor.YELLOW;

enum TrafficLightColor 
{
    RED, GREEN, YELLOW
}
// A computerized traffic light

class TrafficLightSimulator implements Runnable 
{
    // holds the thread that runs the simulation
    private Thread thrd;
    // holds the current traffic light color
    private TrafficLightColor tlc;
    // set to true to stop the simulation
    boolean stop = false;

    TrafficLightSimulator(TrafficLightColor init)
    {
        tlc = init;
        thrd = new Thread(this);
        thrd.start();
    }

    TrafficLightSimulator()
    {
        tlc = TrafficLightColor.RED;
        thrd = new Thread(this);
        thrd.start();
    }

    // Start up the Light
    public void run() 
    {
        while (!stop)
        {
            try 
            {
                switch (tlc) 
                {
                    case GREEN:
                        System.out.println("Green Light");
                        // green for 10 seconds
                        Thread.sleep(10000);
                        break;
                    case YELLOW:
                        System.out.println("Yellow Light");
                        // yellow for 2 seconds
                        Thread.sleep(2000);
                        break;
                    case RED:
                        System.out.println("Red Light");
                        // red for 5 seconds
                        Thread.sleep(5000);
                        break;
                }
            } 
            catch (InterruptedException exc)
            {
                System.out.println(exc);
            }
            changeColor();
        }
    }

    // Change color
    synchronized void changeColor() 
    {
        switch (tlc)
        {
            case RED:
                tlc = TrafficLightColor.GREEN;
                break;
            case YELLOW:
                tlc = TrafficLightColor.RED;
                break;
            case GREEN:
                tlc = TrafficLightColor.YELLOW;
        }
        //signal that light has change
        notify();
    }

    // Wait until a light change occurs
    synchronized void waitForChange()
    {
        try 
        {
            //wait for light to change
            wait();
        } 
        catch (InterruptedException exc)  
        {
            System.out.println(exc);
        }
    }
    
    // Return current color
    TrafficLightColor getColor()
    {
        return tlc;
    }
    
    //stop the traffic light
    void cancel()
    {
        stop = true;
    }
}
    public class TrafficLight
    {

        public static void main(String[] args)
        {
            TrafficLightSimulator t1 = new TrafficLightSimulator(TrafficLightColor.RED);
            for (int i = 0; i < 9; i++) 
            {
                System.out.println(t1.getColor());
                t1.waitForChange();
            }
            t1.cancel();
        }
    }

