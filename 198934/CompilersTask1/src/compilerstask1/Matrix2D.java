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
public interface Matrix2D {
    public int initialState ();
    public int terminalState ();
    public int nextState ( int currentState, int character ); }
    

