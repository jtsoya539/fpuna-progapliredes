/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.paronline.paronlineapi.transaction.domain.service;

import java.util.Collection;
import py.com.paronline.paronlineapi.common.domain.service.BaseService;
import py.com.paronline.paronlineapi.transaction.domain.model.entity.Transaction;
import py.com.paronline.paronlineapi.transaction.domain.repository.TransactionRepository;

/**
 *
 * @author javie
 */
public class TransactionServiceImpl extends BaseService<Transaction, Integer> implements TransactionService {

    private TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        super(transactionRepository);
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void add(Transaction transaction) throws Exception {
        super.add(transaction);
    }

    @Override
    public void update(Transaction transaction) throws Exception {
        this.transactionRepository.update(transaction);
    }

    @Override
    public void delete(Integer id) throws Exception {
        this.transactionRepository.remove(id);
    }

    @Override
    public Transaction findById(Integer id) throws Exception {
        return this.transactionRepository.get(id);
    }

    @Override
    public Collection<Transaction> findByCliente(String nombre, String apellido) throws Exception {
        return this.transactionRepository.findByCliente(nombre, apellido);
    }

    @Override
    public Collection<Transaction> findByEstado(String estado) throws Exception {
        return this.transactionRepository.findByEstado(estado);
    }

    @Override
    public Collection<Transaction> findByTotal(double total) throws Exception {
        return this.transactionRepository.findByTotal(total);
    }

}
