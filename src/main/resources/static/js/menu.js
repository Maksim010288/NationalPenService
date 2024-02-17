let window_menu = $("#window_menu");

let bool = false;

function lines() {
    if (bool === false) {
        window_menu.style.display = 'block';
        bool = true;
    } else {
        window_menu.style.display = 'none';
        bool = false;
    }
}
$("#lines").addEventListener("click", lines);

