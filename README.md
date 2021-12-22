# 接口调用

```shell
curl --location --request POST 'http://localhost:8080/demo/post2' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": 1,
    "name": "name",
    "devops": {
        "key1": "v1",
        "key2": "v2",
        "key3": "v3",
        "time": "2021-03-05 14:00:00"
    },
    "boms": {
        "key1": "v1",
        "key2": "v2",
        "key3": "v3"
    }
}'
```

