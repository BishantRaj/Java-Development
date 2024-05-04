package com.sts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sts.model.Metal;

@RepositoryRestResource(collectionResourceRel = "metals" ,path = "metals")
public interface MetalRepo extends JpaRepository<Metal, Integer> {

}
