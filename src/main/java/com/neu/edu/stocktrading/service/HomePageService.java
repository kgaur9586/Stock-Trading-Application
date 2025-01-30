package com.neu.edu.stocktrading.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neu.edu.stocktrading.dao.HomePageDAO;
import com.neu.edu.stocktrading.model.Stock;
import com.neu.edu.stocktrading.model.StockAPIBean;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import net.sf.json.JSONSerializer;

@Service
public class HomePageService
{
    @Autowired
    private HomePageDAO homePageDAO;

    private static final Logger logger = LoggerFactory.getLogger(HomePageService.class);

    @Autowired
    private RestTemplate restTemplate;

    // final String stockUri = "https://marketdata.websol.barchart.com/getQuote.json?apikey=b0ccbbb0dae9d39ce81f65718f0ecd10&symbols=AMZN,GOOG,AAPL,GOOG,NFLX,TSLA,FB,CSCO,ORCL,INTC,QCOM,EBAY,DELL,COST,MSFT,TWTR,AABA,SNAP,AMD,ATVI,ZNGA,WDC,BKNG&fields=fiftyTwoWkHigh%2CfiftyTwoWkHighDate%2CfiftyTwoWkLow%2CfiftyTwoWkLowDate";
<<<<<<< HEAD
    final String stockUri1 = "https://marketdata.websol.barchart.com/getQuote.json?apikey=SPZW7DZ36OPSLXDH&symbols=AMZN,GOOG,AAPL,NFLX,TSLA,FB,CSCO,ORCL,INTC,QCOM,EBAY,DELL,COST,MSFT,TWTR,AABA,SNAP,AMD,ATVI,ZNGA&fields=fiftyTwoWkHigh%2CfiftyTwoWkHighDate%2CfiftyTwoWkLow%2CfiftyTwoWkLowDate&apikey=SPZW7DZ36OPSLXDH";

    final String stockUri2 = "https://marketdata.websol.barchart.com/getQuote.json?apikey=SPZW7DZ36OPSLXDH&symbols=WDC,BKNG,VZ,HPQ,SNE,W,BABA,JNJ,JPM,XOM,BAC,WMT,WFC,V,PG,BUD,T,UNH,HD,C&fields=fiftyTwoWkHigh%2CfiftyTwoWkHighDate%2CfiftyTwoWkLow%2CfiftyTwoWkLowDate&apikey=SPZW7DZ36OPSLXDH";

//    final String stockUri1 = "https://ondemand.websol.barchart.com/getQuote.json?apikey=&symbols=AAPL%2CGOOG&fields=fiftyTwoWkHigh%2CfiftyTwoWkHighDate%2CfiftyTwoWkLow%2CfiftyTwoWkLowDate&shareClassFigi=BBG001S5S399&figi=BBG000BLNQ16&compositeFigi=BBG000BLNNH6";
//    final String stockUri2 = "https://ondemand.websol.barchart.com/getQuote.json?apikey=YOUR_API_KEY&symbols=AAPL%2CGOOG&fields=fiftyTwoWkHigh%2CfiftyTwoWkHighDate%2CfiftyTwoWkLow%2CfiftyTwoWkLowDate&shareClassFigi=BBG001S5S399&figi=BBG000BLNQ16&compositeFigi=BBG000BLNNH6";

