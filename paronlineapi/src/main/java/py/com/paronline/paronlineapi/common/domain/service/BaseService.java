/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.paronline.paronlineapi.common.domain.service;

import java.util.Collection;
import py.com.paronline.paronlineapi.common.domain.repository.Repository;

/**
 *
 * @author javie
 * @param <TE>
 * @param <T>
 */
public abstract class BaseService<TE, T> extends ReadOnlyBaseService<TE, T> {

    private Repository<TE, T> repository;

    public BaseService(Repository<TE, T> repository) {
        super(repository);
        this.repository = repository;
    }

    public void add(TE entity) throws Exception {
        this.repository.add(entity);
    }

    public Collection<TE> getAll() {
        return this.repository.getAll();
    }

}
