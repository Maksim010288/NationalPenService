let view_order = $("#view_order");
let file_not_found = $("#file_not_found");
let auto_restart = $("#auto_restart_label");
let view_order_table = $("#view_order_table");
let view_order_table_header = $("#view_order_table_header");
let view_order_table_bode = $("#view_order_table_body");


if (view_order_table_bode.length === 0) {
    view_order.style.display = 'none';
    file_not_found.style.display = 'block';
    view_order_table.style.display = 'none';
    view_order_table_header.style.display = 'none';
}

function restart() {
    document.location.reload();
}

function outWindowMenu(){
    window_menu.style.display = 'none';
    bool = false;
}


$("#main_window").addEventListener("mouseover", outWindowMenu);
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