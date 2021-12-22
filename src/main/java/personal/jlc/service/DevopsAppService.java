package personal.jlc.service;

import org.springframework.stereotype.Service;
import personal.jlc.model.DevopsAppQO;

/**
 * @author kelvin
 */
@Service
public class DevopsAppService implements IAppService<DevopsAppQO> {

    @Override
    public String getName() {
        return "devops";
    }
}
