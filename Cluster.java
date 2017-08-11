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
public class Cluster {

    private double centres[][];
    
    private calc_Dist obj[];
    private int index;
    private int size;
    private int minPoint1;
    private int minPoint2;

    public Cluster(int size) {
        size = size;
        centres = new double[2*size-1][2];
        obj = new calc_Dist[size];
        index = 0;
    }

    public void insertKey(double x, double y) {

        centres[index][0] = x;
        centres[index][1] = y;
        index++;
        //     System.out.println(x+" "+y);
    }

    public void startClustering() {
     //   int i = 0;
        int reps=0; // represents the number of iterations which is equal to the number of data points
        System.out.println("The value of index is " + index);
   /*     obj[reps] = new calc_Dist();
        while (i < index) {
            obj[0].insert(centres[i][0], centres[i][1]);
            i++;
        }
        obj[reps].fillHeap();
        obj[reps].displayEdges();
     */   
    System.out.println(reps+" "+index);   
    int loop = index;
    
    
   while(reps<loop-1){
        
       //   System.out.println("Hello");
          obj[reps] = new calc_Dist();  
            if(reps==0)
            {
                int i=0;
                 while (i < index) {
                    obj[0].insert(centres[i][0], centres[i][1]);
                    i++;
                    }
                 
                  obj[reps].fillHeap();
                  obj[reps].displayEdges();
            }
            else
            {
                
                obj[reps-1].minDist();
     
                minPoint1 = obj[reps-1].getMinPoint1(); // returns the point index containing the minimum edge
                minPoint2 = obj[reps-1].getMinPoint2();  // returns the second point index containing the minimum edge
                System.out.println("Point1 for minimum distance is: " + minPoint1);
                System.out.println("Point2 for minimum distance is: " + minPoint2);

                
                 double xCent= getXCent(centres[minPoint1][0],centres[minPoint2][0]);
                 double yCent= getYCent(centres[minPoint1][1],centres[minPoint2][1]);
         
                 /**  we need to set the two points to null,and add the new centroid to the class*/
                 
       //          centres[minPoint1][0]=centres[minPoint1][1]= -1000.0; //set the second point to -1000.0
       //          centres[minPoint2][0]=centres[minPoint2][1]= -1000.0; //set the second point to -1000.0
                 
                 
                 
                 /**shift all the elements of the array */
                 int i;
                 for(i=minPoint1+1;i<=index;i++)
                 {
                     centres[i-1][0] = centres[i][0];
                     centres[i-1][1] = centres[i][1];
                 }
                 
                   for(i=minPoint2+1;i<=index;i++)
                 {
                     centres[i-1][0] = centres[i][0];
                     centres[i-1][1] = centres[i][1];
                 }
                 
                 
                   centres[index-1][0]=xCent;
                   centres[index-1][1]=yCent;
                 
                 
                 
                 
                 
                 int j=0;
                // obj[reps].insert(xCent, yCent);
                 while(j<=index-1)
                 {
                     obj[reps].insert(centres[j][0],centres[j][1]);
                     j++;
                     
                 }
                 
                 obj[reps].fillHeap();
                 obj[reps].displayEdges();
                 
            }
            
       
            reps++;
            index--;
      
        
        
        }
        

    }
    /**
     A function to return the x-Coordinate of the centroid of two points
     
    */
    
    public double getXCent(double x,double y)
    {
        return (x+y)/2;
    }
    
    /**
     * A function to return the y-Coordinate of the centroid of two points
     */
    public double getYCent(double x,double y)
    {
        return (x+y)/2;
    }
    

    public void setArrayNull(int x, int y) {
        //centres = new double[size - 1][2];
        int i = 0;
        int index = 0;
        while (i < size - 1 && (i != x) && (i != y)) {
            centres[index] =centres[i];
        }

    }

}
