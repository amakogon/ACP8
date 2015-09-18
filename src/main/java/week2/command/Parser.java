package week2.command;

/**
 * _|\_/|,,_____,~~`
 * _(.".)~~     )`~}} Created by Juff on $18.09.15
 * __\o/\ /---~\\ ~}}
 * ___ _//    _// ~}
 */


public class Parser {



    public String[] parceCommand(String string){
        String[] parcedComand = string.split("\\$|#");
        return parcedComand;
    }
    public String[] parceCommandWithArgs (String string){
        if (string==null){ return new String[]{};}
        return string.split(" | -");
    }

}
