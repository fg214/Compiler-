package parser;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author farahgee
 */
public class MyParser implements Parser {

    List<Token> theTokenList;

    @Override
    public Block parse(List<Token> input) throws SyntaxException, Task3Exception {

        theTokenList = input;
        checkBrackets();
        return parseBlock();

    }

    public void checkBrackets() throws SyntaxException, Task3Exception {

        int lcb = 0;
        int rcb = 0;

        for (Token t : theTokenList) {
            if (t instanceof T_LeftCurlyBracket) {
                lcb = lcb + 1;
            } 
            else if (t instanceof T_RightCurlyBracket) {
                rcb = rcb + 1;
            }
        }
        if (lcb != rcb) {
            throw new SyntaxException("error! brackets should be balanced");
        }
    }

    public Block parseBlock() throws SyntaxException {

        if (theTokenList.isEmpty() == false) {
            if (theTokenList.get(0) instanceof T_LeftCurlyBracket) {
                theTokenList.remove(0);
                List<Exp> e = parseENE();

                if (theTokenList.get(0) instanceof T_RightCurlyBracket) {
                    theTokenList.remove(0);
                }
                
               return new Block(e);            
            }
            else {
                    throw new SyntaxException("Incorret, the first of the list should be a left curly bracket");
                }
        }
        else {
            throw new SyntaxException("the list is empty");   
        }
    }

    public List<Exp> parseENE() throws SyntaxException {

        List<Exp> e = new ArrayList<>();
        e.add(parseE());
        if (theTokenList.isEmpty()) {            
            throw new SyntaxException("you are parsing an empty list");
        }
        else if (theTokenList.get(0) instanceof T_Semicolon){
            theTokenList.remove(0);
            e.addAll(parseENE());
        }
        return e;
    }

    public Exp parseE() throws SyntaxException {

        if (theTokenList.get(0) instanceof T_Integer) {
            T_Integer newINT = ((T_Integer) (theTokenList.get(0)));
            theTokenList.remove(0);
            return new IntLiteral(newINT.n);
        } 
        else if (theTokenList.get(0) instanceof T_Skip) {
            theTokenList.remove(0);
            return new Skip();
        } 
        else if (theTokenList.get(0) instanceof T_LeftCurlyBracket) {
            Exp e = new BlockExp(parseBlock());
            return e;
        } 
        else {
            throw new SyntaxException("incorrect syntax");
        }
    }
}