package ec.hcam.reglas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Programacion
 */
public class RuleLabClinico extends RuleBase {

    @Override
    public void registerRule() {
        
        evaluateRule("def aplicarReglaLabClinico(List<RegistrosLabClinico>){"
                + "for (InformacionB registroLabClinico : RegistroLabClinico) {"
                + "   registrarDetallePlanillaje(registroLabClinico) "
                + "   System.out.println(registroLabClinico.getTADESCRIPC())"
                + "}}");
    }
    
}
