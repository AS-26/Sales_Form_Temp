<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles.css">
    <title>Sales Form</title>
</head>
<body>

    <h2>Sales Form</h2>

    <form action="SubmitFormServlet" method="post">
        First Name: <input type="text" name="firstName"><br>
        Last Name: <input type="text" name="lastName"><br>
        Email: <input type="text" name="email"><br>
        <!-- Add other form fields as needed -->

        <input type="submit" value="Submit">
    </form>

</body>
</html>
