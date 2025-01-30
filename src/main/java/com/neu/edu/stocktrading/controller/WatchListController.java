package com.neu.edu.stocktrading.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.neu.edu.stocktrading.model.Stock;
import com.neu.edu.stocktrading.model.User;
import com.neu.edu.stocktrading.service.WatchListService;
import com.neu.edu.stocktrading.util.SessionManagementUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.http.HttpStatus;
=======
>>>>>>> bfa3d0c092865e6b8aacd1af30606a372ba3957f
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
<<<<<<< HEAD
public class WatchListController {

    private static final Logger logger = LoggerFactory.getLogger(WatchListController.class);
=======
public class WatchListController
{
    private static final Logger logger = LoggerFactory.getLogger(WatchListController.class);
    
>>>>>>> bfa3d0c092865e6b8aacd1af30606a372ba3957f

    @Autowired
    private WatchListService watchListService;

    @Autowired
    private SessionManagementUtil sessionMgmtUtils;

<<<<<<< HEAD
    @PostMapping(value = "/watchlist.htm", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addToWatchList(HttpServletRequest request, @RequestBody HashMap<String, String> stockSymbol) {
        try {
            logger.info("addToWatchList in controller::" + stockSymbol.get("symbol"));
            String email = (String) request.getSession().getAttribute("user");
            if (email == null) {
                logger.error("User session not found");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User session not found");
            }
            User user = this.watchListService.getProfileAttributes(email);
            if (user == null) {
                logger.error("User not found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            }

            String symbol = stockSymbol.get("symbol");
            if (symbol == null || symbol.isEmpty()) {
                logger.error("Stock symbol not provided");
                return ResponseEntity.badRequest().body("Stock symbol not provided");
            }

            boolean result = this.watchListService.addStockToWatchList(user, symbol);
            if (!result) {
                logger.error("Failed to add stock to watchlist");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add stock to watchlist");
            }

            logger.info("Stock added to watchlist successfully");
            return ResponseEntity.ok("Stock added to watchlist successfully");
        } catch (Exception e) {
            logger.error("An error occurred: " + e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }

    @GetMapping(value = "/watchlist.htm")
    public ModelAndView retrieveWatchList(HttpServletRequest request) {

            if (!this.sessionMgmtUtils.doesSessionExist(request)) {
                logger.info("Please login to access this page");
                ModelAndView mv = new ModelAndView("login-form");
                mv.addObject("user", new User());
                mv.addObject("errorMessage", "Please login to access this page");
                return mv;
            }

            String email = (String) request.getSession().getAttribute("user");
            if (email == null) {
                logger.error("User session not found");
            }
            User user = this.watchListService.getProfileAttributes(email);


        Set<Stock> stockList= this.watchListService.retrieveWatchList(user);
=======
    @PostMapping(value = "/watchlist.htm" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addToWatchList (HttpServletRequest request , @RequestBody HashMap<String, String> stockSymbol)
    {
        logger.info("addToWatchList::"+stockSymbol.get("symbol"));
        String email = (String) request.getSession().getAttribute("user");
        User user = this.watchListService.getProfileAttributes(email);


        boolean result = this.watchListService.addStockToWatchList (user , stockSymbol.get("symbol"));
        Map<String , String> res = new HashMap<String, String>();
        res.put("result", "Success");
        return ResponseEntity.ok(res);
    }

    @GetMapping(value = "/watchlist.htm" )
    public ModelAndView retrieveWatchList (HttpServletRequest request )
    {
        if (!this.sessionMgmtUtils.doesSessionExist(request)) 
        {
            logger.info("Please login to access this page");
            ModelAndView mv = new ModelAndView("login-form");
            mv.addObject("user", new User());
            mv.addObject("errorMessage", "Please login to access this page");
            return mv;

        }

        String email = (String) request.getSession().getAttribute("user");
        User user = this.watchListService.getProfileAttributes(email);


        Set<Stock> stockList= this.watchListService.retrieveWatchList (user);
>>>>>>> bfa3d0c092865e6b8aacd1af30606a372ba3957f
        logger.info("Returned stocklist from watch::"+stockList.size());

        ModelAndView mv = new ModelAndView("stock-watchlist");
        mv.addObject("stockList", stockList);
        return mv;
    }

}