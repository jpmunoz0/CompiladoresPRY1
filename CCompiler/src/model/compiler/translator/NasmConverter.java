
package model.compiler.translator;

import model.compiler.translator.SemanticRegisters.RsDO;

public class NasmConverter {
    private String nasmCode;
    private boolean isInCodeSection;

    public NasmConverter() {
        this.isInCodeSection = false;
        this.nasmCode = 
                "%include \"io.mac\" \n\n" + 
                ".DATA \n" + 
                "out_msg\t db \"Input: \",0 \n\n" + 
                ".UDATA \n";
    }

    public String getNasmCode() {
        return nasmCode;
    }
    
    public void declareVariable(String var){
        nasmCode += var + "\t resd \t 1 \n";
    }
    
    public void initCode(){
        if(!this.isInCodeSection){
            this.isInCodeSection = true;
            this.nasmCode += 
                "\n.CODE \n" +
                "\t.STARTUP \n";
        }
    }
    
    public void doExpressionBinary(RsDO rsDO1, RsDO rsDO2, String op){
        String operand1 = rsDO1.value;
        String operand2 = rsDO2.value;
        if("address".equals(rsDO1.type) && "address".equals(rsDO2.type)){
            switch (op){
                    case "+":
                        this.nasmCode += "\tmov EAX, [" + operand1 + "] \n";
                        this.nasmCode += "\tmov EBX, [" + operand2 + "] \n";
                        this.nasmCode += "\tadd EAX,EBX\n\n";
                        break;
                    case "-":
                        this.nasmCode += "\tmov EAX, [" + operand1 + "] \n";
                        this.nasmCode += "\tmov EBX, [" + operand2 + "] \n";
                        this.nasmCode += "\tsub EAX, EBX\n\n";
                        break;
                    case "*":
                        this.nasmCode += "\tmov EAX, [" + operand1 + "] \n";
                        this.nasmCode += "\tmov ECX, [" + operand2 + "] \n";
                        this.nasmCode += "\tmul ECX \n\n";
                        break;
                    case "/":
                        this.nasmCode += "\tmov EAX, [" + operand1 + "] \n";
                        this.nasmCode += "\tmov EDX, 0\n";
                        this.nasmCode += "\tmov ECX, [" + operand2 + "]\n";
                        this.nasmCode += "\tdiv ECX \n\n";
                        break;
                    case "%":
                        this.nasmCode += "\tmov EAX, [" + operand1 + "] \n";
                        this.nasmCode += "\tmov EDX, 0\n";
                        this.nasmCode += "\tmov ECX, " + operand2 + "\n";
                        this.nasmCode += "\tdiv ECX \n";
                        this.nasmCode += "\tmov EAX,EDX \n\n";
                        break;
                    case "==":
                        this.nasmCode += "\tmov EAX,[" + operand1 + "] \n";
                        this.nasmCode += "\tmov EBX,[" + operand2 + "] \n";
                        this.nasmCode += "\tcmp EAX, EBX \n";
                        this.nasmCode += "\tcall equals \n\n";
                        break;
                    case ">=":
                        this.nasmCode += "\tmov EAX,[" + operand1 + "] \n";
                        this.nasmCode += "\tmov EBX,[" + operand2 + "] \n";
                        this.nasmCode += "\tcmp EAX, EBX \n";
                        this.nasmCode += "\tcall greaterEqualThan \n\n";
                        break;
                    case ">":
                        this.nasmCode += "\tmov EAX,[" + operand1 + "] \n";
                        this.nasmCode += "\tmov EBX,[" + operand2 + "] \n";
                        this.nasmCode += "\tcmp EAX, EBX \n";
                        this.nasmCode += "\tcall greaterThan \n\n";
                        break;
                    case "<=":
                        this.nasmCode += "\tmov EAX,[" + operand1 + "] \n";
                        this.nasmCode += "\tmov EBX,[" + operand2 + "] \n";
                        this.nasmCode += "\tcmp EAX, EBX \n";
                        this.nasmCode += "\tcall lessEqualThan \n\n";
                        break;
                    case "<":
                        this.nasmCode += "\tmov EAX,[" + operand1 + "] \n";
                        this.nasmCode += "\tmov EBX,[" + operand2 + "] \n";
                        this.nasmCode += "\tcmp EAX, EBX \n";
                        this.nasmCode += "\tcall lessThan \n\n";
                        break;
                    case "!=":
                        this.nasmCode += "\tmov EAX,[" + operand1 + "] \n";
                        this.nasmCode += "\tmov EBX,[" + operand2 + "] \n";
                        this.nasmCode += "\tcmp EAX, EBX \n";
                        this.nasmCode += "\tcall notEquals \n\n";
                        break;
                    case "&&":
                        this.nasmCode += "\tmov EAX,[" + operand1 + "] \n";
                        this.nasmCode += "\tmov EBX,[" + operand2 + "] \n";
                        this.nasmCode += "\tand EAX, EBX \n";
                        break;
                    case "||":
                        this.nasmCode += "\tmov EAX,[" + operand1 + "] \n";
                        this.nasmCode += "\tmov EBX,[" + operand2 + "] \n";
                        this.nasmCode += "\tor EAX, EBX \n";
                        break;
                }
        }
        else{
            if("address".equals(rsDO1.type)){
                switch (op){
                    case "+":
                        this.nasmCode += "\tmov EAX, [" + operand1 + "] \n";
                        this.nasmCode += "\tadd EAX, " + operand2 + "\n\n";
                        break;
                    case "-":
                        this.nasmCode += "\tmov EAX, [" + operand1 + "] \n";
                        this.nasmCode += "\tsub EAX, " + operand2 + "\n\n";
                        break;
                    case "*":
                        this.nasmCode += "\tmov EAX, [" + operand1 + "] \n";
                        this.nasmCode += "\tmov ECX, " + operand2 + "\n";
                        this.nasmCode += "\tmul ECX \n\n";
                        break;
                    case "/":
                        this.nasmCode += "\tmov EAX, [" + operand1 + "] \n";
                        this.nasmCode += "\tmov EDX, 0\n";
                        this.nasmCode += "\tmov ECX, " + operand2 + "\n";
                        this.nasmCode += "\tdiv ECX \n\n";
                        break;
                    case "%":
                        this.nasmCode += "\tmov EAX, [" + operand1 + "] \n";
                        this.nasmCode += "\tmov EDX, 0\n";
                        this.nasmCode += "\tmov ECX, " + operand2 + "\n";
                        this.nasmCode += "\tdiv ECX \n";
                        this.nasmCode += "\tmov EAX,EDX \n\n";
                        break;
                    case "==":
                        this.nasmCode += "\tmov EAX,[" + operand1 + "] \n";
                        this.nasmCode += "\tcmp EAX, " + operand2 + "\n";
                        this.nasmCode += "\tcall equals \n\n";
                        break;
                    case ">=":
                        this.nasmCode += "\tmov EAX,[" + operand1 + "] \n";
                        this.nasmCode += "\tcmp EAX, " + operand2 + "\n";
                        this.nasmCode += "\tcall greaterEqualThan \n\n";
                        break;
                    case ">":
                        this.nasmCode += "\tmov EAX,[" + operand1 + "] \n";
                        this.nasmCode += "\tcmp EAX, " + operand2 + "\n";
                        this.nasmCode += "\tcall greaterThan \n\n";
                        break;
                    case "<=":
                        this.nasmCode += "\tmov EAX,[" + operand1 + "] \n";
                        this.nasmCode += "\tcmp EAX, " + operand2 + "\n";
                        this.nasmCode += "\tcall lessEqualThan \n\n";
                        break;
                    case "<":
                        this.nasmCode += "\tmov EAX,[" + operand1 + "] \n";
                        this.nasmCode += "\tcmp EAX, " + operand2 + "\n";
                        this.nasmCode += "\tcall lessThan \n\n";
                        break;
                    case "!=":
                        this.nasmCode += "\tmov EAX,[" + operand1 + "] \n";
                        this.nasmCode += "\tcmp EAX, " + operand2 + "\n";
                        this.nasmCode += "\tcall notEquals \n\n";
                        break;
                    case "&&":
                        this.nasmCode += "\tmov EAX,[" + operand1 + "] \n";
                        this.nasmCode += "\tand EAX, " + operand2 + "\n";
                        break;
                    case "||":
                        this.nasmCode += "\tmov EAX,[" + operand1 + "] \n";
                        this.nasmCode += "\tor EAX, " + operand2 + "\n";
                        break;
                }        
            }
            else{
                switch (op){
                    case "+":
                        this.nasmCode += "\tmov EAX, [" + operand2 + "] \n";
                        this.nasmCode += "\tadd EAX, " + operand1 + "\n\n";
                        break;
                    case "-":
                        this.nasmCode += "\tmov EBX, [" + operand2 + "] \n";
                        this.nasmCode += "\tmov EAX, " + operand1 + "\n";
                        this.nasmCode += "\tsub EAX, EBX\n\n";
                        break;
                    case "*":
                        this.nasmCode += "\tmov EAX, [" + operand2 + "] \n";
                        this.nasmCode += "\tmov ECX, " + operand1 + "\n";
                        this.nasmCode += "\tmul ECX \n\n";
                        break;
                    case "/":
                        this.nasmCode += "\tmov EAX, " + operand1 + "\n";
                        this.nasmCode += "\tmov EDX, 0\n";
                        this.nasmCode += "\tmov ECX, [" + operand2 + "]\n";
                        this.nasmCode += "\tdiv ECX \n\n";
                        break;
                    case "%":
                        this.nasmCode += "\tmov EAX, " + operand1 + "\n";
                        this.nasmCode += "\tmov EDX, 0\n";
                        this.nasmCode += "\tmov ECX, [" + operand2 + "]\n";
                        this.nasmCode += "\tdiv ECX \n";
                        this.nasmCode += "\tmov EAX,EDX \n\n";
                        break;
                    case "==":
                        this.nasmCode += "\tmov EAX, " + operand1 + "\n";
                        this.nasmCode += "\tmov EBX,[" + operand2 + "] \n";
                        this.nasmCode += "\tcmp EAX, EBX \n";
                        this.nasmCode += "\tcall equals \n\n";
                        break;
                    case ">=":
                        this.nasmCode += "\tmov EAX, " + operand1 + "\n";
                        this.nasmCode += "\tmov EBX,[" + operand2 + "] \n";
                        this.nasmCode += "\tcmp EAX, EBX \n";
                        this.nasmCode += "\tcall greaterEqualThan \n\n";
                        break;
                    case ">":
                        this.nasmCode += "\tmov EAX, " + operand1 + "\n";
                        this.nasmCode += "\tmov EBX,[" + operand2 + "] \n";
                        this.nasmCode += "\tcmp EAX, EBX \n";
                        this.nasmCode += "\tcall greaterThan \n\n";
                        break;
                    case "<=":
                        this.nasmCode += "\tmov EAX, " + operand1 + "\n";
                        this.nasmCode += "\tmov EBX,[" + operand2 + "] \n";
                        this.nasmCode += "\tcmp EAX, EBX \n";
                        this.nasmCode += "\tcall lessEqualThan \n\n";
                        break;
                    case "<":
                        this.nasmCode += "\tmov EAX, " + operand1 + "\n";
                        this.nasmCode += "\tmov EBX,[" + operand2 + "] \n";
                        this.nasmCode += "\tcmp EAX, EBX \n";
                        this.nasmCode += "\tcall lessThan \n\n";
                        break;
                    case "!=":
                        this.nasmCode += "\tmov EAX, " + operand1 + "\n";
                        this.nasmCode += "\tmov EBX,[" + operand2 + "] \n";
                        this.nasmCode += "\tcmp EAX, EBX \n";
                        this.nasmCode += "\tcall notEquals \n\n";
                        break;
                    case "&&":
                        this.nasmCode += "\tmov EAX, " + operand1 + "\n";
                        this.nasmCode += "\tmov EBX,[" + operand2 + "] \n";
                        this.nasmCode += "\tand EAX, EBX \n";
                        break;
                    case "||":
                        this.nasmCode += "\tmov EAX, " + operand1 + "\n";
                        this.nasmCode += "\tmov EBX,[" + operand2 + "] \n";
                        this.nasmCode += "\tor EAX, EBX \n";
                        break;
                } 
            }
        }
    }
    
