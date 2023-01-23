* this is a spring boot application which converts numbers to roman numeral and vice versa.
  this application contains the below endpoints for conversion

URL: http://localhost:8080/numeric?input=5
Explanation : this endpoint accepts a number as query param and converts to roman numeral
Example: the above url with given value will return the below output
         5 converted to roman numeral, result : V

URL: http://localhost:8080/numeral?input=V
Explanation : this endpoint accepts a roman numeral string as query param and converts to number
Example : the above url with given value will return the below output
          V converted to number, result : 5