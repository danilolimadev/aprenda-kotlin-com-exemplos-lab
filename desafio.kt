enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL, AVANCADO }

data class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

class Formacao(val nome: String) {
    
    val usuarios = mutableListOf<Usuario>()
    val conteudosEducacionais = mutableListOf<ConteudoEducacional>()

    fun matricularUsuario(usuario: Usuario) {
        try {
            usuarios.add(usuario)
            println("Usuário ${usuario.nome} matriculado na formação $nome.")
        } catch (e: Exception) {
            println("Erro ao efetuar a matricula do usuário: ${usuario.nome} na formação: $nome. Erro de retorno: ${e.message}")
        }
    }
    
    fun editarUsuario(usuarioAntigo: Usuario, novoUsuario: Usuario) {
        var usuarioAlterado = false
        try {
            usuarios.forEachIndexed { indice, usuario ->
                if (usuarioAntigo == usuario) {
                    usuarios[indice] = novoUsuario
                    usuarioAlterado = true
                    println("Usuário: ${novoUsuario.nome} alterado com sucesso.")
                    return@forEachIndexed
                }
            }
            
            if(usuarioAlterado==false) {
                println("O usuário não foi encontrado")
            }
            
        } catch (e: Exception) {
            println("Erro ao editar o usuário: ${usuarioAntigo.nome}. Erro de retorno: ${e.message}")
        }
    }

    fun removerUsuario(usuario: Usuario) {
        try {
            usuarios.remove(usuario)
            println("Usuário ${usuario.nome} removido da formação $nome.")
        } catch (e: Exception) {
            println("Erro ao remover usuário: ${usuario.nome} na formação $nome: ${e.message}")
        }
    }
    
    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        try {
            conteudosEducacionais.add(conteudo)
            println("Conteúdo Educacional: ${conteudo.nome} adicionado a formação $nome.")
        } catch (e: Exception) {
            println("Erro ao adicionar o conteúdo: ${conteudo.nome} a formação: $nome. Erro de retorno: ${e.message}")
        }
    }
    
    fun editarConteudo(conteudoAntigo: ConteudoEducacional, novoConteudo: ConteudoEducacional) {
        var conteudoAlterado = false
        try {
            conteudosEducacionais.forEachIndexed { indice, conteudoEducacional ->
                if (conteudoAntigo == conteudoEducacional) {
                    conteudosEducacionais[indice] = novoConteudo
                    conteudoAlterado = true
                    println("Conteúdo Educacional: ${novoConteudo.nome} alterado com sucesso.")
                    return@forEachIndexed
                }
            }
            
            if(conteudoAlterado==false) {
                println("O Conteúdo Educacional não foi encontrado")
            }
            
        } catch (e: Exception) {
            println("Erro ao editar o conteúdo: ${conteudoAntigo.nome}. Erro de retorno: ${e.message}")
        }
    }

    fun removerConteudo(conteudo: ConteudoEducacional) {
        try {
            conteudosEducacionais.remove(conteudo)
            println("Conteúdo Educacional: ${conteudo.nome} removido da formação $nome.")
        } catch (e: Exception) {
            println("Erro ao remover o conteúdo: ${conteudo.nome} da formação: $nome. Erro de retorno: ${e.message}")
        }
    }
    
    fun mostrarUsuarios() {
        println("Usuários matriculados na formação $nome: ${usuarios.joinToString { it.nome }}.")
    }

    fun mostrarConteudos() {
        println("Conteúdos da formação $nome:")
        conteudosEducacionais.forEach { conteudo ->
            println("${conteudo.nome} - Duração: ${conteudo.duracao} minutos.")
        }
    }
}

fun main() {
    val usuario1 = Usuario("João")
    val usuario2 = Usuario("Joana")
    val usuario3 = Usuario("José")
    val usuario4 = Usuario("Júlia")

    val kotlinBasico = ConteudoEducacional("Kotlin Básico", 60)
    val kotlinIntermediario = ConteudoEducacional("Kotlin Intermediário", 90)
    val kotlinDificil = ConteudoEducacional("Kotlin do Fácil do Difícil", 120)
    val kotlinAvancado = ConteudoEducacional("Kotlin do Básico ao Avançado", 120)
    
    val kotlinCompleto = Formacao("Kotlin Completo")

    println("Matriculas dos Usuários:\n")
    kotlinCompleto.matricularUsuario(usuario1)
    kotlinCompleto.matricularUsuario(usuario2)
    kotlinCompleto.matricularUsuario(usuario3)
    kotlinCompleto.matricularUsuario(usuario4)
    
    println("\n\nAdição de Conteúdos:\n")
    kotlinCompleto.adicionarConteudo(kotlinBasico)
    kotlinCompleto.adicionarConteudo(kotlinIntermediario)
    kotlinCompleto.adicionarConteudo(kotlinDificil)
    kotlinCompleto.adicionarConteudo(kotlinAvancado)

    println("\n\nExibir Conteúdos:\n")
    kotlinCompleto.mostrarConteudos()
    
    println("\n\nExibir Usuários:\n")
    kotlinCompleto.mostrarUsuarios()
    
    println("\n\nEditar Usuário:\n")
    kotlinCompleto.editarUsuario(usuario3, Usuario("José Silva"))
    
    println("\n\nEditar Usuário Inexistente:\n")
    kotlinCompleto.editarUsuario(Usuario("Marimar"), Usuario("Marimar"))
    
    println("\n\nEditar Conteúdo:\n")
    kotlinCompleto.editarConteudo(kotlinBasico, ConteudoEducacional("Novo Kotlin Básico", 120))
    
    println("\n\nEditar Conteúdo Inexistente:\n")
    kotlinCompleto.editarConteudo(ConteudoEducacional("Curso Inexistente", 120), ConteudoEducacional("Novo Kotlin Básico", 120))

    println("\n\nRemover Usuário:\n")
    kotlinCompleto.removerUsuario(usuario1)
    
    println("\n\nRemover Conteúdo:\n")
    kotlinCompleto.removerConteudo(kotlinBasico)
	
    println("\n\nExibir Usuários Após Alteração:\n")
    kotlinCompleto.mostrarUsuarios()
        
    println("\n\nExibir Conteúdos Após Alteração:\n")
    kotlinCompleto.mostrarConteudos()
}