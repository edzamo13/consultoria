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
public class RuleSayHello extends RuleBase {

    @Override
    public void registerRule() {
        // Inyeccion de parametros de reglas
        bindParam("a", 1);
        bindParam("b", 2);
        // x, y, z son parámetros que pueden pasas de una regla a otra
        evaluateRule("def sayHello(x,y,z) { "
                + "'Hola ' + getName('Estupinan') + "
                + "' a: ' + a + "
                + "' b: ' + b + "
                + "' x: ' + x + "
                + "' y: ' + y + "
                + "' z: ' + z"
                + "}");
    }

}
