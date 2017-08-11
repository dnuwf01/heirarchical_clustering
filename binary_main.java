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
public class binary_main {
    
    
    public static void main(String[] args)
    {
        
        
        
        Cluster cl1 = new Cluster(8);
        cl1.insertKey(1,2);
        cl1.insertKey(3,2);
        cl1.insertKey(7,1);
        cl1.insertKey(6,9);
        cl1.insertKey(10,2);
        cl1.insertKey(3,9);
        cl1.insertKey(4,8);
        cl1.insertKey(16,9);
       
        
       
     //   num.displayEdges();
        
        //calc_Dist obj1 = new calc_Dist();
      //  num.fillHeap();
       // System.out.println("The edge with the minimum distance is: "+num.minDist());
        
       cl1.startClustering();
        
        
    }
    
}
