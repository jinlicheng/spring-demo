package personal.jlc.model;

import lombok.Data;

import java.util.Map;

/**
 * @author kelvin
 */
@Data
public class AppQO {

    private Long id;
    private String name;
    private Map<String, IAppSubModule> subModuleMap;

}