    public void assign(RsDO var, RsDO value){
        
        switch(value.type){
            case "asmRegister":
                this.nasmCode += "\tmov dword[" + var.value + "], EAX \n";
                break;
            case "constant":
                this.nasmCode += "\tmov dword[" + var.value + "]," +  value.value + "\n";
                break;
            case "address":
                this.nasmCode += "\tmov EAX, [" + value.value + "] \n";
                this.nasmCode += "\tmov dword[" + var.value + "], EAX \n";
                break;
        }
        this.nasmCode += "\txor EAX,EAX \n\n";
    }
    
    public void doExpressionUnary(RsDO operand, String op, boolean isPostfix){
        switch(operand.type){
            case "asmRegister":
                switch(op){
                    case "!":
                        this.nasmCode += "\tcmp EAX, 0 \n";
                        this.nasmCode += "\tcall equals \n\n";
                        break;
                    case "-":
                        this.nasmCode += "\tmov EBX, EAX \n";
                        this.nasmCode += "\tmov EAX, 0 \n";
                        this.nasmCode += "\tsub EAX,EBX \n\n";
                        break;
                }
                break;
            case "address":
                switch (op){
                    case "++":
                        if (isPostfix){
                            this.nasmCode += "\tmov EAX, [" + operand.value + "] \n";
                            this.nasmCode += "\tinc dword[" + operand.value + "] \n\n";
                            break;
                        }
                        else{
                            this.nasmCode += "\tinc dword[" + operand.value + "] \n";
                            this.nasmCode += "\tmov EAX, [" + operand.value + "] \n\n";
                            break;
                        }
                    case "--":
                        if (isPostfix){
                            this.nasmCode += "\tmov EAX, [" + operand.value + "] \n";
                            this.nasmCode += "\tdec dword[" + operand.value + "] \n\n";
                            break;
                        }
                        else{
                            this.nasmCode += "\tdec dword[" + operand.value + "] \n";
                            this.nasmCode += "\tmov EAX, [" + operand.value + "] \n\n";
                            break;
                        }
                    case "!":
                        this.nasmCode += "\tmov EAX, [" + operand.value + "] \n";
                        this.nasmCode += "\tcmp EAX, 0 \n";
                        this.nasmCode += "\tcall equals \n\n";
                        break;

                    case "+":
                        this.nasmCode += "\tmov EAX, [" + operand.value + "] \n";
                        break;
                    case "-":
                        this.nasmCode += "\tmov EBX, [" + operand.value + "] \n";
                        this.nasmCode += "\tmov EAX, 0 \n";
                        this.nasmCode += "\tsub EAX,EBX \n\n";
                        break;

                }
                break;
        }
    }
    
