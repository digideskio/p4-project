package dk.aau.cs.d402f13.scopechecker;

import java.util.ArrayList;

import dk.aau.cs.d402f13.utilities.scopechecker.TypeSymbolInfo;
import dk.aau.cs.d402f13.utilities.scopechecker.Member;

public class TypeTablePrettyPrinter {

 
    public static void print(ArrayList<TypeSymbolInfo> typeTable){
      for (TypeSymbolInfo ci : typeTable){
        System.out.print("Type " + ci.name + " takes " + ci.args + " args, ");
    
        if (ci.parent != null){
          System.out.print("extends " + ci.parent.name);
          System.out.print(", takes " + ci.parentCallArgs + " args");
        }
        System.out.println("");
        System.out.println("  Has abstract functions:");
        for (Member m : ci.abstractFunctions){
          System.out.println("    " + m.name + ", takes " + m.args + " args");
   
        }
         
        System.out.println("  Has concrete functions:");
        for (Member m : ci.concreteFunctions){
          System.out.println("    " + m.name + ", takes " + m.args + " args");
          
        } 
        System.out.println("  Has abstract constants:");
        for (Member m : ci.abstractConstants){
          System.out.println("    " + m.name);
   
        }
         
        System.out.println("  Has concrete constants:");
        for (Member m : ci.concreteConstants){
          System.out.println("    " + m.name);
          
        } 
      }
    }
}
