package com.qacart.todo.utils;

import java.util.Properties;

public class ConfigUtils {

    private  Properties properties ;

    private static ConfigUtils configUtils ;

    private ConfigUtils(){
      String env =  System.getProperty("env" , "production") ;

      switch (env) {
          case "production" :
              properties = PropertiesUtil.loadProperties("src/test/java/com/qacart/todo/config/production.properties");

              break;

          case "local" :
              System.out.println("There is No Local ");
              break;
          default:
              throw new RuntimeException("Environment is not supported ") ;
      }
    }

    public static ConfigUtils getInstance () {
        if (configUtils== null){
            configUtils= new ConfigUtils();
        }
        return configUtils;
    }

    public  String getBaseUrl (){

      String prop =  properties.getProperty("baseUrl");
      if (prop != null) return prop ;
        throw  new RuntimeException("Could not find the base url ") ;
    }

    public  String getEmail (){

        String prop =  properties.getProperty("email");
        if (prop != null) return prop ;
        throw  new RuntimeException("Could not find the Email ") ;
    }


    public  String getPassword (){

        String prop =  properties.getProperty("password");
        if (prop != null) return prop ;
        throw  new RuntimeException("Could not find the password ") ;
    }



}
