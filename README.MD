
# mall

## module
> eureka  
> goods  
> user  
> order  

## run step
```
1. run EurekaApplication 
2. run GoodsApplication
3. run UserApplication
4. run OrderApplication  
5. curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{ "goodsCount": 1, "goodsId": 1, "userAddressId": 6, "userId": 1 }' 'http://127.0.0.1:8762/orders'  
6. curl -X GET --header 'Accept: application/json' 'http://127.0.0.1:8762/orders/1' 
7. curl -X GET --header 'Accept: application/json' 'http://127.0.0.1:8762/orders?userId=1&currentPage=0&pageSize=10' 

```
