# find all
curl -i -H "Content-Type: application/json" http://localhost:8890/mongodb/api/person

# find by first name
curl -i -H "Content-Type: application/json" http://localhost:8890/mongodb/api/person/firstname/kevin

# find by last name
curl -i -H "Content-Type: application/json" http://localhost:8890/mongodb/api/person/lastname/rudd