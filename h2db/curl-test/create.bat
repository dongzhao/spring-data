curl -i -X POST -H "Content-Type: application/json" -d "{\"firstName\":\"dong\", \"lastName\":\"zhao\", \"gender\":0}" http://localhost:8891/h2/api/customer

curl -i -X POST -H "Content-Type: application/json" -d "{\"product\":\"Macbook air\", \"quantity\":1, \"customer\":{\"id\":\"1\"}}" http://localhost:8891/h2/api/order
