package ec.gob.mag.renagro.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class BrigadaSectorCountDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer sedpId;

	private Integer count;

}