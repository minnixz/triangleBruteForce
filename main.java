import java.awt.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import java.io.*;
import java.lang.*;
//page 241
class main {
    public static void main(String[] args) {
        //Variables
        int triangleCounter = 0; //number of right triangles
        int testTrianglesTo = 500; //this is the number to test triangle dimensions to 1-x, 1-x, 1-x
        int[][] triangleArray = new int[testTrianglesTo][2]; //This will store all right triangles.
    
    
        //Create Headers for Table, Side-3 is the Hypotenuse
        System.out.printf("%8s%8s%8s%n","Side-1", "Side-2", "Side-3");
    
        //Loops through all possible triangle combinations with triple nested loop
        for(int i = 1;i < testTrianglesTo;i++){
            for(int j = 1;j < testTrianglesTo;j++){
               
                for(int z = 1;z < testTrianglesTo;z++){
                    //if it's a right triangle, and it hasn't been found yet, print it and add it to right triangle array
                    //this only tests the first 2 sides to save processing speed
                    if(rightTriangleTest(i,j,z) == true && inTriangleArray(triangleArray,i,j) == false){
                    displayTriangle(i,j,z);
                    triangleArray[triangleCounter][0]=i;
                    triangleArray[triangleCounter][1]=j;
                    triangleCounter++;
                    }
                }    
            } 
        }
        System.out.println("Total Number of Right Triangles: "+triangleCounter);
    }
    //Checks if triangle is in triangle array
    //Since duplicates get entered with side 1 and 2 reversed, this 
    //checks a triangle to a triangle with the sides reversed.
    public static boolean inTriangleArray(int[][] inputArray, int side1, int side2){
        boolean inArray = false;
        for(int i = 0;i< inputArray.length; i++){
            
            if(inputArray[i][0]==side2 && inputArray[i][1]==side1){
                inArray = true;
            }
        }
        return inArray;
    }
    
    //prints triangle side lengths
    public static void displayTriangle(int side1, int side2, int side3){
        System.out.printf("%8d%8d%8d%n", side1,side2, side3);
    }
    
    //checks to see if a triangle is a right triangle
    public static boolean rightTriangleTest(int side1, int side2, int side3){
        return Math.sqrt((Math.pow(side1,2)+Math.pow(side2,2))) == side3;
    }
}