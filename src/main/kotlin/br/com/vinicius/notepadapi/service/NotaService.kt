package br.com.vinicius.notepadapi.service

import br.com.vinicius.notepadapi.model.Nota
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import br.com.vinicius.notepadapi.repository.NotaRepository

@Service
class NotaService {
    @Autowired
    lateinit var notaRepository: NotaRepository

    fun salvar(nota: Nota) {
        val aux = notaRepository.findByTitulo(nota.titulo)
        if (aux != null) {
            nota.id = aux.id
        }
        notaRepository.save(nota)
    }

    fun buscarTodas(): List<Nota> {
        return notaRepository.findAll()
    }

    fun buscar(titulo: String): Nota {
        return notaRepository.findByTitulo(titulo)
    }
}

