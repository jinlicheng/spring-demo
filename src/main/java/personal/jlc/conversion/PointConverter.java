package personal.jlc.conversion;

import org.springframework.core.convert.converter.Converter;

public class PointConverter implements Converter<String, Point> {

    @Override
    public Point convert(String s) {
        String[] split = s.split(":");
        Point point = new Point();
        point.setX(Integer.parseInt(split[0]));
        point.setY(Integer.parseInt(split[1]));
        return point;
    }

}