    public void doSingleOperandExp(RsDO operand){
        switch(operand.type){
            case "address":
                this.nasmCode += "\tmov EAX, [" + operand.value + "] \n";
                break;
            case "constant":
                this.nasmCode += "\tmov EAX, " + operand.value + " \n";
                break;
        }
    }
    
    public void testIf(RsDO rsDO, String elseLabel){
        switch(rsDO.type){
            case "address":
                this.nasmCode += "\tmov EAX, [" + rsDO.value + "] \n";
                break;
            case "constant":
                this.nasmCode += "\tmov EAX, " + rsDO.value + " \n";
                break;
        }
        this.nasmCode += "\tcmp EAX, 0 \n";
        this.nasmCode += "\tje " + elseLabel + "\n\n";
    }
    
    public void startElse(String elseLabel, String exitLabel){
        this.nasmCode += "\tjmp " + exitLabel + "\n\n";
        this.nasmCode += elseLabel + ":\n";
    }
    
    public void endIf(String exitLabel){
        this.nasmCode += exitLabel + ":\n";
    }
    
    public void startWhile(String whileLabel){
        this.nasmCode += whileLabel + ":\n";
    }
    
    public void testWhile(RsDO rsDO, String exitLabel){
        switch(rsDO.type){
            case "address":
                this.nasmCode += "\tmov EAX, [" + rsDO.value + "] \n";
                break;
            case "constant":
                this.nasmCode += "\tmov EAX, " + rsDO.value + " \n";
                break;
        }
        this.nasmCode += "\tcmp EAX, 0 \n";
        this.nasmCode += "\tje " + exitLabel + "\n\n";
    }
    
