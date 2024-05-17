# DEMO_實作


## 開發需求
* Java 22 以上
* maven 3.6.x 以上

## 環境依賴
<details>
<summary><b>mysql</b></summary><br>
執行檔案 docker-compose-mysql.yml

    docker-compose -f docker-compose-mysql.yml up -d
</details>

## Profiles

相關環境設定已於 `pom.xml` 及 `application.yml` 設定



## 相關說明



#### 需求
```
請實作出一個簡易供應商管理系統，包含帳號登入跟CRUD的功能範例(畫面自行定義即可)
```

#### 啟動
```
執行檔案 docker-compose-mysql.yml建立好MySql環境
DemoApplication.java啟動後JPA會自動建立TableSchema
mysql執行腳本可簡單新增一筆測試資料(選擇)
ddl-auto設為create, 請根據需求調整
其餘設定請參考application.yaml
```

#### 登入
http://localhost:8081/login
```
 role 1
 username: romin
 password: momo
 
 role 2
 username: user
 password: pass
 
 僅滿足登入需求,角色與權限管理與未實作, 
 實際需求應該使用資料庫redis和jwt token進行登入驗證,
 建立人與修改人目前使用登入角色.
```

#### 查詢
```
帳號 : 精準
姓名 : 模糊
日期 : 範圍 (起始日期, 結束日期)
```


#### 新增
```
 帳號不可空白 , 錯誤訊息未優化
```

#### 修改
```
 帳號不可空白 , 錯誤訊息未優化
```

#### 刪除
```
 根據ID進行刪除
```

#### UI
```
 僅配置滿足基本需求的簡單頁面
```

