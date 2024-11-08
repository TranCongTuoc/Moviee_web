document.addEventListener("DOMContentLoaded", function () {
    const updateForm = document.getElementById("update-genre-form")
    const addForm = document.getElementById("add-genre-form")
    const deleteForm = document.getElementById("delete-genre-form")

    if(addForm) {
        addForm.addEventListener("submit", function (e) {
            e.preventDefault()
            const genreName = document.querySelector('input[name="genreName"]').value;
            fetch(`http://localhost:8080/genre/add`, {
                method: "POST",
                headers :{
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({
                    genreName: genreName
                })
            }).then(data => {
                    window.location.href = "/admin/genre"
                })
                .catch()
        })
    }

    if (deleteForm) {
        deleteForm.addEventListener("submit", function (e) {
            e.preventDefault()
            const genreId = document.querySelector('input[name="genreId"]').value;
            const url = new URL('/genre/delete', window.location.origin)
            url.search = new URLSearchParams({
                genreId: genreId
            }).toString()
            fetch(url, {
                method: "POST",
                headers :{
                    "Content-Type": "application/json"
                }
            }).then(data => {
                window.location.href = "/admin/genre"
            }).catch()
        })
    }

    if(updateForm) {
        updateForm.addEventListener("submit", function (e) {
            e.preventDefault()
            const genreId = document.querySelector('input[name="genreId"]').value;
            const genreName = document.querySelector('input[name="genreName"]').value;
            const url = new URL('/genre/update', window.location.origin)
            url.search = new URLSearchParams({
                genreId: genreId
            }).toString()
            console.log("hello")
            fetch(url, {
                method: "POST",
                headers :{
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({
                    genreName: genreName
                })
            }).then(data => {
                window.location.href = "/admin/genre"
            })
                .catch(e => {
                    console.log(e.body)
                })
        })
    }

})