    public void endWhile(String whileLabel, String exitLabel){
        this.nasmCode += "\tjmp " + whileLabel + "\n\n";
        this.nasmCode += exitLabel + ":\n";
    }
    
    public void print(){
        System.err.println("TRADUCCIÓN");
        System.out.println(this.nasmCode);
    }
    
    public void endOfCode(){
        this.nasmCode += "\t.EXIT \n\n";
        this.nasmCode += "equals:\n" +
                        "    je  isTrue\n" +
                        "    mov EAX,0\n" +
                        "    ret\n" +
                        "\n" +
                        "greaterEqualThan:\n" +
                        "    jge isTrue\n" +
                        "    mov EAX,0\n" +
                        "    ret\n" +
                        "\n" +
                        "greaterThan:\n" +
                        "    jg  isTrue\n" +
                        "    mov EAX,0\n" +
                        "    ret\n" +
                        "\n" +
                        "lessEqualThan:\n" +
                        "    jle isTrue\n" +
                        "    mov EAX,0\n" +
                        "    ret    \n" +
                        "\n" +
                        "lessThan:\n" +
                        "    jl isTrue\n" +
                        "    mov EAX,0\n" +
                        "    ret  \n" +
                        "\n" +
                        "notEquals:\n" +
                        "    jne isTrue\n" +
                        "    mov EAX,0\n" +
                        "    ret\n" +
                        "\n" +
                        "isTrue:\n" +
                        "    mov EAX,1\n" +
                        "    ret";
    }
    
    public void write(RsDO rsDO, String type){
        switch(rsDO.type){
            case "address":
                this.nasmCode += "\tmov EAX, [" + rsDO.value + "] \n";
                break;
            case "constant":
                this.nasmCode += "\tmov EAX, " + rsDO.value + " \n";
                break;
        }
        switch(type){
            case "int":
                this.nasmCode += "\tPutLInt EAX \n";
                break;
            case "char":
                this.nasmCode += "\tPutCh AL \n";
                break;
        }
        this.nasmCode += "\tnwln \n";
        this.nasmCode += "\txor EAX,EAX \n\n";
    }
    
    public void read(RsDO rsDO, String type){
        this.nasmCode += "\txor EAX,EAX \n";
        this.nasmCode += "\tPutStr out_msg \n";
        switch(type){
            case "int":
                this.nasmCode += "\tGetLInt EAX \n";
                break;
            case "char":
                this.nasmCode += "\tGetCh AL \n";
                break;
        }
        this.nasmCode += "\tmov dword[" + rsDO.value + "], EAX \n\n";
    }
   
}
