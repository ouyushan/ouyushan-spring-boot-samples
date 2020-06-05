package org.ouyushan.springboot.data.cache.entity;

import java.io.Serializable;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/5/8 15:25
 */
public class Country implements Serializable {

    private final String code;

    public Country(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Country country = (Country) o;

        return this.code.equals(country.code);
    }

    @Override
    public int hashCode() {
        return this.code.hashCode();
    }

}
