package ec.com.vitalgym.dto;

import lombok.Getter;
import lombok.Setter;

public class AuditRead {

	@Getter
	@Setter
	private String id;
	@Getter
	@Setter
	private String nameTable;
	public AuditRead(String id, String nameTable) {
		super();
		this.id = id;
		this.nameTable = nameTable;
	}
	
	

}
