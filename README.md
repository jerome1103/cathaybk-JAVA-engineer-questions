# 國泰世華 JAVA engineer 線上作業

# 專案使用版本
* IDE:STS-4.18.0.RELEASE
* Spring Boot:2.7.11
* JDK:1.8

# 專案注意事項
* SQL檔案位於專案目錄下coindb.sql

## 專案API

### 呼叫查詢幣別對應表資料API

* [GET]查詢所有幣值

```javascript
http://localhost:8080/coin
```

* 回傳Json內容

```javascript
[
    {
        "coin_id": 1,
        "coin_code": "USD",
        "coin_rate": 30.32,
        "code_name": "美金"
    },
    {
        "coin_rate": 3.758,
        "code_name": "港幣",
        "coin_id": 2,
        "coin_code": "HKD"
    },
    {
        "code_name": "英鎊",
        "coin_id": 3,
        "coin_code": "GBP",
        "coin_rate": 37.13
    },
    {
        "coin_id": 4,
        "code_name": "澳幣",
        "coin_code": "AUD",
        "coin_rate": 19.9
    },
    {
        "coin_id": 5,
        "coin_code": "CAD",
        "code_name": "加拿大幣",
        "coin_rate": 22.07
    },
    {
        "coin_id": 6,
        "coin_rate": 22.43,
        "code_name": "新加坡幣",
        "coin_code": "SGD"
    },
    {
        "coin_id": 7,
        "coin_rate": 33.75,
        "code_name": "瑞士法郎",
        "coin_code": "CHF"
    },
    {
        "coin_id": 8,
        "coin_rate": 0.2207,
        "coin_code": "JPY",
        "code_name": "日圓"
    }
]
```

* [GET]查詢單筆幣值

```javascript
http://localhost:8080/coin/{id}
```

* 回傳Json內容

```javascript
[
    {
        "coin_id": 1,
        "coin_code": "USD",
        "coin_rate": 30.32,
        "code_name": "美金"
    }
]
```

### 呼叫新增幣別對應表資料API

* [POST]查詢所有幣值

```javascript
http://localhost:8080/coin
```

* 代入的參數

```javascript
{
    "coin_code":"TWD",
    "coin_rate":1
}
```

* 回傳Json內容

```javascript
16
```

### 呼叫修改幣別對應表資料API

* [PUT]查詢所有幣值

```javascript
http://localhost:8080/coin/{id}
```

* 代入的參數

```javascript
{
    "coin_code":"TTT",
    "coin_rate":1
}
```

### 呼叫刪除幣別對應表資料API

* [DELETE]查詢所有幣值

```javascript
http://localhost:8080/coin/{id}
```

### 呼叫Coindesk API

* [GET]查詢https://api.coindesk.com/v1/bpi/currentprice.json幣值並解析

```javascript
http://localhost:8080/coin/desk
```

* 回傳Json內容

```javascript
{
    "date": "2023/04/27 17:37:00",
    "coinList": [
        {
            "code": "EUR",
            "rate": "28,203.3741",
            "rate_float": 28203.3741,
            "description": "Euro",
            "coinType": "歐元"
        },
        {
            "code": "GBP",
            "rate": "24,191.9730",
            "rate_float": 24191.973,
            "description": "British Pound Sterling",
            "coinType": "英鎊"
        },
        {
            "code": "USD",
            "rate": "28,951.8964",
            "rate_float": 28951.8964,
            "description": "United States Dollar",
            "coinType": "美元"
        }
    ]
}
```