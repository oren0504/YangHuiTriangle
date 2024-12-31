/**
 * SymbolPart is the class represents the duplicated combination of specific characters.
 * the "l" means the duplicated times for the characters combination.
 * the "symbol" represents the characters combination.
 *
 * "part" will return the final result of the String after initializing and setting the variable.
 *
 * All three variables are private,which means you can only change them by the public method,make it more reliable.
 *
 *
 */

public class SymbolPart {
    private int l;
    private String symbol;
    private String part;


    SymbolPart(){
        l = 0;
        symbol = null;
        part = "";
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setL(int l) {
        this.l = l;
    }

    public String getPart() {
        this.part = "";
        for (int i = 0; i < l; i++) {
            this.part=this.part.concat(symbol);
            //this.part =this.part + symbol;
        }
        return part;
    }

}
