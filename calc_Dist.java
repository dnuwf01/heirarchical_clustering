/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heirarchical_clustering;

/**
 *
 * @author DELL
 */
public class calc_Dist {
    
    
    private double xCoordinate;
    private double yCoordinate;
    private double minPoint1;
    private double minPoint2;
    
    private binary_heap b1; // an object of the binary_heap class
    
   // private int dist;
    private double xyArray[][] = new double [100][2];
    private double distArray[][] =  new double [100][3];
    private int numPoints=0;
    //private static int edges=0;
    
    /**parameterized constructor*/
   // public calc_Dist(int x,int y)
    //{
     //   xCoordinate=x;
      //  yCoordinate=y;
     //   numPoints++;
       // storeNUpdate(xCoordinate,yCoordinate);
    //}
    
    /**default constructor*/
    
    public calc_Dist()
    {
    }
    
    public void insert(double x,double y)
    {
        
        xCoordinate=x;
        yCoordinate=y;
     //   numPoints++;
        storeNUpdate(xCoordinate,yCoordinate);
    }
    
    public static int getEdges(int x)
    {
        return x*(x-1)/2;
    }
    
    public void storeNUpdate(double x,double y)
    {
        
        xyArray[numPoints][0]=x;
        xyArray[numPoints][1]=y;
        
        int prevEdges = getEdges(numPoints); // returns the previous number of edges
        numPoints++;        
        int currEdges = getEdges(numPoints);    // returns the present number of edges
        
        int i=0;
        while(prevEdges<=currEdges && i<numPoints)
        {
          //  System.out.println(xCoordinate+" "+yCoordinate);
            double interDist;
            interDist = calculate(xyArray[i][0],xyArray[i][1],xCoordinate,yCoordinate);
            distArray[prevEdges][0]=i;
            distArray[prevEdges][1]=numPoints-1;
            distArray[prevEdges][2]=interDist;
        
            prevEdges++;
            i++;
        
        }
        
        System.out.println(toString());
        
    }
    
    
    
    public double calculate(double x1,double y1,double x2,double y2)
    {
        double distance;
        
        distance = Math.sqrt((Math.pow(x1-x2,2)+ Math.pow(y1-y2,2)));
        
        return distance;
    }
    
    /** A method to display the edges array */
    
    public void displayEdges()
    {
        int edges = getEdges(numPoints);
        int i = 0;
        while(i<edges)
        {
            System.out.println(distArray[i][0]+". "+distArray[i][1]+" "+distArray[i][2]);
            System.out.println();
            i++;
        }
    }
    
    
    /**A function to fill the heap with the distance data */
    
    public void fillHeap()
    {
        int size = getEdges(numPoints);
        b1 = new binary_heap(size);
        int i=0;
        
        System.out.println("The distArray size is:"+size);
      //  System.out.println("Hello");
        while(i<size)
        {
            b1.insertKey(distArray[i][2]);
            System.out.println("Inserted "+i+": value");
            i++;
        }
    }
    
    
    public void minDist()
    {
        double min= b1.getMin();
        int i=0;
        while(i<getEdges(numPoints))
        {
            if(distArray[i][2] == min)
            {
               minPoint1=distArray[i][0];
               minPoint2=distArray[i][1];
               break;
            }
            i++;
        }
    }
    
    public int getMinPoint1()
    {
        return (int)minPoint1;
    }
    
    public int getMinPoint2()
    {
        return (int)minPoint2;
    }
    
    
    @Override
    public String toString()
    {
        String output= "The coordinates added to the list is "+xyArray[numPoints-1][0]+" and "+xyArray[numPoints-1][1];
        
        return output;
    }
   
    
} // End of class
