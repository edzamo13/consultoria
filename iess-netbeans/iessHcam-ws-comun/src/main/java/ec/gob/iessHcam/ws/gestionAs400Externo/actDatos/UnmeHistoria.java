/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.iessHcam.ws.gestionAs400Externo.actDatos;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author HCAM
 */
public class UnmeHistoria implements Serializable {

    private static final long serialVersionUID = -1422461130529850817L;
    
    @Getter
    @Setter
    private String unme;
    
    @Getter
    @Setter
    private String histClinica;

    public UnmeHistoria(String unme, String histClinica) {
        this.unme = unme;
        this.histClinica = histClinica;
    }

    public UnmeHistoria() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.unme)+Objects.hashCode(this.histClinica);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
      if (o instanceof UnmeHistoria) {
        UnmeHistoria p = (UnmeHistoria)o;
        return (this.unme+this.histClinica).equals(p.unme+p.histClinica);
      } else {
        return false;
      }
    }
    
    
}
