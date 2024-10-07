<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <script>
        // TODO: 비밀번호 확인란 만들기
        function pwck() {

        }
    </script>
</head>
<body>
    <header>
        <!-- TODO: 회원가입 웹 사이트 이름 정해야 함. -->
        <h1 id = "mainTitle">웹 사이트</h1>
    </header>
    <section>
        <div>
            <form method="post" action="/register">
                <fieldset>
                    <legend style="text-align: center;">LOGIN</legend>
                    <table>
                        <tr>
                            <td>이름: </td>
                            <td><input type="text" name="name" placeholder="이름" required></td>
                        </tr>
                        <tr>
                            <td>아이디: </td>
                            <td><input type="text" name="id" placeholder="아이디" required></td>
                        </tr>
                        <tr>
                            <td>비밀번호: </td>
                            <td><input type="password" name="passwd" placeholder="비밀번호" required></td>
                        </tr>
                    </table><br>
                    <div><input type="submit" value="회원가입"></div>
                </fieldset>
            </form>
        </div>
    </section>
</body>
</html>