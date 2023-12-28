<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student List</title>
</head>
<body>
    <h2>Student List</h2>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Password</th>
                <th>Date of Birth</th>
                <th>Gender</th>
                <th>Quota</th>
                <th>Country</th>
                <th colspan="2">Action</th>
            </tr>
        </thead>
        <tbody>
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.email}</td>
                    <td>${student.password}</td>
                    <td>${student.dateOfBirth}</td>
                    <td>${student.gender}</td>
                    <td>${student.quota}</td>
                    <td>${student.country}</td>
                    <td><a href="${pageContext.request.contextPath}/students/${student.id}/edit">Update</a></td>
                    <td><a href="${pageContext.request.contextPath}/students/${student.id}/delete" onclick="return confirm('Are you sure you want to delete this student?')">Delete</a></td>


                </tr>
        </tbody>
    </table>

    <hr>

    <a href="${pageContext.request.contextPath}">Home</a>

</body>
</html>