package week2.command;

/**
 * _|\_/|,,_____,~~`
 * _(.".)~~     )`~}} Created by Juff on $18.09.15
 * __\o/\ /---~\\ ~}}
 * ___ _//    _// ~}
 */


public class Parser {
    String string;


    public Parser(String string){
        this.string=string;
    }

    public String[] parce (){
        if (string==null){ return new String[]{};}
        return string.split(" | -");
    }

}
