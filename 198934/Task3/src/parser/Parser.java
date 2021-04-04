/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.util.List;

/**
 *
 * @author farahgee
 */
interface Parser 
{    
    public Block parse ( List<Token> input ) throws SyntaxException, Task3Exception; 
}