    final String currencyUri = "https://www.worldtradingdata.com/api/v1/forex?base=USD&sort=newest&api_token=uRqeU8C651htqmF8iI5N6VvSBEIpTiQ5xvvKkz9Slsm1D9jFvIGdG97m0RpF";
    

//    public List<StockAPIBean> getTopStocks ()
//    {
//        List<StockAPIBean> stocks = new ArrayList<StockAPIBean>();
//        logger.info("stocks are : {}",stockUri1);
//        String result = "[\n"
//        		+ "  {\n"
//        		+ "    \"symbol\": \"AAPL\",\n"
//        		+ "    \"exchange\": \"NASDAQ\",\n"
//        		+ "    \"name\": \"Apple Inc.\",\n"
//        		+ "    \"dayCode\": \"20240425\",\n"
//        		+ "    \"serverTimestamp\": \"20240425120000\",\n"
//        		+ "    \"mode\": \"realtime\",\n"
//        		+ "    \"lastPrice\": \"135.25\",\n"
//        		+ "    \"tradeTimestamp\": \"20240425120100\",\n"
//        		+ "    \"netChange\": \"+2.50\",\n"
//        		+ "    \"percentChange\": \"+1.89%\",\n"
//        		+ "    \"unitCode\": \"USD\",\n"
//        		+ "    \"open\": \"133.50\",\n"
//        		+ "    \"high\": \"135.75\",\n"
//        		+ "    \"low\": \"132.80\",\n"
//        		+ "    \"close\": \"132.30\",\n"
//        		+ "    \"flag\": \"normal\",\n"
//        		+ "    \"volume\": \"2356789\",\n"
//        		+ "    \"fiftyTwoWkHigh\": \"145.00\",\n"
//        		+ "    \"fiftyTwoWkHighDate\": \"20240215\",\n"
//        		+ "    \"fiftyTwoWkLow\": \"110.20\",\n"
//        		+ "    \"fiftyTwoWkLowDate\": \"20231020\"\n"
//        		+ "  },\n"
//        		+ "  {\n"
//        		+ "    \"symbol\": \"GOOGL\",\n"
//        		+ "    \"exchange\": \"NASDAQ\",\n"
//        		+ "    \"name\": \"Alphabet Inc.\",\n"
//        		+ "    \"dayCode\": \"20240425\",\n"
//        		+ "    \"serverTimestamp\": \"20240425120030\",\n"
//        		+ "    \"mode\": \"realtime\",\n"
//        		+ "    \"lastPrice\": \"2700.00\",\n"
//        		+ "    \"tradeTimestamp\": \"20240425120130\",\n"
//        		+ "    \"netChange\": \"-15.50\",\n"
//        		+ "    \"percentChange\": \"-0.57%\",\n"
//        		+ "    \"unitCode\": \"USD\",\n"
//        		+ "    \"open\": \"2715.50\",\n"
//        		+ "    \"high\": \"2725.00\",\n"
//        		+ "    \"low\": \"2695.25\",\n"
//        		+ "    \"close\": \"2715.50\",\n"
//        		+ "    \"flag\": \"normal\",\n"
//        		+ "    \"volume\": \"1254321\",\n"
//        		+ "    \"fiftyTwoWkHigh\": \"2805.50\",\n"
//        		+ "    \"fiftyTwoWkHighDate\": \"20240310\",\n"
//        		+ "    \"fiftyTwoWkLow\": \"2400.20\",\n"
//        		+ "    \"fiftyTwoWkLowDate\": \"20231105\"\n"
//        		+ "  },\n"
//        		+ "  {\n"
//        		+ "    \"symbol\": \"MSFT\",\n"
//        		+ "    \"exchange\": \"NASDAQ\",\n"
//        		+ "    \"name\": \"Microsoft Corporation\",\n"
//        		+ "    \"dayCode\": \"20240425\",\n"
//        		+ "    \"serverTimestamp\": \"20240425120100\",\n"
//        		+ "    \"mode\": \"realtime\",\n"
//        		+ "    \"lastPrice\": \"280.30\",\n"
//        		+ "    \"tradeTimestamp\": \"20240425120145\",\n"
//        		+ "    \"netChange\": \"+3.75\",\n"
//        		+ "    \"percentChange\": \"+1.36%\",\n"
//        		+ "    \"unitCode\": \"USD\",\n"
//        		+ "    \"open\": \"277.50\",\n"
//        		+ "    \"high\": \"281.25\",\n"
//        		+ "    \"low\": \"276.10\",\n"
//        		+ "    \"close\": \"276.55\",\n"
//        		+ "    \"flag\": \"normal\",\n"
//        		+ "    \"volume\": \"1897654\",\n"
//        		+ "    \"fiftyTwoWkHigh\": \"295.80\",\n"
//        		+ "    \"fiftyTwoWkHighDate\": \"20240115\",\n"
//        		+ "    \"fiftyTwoWkLow\": \"250.20\",\n"
//        		+ "    \"fiftyTwoWkLowDate\": \"20230920\"\n"
//        		+ "  },\n"
//        		+ "  {\n"
//        		+ "    \"symbol\": \"AMZN\",\n"
//        		+ "    \"exchange\": \"NASDAQ\",\n"
//        		+ "    \"name\": \"Amazon.com Inc.\",\n"
//        		+ "    \"dayCode\": \"20240425\",\n"
//        		+ "    \"serverTimestamp\": \"20240425120200\",\n"
//        		+ "    \"mode\": \"realtime\",\n"
//        		+ "    \"lastPrice\": \"3400.00\",\n"
//        		+ "    \"tradeTimestamp\": \"20240425120230\",\n"
//        		+ "    \"netChange\": \"-25.80\",\n"
//        		+ "    \"percentChange\": \"-0.75%\",\n"
//        		+ "    \"unitCode\": \"USD\",\n"
//        		+ "    \"open\": \"3425.80\",\n"
//        		+ "    \"high\": \"3440.25\",\n"
//        		+ "    \"low\": \"3395.50\",\n"
//        		+ "    \"close\": \"3425.80\",\n"
//        		+ "    \"flag\": \"normal\",\n"
//        		+ "    \"volume\": \"876543\",\n"
//        		+ "    \"fiftyTwoWkHigh\": \"3600.20\",\n"
//        		+ "    \"fiftyTwoWkHighDate\": \"20240228\",\n"
//        		+ "    \"fiftyTwoWkLow\": \"3100.25\",\n"
//        		+ "    \"fiftyTwoWkLowDate\": \"20231110\"\n"
//        		+ "  },\n"
//        		+ "  {\n"
//        		+ "    \"symbol\": \"TSLA\",\n"
//        		+ "    \"exchange\": \"NASDAQ\",\n"
//        		+ "    \"name\": \"Tesla Inc.\",\n"
//        		+ "    \"dayCode\": \"20240425\",\n"
//        		+ "    \"serverTimestamp\": \"20240425120300\",\n"
//        		+ "    \"mode\": \"realtime\",\n"
//        		+ "    \"lastPrice\": \"900.50\",\n"
//        		+ "    \"tradeTimestamp\": \"20240425120400\",\n"
//        		+ "    \"netChange\": \"+15.20\",\n"
//        		+ "    \"percentChange\": \"+1.72%\",\n"
//        		+ "    \"unitCode\": \"USD\",\n"
//        		+ "    \"open\": \"895.30\",\n"
//        		+ "    \"high\": \"905.75\",\n"
//        		+ "    \"low\": \"892.40\",\n"
//        		+ "    \"close\": \"885.30\",\n"
//        		+ "    \"flag\": \"normal\",\n"
//        		+ "    \"volume\": \"1456789\",\n"
//        		+ "    \"fiftyTwoWkHigh\": \"950.00\",\n"
//        		+ "    \"fiftyTwoWkHighDate\": \"20240320\",\n"
//        		+ "    \"fiftyTwoWkLow\": \"780.20\",\n"
//        		+ "    \"fiftyTwoWkLowDate\": \"20231025\"\n"
//        		+ "  },\n"
//        		+ "  {\n"
//        		+ "    \"symbol\": \"NVDA\",\n"
//        		+ "    \"exchange\": \"NASDAQ\",\n"
//        		+ "    \"name\": \"NVIDIA Corporation\",\n"
//        		+ "    \"dayCode\": \"20240425\",\n"
//        		+ "    \"serverTimestamp\": \"20240425120430\",\n"
//        		+ "    \"mode\": \"realtime\",\n"
//        		+ "    \"lastPrice\": \"650.75\",\n"
//        		+ "    \"tradeTimestamp\": \"20240425120500\",\n"
//        		+ "    \"netChange\": \"+8.45\",\n"
//        		+ "    \"percentChange\": \"+1.32%\",\n"
//        		+ "    \"unitCode\": \"USD\",\n"
//        		+ "    \"open\": \"645.30\",\n"
//        		+ "    \"high\": \"654.25\",\n"
//        		+ "    \"low\": \"642.50\",\n"
//        		+ "    \"close\": \"643.30\",\n"
//        		+ "    \"flag\": \"normal\",\n"
//        		+ "    \"volume\": \"987654\",\n"
//        		+ "    \"fiftyTwoWkHigh\": \"680.50\",\n"
//        		+ "    \"fiftyTwoWkHighDate\": \"20240305\",\n"
//        		+ "    \"fiftyTwoWkLow\": \"610.20\",\n"
//        		+ "    \"fiftyTwoWkLowDate\": \"20231115\"\n"
//        		+ "  },\n"
//        		+ "  {\n"
//        		+ "    \"symbol\": \"NFLX\",\n"
//        		+ "    \"exchange\": \"NASDAQ\",\n"
//        		+ "    \"name\": \"Netflix Inc.\",\n"
//        		+ "    \"dayCode\": \"20240425\",\n"
//        		+ "    \"serverTimestamp\": \"20240425120600\",\n"
//        		+ "    \"mode\": \"realtime\",\n"
//        		+ "    \"lastPrice\": \"575.30\",\n"
//        		+ "    \"tradeTimestamp\": \"20240425120630\",\n"
//        		+ "    \"netChange\": \"+10.80\",\n"
//        		+ "    \"percentChange\": \"+1.91%\",\n"
//        		+ "    \"unitCode\": \"USD\",\n"
//        		+ "    \"open\": \"565.50\",\n"
//        		+ "    \"high\": \"578.75\",\n"
//        		+ "    \"low\": \"562.40\",\n"
//        		+ "    \"close\": \"564.50\"\n"
//        		+ "  }\n"
//        		+ "]\n"
//        		+ "";
//        Object obj = null;
//        JSONObject jo = null;
//        try {
//            obj = new JSONParser().parse(result);
//            jo = (JSONObject) obj;
//        } catch (ParseException e) {
//            logger.error(e.toString());
//            obj = null;
//            jo = null;
//        }
//
//        if (obj != null && jo != null) {
//            JSONArray ja = (JSONArray) jo.get("results");
//
//            Iterator itr2 = ja.iterator();
//
//            while (itr2.hasNext()) {
//
//                Map map = (Map) itr2.next();
//                ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
//                StockAPIBean pojo = mapper.convertValue(map, StockAPIBean.class);
//                stocks.add(pojo);
//            }
//        }
//
//        result = this.restTemplate.getForObject(stockUri2, String.class);
//        obj = null;
//        jo = null;
//        try {
//            obj = new JSONParser().parse(result);
//            jo = (JSONObject) obj;
//        } catch (ParseException e) {
//            logger.error(e.toString());
//            obj = null;
//            jo = null;
//        }
//
//        if (obj != null && jo != null) 
//        {
//            JSONArray ja = (JSONArray) jo.get("results");
//
//            Iterator itr2 = ja.iterator();
//
//            while (itr2.hasNext()) {
//
//                Map map = (Map) itr2.next();
//                ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
//                StockAPIBean pojo = mapper.convertValue(map, StockAPIBean.class);
//                stocks.add(pojo);
//            }
//        }
//
//        saveAllStocks(stocks);
//
//        logger.info("size::" + stocks.size());
//        return stocks;
//
//    }
    public List<StockAPIBean> getTopStocks() {
        List<StockAPIBean> stocks = new ArrayList<>();
        String result = "[{\"symbol\":\"AAPL\",\"exchange\":\"NASDAQ\",\"name\":\"Apple Inc.\",\"dayCode\":\"20240425\",\"serverTimestamp\":\"20240425120000\",\"mode\":\"realtime\",\"lastPrice\":\"135.25\",\"tradeTimestamp\":\"20240425120100\",\"netChange\":\"+2.50\",\"percentChange\":\"+1.89%\",\"unitCode\":\"USD\",\"open\":\"133.50\",\"high\":\"135.75\",\"low\":\"132.80\",\"close\":\"132.30\",\"flag\":\"normal\",\"volume\":\"2356789\",\"fiftyTwoWkHigh\":\"145.00\",\"fiftyTwoWkHighDate\":\"20240215\",\"fiftyTwoWkLow\":\"110.20\",\"fiftyTwoWkLowDate\":\"20231020\"},{\"symbol\":\"GOOGL\",\"exchange\":\"NASDAQ\",\"name\":\"Alphabet Inc.\",\"dayCode\":\"20240425\",\"serverTimestamp\":\"20240425120030\",\"mode\":\"realtime\",\"lastPrice\":\"2700.00\",\"tradeTimestamp\":\"20240425120130\",\"netChange\":\"-15.50\",\"percentChange\":\"-0.57%\",\"unitCode\":\"USD\",\"open\":\"2715.50\",\"high\":\"2725.00\",\"low\":\"2695.25\",\"close\":\"2715.50\",\"flag\":\"normal\",\"volume\":\"1254321\",\"fiftyTwoWkHigh\":\"2805.50\",\"fiftyTwoWkHighDate\":\"20240310\",\"fiftyTwoWkLow\":\"2400.20\",\"fiftyTwoWkLowDate\":\"20231105\"},{\"symbol\":\"MSFT\",\"exchange\":\"NASDAQ\",\"name\":\"Microsoft Corporation\",\"dayCode\":\"20240425\",\"serverTimestamp\":\"20240425120100\",\"mode\":\"realtime\",\"lastPrice\":\"280.30\",\"tradeTimestamp\":\"20240425120145\",\"netChange\":\"+3.75\",\"percentChange\":\"+1.36%\",\"unitCode\":\"USD\",\"open\":\"277.50\",\"high\":\"281.25\",\"low\":\"276.10\",\"close\":\"276.55\",\"flag\":\"normal\",\"volume\":\"1897654\",\"fiftyTwoWkHigh\":\"295.80\",\"fiftyTwoWkHighDate\":\"20240115\",\"fiftyTwoWkLow\":\"250.20\",\"fiftyTwoWkLowDate\":\"20230920\"},{\"symbol\":\"AMZN\",\"exchange\":\"NASDAQ\",\"name\":\"Amazon.com Inc.\",\"dayCode\":\"20240425\",\"serverTimestamp\":\"20240425120200\",\"mode\":\"realtime\",\"lastPrice\":\"3400.00\",\"tradeTimestamp\":\"20240425120230\",\"netChange\":\"-25.80\",\"percentChange\":\"-0.75%\",\"unitCode\":\"USD\",\"open\":\"3425.80\",\"high\":\"3440.25\",\"low\":\"3395.50\",\"close\":\"3425.80\",\"flag\":\"normal\",\"volume\":\"876543\",\"fiftyTwoWkHigh\":\"3600.20\",\"fiftyTwoWkHighDate\":\"20240228\",\"fiftyTwoWkLow\":\"3100.25\",\"fiftyTwoWkLowDate\":\"20231110\"},{\"symbol\":\"TSLA\",\"exchange\":\"NASDAQ\",\"name\":\"Tesla Inc.\",\"dayCode\":\"20240425\",\"serverTimestamp\":\"20240425120300\",\"mode\":\"realtime\",\"lastPrice\":\"900.50\",\"tradeTimestamp\":\"20240425120400\",\"netChange\":\"+15.20\",\"percentChange\":\"+1.72%\",\"unitCode\":\"USD\",\"open\":\"895.30\",\"high\":\"905.75\",\"low\":\"892.40\",\"close\":\"885.30\",\"flag\":\"normal\",\"volume\":\"1456789\",\"fiftyTwoWkHigh\":\"950.00\",\"fiftyTwoWkHighDate\":\"20240320\",\"fiftyTwoWkLow\":\"780.20\",\"fiftyTwoWkLowDate\":\"20231025\"},{\"symbol\":\"NVDA\",\"exchange\":\"NASDAQ\",\"name\":\"NVIDIA Corporation\",\"dayCode\":\"20240425\",\"serverTimestamp\":\"20240425120430\",\"mode\":\"realtime\",\"lastPrice\":\"650.75\",\"tradeTimestamp\":\"20240425120500\",\"netChange\":\"+8.45\",\"percentChange\":\"+1.32%\",\"unitCode\":\"USD\",\"open\":\"645.30\",\"high\":\"654.25\",\"low\":\"642.50\",\"close\":\"643.30\",\"flag\":\"normal\",\"volume\":\"987654\",\"fiftyTwoWkHigh\":\"680.50\",\"fiftyTwoWkHighDate\":\"20240305\",\"fiftyTwoWkLow\":\"610.20\",\"fiftyTwoWkLowDate\":\"20231115\"},{\"symbol\":\"NFLX\",\"exchange\":\"NASDAQ\",\"name\":\"Netflix Inc.\",\"dayCode\":\"20240425\",\"serverTimestamp\":\"20240425120600\",\"mode\":\"realtime\",\"lastPrice\":\"575.30\",\"tradeTimestamp\":\"20240425120630\",\"netChange\":\"+10.80\",\"percentChange\":\"+1.91%\",\"unitCode\":\"USD\",\"open\":\"565.50\",\"high\":\"578.75\",\"low\":\"562.40\",\"close\":\"564.50\"},{\n"
        		+ "    \"symbol\": \"MSFT\",\n"
        		+ "    \"exchange\": \"NASDAQ\",\n"
        		+ "    \"name\": \"Microsoft Corporation\",\n"
        		+ "    \"dayCode\": \"20240425\",\n"
        		+ "    \"serverTimestamp\": \"20240425120430\",\n"
        		+ "    \"mode\": \"realtime\",\n"
        		+ "    \"lastPrice\": \"270.80\",\n"
        		+ "    \"tradeTimestamp\": \"20240425120500\",\n"
        		+ "    \"netChange\": \"+3.75\",\n"
        		+ "    \"percentChange\": \"+1.40%\",\n"
        		+ "    \"unitCode\": \"USD\",\n"
        		+ "    \"open\": \"267.50\",\n"
        		+ "    \"high\": \"273.00\",\n"
        		+ "    \"low\": \"267.00\",\n"
        		+ "    \"close\": \"267.00\",\n"
        		+ "    \"flag\": \"normal\",\n"
        		+ "    \"volume\": \"987654\",\n"
        		+ "    \"fiftyTwoWkHigh\": \"280.50\",\n"
        		+ "    \"fiftyTwoWkHighDate\": \"20240305\",\n"
        		+ "    \"fiftyTwoWkLow\": \"260.20\",\n"
        		+ "    \"fiftyTwoWkLowDate\": \"20231115\"\n"
        		+ "  },\n"
        		+ "  {\n"
        		+ "    \"symbol\": \"AMZN\",\n"
        		+ "    \"exchange\": \"NASDAQ\",\n"
        		+ "    \"name\": \"Amazon.com, Inc.\",\n"
        		+ "    \"dayCode\": \"20240425\",\n"
        		+ "    \"serverTimestamp\": \"20240425120430\",\n"
        		+ "    \"mode\": \"realtime\",\n"
        		+ "    \"lastPrice\": \"3300.00\",\n"
        		+ "    \"tradeTimestamp\": \"20240425120500\",\n"
        		+ "    \"netChange\": \"+25.60\",\n"
        		+ "    \"percentChange\": \"+0.78%\",\n"
        		+ "    \"unitCode\": \"USD\",\n"
        		+ "    \"open\": \"3275.40\",\n"
        		+ "    \"high\": \"3325.00\",\n"
        		+ "    \"low\": \"3265.25\",\n"
        		+ "    \"close\": \"3274.40\",\n"
        		+ "    \"flag\": \"normal\",\n"
        		+ "    \"volume\": \"987654\",\n"
        		+ "    \"fiftyTwoWkHigh\": \"3400.00\",\n"
        		+ "    \"fiftyTwoWkHighDate\": \"20240305\",\n"
        		+ "    \"fiftyTwoWkLow\": \"3200.20\",\n"
        		+ "    \"fiftyTwoWkLowDate\": \"20231115\"\n"
        		+ "  },{\n"
        		+ "    \"symbol\": \"AAPL\",\n"
        		+ "    \"exchange\": \"NASDAQ\",\n"
        		+ "    \"name\": \"Apple Inc.\",\n"
        		+ "    \"dayCode\": \"20240425\",\n"
        		+ "    \"serverTimestamp\": \"20240425120430\",\n"
        		+ "    \"mode\": \"realtime\",\n"
        		+ "    \"lastPrice\": \"180.25\",\n"
        		+ "    \"tradeTimestamp\": \"20240425120500\",\n"
        		+ "    \"netChange\": \"+2.75\",\n"
        		+ "    \"percentChange\": \"+1.55%\",\n"
        		+ "    \"unitCode\": \"USD\",\n"
        		+ "    \"open\": \"178.50\",\n"
        		+ "    \"high\": \"182.00\",\n"
        		+ "    \"low\": \"177.50\",\n"
        		+ "    \"close\": \"177.50\",\n"
        		+ "    \"flag\": \"normal\",\n"
        		+ "    \"volume\": \"123456\",\n"
        		+ "    \"fiftyTwoWkHigh\": \"185.50\",\n"
        		+ "    \"fiftyTwoWkHighDate\": \"20240305\",\n"
        		+ "    \"fiftyTwoWkLow\": \"170.20\",\n"
        		+ "    \"fiftyTwoWkLowDate\": \"20231115\"\n"
        		+ "  },{\n"
        		+ "    \"symbol\": \"NVDA\",\n"
        		+ "    \"exchange\": \"NASDAQ\",\n"
        		+ "    \"name\": \"NVIDIA Corporation\",\n"
        		+ "    \"dayCode\": \"20240425\",\n"
        		+ "    \"serverTimestamp\": \"20240425120430\",\n"
        		+ "    \"mode\": \"realtime\",\n"
        		+ "    \"lastPrice\": \"650.75\",\n"
        		+ "    \"tradeTimestamp\": \"20240425120500\",\n"
        		+ "    \"netChange\": \"+8.45\",\n"
        		+ "    \"percentChange\": \"+1.32%\",\n"
        		+ "    \"unitCode\": \"USD\",\n"
        		+ "    \"open\": \"645.30\",\n"
        		+ "    \"high\": \"654.25\",\n"
        		+ "    \"low\": \"642.50\",\n"
        		+ "    \"close\": \"643.30\",\n"
        		+ "    \"flag\": \"normal\",\n"
        		+ "    \"volume\": \"987654\",\n"
        		+ "    \"fiftyTwoWkHigh\": \"680.50\",\n"
        		+ "    \"fiftyTwoWkHighDate\": \"20240305\",\n"
        		+ "    \"fiftyTwoWkLow\": \"610.20\",\n"
        		+ "    \"fiftyTwoWkLowDate\": \"20231115\"\n"
        		+ "  }]";
        

        try {
            JSONArray jsonArray = (JSONArray) new JSONParser().parse(result);

            for (Object obj : jsonArray) {
                JSONObject jsonObject = (JSONObject) obj;
                ObjectMapper mapper = new ObjectMapper(); // Jackson's object mapper
                StockAPIBean pojo = mapper.convertValue(jsonObject, StockAPIBean.class);
                stocks.add(pojo);
            }
        } catch (ParseException e) {
            logger.error(e.toString());
        }

//        result = this.restTemplate.getForObject(stockUri2, String.class);

//        try {
//            JSONArray jsonArray = (JSONArray) new JSONParser().parse(result);
//
//            for (Object obj : jsonArray) {
//                JSONObject jsonObject = (JSONObject) obj;
//                ObjectMapper mapper = new ObjectMapper(); // Jackson's object mapper
//                StockAPIBean pojo = mapper.convertValue(jsonObject, StockAPIBean.class);
//                stocks.add(pojo);
//            }
//        } catch (ParseException e) {
//            logger.error(e.toString());
//        }
=======
    final String stockUri1 = "https://marketdata.websol.barchart.com/getQuote.json?apikey=b0ccbbb0dae9d39ce81f65718f0ecd10&symbols=AMZN,GOOG,AAPL,NFLX,TSLA,FB,CSCO,ORCL,INTC,QCOM,EBAY,DELL,COST,MSFT,TWTR,AABA,SNAP,AMD,ATVI,ZNGA&fields=fiftyTwoWkHigh%2CfiftyTwoWkHighDate%2CfiftyTwoWkLow%2CfiftyTwoWkLowDate";

    final String stockUri2 = "https://marketdata.websol.barchart.com/getQuote.json?apikey=b0ccbbb0dae9d39ce81f65718f0ecd10&symbols=WDC,BKNG,VZ,HPQ,SNE,W,BABA,JNJ,JPM,XOM,BAC,WMT,WFC,V,PG,BUD,T,UNH,HD,C&fields=fiftyTwoWkHigh%2CfiftyTwoWkHighDate%2CfiftyTwoWkLow%2CfiftyTwoWkLowDate";



    final String currencyUri = "https://www.worldtradingdata.com/api/v1/forex?base=USD&sort=newest&api_token=uRqeU8C651htqmF8iI5N6VvSBEIpTiQ5xvvKkz9Slsm1D9jFvIGdG97m0RpF";

    public List<StockAPIBean> getTopStocks ()
    {
        List<StockAPIBean> stocks = new ArrayList<StockAPIBean>();

        String result = this.restTemplate.getForObject(stockUri1, String.class);
        Object obj = null;
        JSONObject jo = null;
        try {
            obj = new JSONParser().parse(result);
            jo = (JSONObject) obj;
        } catch (ParseException e) {
            logger.error(e.toString());
            obj = null;
            jo = null;
        }

        if (obj != null && jo != null) {
            JSONArray ja = (JSONArray) jo.get("results");

            Iterator itr2 = ja.iterator();

            while (itr2.hasNext()) {

                Map map = (Map) itr2.next();
                ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
                StockAPIBean pojo = mapper.convertValue(map, StockAPIBean.class);
                stocks.add(pojo);
            }
        }

        result = this.restTemplate.getForObject(stockUri2, String.class);
        obj = null;
        jo = null;
        try {
            obj = new JSONParser().parse(result);
            jo = (JSONObject) obj;
        } catch (ParseException e) {
            logger.error(e.toString());
            obj = null;
            jo = null;
        }

        if (obj != null && jo != null) 
        {
            JSONArray ja = (JSONArray) jo.get("results");

            Iterator itr2 = ja.iterator();

            while (itr2.hasNext()) {

                Map map = (Map) itr2.next();
                ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
                StockAPIBean pojo = mapper.convertValue(map, StockAPIBean.class);
                stocks.add(pojo);
            }
        }
>>>>>>> bfa3d0c092865e6b8aacd1af30606a372ba3957f

        saveAllStocks(stocks);

        logger.info("size::" + stocks.size());
        return stocks;
<<<<<<< HEAD
    }

=======

    }
>>>>>>> bfa3d0c092865e6b8aacd1af30606a372ba3957f

