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
   git clone https://github.com/SEU_REPOSITORIO.git

2. **Importe o projeto na sua IDE:**
  • Abra sua IDE.
  • Importe o projeto como um projeto Maven existente.

3. **Configure as variáveis de ambiente:**
   - No sistema operacional, crie as variáveis de ambiente:
      - **EMAIL_USERNAME**: Seu endereço de e-mail (ex.: seuemail@gmail.com).
      - **EMAIL_PASSWORD**: A senha de app gerada no Gmail (não é a senha da conta).
   
  • Para gerar a senha de app:
    1. Acesse sua conta Google e ative a verificação em duas etapas.
    2. Vá até Segurança > Senhas de app > Escolha qualquer nome para o app e clique em Criar, para que seja gerada uma senha específica para este projeto.
    3. Copie e use essa senha como valor de EMAIL_PASSWORD.

---

## Inicialização do Sistema

1. Inicie o Servidor Local
   • Execute o método main da classe principal
   
3. Acesse a aplicação no navegador para verificar se está ok (http://localhost:8080)

---

## ENDPOINTS

