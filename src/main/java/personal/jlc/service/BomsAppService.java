package personal.jlc.service;

import org.springframework.stereotype.Service;
import personal.jlc.model.BomsAppQO;

/**
 * @author kelvin
 */
@Service
public class BomsAppService implements IAppService<BomsAppQO> {
    @Override
    public String getName() {
        return "boms";
    }
}
