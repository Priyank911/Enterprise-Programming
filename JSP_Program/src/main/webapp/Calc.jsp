<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calc Program Using JSP</title>
</head>
<body>
<h2>Simple Calculator</h2>
    <form method="post">
        <label for="number1">Enter Number 1:</label><br>
        <input type="number" id="number1" name="number1"><br><br>

        <label for="number2">Enter Number 2:</label><br>
        <input type="number" id="number2" name="number2"><br><br>

        <label>Select Operation:</label><br>
        <input type="radio" id="add" name="operation" value="add">
        <label for="add">+</label><br>
        <input type="radio" id="subtract" name="operation" value="subtract">
        <label for="subtract">-</label><br>
        <input type="radio" id="multiply" name="operation" value="multiply">
        <label for="multiply">*</label><br>
        <input type="radio" id="divide" name="operation" value="divide">
        <label for="divide">/</label><br><br>

        <input type="submit" value="Calculate">
    </form>

    <h3>Result:</h3>
    <p>
        <%
            
            String number1Str = request.getParameter("number1");
            String number2Str = request.getParameter("number2");
            String operation = request.getParameter("operation");

            if (number1Str != null && number2Str != null && operation != null) {
                try {
                    double number1 = Double.parseDouble(number1Str);
                    double number2 = Double.parseDouble(number2Str);
                    double result = 0;

                    switch(operation) {
                        case "add":
                            result = number1 + number2;
                            break;
                        case "subtract":
                            result = number1 - number2;
                            break;
                        case "multiply":
                            result = number1 * number2;
                            break;
                        case "divide":
                            if (number2 != 0) {
                                result = number1 / number2;
                            } else {
                                out.println("Error: Division by zero");
                                return;
                            }
                            break;
                    }

                    out.println("The result is: " + result);
                } catch (NumberFormatException e) {
                    out.println("Error: Invalid number format");
                }
            }
        %>
    </p>
</body>
</html>