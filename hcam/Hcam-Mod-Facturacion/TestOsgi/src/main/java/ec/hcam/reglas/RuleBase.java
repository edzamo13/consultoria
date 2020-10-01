package ec.hcam.reglas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author pestupinan
 */
public abstract class RuleBase implements IRuleBase {

    private static final ScriptEngineManager factory = new ScriptEngineManager();
    private static final ScriptEngine engine = factory.getEngineByName("groovy");

    @Override
    public void evaluateRule(String rule) {
        try {
            engine.eval(rule);
        } catch (ScriptException ex) {
            Logger.getLogger(RuleBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object invokeRule(String ruleName, Object[] ruleParams) {
        try {
            Invocable inv = (Invocable) engine;
            return inv.invokeFunction(ruleName, ruleParams);
        } catch (ScriptException ex) {
            Logger.getLogger(RuleBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(RuleBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public abstract void registerRule();

    @Override
    public void bindParam(String name, Object value) {
        engine.put(name, value);
    }
}
