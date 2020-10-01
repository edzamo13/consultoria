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
public class RuleFarmacos extends RuleBase {

    @Override
    public void registerRule() {
        evaluateRule("def aplicarReglaFarmacos(List<RegistrosFarmacos>){"
                + "for (InformacionB registroFarmaco : RegistroFarmacos) {"
                + "   registrarDetallePlanillaje(registroFarmaco) "
                + "   System.out.println(registroFarmaco.getCodigo_item())"
                + "}}");
    }
    
}
