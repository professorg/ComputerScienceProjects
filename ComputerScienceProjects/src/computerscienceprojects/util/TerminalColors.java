/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.util;

/**
 *
 * @author gvandomelen19
 */
public enum TerminalColors {

    BLACK   ("\u001B[30m"),
    RED     ("\u001B[31m"),
    GREEN   ("\u001B[32m"),
    YELLOW  ("\u001B[33m"),
    BLUE    ("\u001B[34m"),
    MAGENTA ("\u001B[35m"),
    CYAN    ("\u001B[36m"),
    WHITE   ("\u001B[37m"),

    BG_BLACK    ("\u001B[40m"),
    BG_RED      ("\u001B[41m"),
    BG_GREEN    ("\u001B[42m"),
    BG_YELLOW   ("\u001B[43m"),
    BG_BLUE     ("\u001B[44m"),
    BG_MAGENTA  ("\u001B[45m"),
    BG_CYAN     ("\u001B[46m"),
    BG_WHITE    ("\u001B[47m"),

    RESET   ("\u001B[0m");
    private String col;
    private TerminalColors(String s) {
        col = s;
    }
    
    public String getCol() {
        return this.col;
    }
}
