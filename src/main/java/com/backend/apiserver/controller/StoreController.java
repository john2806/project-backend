package com.backend.apiserver.controller;

import com.backend.apiserver.entity.Store;
import com.backend.apiserver.request.StoreRequest;
import com.backend.apiserver.response.ResponseWrapper;
import com.backend.apiserver.response.StoreResponse;
import com.backend.apiserver.service.StoreService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor

public class StoreController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    private StoreService storeService;

    @GetMapping("api/v1/list/store")
    public ResponseWrapper getAllListStores() {
        LOG.info("Start to find all store");
        List<Store> allListStores = storeService.getAllListStores();
        LOG.info("End to find all store");
        return new ResponseWrapper(allListStores);
    }

    @PostMapping("api/v1/store/create")
    public StoreResponse createStore(@Valid @RequestBody final StoreRequest storeRequest){
        LOG.info("Start to create store with information: ", storeRequest);
        StoreResponse storeResponse = storeService.createStore(storeRequest);
        LOG.info("End to create card with information: ", storeRequest);
        return storeResponse;
    }

}
