package parser;
import java.util.List;

/**
 *
 * @author farahgee
 */



class Block {
    public List <Exp> exps;
    public Block ( List <Exp> _exps ) {
	assert ( _exps.size () > 0 );
	exps = _exps; } }

// The member variable exps should contain expressions in the same
// order as the program that the Block AST represent. E.g.
//
//     { 2; SKIP; 4 }
// 
// gives rise to something like the following list of expressions:
//
//    List ( new IntLiteral ( 2 ), new Skip (), new IntLiteral ( 4 ) )
//
// Note that token lists like { 2; SKIP; 4 } can be parsed in two
// ways: according to the rule BLOCK -> { ENE } and according to the
// E -> BLOCK rule. The former must return an instance of the Block
// class, while the latter an instance of the Exp interface (which?).
//
// Note also that nesting of blocks is permitted, e.g.
//
//    { 1; { 2; SKIP; 3 }; 4 }
// or
//
//    {{{{ 17 }}}}

interface Exp {} 

class IntLiteral implements Exp { 
    public int n;
    IntLiteral ( int _n ) { n = _n; } }

class Skip implements Exp { 
    public Skip () {} }

class BlockExp implements Exp { 
    public Block b;
    public BlockExp ( Block _b ) { b = _b; } 
}


