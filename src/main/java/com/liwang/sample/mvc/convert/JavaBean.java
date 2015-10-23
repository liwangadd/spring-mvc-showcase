package com.liwang.sample.mvc.convert;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Nikolas on 2015/10/23.
 */
public class JavaBean {

    private Integer primitive;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date date;

    @MaskFormat("(###)###-####")
    private String masked;

    private List<Integer> list;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private List<Date> formattedList;

    private Map<Integer, String> map;

    private NestedBean nested;

    public Integer getPrimitive() {
        return primitive;
    }

    public void setPrimitive(Integer primitive) {
        this.primitive = primitive;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMasked() {
        return masked;
    }

    public void setMasked(String masked) {
        this.masked = masked;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public List<Date> getFormattedList() {
        return formattedList;
    }

    public void setFormattedList(List<Date> formattedList) {
        this.formattedList = formattedList;
    }

    public Map<Integer, String> getMap() {
        return map;
    }

    public void setMap(Map<Integer, String> map) {
        this.map = map;
    }

    public NestedBean getNested() {
        return nested;
    }

    public void setNested(NestedBean nested) {
        this.nested = nested;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("JavaBean");
        if (primitive != null) {
            sb.append(" primitive=").append(primitive);
        }
        if (date != null) {
            sb.append(" date=").append(date);
        }
        if (masked != null) {
            sb.append(" masked=").append(masked);
        }
        if (list != null) {
            sb.append(" list=").append(list);
        }
        if (formattedList != null) {
            sb.append(" formattedList=").append(formattedList);
        }
        if (map != null) {
            sb.append(" map=").append(map);
        }
        if (nested != null) {
            sb.append(" nested=").append(nested);
        }
        return sb.toString();
    }
}
