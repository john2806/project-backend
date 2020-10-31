package com.backend.apiserver.service.impl;

import com.backend.apiserver.entity.Status;
import com.backend.apiserver.entity.Store;
import com.backend.apiserver.repository.StoreRepository;
import com.backend.apiserver.request.StoreRequest;
import com.backend.apiserver.response.StoreResponse;
import com.backend.apiserver.service.StoreService;
import com.backend.apiserver.utils.JwtUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class StoreServiceImpl implements StoreService {

    /**
     * StoreRepository
     */
    private StoreRepository storeRepository;
    /**
     * JwtUtils
     */
    private JwtUtils jwtUtils;

    /**
     * HttpServletRequest
     */
    private HttpServletRequest httpServletRequest;

    @Override
    public List<Store> getAllListStores() {
        return storeRepository.findAll();
    }

    @Override
    @Transactional
    public StoreResponse createStore(StoreRequest storeRequest) {
        Long userId = jwtUtils.getUserId(httpServletRequest);
        Store card =  storeRepository.saveAndFlush(requestToEntity(userId, storeRequest));
        return entityToResponse(card);
    }

    private Store requestToEntity(Long userId, StoreRequest storeRequest) {
        Store store = new Store();
        store.setName(storeRequest.getName());
        store.setAddress(storeRequest.getAddress());
        store.setPhone(storeRequest.getPhone());
        store.setCompany(storeRequest.getCompany());
        store.setLatitude(storeRequest.getLatitude());
        store.setLongitude(storeRequest.getLongitude());
        return store;
    }

    private StoreResponse entityToResponse(Store store) {
        StoreResponse storeResponse = new StoreResponse();
        storeResponse.setId(store.getId());
        storeResponse.setName(store.getName());
        storeResponse.setAddress(store.getAddress());
        storeResponse.setPhone(store.getPhone());
        storeResponse.setCompany(store.getCompany());
        storeResponse.setLatitude(store.getLatitude());
        storeResponse.setLongitude(store.getLongitude());
        return storeResponse;
    }
}
