/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.paronline.paronlineapi.product.domain.model.entity;

import py.com.paronline.paronlineapi.common.domain.model.entity.BaseEntity;

/**
 *
 * @author javie
 */
public class ProductCategory extends BaseEntity<Integer> {

    public ProductCategory() {
        super(0, "Sin nombre");
    }

    public ProductCategory(Integer id, String nombre) {
        super(id, nombre);
    }

}
