function aplicarMascaraTelefone(input) {
    input.value = input.value
        .replace(/\D/g, "")
        .replace(/(\d{2})(\d)/, "($1) $2")
        .replace(/(\d{5})(\d)/, "$1-$2")
        .slice(0, 15);
}

document.getElementById("telefone").addEventListener("input", function () {
    aplicarMascaraTelefone(this);
});

document.getElementById("cadastroForm").addEventListener("submit", function (event) {
    event.preventDefault();

    const nome = document.getElementById("nome").value.trim();
    const email = document.getElementById("email").value.trim();
    const telefone = document.getElementById("telefone").value.trim();
    const senha = document.getElementById("senha").value;
    const confirmarSenha = document.getElementById("confirmarSenha").value;

    const regex = /admin/i;

    if (nome === "" || email === "" || telefone === "" || senha === "" || confirmarSenha === "") {
        alert("Preencha todos os campos!");
        return;
    }

    if (regex.test(email)) {
        alert("O email não pode conter a palavra 'admin'.");
        return;
    }

    if (senha !== confirmarSenha) {
        alert("As senhas não coincidem.");
        return;
    }

    const cadastroData = {
        nome: nome,
        email: email,
        telefone: telefone.replace(/\D/g, ""),
        senha: senha,
        confirmarSenha: confirmarSenha
    };

    fetch("http://localhost:8080/cliente/cadastrar", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(cadastroData)
    })
        .then(response => {
            if (!response.ok) {
                return response.text().then(msg => {
                    throw new Error(msg);
                });
            }
            return response.text();
        })
        .then(msg => {
            console.log("Candidato cadastrado:", msg);
            alert("Cadastro realizado com sucesso!");
            window.location.href = "dashboard_candidato.html";
        })
        .catch(error => {
            console.error("Erro ao cadastrar candidato:", error.message);
            alert("Erro: " + error.message);
        });
});