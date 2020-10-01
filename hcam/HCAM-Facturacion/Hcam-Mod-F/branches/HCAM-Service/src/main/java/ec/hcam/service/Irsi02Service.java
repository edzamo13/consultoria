
package ec.hcam.service;

import ec.hcam.entities1.Irsi02;
import ec.hcam.jpa.Irsi02FacadeRemote;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class Irsi02Service implements Irsi02ServiceRemote {

    @EJB
    private Irsi02FacadeRemote irsi02tblFacade;

    @Override
    public void create(Irsi02 irsi02) {
        irsi02tblFacade.create(irsi02);
    }

    @Override
    public void edit(Irsi02 irsi02) {
        irsi02tblFacade.edit(irsi02);
    }

    @Override
    public void remove(Irsi02 irsi02) {
        irsi02tblFacade.remove(irsi02);
    }

    @Override
    public Irsi02 find(Object id) {
        return irsi02tblFacade.find(id);
    }

    @Override
    public List<Irsi02> findAll() {
        return irsi02tblFacade.findAll();
    }

    @Override
    public List<Irsi02> findRange(int[] range) {
        return irsi02tblFacade.findRange(range);
    }

    @Override
    public int count() {
        return irsi02tblFacade.count();
    }

}
