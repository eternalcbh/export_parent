package cn.itcast.web.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class StringToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        Date result = null;
        try {
            result = new SimpleDateFormat().parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}
