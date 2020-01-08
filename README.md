# Getting Started

``i have added two route context``


### Java Route: /bsb/web/data/**
### YML Route: /my/web/ser/**

### Authorized API: 
     All POST except, http://localhost:8989/{context}/api/v1/messages/send
### Public API: 
    All GET API, [not working with java route]


### Example

    curl --location --request POST 'http://localhost:8989/my/web/ser/api/v1/messages/send' \
    --header 'Content-Type: application/json' \
    --header 'Authorization: Basic YnJ1Y2Uud2F5bmVAZXhhbXBsZS5jb206d2F5bmU=' \
    --data-raw '{
    }'


    curl --location --request POST 'http://localhost:8989/my/web/ser/downstream_get_api'
