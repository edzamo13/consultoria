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
interface IRuleBase {

    void evaluateRule(String rule);

    Object invokeRule(String ruleName, Object[] ruleParams);

    void registerRule();

    void bindParam(String name, Object value);
}
