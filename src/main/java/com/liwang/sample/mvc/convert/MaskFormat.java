package com.liwang.sample.mvc.convert;

import java.lang.annotation.*;

/**
 * Created by Nikolas on 2015/10/23.
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MaskFormat {
    String value();
}
