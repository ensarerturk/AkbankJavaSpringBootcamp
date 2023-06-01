# homework

There is a Country model and a CountryDTO class accordingly. For the conversion operations between these two classes, the CountryMapper interface and a class that implements this interface are used.

The Controller class and the methods of this class corresponding to the HTTP methods required for the RESTful API are written. When an HTTP request comes, the request parameters are transferred to the relevant method in the Controller class and processed there. The Service class is the layer where the operations are performed and database operations are performed. The Service class performs database operations by making use of the CountryRepository interface.

Finally, the HTTP response is returned based on the result of the transactions.# AkbankJavaSpringBootcamp
