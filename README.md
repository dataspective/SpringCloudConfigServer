#Spring Cloud Config Server
## READ ME
Author: Derek Fermaint
K12 Portland, Oregon June 15th, 2018

## DESCRIPTION
This program is a simple example of a Java Spring Config server.

It uses git for version control, and has three services:

1. limits-service: simple service that stores upper and lower bound values to demonstrate
    how the config server drives from the property files.
2. currency-exchange-service: service stores different conversion rates from USD to other countries.
    Also managed from property files in the git repository.
3. currency-conversion-service: depends on the currency-exchange-service values in order to
    calculate quantities of currency.

## BEFORE USE
The path of the git config repo needs to be updated to where it's stored locally.
Path uri is located in SpringCloudConfigServer/spring-cloud-config-server/main/resources/application.properties


## PORT INFORMATION
spring-cloud-config-server      8888
limits-service                  8080
currency-exchange-service       8000
currency-conversion-service     8100

## USEFUL ENDPOINTS
http://localhost:8080/limits                                                     displays the upper and lower bound values

http://localhost:8000/currency-exchange/from/USD/to/INR                          displays conversion rate information from American to Indian currency

http://localhost:8000/currency-exchange/from/USD/to/EUR                          displays conversion rate information from American to European currency

http://localhost:8000/currency-exchange/from/USD/to/RUB                          displays conversion rate information from American to Russian currency

http://localhost:8000/currency-exchange/from/USD/to/JPY                          displays conversion rate information from American to Japanese currency

http://localhost:8100/currency-converter/from/USD/to/X/quantity/Y                displays amount of money after converted where x = {INR, EUR, RUB, JPY} and y being a positive integer

note: update the values in the property files, restart the service and see the change propagate
