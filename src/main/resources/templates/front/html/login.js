document.getElementById("loginForm").addEventListener("submit", function(event) {
    event.preventDefault();  // Evita que o formulário seja enviado normalmente

    const email = document.getElementById("email").value;
    const senha = document.getElementById("senha").value;

    if(email == "admin@1" && senha == "123"){
        window.location.href = "dashboard-admin.html";
    }

    const loginData = {
        email: email,
        senha: senha
    };

    fetch("http://localhost:8080/cliente/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(loginData)
    })
    .then(response => response.text())  // Ou .json(), caso a resposta seja JSON
    .then(data => {
        if (data === "Login bem-sucedido!") {
            localStorage.setItem("clienteId", 1);
            window.location.href = "dashboard-cliente.html";  // Redireciona para outra página após login bem-sucedido
        } else {
            alert("Erro de login: " + data);  // Exibe uma mensagem de erro
        }
    })
    .catch(error => {
        console.error("Erro:", error);
    });
});
