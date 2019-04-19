/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paronlineapi.common.domain.repository;

import java.util.Collection;
import paronlineapi.common.domain.model.entity.Entity;

/**
 *
 * @author javie
 * @param <TE>
 * @param <T>
 */
public interface ReadOnlyRepository<TE, T> {

    boolean contains(T id);

    Entity get(T id);

    Collection<TE> getAll();

}
