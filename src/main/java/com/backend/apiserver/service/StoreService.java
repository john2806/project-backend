package com.backend.apiserver.service;

import com.backend.apiserver.entity.Store;
import com.backend.apiserver.request.StoreRequest;
import com.backend.apiserver.response.StoreResponse;

import java.util.List;

public interface StoreService {
    /**
     * Get all list stores
     * @return
     */
    List<Store> getAllListStores();

    /**
     * Create new store
     * @param storeRequest
     * @return
     */
    StoreResponse createStore(StoreRequest storeRequest);


}
