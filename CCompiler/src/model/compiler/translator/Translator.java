
package model.compiler.translator;

import java.util.ArrayList;
import java.util.HashMap;
import model.compiler.translator.SemanticRegisters.*;
import model.compiler.translator.Symbols.FunctionData;
import model.compiler.translator.Symbols.IdentifierData;
import model.compiler.translator.Symbols.VariableData;

public class Translator {
    private ArrayList<SemanticError> semanticErrors = new ArrayList<>();
    private HashMap<String, IdentifierData> symbolTable = new HashMap<>();
    private SemanticStack stack = new SemanticStack();
        
    public ArrayList<SemanticError> getSemanticErrors() {
        return semanticErrors;
    }
    
    public HashMap<String, IdentifierData> getSymbolTable() {
        return symbolTable;
    }

    public void rememberType(Object type, int line, int col){
        RsType rs = new RsType(String.valueOf(type), line, col);
        stack.push(rs);    
    }
    
    public void rememberIdVar(Object id, int line, int col){
        RsId rs = new RsId(String.valueOf(id), false, line, col);
        stack.push(rs);
    }
    
    public void insertTableVar(){
        RsType rsType = (RsType) stack.findNearest(RsType.class);
        while (!stack.peek().getClass().equals(RsType.class)) {            
            RsId rsId = (RsId) stack.pop();
            if (isNewId(rsId)){
                symbolTable.put(rsId.name, new VariableData(rsType.type, rsId.name));
            }
        }
        stack.pop(); 
    }
    
    private boolean isNewId(RsId rsId){
        if (!symbolTable.containsKey(rsId.name)){
            return true;
        } else if (!symbolTable.get(rsId.name).hasError()){
            symbolTable.get(rsId.name).addError();
            String errorMessage = "identifier name already declared";  //deberiamos definir los errores
            SemanticError error = new SemanticError(rsId.line, rsId.col, rsId.name, errorMessage);     
            semanticErrors.add(error); 
        } 
        return false;
    }
    
    public void rememberIdFunc(Object id, int line, int col){
        RsId rs = new RsId(String.valueOf(id), true, line, col);
        stack.push(rs);
    }
    
    public void insertTableFunc(){
        ArrayList<VariableData> parameters = new ArrayList<>();
        while(!((RsId) stack.peek()).isFunc){
            RsId rsId = (RsId) stack.pop();
            RsType rsType = (RsType) stack.pop();
            VariableData varData = new VariableData(rsType.type, rsId.name);
            if (isNewId(rsId)){
                symbolTable.put(rsId.name, varData);
            }
            parameters.add(0, varData);
        }
        RsId rsId = (RsId) stack.pop();
        RsType rsType = (RsType) stack.pop();
        if (isNewId(rsId)){
            FunctionData funcData = new FunctionData(rsType.type, rsId.name, parameters);
            symbolTable.put(rsId.name, funcData);
        }
    }

    public void rememberConst(String value, int line, int column){
        RsDO rs = new RsDO("Const", value, line, column); // No se si el tipo es "Const"
        stack.push(rs);
    }
    
    public void rememberOperator(String operator, int line, int column){
        RsOp rs = new RsOp(operator, line, column);
        stack.push(rs);
    }    
    
    public void rememberVariable(String value, int line, int column){
        RsDO rs = new RsDO("Address", value, line, column); // No se si el tipo es "Address"
        if(!symbolTable.containsKey(rs.value)){
            VariableData variableData = new VariableData("Unknown", rs.value); // Si no está declarada no sabemos el tipo
            variableData.addError(); 
            symbolTable.put(rs.value, variableData);
            
            // Agregar el error
            String errorMessage =  "Variable undeclared";  //deberiamos definir los errores
            SemanticError error = new SemanticError(rs.line, rs.col, rs.value, errorMessage);     
            semanticErrors.add(error); //insertar al inicio para que queden en orden            
        }
        stack.push(rs);
    }
    
    public void evalBinary(){
        RsDO rsDO1 = (RsDO) stack.pop();
        RsOp rsOperator = (RsOp) stack.pop();
        RsDO rsDO2 = (RsDO) stack.pop();
        if(rsDO1.type == "Const" && rsDO2.type == "Const"){
            // calcular el resultado dependiendo de operador
            // crear RsDO tipo Const con el resultado calculado
        }
        else{
            // generar código para la operación
            // crear RsDO tipo Address
        }
        // hacer push al RsDO creado en el if o else
    }
}
