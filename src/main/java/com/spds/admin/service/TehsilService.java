package com.spds.admin.service;


import java.util.List;
import com.spds.admin.entity.*;

public interface TehsilService {
    Tehsil saveTehsil(Tehsil tehsil);
    
    
    Tehsil getTehsilById(Long id);

    
    List<Tehsil> getAllTehsils(Boolean isActive);


    Tehsil deleteById(Long id);
    
    
    
    
	
	

}
