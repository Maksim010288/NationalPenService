let view_order = document.getElementById("view_order");
let file_not_found = document.getElementById("file_not_found");
let auto_restart = document.getElementById("auto_restart_label");
let view_order_table = document.getElementById("view_order_table");
let view_order_table_header = document.getElementById("view_order_table_header");
let view_order_table_bode = document.querySelectorAll("#view_order_table_body");


if (view_order_table_bode.length === 0) {
    view_order.style.display = 'none';
    file_not_found.style.display = 'block';
    view_order_table.style.display = 'none';
    view_order_table_header.style.display = 'none';
}

function restart() {
    document.location.reload();
}

auto_restart.addEventListener("click", function () {
    if (auto_restart.innerText === 'Auto restart on') {
        auto_restart.innerText = 'Auto restart off';
        clearTimeout(timeout);
    } else if (auto_restart.innerText === 'Auto restart off') {
        auto_restart.innerText = 'Auto restart on'
        timeout = setTimeout(restart, 10000);
    }
});

timeout = setTimeout(restart, 10000);
