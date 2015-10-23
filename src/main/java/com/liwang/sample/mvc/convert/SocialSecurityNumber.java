package com.liwang.sample.mvc.convert;

/**
 * Created by Nikolas on 2015/10/23.
 */
public class SocialSecurityNumber {

    private final String value;

    public SocialSecurityNumber(String value) {
        this.value = value;
    }

    @MaskFormat("###-##-####")
    public String getValue() {
        return this.value;
    }

    public static SocialSecurityNumber valueOf(@MaskFormat("###-##-####") String value) {
        return new SocialSecurityNumber(value);
    }

}
