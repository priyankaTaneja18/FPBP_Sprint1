package com.fpbp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpbp.DAO.AvailableCategoriesDAO;


@Service
public class AvailableCategoriesService implements IAvailableCategoriesService {


     @Autowired
     AvailableCategoriesDAO availableCategoriesDAO;
    
    public AvailableCategoriesService(AvailableCategoriesDAO availableCategoriesDAO){
        this.availableCategoriesDAO=availableCategoriesDAO;
    }
    
    public List<String> seekHelpCategories(){
   	 return availableCategoriesDAO.seekHelpCategories();
   	}
   	
   	public List<String> donateHelpCategories(){
   		 return availableCategoriesDAO.donateHelpCategories();
   	}	
}
