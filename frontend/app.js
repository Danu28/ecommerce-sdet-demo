function loadProducts() {
    fetch("http://localhost:8080/products")
        .then(res => res.json())
        .then(data => {
            const list = document.getElementById("productList");
            list.innerHTML = "";

            data.forEach(product => {
                const li = document.createElement("li");
                li.innerText = product.name + " - ₹" + product.price;
                list.appendChild(li);
            });
        })
        .catch(err => console.error("Error:", err));
}

function addProduct() {
    const name = document.getElementById("name").value;
    const price = document.getElementById("price").value;

    fetch("http://localhost:8080/products", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ name, price })
    })
        .then(res => res.json())
        .then(() => {
            alert("Product added!");
            loadProducts();
        });
}

// LOGIN
function login() {
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    fetch("http://localhost:8080/auth/login", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({ username, password })
    })
        .then(res => res.text())
        .then(data => alert("Login: " + data));
}

// ADD TO CART
function addToCart() {
    const productId = parseInt(document.getElementById("productId").value);
    const quantity = parseInt(document.getElementById("quantity").value);

    fetch("http://localhost:8080/cart", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({ productId, quantity })
    })
        .then(res => res.json())
        .then(data => {
            alert("Added to cart!");
            console.log(data);
        });
}

// LOAD CART
function loadCart() {
    fetch("http://localhost:8080/cart")
        .then(res => res.json())
        .then(data => {
            const list = document.getElementById("cartList");
            list.innerHTML = "";

            data.forEach(item => {
                const li = document.createElement("li");
                li.innerText = "Product: " + item.productId + " Qty: " + item.quantity;
                list.appendChild(li);
            });
        });
}