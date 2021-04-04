/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilerstask1;

/**
 *
 * @author farahgee
 */
public class Decision implements Language {
     
    private Matrix2D inputMatrix; 
    public Decision(Matrix2D matrix2D){
        inputMatrix=matrix2D;
    }
    
    public Boolean decide(int[] input) throws Task1Exception {
    
    
    int starting = inputMatrix.initialState(); //initial state of the matrix is assigned to s
    int i = input[0]; //will be parameter entered by user
    int finalState = inputMatrix.terminalState(); //finalState or accepting state is the terminal state of the Matrix
    
            //while the input lenght is greater than i(users input), make initial state go to the next state, and increment 
            while (input.length > i){ 
                starting = inputMatrix.nextState(starting, input[i]);
                i++;
            }
        //exit while loop when the initial state is equal the final accepting state
        return starting==finalState;  
    }
}


    
