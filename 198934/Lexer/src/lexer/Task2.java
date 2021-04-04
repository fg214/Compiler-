package lexer;

import java.util.List;

/**
 *
 */
public class Task2 {
    
//    public static void main(String[] args) throws LexicalException, Task2Exception//, SyntaxException, Task3Exception 
//    {
//        Lexer newlex = new TheLex();
//        //Parser newParse = new MyParser();
//        //List<Token> tokens = new ArrayList<>();
//        List<Token> tokens = newlex.lex("{9}");
//        //System.out.println(newParse.parse(tokens));
//        System.out.println(tokens);
//        // ";;{{{}}{{{ {{}}}} }}}}}}}}10 10 if if then thisMethod999 then then else"
//    }
    
    public static TheLex create() {
        TheLex lx = new TheLex();
        return lx;
    }
}
