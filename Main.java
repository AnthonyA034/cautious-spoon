/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_3;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
/**
 *
 * @author chimera
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Main();
    }
    public Main(){
        int Size= 600000; // the size of the array
        int Poppy = 6000; // amount of searches
        Random x = new Random();// random variable to get array and search values
        int[] ARay = new int[Size];
        SearchingAlgorithms.fillArray(ARay);
        //SearchingAlgorithms.printArray(ARay);
        SearchingAlgorithms.quickSort(ARay);
        //SearchingAlgorithms.printArray(ARay);
        
        // From writeToFile code given with assignment
        String outputFilename = "output.csv";
        PrintWriter output = null;
        
        //open output stream
        try
        {
            output = new PrintWriter(new FileWriter(outputFilename));
        } catch (IOException ex)
        {
            System.exit(1);
        }
        
        for(int i = 0 ;i < Poppy; i ++ ){
            int y = x.nextInt();
            
            long bsStartTime= System.nanoTime();
            SearchingAlgorithms.binarySearch(ARay, y);
            long bsElapsedTime = System.nanoTime() - bsStartTime;
            
            long seqStartTime = System.nanoTime();
            SearchingAlgorithms.seqSearch(ARay, y);
            long seqElapsedTime = System.nanoTime() - seqStartTime;
            
            long sortStartTime = System.nanoTime();
            SearchingAlgorithms.sortSearch(ARay, y);
            long sortElapsedTime = System.nanoTime() - sortStartTime;
            
            output.println(y + ", " + bsElapsedTime + ", " + seqElapsedTime 
            + ", " + sortElapsedTime);
        }
        output.close();
    }
}
