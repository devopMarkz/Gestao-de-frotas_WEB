# Sistema de Gestão de Frotas

## Apresentação

Bem-vindo ao Sistema de Gestão de Frotas! Este sistema foi desenvolvido para simplificar a administração de veículos, motoristas e processos de aluguel. Com uma interface funcional e recursos bem definidos, ele oferece ferramentas para cadastro, gerenciamento e envio de informações automatizadas.

---

## Funcionalidades

- **Cadastro de Veículos:** Administradores podem cadastrar veículos e gerenciar sua disponibilidade.
- **Cadastro de Usuários e Motoristas:** Criação de usuários, com opção de associar motoristas aos perfis cadastrados.
- **Aluguel de Veículos:** Reserva de veículos com validações automáticas e cálculo de custos.
- **Envio de E-mails Automáticos:** Detalhes do aluguel são enviados por e-mail ao usuário responsável.

---

## Pré-requisitos

Antes de começar, você precisará do seguinte instalado em sua máquina:

- **Java 17** ou superior
- **Maven**
- **IDE de sua escolha** (recomenda-se IntelliJ ou Eclipse)
- **Conta Gmail** com autenticação em duas etapas ativada

---

## Instalação e Configuração

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/devopMarkz/Gestao-de-frotas_WEB.git

2. **Importe o projeto na sua IDE:**
   - Abra sua IDE.
   - Importe o projeto como um projeto Maven existente.

3. **Configure as variáveis de ambiente:**
   - No sistema operacional, crie as variáveis de ambiente:
      - **EMAIL_USERNAME**: Seu endereço de e-mail (ex.: seuemail@gmail.com).
      - **EMAIL_PASSWORD**: A senha de app gerada no Gmail (não é a senha da conta).

   - Para gerar a senha de app:
      - Acesse sua conta Google e ative a verificação em duas etapas.
      - Vá até Segurança > Senhas de app > Escolha qualquer nome para o app e clique em Criar, para que seja gerada uma senha específica para este projeto.
      - Copie e use essa senha como valor de EMAIL_PASSWORD.

---

## Inicialização do Sistema

1. Inicie o Servidor Local
   - Execute o método main da classe principal
   
3. Acesse a aplicação no navegador para verificar se está ok (http://localhost:8080)

---

## Endpoints - Usuário

### 1. Cadastro de Usuário
**URL:** `POST - http://localhost:8080/usuarios/cadastro`  
**Descrição:** Cadastra usuários no sistema.

**JSON de Entrada:**
   ```json
   {
     "email": "seugmail@gmail.com",
     "password": "minhaSenha123",
     "tipoDeUsuario": "MOTORISTA"
   }
```

### 2. Cadastro de Motorista para Usuário
**URL:** `POST - http://localhost:8080/usuarios/usuario/motorista`  
**Descrição:** Cria um cadastro de motorista para o usuário.

**JSON de Entrada:**
   ```json
   {
     "email": "seugmail@gmail.com",
     "cadastroDeMotorista": {
         "nome": "João Silva",
         "cnh": "123456781",
         "categoriaCNH": "C",
         "dataNascimento": "1985-05-15"
      }
   }
```

### 3. Login de Usuário
**URL:** `POST - http://localhost:8080/usuarios/login`  
**Descrição:** Efetua o login do usuário no sistema.

**JSON de Entrada:**
   ```json
   {
      "email": "marcosacs.2022@gmail.com",
      "password": "minhaSenha123"
   }
```

## Endpoints - Veículos

### 1. Cadastro de Veículo
**URL:** `POST - http://localhost:8080/veiculos`  
**Descrição:** Cria um novo veículo no sistema que pode ser alugado.

**JSON de Entrada para criação de Ônibus:**
```json
{
    "categoriaVeiculo": "ONIBUS",
    "placa": "PTW5D24",
    "marca": "Mercedes-Benz",
    "modelo": "Tourismo",
    "anoFabricacao": 2020,
    "capacidade": 50,
    "custoPorDia": 600.00,
    "atributosEspecificos": {
        "numeroDeAssentos": 52
    }
}
```

**JSON de Entrada para criação de Caminhão:**
```json
{
    "categoriaVeiculo": "CAMINHAO",
    "placa": "PTW5D24",
    "marca": "Scania",
    "modelo": "R450",
    "anoFabricacao": 2022,
    "capacidade": 18000.00,
    "custoPorDia": 750.00,
    "atributosEspecificos": {
        "numeroDeEixos": 6
    }
}
```

### 2. Busca de Veículos por Filtros
**URL:** `GET - http://localhost:8080/veiculos?disponivel=true&categoriaVeiculo=ONIBUS`  
**Descrição:** Efetua uma busca de veículos disponíveis por filtros.  

**Parâmetros de Query:**  
- `disponivel`: Filtra os veículos disponíveis (`true` ou `false`).  
- `categoriaVeiculo`: Filtra os veículos pela categoria (ex.: `ONIBUS`, `CAMINHAO`).

### 3. Busca de Veículo por Placa
**URL:** `GET - http://localhost:8080/veiculos/PTW5D24`  
**Descrição:** Efetua a busca de um veículo por sua placa.  

**Parâmetros de Rota:**  
- `{placa}`: Placa do veículo a ser buscado (ex.: `PTW5D24`).  
