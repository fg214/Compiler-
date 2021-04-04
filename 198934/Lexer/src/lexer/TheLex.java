package lexer;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class TheLex implements Lexer
{
    public List<Token> lex(String input) throws LexicalException, Task2Exception
    {
        JLexer l1 = new JLexer(new StringReader(input));
        List<Token> tokenList = new ArrayList<>();
        try 
        {
            Token b = l1.yylex();
            while (b != null)
            {
                tokenList.add(b);
                b = l1.yylex();
            }
        } 
        catch (LexicalException ex) 
        {
            throw new LexicalException("ILLEGAL"); 
            //language error, for example if you find a square bracket []
            
        } 
        catch (Exception e)
        {
            throw new Task2Exception("");
        }
        return tokenList;
    }
}
