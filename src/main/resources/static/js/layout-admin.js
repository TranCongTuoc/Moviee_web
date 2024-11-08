document.addEventListener('DOMContentLoaded', function () {
    const username = localStorage.getItem('user')
    if (username) {
        document.getElementById('userDropdown').textContent = username
    }
})


