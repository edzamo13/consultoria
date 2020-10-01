package ec.hcam.reglas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pestupinan
 */
public class Test {

    // OJO este es un ejemplo que explica el registro y uso de la regla hecho por el middleware
    // OJO se mantiene lo explicado los dias anteriores, esto es SOLO UN EJMPLO
    public static void main(String args[]) {
        Test test = new Test();

//        RuleGetName ruleA = new RuleGetName();
//        ruleA.registerRule();
        RuleLabClinico reglaLaboratorio=new RuleLabClinico();
        reglaLaboratorio.registerRule();

//        RuleSayHello ruleB = new RuleSayHello();
//        ruleB.registerRule();

        Object[] params = {3, 2, 1};
        reglaLaboratorio.invokeRule("aplicarReglaLabClinico", params);
        

    }

}
