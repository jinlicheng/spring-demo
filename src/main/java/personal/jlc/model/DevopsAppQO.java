package personal.jlc.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author kelvin
 */
@Data
public class DevopsAppQO implements IAppSubModule{

    private Long id;

    private String key1;
    private String key2;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date time;

}
