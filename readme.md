# Design Documents



# Design
1. Three interfaces are designed according to the car rental service: query the car rental model, rent a car and cancel the car rental
2. Everyone who rents a car needs to be marked with a userid
3. use map to storage the cars and who rent the cars 

# Interface
## Query the car rental model of the current company
### Interface：
Get    http://129.204.137.138:8080/car/list
### Out params
#### success
 ```
{
    "data": true,
    "res": "",
    "code": 200
}
```
## Rent Car
### Interface
Post http://129.204.137.138:8080/car/rent
### Input params
```
{
    "type": "Toyota Camry",
    "userId":"3"
}
```
### Out params
#### success
```
{
    "data": true,
    "res": "",
    "code": 200
}
```
#### fail
1.There is no stock in the warehouse
```
{
    "data": null,
    "res": "this type of car  are rented by other customers",
    "code": 10001
}
```

2.no kind of car
```
{
    "data": null,
    "res": "this kind of car is not in our warehouse",
    "code": 10001
}
```
## Cancel  Car of Renting
### Interface
Post  http://129.204.137.138:8080/car/cancel
### Input param
```
{
    "type": "Toyota Camry",
    "userId":"3"
}
```
### Out param
#### success
```
{
    "data": true,
    "res": "",
    "code": 200
}
```
#### fail
1.haven't rented such a car

```
{
    "data": null,
    "res": "you don't have rented this kind of car before",
    "code": 10001
}
```

2.no kind of car

```
{
    "data": null,
    "res": "this kind of car is not in our warehouse",
    "code": 10001
}
```


