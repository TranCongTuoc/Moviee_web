document.addEventListener("DOMContentLoaded", function () {
    const registerForm = document.getElementById("register-form")

    if(registerForm) {
        registerForm.addEventListener("submit", function (e) {
            e.preventDefault()

            const fullname = document.querySelector('input[name="fullname"]').value;
            const email = document.querySelector('input[name="email"]').value;
            const username = document.querySelector('input[name="username"]').value;
            const password = document.querySelector('input[name="password"]').value;

            fetch(`http://localhost:8080/user/register`, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({
                    fullName: fullname,
                    username: username,
                    email: email,
                    password: password,
                    role: "USER",
                })
            }).then(data => {
                    return fetch(`http://localhost:8080/auth/login`, {
                        method: "POST",
                        headers: {
                            "Content-Type": "application/json"
                        },
                        body: JSON.stringify({
                            username: username,
                            password: password
                        })
                    });
                }).then(data => {
                    localStorage.setItem("access_token", data.token);
                    localStorage.setItem("user", username);
                    window.location.href = "/";
                }).catch(error => {
                    alert(error.message);
                });
        })
    }
})