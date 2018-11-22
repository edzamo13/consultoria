/*
 * Copyright 2018 CNE
 * Todos los derechos reservados
 */
package ec.gob.cne.web.controlador;

import ec.gob.cne.web.cliente.restful.WsClienteRestful;
import ec.gob.cne.ws.dto.Car;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ezamora
 */
@ManagedBean
@ViewScoped
public class PrincipalControlador implements Serializable {

    @Getter
    @Setter
    private List<Car> cars;
    @Getter
    @Setter
    private Car selectedCar;
    @Getter
    @Setter
    private String hola;

    WsClienteRestful cliente = new WsClienteRestful();

    /*
    @ManagedProperty("#{carService}")
    private CarService service;
*/
    @PostConstruct
    public void init() {
        setHola(new String());
        setHola("Edwin");
        setCars(new ArrayList<>());
        cars = createCars(48);
    }

    
    private final static String[] colors;
     
	    private final static String[] brands;
	     
	    static {
	        colors = new String[10];
	        colors[0] = "Jose";
	        colors[1] = "Manuel";
	        colors[2] = "Estevan";
	        colors[3] = "Paula";
	        colors[4] = "Ramiro";
	        colors[5] = "Edwin";
	        colors[6] = "Pedro";
	        colors[7] = "Rafael";
	        colors[8] = "Lenin";
	        colors[9] = "Alfaro";
	         
	        brands = new String[10];
	        brands[0] = "BMW";
	        brands[1] = "Mercedes";
	        brands[2] = "Volvo";
	        brands[3] = "Audi";
	        brands[4] = "Renault";
	        brands[5] = "Fiat";
	        brands[6] = "Volkswagen";
	        brands[7] = "Honda";
	        brands[8] = "Jaguar";
	        brands[9] = "Ford";
	    }
    
    
             public List<Car> createCars(int size) {
	        List<Car> list = new ArrayList<Car>();
	        for(int i = 0 ; i < size ; i++) {
	            list.add(new Car(getRandomId(), getRandomBrand(), getRandomYear(), getRandomColor(), getRandomPrice(), getRandomSoldState()));
	        }
	         
	        return list;
	    }
	     
	    private String getRandomId() {
	        return UUID.randomUUID().toString().substring(0, 8);
	    }
	     
	    private int getRandomYear() {
	        return (int) (Math.random() * 50 + 1960);
	    }
	     
	    private String getRandomColor() {
	        return colors[(int) (Math.random() * 10)];
	    }
	     
	    private String getRandomBrand() {
	        return brands[(int) (Math.random() * 10)];
	    }
	     
	    public int getRandomPrice() {
	        return (int) (Math.random() * 100000);
	    }
	     
	    public boolean getRandomSoldState() {
	        return (Math.random() > 0.5) ? true: false;
	    }
	 
	    public List<String> getColors() {
	        return Arrays.asList(colors);
	    }
	     
	    public List<String> getBrands() {
	        return Arrays.asList(brands);
	    }
            
            
}