    public void saveAllStocks(List<StockAPIBean> stocks)
    {

        logger.info("Saving stock object to database");
        for (StockAPIBean stock : stocks) {
            Stock temp = null;
            try {
                temp = this.homePageDAO.checkIfStockExists(stock.getSymbol());
            } catch (Exception e) {
                temp = null;
            }
            if (temp == null) 
            {
<<<<<<< HEAD
                this.homePageDAO.saveStock(stock);
=======
                //this.homePageDAO.saveStock(stock);
>>>>>>> bfa3d0c092865e6b8aacd1af30606a372ba3957f
            } 
            else {
                this.homePageDAO.updateStock(stock, temp.getId());

            }

        }
        logger.info("Done updating stock table");

    }

<<<<<<< HEAD
////    public Map<String , String> getTopCurrencies ()
////    {
////        String result = this.restTemplate.getForObject(currencyUri, String.class);
////
////        net.sf.json.JSONObject json = (net.sf.json.JSONObject) JSONSerializer.toJSON( result );        
////        net.sf.json.JSONObject data = json.getJSONObject("data");
////        
////        Map<String,String> map = new HashMap<String,String>();
////        Iterator iter = data.keys();
////        
////        while(iter.hasNext())
////        {
////            String key = (String)iter.next();
////            String value = data.getString(key);
////            map.put(key,value);
////        }
////
////        Map<String,String> resultMap = new HashMap<String,String>();
////
////        String eur = map.get("EUR");
////        String jpy = map.get("JPY");
////        String inr = map.get("INR");
////
////        resultMap.put("Euro", eur);
////        resultMap.put("Yen", jpy);
////        resultMap.put("Rupee", inr);
////
////        return resultMap;
////        
//    }
    public Map<String, String> getTopCurrencies() {
        // Mocking response data instead of calling the API
        String result = "{ \"data\": { \"EUR\": \"1.20\", \"JPY\": \"0.0095\", \"INR\": \"0.014\" } }";

        net.sf.json.JSONObject json = (net.sf.json.JSONObject) JSONSerializer.toJSON(result);
        net.sf.json.JSONObject data = json.getJSONObject("data");

        Map<String, String> map = new HashMap<>();

        Iterator<?> iter = data.keys();

        while (iter.hasNext()) {
            String key = (String) iter.next();
            String value = data.getString(key);
            map.put(key, value);
        }

        // Creating and returning fake data instead of calling the API
        Map<String, String> resultMap = new HashMap<>();
=======
    public Map<String , String> getTopCurrencies ()
    {
        String result = this.restTemplate.getForObject(currencyUri, String.class);

        net.sf.json.JSONObject json = (net.sf.json.JSONObject) JSONSerializer.toJSON( result );        
        net.sf.json.JSONObject data = json.getJSONObject("data");
        
        Map<String,String> map = new HashMap<String,String>();
        Iterator iter = data.keys();
        
        while(iter.hasNext())
        {
            String key = (String)iter.next();
            String value = data.getString(key);
            map.put(key,value);
        }

        Map<String,String> resultMap = new HashMap<String,String>();

>>>>>>> bfa3d0c092865e6b8aacd1af30606a372ba3957f
        String eur = map.get("EUR");
        String jpy = map.get("JPY");
        String inr = map.get("INR");

        resultMap.put("Euro", eur);
        resultMap.put("Yen", jpy);
        resultMap.put("Rupee", inr);

        return resultMap;
<<<<<<< HEAD
    }


=======
        
    }

>>>>>>> bfa3d0c092865e6b8aacd1af30606a372ba3957f
    

}