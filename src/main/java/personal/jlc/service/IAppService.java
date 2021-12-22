package personal.jlc.service;

/**
 * @author kelvin
 */

import personal.jlc.model.IAppSubModule;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public interface IAppService<T extends IAppSubModule> {

    String getName();

    @SuppressWarnings({"unchecked"})
    default Class<T> getRealType() {

        Type[] gis = this.getClass().getGenericInterfaces();
        for (Type gi : gis) {
            if (gi instanceof ParameterizedType) {
                ParameterizedType pt = (ParameterizedType) gi;
                if (pt.getRawType() == IAppService.class) {
                    Type[] atas = pt.getActualTypeArguments();
                    return (Class<T>) atas[0];
                }
            }
        }
        return null;
    }
}
