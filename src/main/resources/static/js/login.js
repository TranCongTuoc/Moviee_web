document.addEventListener("DOMContentLoaded", function () {
    const loginForm = document.getElementById("login-form")

    if(loginForm) {
        loginForm.addEventListener("submit", function (e) {
            e.preventDefault()
            const username = document.querySelector('input[name="username"]').value;
            const password = document.querySelector('input[name="password"]').value;

            fetch(`http://localhost:8080/auth/login`, {
                method: "POST",
                headers :{
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({
                    username: username,
                    password: password
                })
            }).then(response => response.json())
                .then(data => {
                    localStorage.setItem("access_token", data.token);
                    localStorage.setItem("user", username);

                    setTimeout(() => {
                        window.location.href = "/admin/home";
                    }, 0);
                }).catch(error => {
                    const errorModal = new bootstrap.Modal(document.getElementById("error-modal"));
                    errorModal.show();
                })
        })
    }
})