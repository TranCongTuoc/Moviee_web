document.addEventListener("DOMContentLoaded", function () {
    const addMovieForm = document.getElementById("add-movie-form")
    const deleteMovieForm = document.getElementById("delete-movie-form")

    if (addMovieForm) {
        addMovieForm.addEventListener("submit", function (e) {
            e.preventDefault()

            const title = document.querySelector('input[name="title"]').value;
            const description = document.querySelector('textarea[name="description"]').value;
            const releaseDate = document.querySelector('input[name="releaseDate"]').value;
            const duration = document.querySelector('input[name="duration"]').value;
            const trailer = document.querySelector('input[name="trailer"]').value;
            const genreId = document.querySelector("#genre-checked option:checked").value;

            const url = new URL('/movie/add', window.location.origin)
            url.search = new URLSearchParams({
                genreId: genreId
            }).toString()
            fetch(url, {
                method: "POST",
                headers :{
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({
                    title: title,
                    description: description,
                    releaseDate: releaseDate,
                    duration: duration,
                    trailer : trailer
                })
            }).then(data => {
                    window.location.href = "/admin/movie"
            })
                .catch()
        })
    }

    if (deleteMovieForm) {
        deleteMovieForm.addEventListener("submit", function (e) {
            e.preventDefault()
            const movieId = document.querySelector('input[name="movieId"]').value;
            const url = new URL('/movie/delete', window.location.origin)
            url.search = new URLSearchParams({
                movieId: movieId
            }).toString()
            fetch(url, {
                method: "POST",
                headers :{
                    "Content-Type": "application/json"
                }
            }).then(data => {
                window.location.href = "/admin/movie"
            })
                .catch()
        })
    }
})