package com.neu.edu.stocktrading.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.neu.edu.stocktrading.model.StockAPIBean;
<<<<<<< HEAD
import com.neu.edu.stocktrading.model.User;
import com.neu.edu.stocktrading.service.HomePageService;
import com.neu.edu.stocktrading.util.FileReaderUtil;
=======
import com.neu.edu.stocktrading.service.HomePageService;
>>>>>>> bfa3d0c092865e6b8aacd1af30606a372ba3957f
import com.neu.edu.stocktrading.util.SessionManagementUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePageController {
    private static final Logger logger = LoggerFactory.getLogger(HomePageController.class);

    @Autowired
    private HomePageService homePageService;

    @Autowired
    private SessionManagementUtil sessionMgmtUtils;
<<<<<<< HEAD
    
    @GetMapping (value = "/landing.htm")    
    public ModelAndView landingPage (HttpServletRequest request )
    {
        
            logger.info("landing page");
            ModelAndView mv = new ModelAndView("landing-page");
            
        return mv;
    }
=======
>>>>>>> bfa3d0c092865e6b8aacd1af30606a372ba3957f

    @GetMapping(value = "/")
    public ModelAndView home(HttpServletRequest request) 
    {
        if (!this.sessionMgmtUtils.doesSessionExist(request)) 
        {
            logger.info("Session does not exist. Redirect to login page");
            ModelAndView mv = new ModelAndView("landing-page");
            return mv;
        }

        try {

<<<<<<< HEAD
            if (request.getSession().getAttribute("isAdmin")!=null && request.getSession().getAttribute("isAdmin").equals("Yes")) 
            {
            	logger.info("getting stocks $%^A6");
                List<StockAPIBean> stocks = this.homePageService.getTopStocks();
                logger.info("stocks : {}",stocks);
=======
            if (request.getSession().getAttribute("isAdmin").equals("Yes")) 
            {
                List<StockAPIBean> stocks = this.homePageService.getTopStocks();
>>>>>>> bfa3d0c092865e6b8aacd1af30606a372ba3957f
                ModelAndView mv = new ModelAndView("admin-home");
                mv.addObject("stocks", stocks);
    
                ArrayList<String> logos = new ArrayList<String>();
                logos.add("//logo.clearbit.com/amazon.com");
                logos.add("//logo.clearbit.com/google.com");
                logos.add("//logo.clearbit.com/apple.com");
                logos.add("//logo.clearbit.com/netflix.com");
        
                logos.add("//logo.clearbit.com/tesla.com");
                logos.add("//logo.clearbit.com/facebook.com");
                logos.add("//logo.clearbit.com/cisco.com?size=120");
                logos.add("//logo.clearbit.com/oracle.com");
        
                logos.add("//logo.clearbit.com/intel.com");
                logos.add("//logo.clearbit.com/qualcomm.com");
                logos.add("//logo.clearbit.com/ebay.com");
                logos.add("//logo.clearbit.com/dell.com?size=100");
                mv.addObject("logos", logos);

                Map<String, String> currencies = new HashMap<String , String> ();
                currencies = this.homePageService.getTopCurrencies();
                mv.addObject("currencies", currencies);

                
                return mv;
    
            }
            
        } 
        
        catch (Exception e) {
            logger.error(e.toString());
        }



        List<StockAPIBean> stocks = this.homePageService.getTopStocks();
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("stocks", stocks);

        ArrayList<String> logos = new ArrayList<String>();
        logos.add("//logo.clearbit.com/amazon.com");
        logos.add("//logo.clearbit.com/google.com");
        logos.add("//logo.clearbit.com/apple.com");
        logos.add("//logo.clearbit.com/netflix.com");

        logos.add("//logo.clearbit.com/tesla.com");
        logos.add("//logo.clearbit.com/facebook.com");
        logos.add("//logo.clearbit.com/cisco.com?size=120");
        logos.add("//logo.clearbit.com/oracle.com");

        logos.add("//logo.clearbit.com/intel.com");
        logos.add("//logo.clearbit.com/qualcomm.com");
        logos.add("//logo.clearbit.com/ebay.com");
        logos.add("//logo.clearbit.com/dell.com?size=100");
        mv.addObject("logos", logos);


        Map<String, String> currencies = new HashMap<String , String> ();
        currencies = this.homePageService.getTopCurrencies();
        mv.addObject("currencies", currencies);

        return mv;
    }

}