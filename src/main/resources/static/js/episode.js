document.addEventListener("DOMContentLoaded", function () {
    const movieFile = document.getElementById("movieFile")
    const addEpisodeForm = document.getElementById("add-episode-form")

    if(movieFile) {
        movieFile.addEventListener("change", function (e) {
            e.preventDefault()
            const output = document.getElementById("video-here")
            output.src = URL.createObjectURL(e.target.files[0])
            output.onload = function () {
                URL.revokeObjectURL(output.src)
            }
        })
    }

    if(addEpisodeForm) {
        addEpisodeForm.addEventListener("submit", function (e) {
            e.preventDefault()
            const episode = document.querySelector('input[name="episode"]').value
            const title = document.querySelector('input[name="title"]').value
            const duration = document.querySelector('input[name="duration"]').value
            const releaseDate = document.querySelector('input[name="releaseDate"]').value
            const movieId = document.querySelector('input[name="movieId"]').value
            const movieFile = document.querySelector('input[name="movieFile"]').files[0]

            const addEpisodeUrl = new URL("/episode/add", window.location.origin)
            const movieDetailsUrl = new URL("/admin/movie/details", window.location.origin)
            movieDetailsUrl.searchParams.set('movieId', movieId)

            if (!movieFile) {
                alert("Vui lòng chọn một tệp.");
            } else {
                const formData = new FormData();
                formData.append("episode", episode)
                formData.append("title", title)
                formData.append("duration", duration)
                formData.append("releaseDate", releaseDate)
                formData.append("movieId", movieId)
                formData.append("movieFile", movieFile)

                fetch(addEpisodeUrl, {
                    method: 'POST',
                    headers: {
                        'Authorization': 'Bearer ' + localStorage.getItem('access_token')
                    },
                    body: formData
                }).then(data => {
                    window.location.href = movieDetailsUrl.toString()
                }).catch()
            }
        })
    }
})