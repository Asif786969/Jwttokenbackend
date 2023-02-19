localhost:8090/welcome/auth
Body->raw->text->eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJWaXZlayIsInJvbGUiOiJhZG1pbiIsImV4cCI6MTY3Mzk1NzYzMX0.N0jzWevB63PTOJBrZsPpWDUNp-k78kkKo6iWJ_wRyGA


localhost:8090/welcome/login
Body->raw->JSON
{
    "username":"Vivek",
    "password":"Vivek1253@"
}
result->
{
    "admin": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJWaXZlayIsInJvbGUiOiJhZG1pbiIsImV4cCI6MTY3Mzk1NzYzMX0.N0jzWevB63PTOJBrZsPpWDUNp-k78kkKo6iWJ_wRyGA"
}





localhost:8090/welcome/register
Body->raw->JSON->POSTa
{
    "username":"Vivek",
    "password":"Vivek1253@",
    "role":"admin"
}




localhost:8090/welcome/allusers->GET
